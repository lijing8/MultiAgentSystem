package multiagent.utility.AgentStarter;

import jade.wrapper.ControllerException;

public class Start {
	public static void main(String[] args) throws Exception {
		//启动云
		StartCloud startcloud=new StartCloud();
		startcloud.startcloud();
		//启动Manu
		StartManu startManu=new StartManu();
		startManu.start();
		
		//启动Sale
		StartSale startsale=new StartSale();
        startsale.start();
		
		//启动Supply
		StartSupply startsupply=new StartSupply();
		startsupply.start();
		
	}

	public void  allstart() throws  Exception {
		       //启动云
				StartCloud startcloud=new StartCloud();
				startcloud.startcloud();
				//启动Manu
				StartManu startManu=new StartManu();
				startManu.start();
				
				//启动Sale
				StartSale startsale=new StartSale();
		        startsale.start();
				
				//启动Supply
				StartSupply startsupply=new StartSupply();
				startsupply.start();
	}
}
