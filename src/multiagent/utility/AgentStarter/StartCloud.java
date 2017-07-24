package multiagent.utility.AgentStarter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import multiagent.utility.DBoperater.SQLConnector;
import web.entity.FirmEntity;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
/**
 * ����������ָ����������������CloudAgent
 * @author hanyuping
 *
 */
public class StartCloud {
	/**
	 * 
	 * @param args
	 * @throws ControllerException
	 */
	public static void main(String[] args) throws ControllerException {
		try {
			int i=deleteall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		����JADE�ڲ����ȡ��ǰ���л���
		Runtime rt=Runtime.instance();
//		����JADE�ڲ���ƽ̨�࣬��������ƽ̨
		Profile pMain=new ProfileImpl(null,1099,null);
//		����һ��JADE�ڲ���AgentContainer������������
		AgentContainer container = rt.createMainContainer(pMain);
		
		String s=new String("*");
//		����һ��JADE�ڲ���AgentController�����������д��������ڲ�Agent��Sniffer��
		AgentController controller3= container.createNewAgent("mySniffer", "jade.tools.sniffer.Sniffer",null);
//		����AgentController�ڲ���������Agent
		controller3.start();
		//����ͼ�ν���
		AgentController controller= container.createNewAgent("rma", "jade.tools.rma.rma", new Object[]{s});
//		����AgentController�ڲ���������Agent
		controller.start();
//		����һ��JADE�ڲ���AgentController�����������д�������CloudAgent��
		AgentController controller1=container.createNewAgent("Cloud", "multiagent.agents.CloudAgent", null);
//		����AgentController�ڲ���������Agent
		controller1.start();
		
		
	}
	
	private static int deleteall()throws Exception {
		int i = 0;
		//ʵ����������
		SQLConnector mysqlConnector = new SQLConnector(); 				
		//��������
		Connection conn=null;
//		�������ݿ�����
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
//		  ����Statement ����
		Statement statement=conn.createStatement();
//		����SQL���
		String str="delete from t_firmservice;";
//		ִ�в���
		i=statement.executeUpdate(str);	
		//����SQL���
		String sql="delete from t_agent;";
//		ִ�в���
		i=statement.executeUpdate(sql);	
//		ִ��SQL��䲢����ִ�н��		
		return i;

	}
	
	public void  startcloud() throws ControllerException {
		try {
			int i=deleteall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		����JADE�ڲ����ȡ��ǰ���л���
		Runtime rt=Runtime.instance();
//		����JADE�ڲ���ƽ̨�࣬��������ƽ̨
		Profile pMain=new ProfileImpl(null,1099,null);
//		����һ��JADE�ڲ���AgentContainer������������
		AgentContainer container = rt.createMainContainer(pMain);
		
		String s=new String("*");
//		����һ��JADE�ڲ���AgentController�����������д��������ڲ�Agent��Sniffer��
		AgentController controller3= container.createNewAgent("mySniffer", "jade.tools.sniffer.Sniffer",null);
//		����AgentController�ڲ���������Agent
		controller3.start();
		//����ͼ�ν���
		AgentController controller= container.createNewAgent("rma", "jade.tools.rma.rma", new Object[]{s});
//		����AgentController�ڲ���������Agent
		controller.start();
//		����һ��JADE�ڲ���AgentController�����������д�������CloudAgent��
		AgentController controller1=container.createNewAgent("Cloud", "multiagent.agents.CloudAgent", null);
//		����AgentController�ڲ���������Agent
		controller1.start();
		
		
	}
}
