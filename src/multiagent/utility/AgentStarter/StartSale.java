package multiagent.utility.AgentStarter;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.ContainerController;

import java.util.ArrayList;
import java.util.List;

import multiagent.utility.DBoperater.SQLConnector;
import web.entity.AgentEntity;
import web.entity.FirmEntity;

import java.net.InetAddress;
/**
 * ����������ָ��������������StartSale
 * @author hanyuping
 *
 */
public class StartSale {
//	����JADE�ڲ����ȡ��ǰ���л���
	Runtime rt=Runtime.instance();
//	����JADE�ڲ���ƽ̨�࣬��������ƽ̨
	Profile pMain=new ProfileImpl();
//	������ҵʵ��List�б�
	List<FirmEntity> listSale=new ArrayList<FirmEntity>();
//	����AgentStarter�����
	AgentStarter agentStarter=new AgentStarter();
	/**
	 * 
	 * @throws Exception
	 */
//	�Զ�����������
	public void startsale() throws Exception{
		String localip;
		InetAddress ia=null;
		ia=ia.getLocalHost();		
		localip=ia.getHostAddress();
		String IP=localip;
//		��ȡ���ݿ��е���ҵ�б�
		listSale=getSale();
//		Ϊ����ƽ̨���ò�����IP��ַ
		pMain.setParameter(Profile.MAIN_HOST, IP);
//		Ϊ����ƽ̨���ò������ӿ�
		pMain.setParameter(Profile.MAIN_PORT, "1099");
//		Ϊ����ƽ̨���ò�������������
		pMain.setParameter(Profile.CONTAINER_NAME, "Sale-Container");
//		����һ��JADE�ڲ���ContainerController�������µ�����
		ContainerController cc=rt.createAgentContainer(pMain);
//		������ҵ�б���������Agent
		for(int i = 0;i < listSale.size(); i ++){
//			����AgentEntity��������
			AgentEntity []agentEntity=new AgentEntity[1];
//			ΪAgentEntity���ó�Ա����ֵ
			agentEntity[0]=new AgentEntity();
			agentEntity[0].setAgentID("Agent"+listSale.get(i).getFirmID());
			agentEntity[0].setAgentName(listSale.get(i).getFirmID());;
			agentEntity[0].setAgentAddress(IP+":1099");
			agentEntity[0].setAgentRole("Sell");
//			����AgentStarter��һ����Ա��������Agent
		agentStarter.startAgentwithContainer(cc, listSale.get(i).getFirmID(), "multiagent.agents.SaleAgent", agentEntity);
		
		}
	}
//	�������������������
	public static void main(String[] args) throws Exception {
//		��������󣬵�����������
		StartSale startsale=new StartSale();
		startsale.startsale();
	}
//	��ȡ��ҵ�б�
	private static List<FirmEntity> getSale()throws Exception {
//		�������ݿ������࣬�����ݿ�
		SQLConnector sqlConnector=new SQLConnector();
		
//		����SQL���
		String str="select * From  cloud.t_firm where FirmID like"+"'"+"Sell%"+"'"+";";
//		ִ��SQL��䲢����ִ�н��		
		return sqlConnector.query(str);

	}
	
	public void  start() throws  Exception {	
//		��������󣬵�����������
		StartSale startsale=new StartSale();
		startsale.startsale();
	}
	
}
