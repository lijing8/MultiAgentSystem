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
 * ����������ָ��������������ManualAgent
 * @author hanyuping
 *
 */
public class StartManu {
//	����JADE�ڲ����ȡ��ǰ���л���
	Runtime rt=Runtime.instance();
//	����JADE�ڲ���ƽ̨�࣬��������ƽ̨
	Profile pMain=new ProfileImpl();
//	������ҵʵ��List�б�
	List<FirmEntity> listManual=new ArrayList<FirmEntity>();
//	����AgentStarter�����
	AgentStarter agentStarter=new AgentStarter();
//	�Զ�����������
	public void startmanual() throws Exception{
		String localip;
		InetAddress ia=null;
		ia=ia.getLocalHost();		
		localip=ia.getHostAddress();
//		��ȡ���ݿ��е���ҵ�б�
		listManual=getManual();
//		Ϊ����ƽ̨���ò�����IP��ַ
		pMain.setParameter(Profile.MAIN_HOST, localip);
//		Ϊ����ƽ̨���ò������ӿ�
		pMain.setParameter(Profile.MAIN_PORT, "1099");
//		Ϊ����ƽ̨���ò�������������
		pMain.setParameter(Profile.CONTAINER_NAME, "Manu-Container");
//		����һ��JADE�ڲ���ContainerController�������µ�����
		ContainerController cc=rt.createAgentContainer(pMain);
//		������ҵ�б���������Agent
		for(int i = 0;i < listManual.size(); i ++){
//			����AgentEntity��������
		AgentEntity []agentEntity=new AgentEntity[1];
//			ΪAgentEntity���ó�Ա����ֵ
		agentEntity[0]=new AgentEntity();
		agentEntity[0].setAgentID("Agent"+listManual.get(i).getFirmID());
		agentEntity[0].setAgentName(listManual.get(i).getFirmID());;
		agentEntity[0].setAgentAddress(localip+":1099");
		agentEntity[0].setAgentRole("Manul");
//		����AgentStarter��һ����Ա��������Agent
		agentStarter.startAgentwithContainer(cc, listManual.get(i).getFirmID(), "multiagent.agents.ManualAgent", agentEntity);
		
		}
	}
//	�������������������
	public static void main(String[] args) throws Exception {
//		��������󣬵�����������
		StartManu startManu=new StartManu();
		startManu.startmanual();
	}
//	��ȡ��ҵ�б�
	private static List<FirmEntity> getManual()throws Exception {
//		�������ݿ������࣬�����ݿ�
		SQLConnector sqlConnector=new SQLConnector();
//		����SQL���
		String str="select * From  cloud.t_firm where FirmID like"+"'"+"Manul%"+"'"+";";
//		ִ��SQL��䲢����ִ�н��	
		return sqlConnector.query(str);

	}
	
	public void  start() throws  Exception {
//		��������󣬵�����������
		StartManu startManu=new StartManu();
		startManu.startmanual();
	}
}
