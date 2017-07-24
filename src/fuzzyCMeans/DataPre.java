package fuzzyCMeans;

public class DataPre {
	FuzzyData fd = new FuzzyData();
	double dataPre[][][] = fd.fuzzy();
	double p[] = {1,1,0.5,1,0.7,0.6,0.5};

	public double[][][] process(int[] cycle) {

		int n, s, k;
		n = dataPre.length;
		s = dataPre[0].length;
		k = dataPre[0][0].length;

		double datas[][][] = new double[cycle.length][n][k];
		for (int a = 0; a < 3; a++) {
			for (int i = 0; i < cycle.length; i++) {
				for (int j = 0; j < s; j++) {
					datas[i][j][a] = dataPre[cycle[i]][j][a]* p[j];// 得到cycle[]中所有的行
				}
			}
		}	
		return datas;
	}

}
