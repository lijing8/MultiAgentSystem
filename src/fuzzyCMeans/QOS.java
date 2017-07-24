package fuzzyCMeans;

public class QOS {

	public double[][] fuzzyqos(String[] demand) {
		// TODO Auto-generated method stub
		//String demand[]={"气缸体","20","7","1001032","100","95","110","高","高","高","高","是","高","是"};
		FuzzyCMeans fcm=new FuzzyCMeans();
		double[][] simRes=fcm.getSimRes(demand);

	
		return simRes;
		
	}
}
