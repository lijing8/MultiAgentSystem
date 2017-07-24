package fuzzyCMeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import Jama.Matrix;

public class FuzzyCMeans {

	static int n, s, k;
	
	static int colnum;
	static int m;
	static int ClusterRes[][];// �洢����ľ���C*m
	static ArrayList cycleList = new ArrayList();
	static ArrayList cycleTemp = new ArrayList();

	
	public void FuzzyQoS(double[][][] data, int cluster) throws IOException {// cluster:������,1<C<N
		// data[][][]Ϊ��������

		n = data.length;// data������
		s = data[0].length;// data������
		k = data[0][0].length;// data�Ĳ���

		int iter = 0;// FCM �㷨��������
		int getnum = 1;// ��getnum��Ԫ��������

		double epsm = 0.01;// FCM �㷨�ĵ���ֹͣ��ֵ,ȱʡֵΪ 1.0e-6
		double reply = 0.0;// ��ʱ�洢U�еľ���
		double usum = 0.0;// �洢replyƽ����

		int count[] = new int[cluster];// �����ͳ��ÿһ��ĸ���
		Matrix dist = new Matrix(cluster, n);// FCM ���������ĵ���������ľ���,�������� i �������� j
												// �ľ���Ϊ Dist(i,j)
		Matrix uarray = new Matrix(cluster, n);// FCM �Ļ��־���
		Matrix uarray0 = new Matrix(cluster, n);// �����ʼ�����־���
		Matrix uarraym = new Matrix(cluster, n);
		Matrix utemp = new Matrix(cluster, n);

		double parray[][][] = new double[cluster][s][k];// FCM �ľ�������,ÿһ�ж�Ӧһ������ԭ��
		Matrix p0= new Matrix(cluster, s);
		Matrix p1 = new Matrix(cluster, s);
		Matrix p2 = new Matrix(cluster, s);

		Matrix data0 = new Matrix(n, s);// ���ݽ�������ά����data���зֲ�
		Matrix data1 = new Matrix(n, s);
		Matrix data2 = new Matrix(n, s);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < s; j++) {
				data0.set(i, j, data[i][j][0]);
				data1.set(i, j, data[i][j][1]);
				data2.set(i, j, data[i][j][2]);
			}
		}

		Matrix onec = new Matrix(cluster, 1);// cluster��1�еľ������ڹ滮������

		// ��ʼ��ones����Ϊ1
		for (int i = 0; i < cluster; i++) {
			onec.set(i, 0, 1);
		}

		Matrix ones = new Matrix(s, 1);// s��1�еľ������ڹ滮������

		// ��ʼ��ones����Ϊ1
		for (int i = 0; i < s; i++) {
			ones.set(i, 0, 1);
		}

		// ��ʼ��uarray0����Ϊ�������
		for (int i = 0; i < cluster; i++) {
			for (int j = 0; j < n; j++) {
				uarray0.set(i, j, Math.random());
			}
		}

		Dist fdist = new Dist();

		uarray0 = uarray0.arrayRightDivide(onec.times(sum(uarray0)));

		// FCM�ĵ����㷨
		while (true) {
			// ����������
			iter = iter + 1;
			// System.out.println("FCM������" + iter + "��ѭ��");

			// �������¾������� P
			uarraym = uarray0.arrayTimes(uarray0);

			p0 = (uarraym.times(data0)).arrayRightDivide((ones.times(sum(uarraym.transpose()))).transpose());
			p1 = (uarraym.times(data1)).arrayRightDivide((ones.times(sum(uarraym.transpose()))).transpose());
			p2 = (uarraym.times(data2)).arrayRightDivide((ones.times(sum(uarraym.transpose()))).transpose());

			// ���»��־��� U
			for (int i = 0; i < cluster; i++) {
				for (int j = 0; j < n; j++) {
					for (int k0 = 0; k0 < k; k0++) {
						switch (k0) {
						case 0:
							reply = fdist.fuzzyDist(getRow(p0, i), getRow(data0, j));
							break;
						case 1:
							reply = fdist.fuzzyDist(getRow(p1, i), getRow(data1, j));
							break;
						case 2:
							reply = fdist.fuzzyDist(getRow(p2, i), getRow(data2, j));
							break;
						}
						usum = usum + reply * reply;

					}

					dist.set(i, j, Math.sqrt(usum) / 3);
					usum = 0;

				}
			}

			// ���㻮�־���U����ÿ��Ԫ�صĵ���
			utemp = dist.arrayTimes(dist);
			for (int i = 0; i < utemp.getRowDimension(); i++) {
				for (int j = 0; j < utemp.getColumnDimension(); j++) {
					reply = utemp.get(i, j);
					utemp.set(i, j, 1 / reply);
				}
			}

			uarray = (dist.arrayTimes(dist)).arrayTimes(onec.times(sum(utemp)));// ���㻮�־���U

			for (int i = 0; i < cluster; i++) {
				for (int j = 0; j < n; j++) {
					reply = uarray.get(i, j);
					uarray.set(i, j, 1 / reply);
				}
			}

			// ѭ��ֹͣ����
			if ((uarray.minus(uarray0)).normInf() < epsm) {
				break;
			}

			uarray0 = uarray;

		}

		// �������յľ�������
		for (int i = 0; i < cluster; i++) {
			for (int j = 0; j < s; j++) {
				parray[i][j][0] = p0.get(i, j);
				parray[i][j][1] = p1.get(i, j);
				parray[i][j][2] = p2.get(i, j);
			}
		}

		ClusterRes = new int[cluster][n];// �������

		// �������ClusterRes������ÿһ��Ԫ�ؽ��и�ֵΪ-1��������滮��ÿһ�����
		for (int i = 0; i < cluster; i++) {
			for (int j = 0; j < n; j++) {
				ClusterRes[i][j] = -1;
			}
		}

		// �ж�ÿһ���е���������ĸ��У�����ԭ�����кż�¼��ClusterRes��
		for (int i = 0; i < n; i++) {
			colnum = findaddr(getRow(uarray.transpose(), i), getnum);
			for (int j = 0; j < cluster; j++) {
				if (colnum == j) {
					ClusterRes[j][i] = i;
					break;
				}
			}
		}

		// ClusterRes�в�Ϊ-1����Ϊԭ���к�
		for (int j = 0; j < cluster; j++) {
			for (int i = 0; i < n; i++) {
				if (ClusterRes[j][i] != -1) {
					count[j] = count[j] + 1;// ����ÿһ��ĸ���
				} else {
					continue;
				}
			}
		}

		m = count[colnum];// ��¼���һ���������ڵ���ĸ���
//		return uarray;

	}

	// ��Matrix�еõ���i�е�һά����
	public static Matrix getRow(Matrix rm, int i) {
		Matrix rowMatrix = new Matrix(1, rm.getColumnDimension());

		for (int b = 0; b < rm.getColumnDimension(); b++) {
			rowMatrix.set(0, b, rm.get(i, b));
		}
		return rowMatrix;
	}

	// ����ÿ���и��е��ܺ�
	public static Matrix sum(Matrix temp) {
		int a = temp.getRowDimension();
		int b = temp.getColumnDimension();
		double sumCol = 0.0;

		Matrix resum = new Matrix(1, b);

		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				sumCol = sumCol + temp.get(j, i);
			}
			resum.set(0, i, sumCol);
			sumCol = 0;
		}
		return resum;
	}

	// Ѱ�Ҿ������Դ���ڵ�ԭʼ��
	public static int findaddr(Matrix frm, int getnum) {
		// ����ʹ��array�������ܽ��У���ʹ��Map���Դ洢ԭ��ַ���ص㣬ʵ�ֲ��ҡ�

		int colnum = 0;
		double[] fa = new double[frm.getColumnDimension()];
		HashMap map = new HashMap();
		for (int i = 0; i < frm.getColumnDimension(); i++) {
			fa[i] = frm.get(0, i);
			map.put(frm.get(0, i), i); // ��ֵ���±����Map
		}

		// ����
		List list = new ArrayList();
		Arrays.sort(fa); // ��������
		for (int i = 0; i < fa.length; i++) {
			list.add(fa[i]);
		}

		Collections.reverse(list); // ��������,��Ϊ����
		for (int i = 0; i < list.size(); i++) {
			fa[i] = Double.parseDouble((list.get(i)).toString());
		}
		// ����ԭʼ��ַ
		for (int i = 0; i < getnum; i++) {
			colnum = Integer.parseInt(String.valueOf(map.get(fa[i])));
		}

		return colnum;

	}

	// ����´�ѭ����Դ���ڵ���
	public static int[] getCycle(int ClusterRes[][], int jm, int jcolnum) {

		int ca = 0;// CycleList��ɾ��Ԫ�صĸ���
		int cycle[] = new int[jm];

		// ��ClusterRes�����һ���������ڵľ����¼��Cycle�У��Ӷ��õ��´�ѭ������Ҫ����Դ
		for (int i = 0; i < ClusterRes[jcolnum].length; i++) {
			if (ClusterRes[jcolnum][i] == -1) {

				cycleTemp.remove(i - ca);
				cycleList.remove(i - ca);
				ca++;
			}
		}

		for (int i = 0; i < cycleTemp.size(); i++) {
			int m1=cycleTemp.size();
			cycle[i] = (Integer) cycleTemp.get(i);
		}
		return cycle;
	}

	public static double[][] getFcmSim(int[] cycle) {

		double sim = 0;
		DataPre dp = new DataPre();

		// �������ƶ�
		double test[][][] = dp.process(cycle);// ȡ����Դ����

		double SimRes[][] = new double[cycleList.size()][2];// ���ƶȽ������
//		double Simtemp[][] = new double[cycleList.size()][2];// ���ƶȼ��㻺�����

		// ����������Դ�����������ƶ�
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				for (int a = 0; a < test[0][0].length; a++) {
					sim = sim + Math.pow(test[test.length - 1][j][a] - test[i][j][a], 2);
				}
			}
			SimRes[i][0] = Double.parseDouble(cycleList.get(i).toString());
			SimRes[i][1] = 1 - ((double) 1 / 3) * Math.sqrt((1 / (double) test[0].length) * sim);
			sim = 0;
		}
		
		return SimRes;
	}
	
	
	public static double[][] Similarity(double SimRes[][]){
		FuzzyData fd=new FuzzyData();
		String []PreResourceName=fd.getPreResourceName();
		double []PreSim=fd.getPreSim();
		
//		preliminaryresult Rbs=fd.getRbs();
		String[][] Ras=fd.getRas();
		double SimilarityRes[][]=new double[SimRes.length][SimRes[0].length];
		double srTemp[][]=new double[SimRes.length][SimRes[0].length];
		
		for(int i=0;i<SimRes.length;i++){
			srTemp[i][0]=SimRes[i][0];
			for(int j=0;j<Ras.length;j++){
				if(SimRes[i][0]==Double.parseDouble(Ras[j][0])){
					for(int k=0;k<PreResourceName.length;k++){
						if(Ras[j][2].equals(PreResourceName[k])){
							srTemp[i][1]=0.25*SimRes[i][1]+0.75*PreSim[k];
						}
					}
					break;
				}
			}
		}

		//����
		double simMat[] = new double[cycleList.size()];
		for (int i = 0; i < cycleList.size(); i++) {
			simMat[i] = srTemp[i][1];
		}

		List simlist = new ArrayList();
		Arrays.sort(simMat); // ��������
		for (int i = 0; i < simMat.length; i++) {
			simlist.add(simMat[i]);
		}

		Collections.reverse(simlist); // ��������,��Ϊ����
		for (int i = 0; i < simlist.size(); i++) {
			simMat[i] = Double.parseDouble((simlist.get(i)).toString());
		}
		
		// ����������Դ��Ŷ�Ӧ���������ƶ�
		for (int i = 0; i < simMat.length; i++) {
			for (int j = 0; j < srTemp.length; j++) {
				double pt=simMat[i] - srTemp[j][1];
				if (pt==0) {
					SimilarityRes[i][0] = srTemp[j][0];
					SimilarityRes[i][1] = srTemp[j][1];
					break;
				}

			}
		}

		return SimilarityRes;
	}
	
	

	public double [][] getSimRes(String demand[]){
		// TODO Auto-generated method stub

		FuzzyData fd=new FuzzyData();
		fd.setDemand(demand);

		int countm = 0;// ѭ������
		int cluster = 2;// ������
		
		int inrow = fd.getRasRow();// ��ʼ��Դ������
		String[][] ras = fd.getRas();

		int incycle[] = new int[inrow];// �ʼ��ѭ�������ľ��󣬳�ʼ��Դ
		int cycle[] = null;
		if (cycleTemp.size()!=0) {
			cycleTemp.clear();
			cycleList.clear();
		}

		for (int i = 0; i < inrow; i++) {
			incycle[i] = i;
			cycleTemp.add(i);
			cycleList.add(Integer.parseInt(ras[i][0]));
		}

		DataPre dp = new DataPre();
		double test[][][] = dp.process(incycle);

		m = test.length;
//������20
		while (m > 40) {
			countm = countm + 1;
			
				FuzzyCMeans fcm = new FuzzyCMeans();
				try {
					fcm.FuzzyQoS(test, cluster);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			cycle = getCycle(ClusterRes, m, colnum);

			test = dp.process(cycle);
			m = test.length;

		}

		double [][]SimRes= Similarity(getFcmSim(cycle));// ����ĳ���Ȩ������ƶȾ���
		return SimRes;
		

	}

}
