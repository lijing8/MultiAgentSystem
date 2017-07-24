package multiagent.utility.AgentStarter;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
/**
 * ������������JADEƽ̨���������� 
 * @author hanyuping
 */
public class AgentStarterwithMain {
	/**
	 * 
	 * @param args
	 * @throws ControllerException
	 */
	public static void main(String[] args) throws ControllerException {
//		����JADE�ڲ����ȡ��ǰ���л���
		Runtime rt=Runtime.instance();
//		����JADE�ڲ���ƽ̨��
		Profile pMain=new ProfileImpl(null,1099,null);
//		����һ��JADE�ڲ���AgentContainer������������
		AgentContainer container = rt.createMainContainer(pMain);
		
		String s=new String("*");
		AgentController controller3= container.createNewAgent("mySniffer", "jade.tools.sniffer.Sniffer",null);
		controller3.start();
		//����ͼ�ν���
		AgentController controller= container.createNewAgent("rma", "jade.tools.rma.rma", new Object[]{s});
//		����AgentController�ڲ���������Agent
		controller.start();
	}
}
