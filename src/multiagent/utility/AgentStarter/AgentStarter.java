package multiagent.utility.AgentStarter;


import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;

import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
/**
 * ���������ⲿ����Agent�࣬���а���������Ա���� 
 * @author hanyuping
 */
public class AgentStarter {
	
	/**
	 * �����е�����������Agent
	 * @param cc ��������
	 * @param firmID Agent��������
	 * @param classsString Agent������������
	 * @param agentEntity ��������
	 * @throws StaleProxyException �쳣�׳�
	 */
		public void startAgentwithContainer(ContainerController cc, String firmID,
				String classsString,Object[] agentEntity) throws StaleProxyException {
//			�ж������Ƿ�Ϊ��
			if (cc!=null) {	
//				����һ��JADE�ڲ���AgentController�����������д�������Agent��
				AgentController ac= cc.createNewAgent(firmID, classsString, agentEntity);	
//				����AgentController�ڲ���������Agent
					ac.start();								
					  			
			}
		
			
		}
		
	/**
	 * ����Agent����
	 * @param host ƽ̨IP��ַ
	 * @param port ƽ̨�ӿ�
	 * @param name Agent��������
	 * @param classsString Agent������������
	 * @param object ����ʵ���������
	 * @throws StaleProxyException �쳣
	 */
	public void startAgent(String host,String port,String name,String classsString,Object[] object) throws StaleProxyException {
//		����JADE�ڲ����ȡ��ǰ���л���
		Runtime rt=Runtime.instance();
//		����JADE�ڲ���ƽ̨�࣬��������ƽ̨
		Profile pMain=new ProfileImpl();
//		Ϊƽ̨���ò���������ƽ̨��IP
		pMain.setParameter(Profile.MAIN_HOST, host);
//		Ϊƽ̨���ö˿ں�
		pMain.setParameter(Profile.MAIN_PORT, port);
		
		
		Boolean blBoolean=pMain.isMain();
//		�ж������ǹ�Ϊ������
		if (pMain.isMain()) {
		//	ContainerID containerID=new ContainerID("1-Container",transportAddress);
//			����һ��JADE�ڲ���ContainerController�������µ�����
			ContainerController cc=rt.createAgentContainer(pMain);
			if (cc!=null) {	
//				����һ��JADE�ڲ���AgentController�����������д�������Agent��
				AgentController ac= cc.createNewAgent(name, classsString, object);	
//				����AgentController�ڲ���������Agent
					ac.start();								
					  			
			}
		}else {
//			����һ��JADE�ڲ���AgentContainer������������
			AgentContainer container = rt.createMainContainer(pMain);
			
			String s=new String("*");
			//AgentController controller3= container.createNewAgent("mySniffer", "jade.tools.sniffer.Sniffer",null);
			//controller3.start();
			//����ͼ�ν���			
			AgentController controller= container.createNewAgent("rma", "jade.tools.rma.rma", new Object[]{s});
//			����AgentController�ڲ���������Agent
			controller.start();
//			����һ��JADE�ڲ���AgentController�����������д�������Agent��
			AgentController ac= container.createNewAgent(name, classsString, object);	
//			����AgentController�ڲ���������Agent
			ac.start();			
		}
		
		
		
		
		
	}
	
}

