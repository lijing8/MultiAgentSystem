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
	static int ClusterRes[][];// 存储结果的矩阵，C*m
	static ArrayList cycleList = new ArrayList();
	static ArrayList cycleTemp = new ArrayList();

	
	public void FuzzyQoS(double[][][] data, int cluster) throws IOException {// cluster:聚类数,1<C<N
		// data[][][]为数据数组

		n = data.length;// data的行数
		s = data[0].length;// data的列数
		k = data[0][0].length;// data的层数

		int iter = 0;// FCM 算法迭代次数
		int getnum = 1;// 第getnum大元素所在行

		double epsm = 0.01;// FCM 算法的迭代停止阈值,缺省值为 1.0e-6
		double reply = 0.0;// 临时存储U中的距离
		double usum = 0.0;// 存储reply平方和

		int count[] = new int[cluster];// 聚类后，统计每一类的个数
		Matrix dist = new Matrix(cluster, n);// FCM 各聚类中心到各样本点的距离,聚类中心 i 到样本点 j
												// 的距离为 Dist(i,j)
		Matrix uarray = new Matrix(cluster, n);// FCM 的划分矩阵
		Matrix uarray0 = new Matrix(cluster, n);// 随机初始化划分矩阵
		Matrix uarraym = new Matrix(cluster, n);
		Matrix utemp = new Matrix(cluster, n);

		double parray[][][] = new double[cluster][s][k];// FCM 的聚类中心,每一行对应一个聚类原型
		Matrix p0= new Matrix(cluster, s);
		Matrix p1 = new Matrix(cluster, s);
		Matrix p2 = new Matrix(cluster, s);

		Matrix data0 = new Matrix(n, s);// 传递进来的三维数组data进行分层
		Matrix data1 = new Matrix(n, s);
		Matrix data2 = new Matrix(n, s);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < s; j++) {
				data0.set(i, j, data[i][j][0]);
				data1.set(i, j, data[i][j][1]);
				data2.set(i, j, data[i][j][2]);
			}
		}

		Matrix onec = new Matrix(cluster, 1);// cluster行1列的矩阵，用于规划化数组

		// 初始化ones矩阵为1
		for (int i = 0; i < cluster; i++) {
			onec.set(i, 0, 1);
		}

		Matrix ones = new Matrix(s, 1);// s行1列的矩阵，用于规划化数组

		// 初始化ones矩阵为1
		for (int i = 0; i < s; i++) {
			ones.set(i, 0, 1);
		}

		// 初始化uarray0矩阵为随机矩阵
		for (int i = 0; i < cluster; i++) {
			for (int j = 0; j < n; j++) {
				uarray0.set(i, j, Math.random());
			}
		}

		Dist fdist = new Dist();

		uarray0 = uarray0.arrayRightDivide(onec.times(sum(uarray0)));

		// FCM的迭代算法
		while (true) {
			// 迭代计数器
			iter = iter + 1;
			// System.out.println("FCM迭代第" + iter + "次循环");

			// 计算或更新聚类中心 P
			uarraym = uarray0.arrayTimes(uarray0);

			p0 = (uarraym.times(data0)).arrayRightDivide((ones.times(sum(uarraym.transpose()))).transpose());
			p1 = (uarraym.times(data1)).arrayRightDivide((ones.times(sum(uarraym.transpose()))).transpose());
			p2 = (uarraym.times(data2)).arrayRightDivide((ones.times(sum(uarraym.transpose()))).transpose());

			// 更新划分矩阵 U
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

			// 计算划分矩阵U，求每个元素的倒数
			utemp = dist.arrayTimes(dist);
			for (int i = 0; i < utemp.getRowDimension(); i++) {
				for (int j = 0; j < utemp.getColumnDimension(); j++) {
					reply = utemp.get(i, j);
					utemp.set(i, j, 1 / reply);
				}
			}

			uarray = (dist.arrayTimes(dist)).arrayTimes(onec.times(sum(utemp)));// 计算划分矩阵U

			for (int i = 0; i < cluster; i++) {
				for (int j = 0; j < n; j++) {
					reply = uarray.get(i, j);
					uarray.set(i, j, 1 / reply);
				}
			}

			// 循环停止条件
			if ((uarray.minus(uarray0)).normInf() < epsm) {
				break;
			}

			uarray0 = uarray;

		}

		// 更新最终的聚类中心
		for (int i = 0; i < cluster; i++) {
			for (int j = 0; j < s; j++) {
				parray[i][j][0] = p0.get(i, j);
				parray[i][j][1] = p1.get(i, j);
				parray[i][j][2] = p2.get(i, j);
			}
		}

		ClusterRes = new int[cluster][n];// 结果矩阵

		// 结果矩阵ClusterRes，对其每一个元素进行赋值为-1，方便后面划分每一类的数
		for (int i = 0; i < cluster; i++) {
			for (int j = 0; j < n; j++) {
				ClusterRes[i][j] = -1;
			}
		}

		// 判断每一列中的最大行在哪个行，并将原来的行号记录到ClusterRes中
		for (int i = 0; i < n; i++) {
			colnum = findaddr(getRow(uarray.transpose(), i), getnum);
			for (int j = 0; j < cluster; j++) {
				if (colnum == j) {
					ClusterRes[j][i] = i;
					break;
				}
			}
		}

		// ClusterRes中不为-1的项为原来行号
		for (int j = 0; j < cluster; j++) {
			for (int i = 0; i < n; i++) {
				if (ClusterRes[j][i] != -1) {
					count[j] = count[j] + 1;// 计算每一类的个数
				} else {
					continue;
				}
			}
		}

		m = count[colnum];// 记录最后一行需求所在的类的个数
//		return uarray;

	}

	// 从Matrix中得到第i行的一维数组
	public static Matrix getRow(Matrix rm, int i) {
		Matrix rowMatrix = new Matrix(1, rm.getColumnDimension());

		for (int b = 0; b < rm.getColumnDimension(); b++) {
			rowMatrix.set(0, b, rm.get(i, b));
		}
		return rowMatrix;
	}

	// 计算每列中各行的总和
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

	// 寻找聚类后资源所在的原始行
	public static int findaddr(Matrix frm, int getnum) {
		// 排序，使用array的排序功能进行，并使用Map可以存储原地址的特点，实现查找。

		int colnum = 0;
		double[] fa = new double[frm.getColumnDimension()];
		HashMap map = new HashMap();
		for (int i = 0; i < frm.getColumnDimension(); i++) {
			fa[i] = frm.get(0, i);
			map.put(frm.get(0, i), i); // 将值和下标存入Map
		}

		// 排列
		List list = new ArrayList();
		Arrays.sort(fa); // 升序排列
		for (int i = 0; i < fa.length; i++) {
			list.add(fa[i]);
		}

		Collections.reverse(list); // 逆序排列,变为降序
		for (int i = 0; i < list.size(); i++) {
			fa[i] = Double.parseDouble((list.get(i)).toString());
		}
		// 查找原始地址
		for (int i = 0; i < getnum; i++) {
			colnum = Integer.parseInt(String.valueOf(map.get(fa[i])));
		}

		return colnum;

	}

	// 获得下次循环资源所在的行
	public static int[] getCycle(int ClusterRes[][], int jm, int jcolnum) {

		int ca = 0;// CycleList中删除元素的个数
		int cycle[] = new int[jm];

		// 将ClusterRes中最后一行需求所在的聚类记录到Cycle中，从而得到下次循环所需要的资源
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

		// 计算相似度
		double test[][][] = dp.process(cycle);// 取得资源矩阵

		double SimRes[][] = new double[cycleList.size()][2];// 相似度结果矩阵
//		double Simtemp[][] = new double[cycleList.size()][2];// 相似度计算缓存矩阵

		// 计算所有资源和需求间的相似度
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

		//排序
		double simMat[] = new double[cycleList.size()];
		for (int i = 0; i < cycleList.size(); i++) {
			simMat[i] = srTemp[i][1];
		}

		List simlist = new ArrayList();
		Arrays.sort(simMat); // 升序排列
		for (int i = 0; i < simMat.length; i++) {
			simlist.add(simMat[i]);
		}

		Collections.reverse(simlist); // 逆序排列,变为降序
		for (int i = 0; i < simlist.size(); i++) {
			simMat[i] = Double.parseDouble((simlist.get(i)).toString());
		}
		
		// 将排序后的资源序号对应排序后的相似度
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

		int countm = 0;// 循环次数
		int cluster = 2;// 聚类数
		
		int inrow = fd.getRasRow();// 初始资源的行数
		String[][] ras = fd.getRas();

		int incycle[] = new int[inrow];// 最开始的循环行数的矩阵，初始资源
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
//最多输出20
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

		double [][]SimRes= Similarity(getFcmSim(cycle));// 计算的出加权后的相似度矩阵
		return SimRes;
		

	}

}
