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
 * 此类用于在指定的主容器中启动CloudAgent
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
//		声明JADE内部类获取当前运行环境
		Runtime rt=Runtime.instance();
//		声明JADE内部类平台类，定义启动平台
		Profile pMain=new ProfileImpl(null,1099,null);
//		声明一个JADE内部类AgentContainer，创建主容器
		AgentContainer container = rt.createMainContainer(pMain);
		
		String s=new String("*");
//		声明一个JADE内部类AgentController对象，在容器中创建启动内部Agent类Sniffer。
		AgentController controller3= container.createNewAgent("mySniffer", "jade.tools.sniffer.Sniffer",null);
//		调用AgentController内部方法启动Agent
		controller3.start();
		//调用图形界面
		AgentController controller= container.createNewAgent("rma", "jade.tools.rma.rma", new Object[]{s});
//		调用AgentController内部方法启动Agent
		controller.start();
//		声明一个JADE内部类AgentController对象，在容器中创建启动CloudAgent。
		AgentController controller1=container.createNewAgent("Cloud", "multiagent.agents.CloudAgent", null);
//		调用AgentController内部方法启动Agent
		controller1.start();
		
		
	}
	
	private static int deleteall()throws Exception {
		int i = 0;
		//实例化连接器
		SQLConnector mysqlConnector = new SQLConnector(); 				
		//建立连接
		Connection conn=null;
//		建立数据库链接
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
//		  创建Statement 对象
		Statement statement=conn.createStatement();
//		声明SQL语句
		String str="delete from t_firmservice;";
//		执行操作
		i=statement.executeUpdate(str);	
		//声明SQL语句
		String sql="delete from t_agent;";
//		执行操作
		i=statement.executeUpdate(sql);	
//		执行SQL语句并返回执行结果		
		return i;

	}
	
	public void  startcloud() throws ControllerException {
		try {
			int i=deleteall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		声明JADE内部类获取当前运行环境
		Runtime rt=Runtime.instance();
//		声明JADE内部类平台类，定义启动平台
		Profile pMain=new ProfileImpl(null,1099,null);
//		声明一个JADE内部类AgentContainer，创建主容器
		AgentContainer container = rt.createMainContainer(pMain);
		
		String s=new String("*");
//		声明一个JADE内部类AgentController对象，在容器中创建启动内部Agent类Sniffer。
		AgentController controller3= container.createNewAgent("mySniffer", "jade.tools.sniffer.Sniffer",null);
//		调用AgentController内部方法启动Agent
		controller3.start();
		//调用图形界面
		AgentController controller= container.createNewAgent("rma", "jade.tools.rma.rma", new Object[]{s});
//		调用AgentController内部方法启动Agent
		controller.start();
//		声明一个JADE内部类AgentController对象，在容器中创建启动CloudAgent。
		AgentController controller1=container.createNewAgent("Cloud", "multiagent.agents.CloudAgent", null);
//		调用AgentController内部方法启动Agent
		controller1.start();
		
		
	}
}
