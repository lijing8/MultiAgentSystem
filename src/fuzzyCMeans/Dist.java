package fuzzyCMeans;

import Jama.Matrix;

public class Dist {

	public double fuzzyDist(Matrix m1, Matrix m2) {

		double sum = 0;
		double dist;
		for(int i=0;i<m1.getColumnDimension();i++){
			sum=sum+Math.pow(m1.get(0, i)-m2.get(0, i), 2);
		}
		dist=Math.sqrt(sum);
		return dist;
	}

}
