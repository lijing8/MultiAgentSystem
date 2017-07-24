package fuzzyCMeans;

public class FuzzyData {
	double standad = 0.18;
	private static int rasRow;
	private static String[] demand;
	Algorithm al = new Algorithm();

	public void setDemand(String demand[]) {
		this.demand = demand;
		
	}

	public double[][][] fuzzy() {
		 

		int attributeCol = 7;
		String[][] ResultAfterSelect = getRas();


		int rasRow = getRasRow();

		String[][] rasTemp = new String[rasRow][attributeCol];
		double[][] arr1 = new double[rasRow][attributeCol];
		double[][] arr2 = new double[rasRow][attributeCol];
		double[][] arr3 = new double[rasRow][attributeCol];
		double[][][] dataPre = new double[rasRow][attributeCol][3];

		for (int i = 0; i < rasRow; i++) {
			int k = attributeCol - 1;
			for (int j = ResultAfterSelect[0].length - 1; j > ResultAfterSelect[0].length - attributeCol - 1; j--) {
				rasTemp[i][k] = ResultAfterSelect[i][j];
				k--;
			}
		}

		// 把模糊矩阵三角模糊化，变成三个二维矩阵
		for (int i = 0; i < rasRow; i++) {
			for (int j = 0; j < attributeCol; j++) {
				switch (rasTemp[i][j]) {
				case "否":
					arr1[i][j] = 0.125;
					arr2[i][j] = 0.25;
					arr3[i][j] = 0.375;
					break;
				case "无":
					arr1[i][j] = 0;
					arr2[i][j] = 0;
					arr3[i][j] = 0;
					break;
				case "很低":
					arr1[i][j] = 0;
					arr2[i][j] = 0.125;
					arr3[i][j] = 0.25;
					break;
				case "低":
					arr1[i][j] = 0.125;
					arr2[i][j] = 0.25;
					arr3[i][j] = 0.375;
					break;
				case "微低":
					arr1[i][j] = 0.25;
					arr2[i][j] = 0.375;
					arr3[i][j] = 0.5;
					break;
				case "中":
					arr1[i][j] = 0.375;
					arr2[i][j] = 0.5;
					arr3[i][j] = 0.625;
					break;
				case "微高":
					arr1[i][j] = 0.5;
					arr2[i][j] = 0.625;
					arr3[i][j] = 0.75;
					break;
				case "高":
					arr1[i][j] = 0.625;
					arr2[i][j] = 0.75;
					arr3[i][j] = 0.875;
					break;
				case "很高":
					arr1[i][j] = 0.75;
					arr2[i][j] = 0.875;
					arr3[i][j] = 1;
					break;
				case "完全":
					arr1[i][j] = 1;
					arr2[i][j] = 1;
					arr3[i][j] = 1;
					break;
				case "是":
					arr1[i][j] = 0.625;
					arr2[i][j] = 0.75;
					arr3[i][j] = 0.875;
					break;
				}
			}
		}

		for (int i = 0; i < rasRow; i++) {
			for (int j = 0; j < attributeCol; j++) {
				dataPre[i][j][0] = arr1[i][j];
				dataPre[i][j][1] = arr2[i][j];
				dataPre[i][j][2] = arr3[i][j];
			}
		}

		return dataPre;

	}

	
	public String[][] getRas() {	
		
		String[][] ResultAfterSelect = al.algorithm(demand).ResultAfterSelect;
	
			return ResultAfterSelect;

	}

	public String[] getPreResourceName() {
		String[] PreResourceName = al.algorithm(demand).preliminaryresult1;
	
		return PreResourceName;

	}

	public double[] getPreSim() {
		double[] PreSim = al.algorithm(demand).preliminaryresult2;
		return PreSim;
	}

	public int getRasRow() {
		String[][] ResultAfterSelect = getRas();
		for (int i = 0; i < ResultAfterSelect.length; i++) {
			if (ResultAfterSelect[i][0] == null) {
				rasRow = i;
				break;
			}
		}
		return rasRow;
	}

}
