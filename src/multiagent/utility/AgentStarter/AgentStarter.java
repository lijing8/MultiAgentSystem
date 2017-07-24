package multiagent.utility.AgentStarter;


import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;

import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
/**
 * 此类用于外部启动Agent类，类中包括两个成员方法 
 * @author hanyuping
 */
public class AgentStarter {
	
	/**
	 * 在已有的容器中启动Agent
	 * @param cc 已有容器
	 * @param firmID Agent启动名称
	 * @param classsString Agent类名包括包名
	 * @param agentEntity 启动参数
	 * @throws StaleProxyException 异常抛出
	 */
		public void startAgentwithContainer(ContainerController cc, String firmID,
				String classsString,Object[] agentEntity) throws StaleProxyException {
//			判断容器是否为空
			if (cc!=null) {	
//				声明一个JADE内部类AgentController对象，在容器中创建启动Agent。
				AgentController ac= cc.createNewAgent(firmID, classsString, agentEntity);	
//				调用AgentController内部方法启动Agent
					ac.start();								
					  			
			}
		
			
		}
		
	/**
	 * 启动Agent程序，
	 * @param host 平台IP地址
	 * @param port 平台接口
	 * @param name Agent启动名称
	 * @param classsString Agent类名包括包名
	 * @param object 启动实体参数数组
	 * @throws StaleProxyException 异常
	 */
	public void startAgent(String host,String port,String name,String classsString,Object[] object) throws StaleProxyException {
//		声明JADE内部类获取当前运行环境
		Runtime rt=Runtime.instance();
//		声明JADE内部类平台类，定义启动平台
		Profile pMain=new ProfileImpl();
//		为平台设置参数，包括平台的IP
		pMain.setParameter(Profile.MAIN_HOST, host);
//		为平台设置端口号
		pMain.setParameter(Profile.MAIN_PORT, port);
		
		
		Boolean blBoolean=pMain.isMain();
//		判断容器是够为主容器
		if (pMain.isMain()) {
		//	ContainerID containerID=new ContainerID("1-Container",transportAddress);
//			声明一个JADE内部类ContainerController，创建新的容器
			ContainerController cc=rt.createAgentContainer(pMain);
			if (cc!=null) {	
//				声明一个JADE内部类AgentController对象，在容器中创建启动Agent。
				AgentController ac= cc.createNewAgent(name, classsString, object);	
//				调用AgentController内部方法启动Agent
					ac.start();								
					  			
			}
		}else {
//			声明一个JADE内部类AgentContainer，创建主容器
			AgentContainer container = rt.createMainContainer(pMain);
			
			String s=new String("*");
			//AgentController controller3= container.createNewAgent("mySniffer", "jade.tools.sniffer.Sniffer",null);
			//controller3.start();
			//调用图形界面			
			AgentController controller= container.createNewAgent("rma", "jade.tools.rma.rma", new Object[]{s});
//			调用AgentController内部方法启动Agent
			controller.start();
//			声明一个JADE内部类AgentController对象，在容器中创建启动Agent。
			AgentController ac= container.createNewAgent(name, classsString, object);	
//			调用AgentController内部方法启动Agent
			ac.start();			
		}
		
		
		
		
		
	}
	
}

