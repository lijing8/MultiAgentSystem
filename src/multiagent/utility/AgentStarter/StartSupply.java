package multiagent.utility.AgentStarter;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.ContainerController;

import java.util.ArrayList;
import java.util.List;





import multiagent.agents.SupplyAgent;
import multiagent.utility.DBoperater.SQLConnector;
import web.entity.AgentEntity;
import web.entity.FirmEntity;

import java.net.InetAddress;

/**
 * ����������ָ��������������SupplyAgent
 * @author hanyuping
 *
 */
public class StartSupply {
//	����JADE�ڲ����ȡ��ǰ���л���
	Runtime rt=Runtime.instance();
//	����JADE�ڲ���ƽ̨�࣬��������ƽ̨
	Profile pMain=new ProfileImpl();
//	������ҵʵ��List�б�
	List<FirmEntity> listSupply=new ArrayList<FirmEntity>();
//	����AgentStarter�����
	AgentStarter agentStarter=new AgentStarter();
//	�Զ�����������
	public void startsupply() throws Exception{
		String localip;
		InetAddress ia=null;
		ia=ia.getLocalHost();		
		localip=ia.getHostAddress();
//		��ȡ���ݿ��е���ҵ�б�
		listSupply=getSupply();
//		Ϊ����ƽ̨���ò�����IP��ַ
		pMain.setParameter(Profile.MAIN_HOST, localip);
//		Ϊ����ƽ̨���ò������ӿ�
		pMain.setParameter(Profile.MAIN_PORT, "1099");
//		Ϊ����ƽ̨���ò�������������
		pMain.setParameter(Profile.CONTAINER_NAME, "Supply-Container");
//		����һ��JADE�ڲ���ContainerController�������µ�����
		ContainerController cc=rt.createAgentContainer(pMain);
//		������ҵ�б���������Agent
		for(int i = 0;i < listSupply.size(); i ++){
//		����AgentEntity��������
		AgentEntity []agentEntity=new AgentEntity[1];
//		ΪAgentEntity���ó�Ա����ֵ
		agentEntity[0]=new AgentEntity();
		agentEntity[0].setAgentID("Agent"+listSupply.get(i).getFirmID());
		agentEntity[0].setAgentName(listSupply.get(i).getFirmID());;
		agentEntity[0].setAgentAddress(localip+":1099");
		agentEntity[0].setAgentRole("Supply");
//		����AgentStarter��һ����Ա��������Agent
		agentStarter.startAgentwithContainer(cc, listSupply.get(i).getFirmID(), "multiagent.agents.SupplyAgent", agentEntity);
		
		}
	}
//	�������������������
	public static void main(String[] args) throws Exception {
//		��������󣬵�����������
		StartSupply startSupply=new StartSupply();
		startSupply.startsupply();
		
//		List<FirmEntity> listSupply=new ArrayList<FirmEntity>();
//		listSupply=getSupply();
//		
//		for(int i = 0;i < listSupply.size(); i ++){
//	//	System.out.println(listSupply.get(i).getFirmID());
//		AgentStarter agentStarter=new AgentStarter();
//		
//		AgentEntity []agentEntity=new AgentEntity[1];
//		agentEntity[0]=new AgentEntity();
//		agentEntity[0].setAgentID("Agent"+listSupply.get(i).getFirmID());
//		agentEntity[0].setAgentName(listSupply.get(i).getFirmID());;
//		agentEntity[0].setAgentAddress("192.168.1.156:1099");
//		agentEntity[0].setAgentRole("Supply");
//		//Agent start=new Cloud();
//		//agentStarter.startUp(start, listSupply.get(i).getFirmID(), "multiagent.agents.SupplyAgent", "Main-Container",agentEntity);
//		agentStarter.startAgent("192.168.1.156", "1099","Supply-Container", listSupply.get(i).getFirmID(), "multiagent.agents.SupplyAgent", agentEntity);
//		}
	}
//	��ȡ��ҵ�б�
	private static List<FirmEntity> getSupply()throws Exception {
//		�������ݿ������࣬�����ݿ�
		SQLConnector sqlConnector=new SQLConnector();
		
//		����SQL���
		String str="select * From  cloud.t_firm where FirmID like"+"'"+"Supply%"+"'"+";";
//		ִ��SQL��䲢����ִ�н��		
		return sqlConnector.query(str);

	}

	public void  start() throws  Exception {	
//		��������󣬵�����������
		StartSupply startSupply=new StartSupply();
		startSupply.startsupply();
	}
}
