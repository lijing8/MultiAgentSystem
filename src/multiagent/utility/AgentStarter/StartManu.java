package multiagent.utility.AgentStarter;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.ContainerController;
import jade.wrapper.ControllerException;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import multiagent.utility.DBoperater.SQLConnector;
import web.entity.AgentEntity;
import web.entity.FirmEntity;

import java.net.InetAddress;
/**
 * 此类用于在指定的容器中启动ManualAgent
 * @author hanyuping
 *
 */
public class StartManu {
//	声明JADE内部类获取当前运行环境
	Runtime rt=Runtime.instance();
//	声明JADE内部类平台类，定义启动平台
	Profile pMain=new ProfileImpl();
//	声明企业实体List列表
	List<FirmEntity> listManual=new ArrayList<FirmEntity>();
//	声明AgentStarter类对象
	AgentStarter agentStarter=new AgentStarter();
//	自定义启动函数
	public void startmanual() throws Exception{
		String localip;
		InetAddress ia=null;
		ia=ia.getLocalHost();		
		localip=ia.getHostAddress();
//		获取数据库中的企业列表
		listManual=getManual();
//		为启动平台设置参数，IP地址
		pMain.setParameter(Profile.MAIN_HOST, localip);
//		为启动平台设置参数，接口
		pMain.setParameter(Profile.MAIN_PORT, "1099");
//		为启动平台设置参数，容器名称
		pMain.setParameter(Profile.CONTAINER_NAME, "Manu-Container");
//		声明一个JADE内部类ContainerController，创建新的容器
		ContainerController cc=rt.createAgentContainer(pMain);
//		根据企业列表依次启动Agent
		for(int i = 0;i < listManual.size(); i ++){
//			声明AgentEntity对象数组
		AgentEntity []agentEntity=new AgentEntity[1];
//			为AgentEntity设置成员变量值
		agentEntity[0]=new AgentEntity();
		agentEntity[0].setAgentID("Agent"+listManual.get(i).getFirmID());
		agentEntity[0].setAgentName(listManual.get(i).getFirmID());;
		agentEntity[0].setAgentAddress(localip+":1099");
		agentEntity[0].setAgentRole("Manul");
//		调用AgentStarter第一个成员函数启动Agent
		agentStarter.startAgentwithContainer(cc, listManual.get(i).getFirmID(), "multiagent.agents.ManualAgent", agentEntity);
		
		}
	}
//	主函数，控制类的运行
	public static void main(String[] args) throws Exception {
//		声明类对象，调用启动函数
		StartManu startManu=new StartManu();
		startManu.startmanual();
	}
//	获取企业列表
	private static List<FirmEntity> getManual()throws Exception {
//		声明数据库连接类，打开数据库
		SQLConnector sqlConnector=new SQLConnector();
//		声明SQL语句
		String str="select * From  cloud.t_firm where FirmID like"+"'"+"Manul%"+"'"+";";
//		执行SQL语句并返回执行结果	
		return sqlConnector.query(str);

	}
	
	public void  start() throws  Exception {
//		声明类对象，调用启动函数
		StartManu startManu=new StartManu();
		startManu.startmanual();
	}
}
