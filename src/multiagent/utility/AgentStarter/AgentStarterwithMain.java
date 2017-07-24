package multiagent.utility.AgentStarter;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
/**
 * 此类用于启动JADE平台创建主容器 
 * @author hanyuping
 */
public class AgentStarterwithMain {
	/**
	 * 
	 * @param args
	 * @throws ControllerException
	 */
	public static void main(String[] args) throws ControllerException {
//		声明JADE内部类获取当前运行环境
		Runtime rt=Runtime.instance();
//		声明JADE内部类平台类
		Profile pMain=new ProfileImpl(null,1099,null);
//		声明一个JADE内部类AgentContainer，创建主容器
		AgentContainer container = rt.createMainContainer(pMain);
		
		String s=new String("*");
		AgentController controller3= container.createNewAgent("mySniffer", "jade.tools.sniffer.Sniffer",null);
		controller3.start();
		//调用图形界面
		AgentController controller= container.createNewAgent("rma", "jade.tools.rma.rma", new Object[]{s});
//		调用AgentController内部方法启动Agent
		controller.start();
	}
}
