package fuzzyCMeans;

public class QOS {

	public double[][] fuzzyqos(String[] demand) {
		// TODO Auto-generated method stub
		//String demand[]={"������","20","7","1001032","100","95","110","��","��","��","��","��","��","��"};
		FuzzyCMeans fcm=new FuzzyCMeans();
		double[][] simRes=fcm.getSimRes(demand);

	
		return simRes;
		
	}
}
