package multiagent.utility.AgentStarter;

import jade.wrapper.ControllerException;

public class Start {
	public static void main(String[] args) throws Exception {
		//������
		StartCloud startcloud=new StartCloud();
		startcloud.startcloud();
		//����Manu
		StartManu startManu=new StartManu();
		startManu.start();
		
		//����Sale
		StartSale startsale=new StartSale();
        startsale.start();
		
		//����Supply
		StartSupply startsupply=new StartSupply();
		startsupply.start();
		
	}

	public void  allstart() throws  Exception {
		       //������
				StartCloud startcloud=new StartCloud();
				startcloud.startcloud();
				//����Manu
				StartManu startManu=new StartManu();
				startManu.start();
				
				//����Sale
				StartSale startsale=new StartSale();
		        startsale.start();
				
				//����Supply
				StartSupply startsupply=new StartSupply();
				startsupply.start();
	}
}
