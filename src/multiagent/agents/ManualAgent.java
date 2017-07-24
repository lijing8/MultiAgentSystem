package multiagent.agents;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import multiagent.utility.DBoperater.SQLConnector;
import multiagent.utility.DBoperater.SaveCommunication;
import multiagent.utility.others.MyList;
import web.entity.AgentEntity;
import web.entity.ServiceEntity;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
/**
 * ManualAgent�����ڶ��������칩Ӧ������������Ϊ�ĵ�ģ�⡣
 * ͨ���̳�Agent���࣬ӵ��Agent��ͨ�ù�����Ϊ��Ϊ��Agent����������Ϊ��
 * �ֱ�ΪOneShotBehaviour��OneShotBehaviour�Լ�SimpleBehaviour��
 * �ֱ���������ע������Agent������Ϣ�Լ�����ҵ�ṩ�ķ�����Ϣ���Լ����������Ƶ���Ϣ��
 * ��FSMBehaviour��֯��Щ��Ϊ���߼�.
 * @author hanyuping
 *
 */
public class ManualAgent extends Agent{
	
	protected void setup(){	
		//����һ����Ϊ����ע��Agent��������JADE�ڲ���
		OneShotBehaviour registAgent =new OneShotBehaviour() {
//			�ڴ˷�����������ִ�еĲ���
			@Override
			public void action() {
//				��ȡ��������
				Object object=myAgent.getArguments();
//				����AgentEntity�������
				AgentEntity []agentEntity=new AgentEntity[1];
//				��ȡ��������
				agentEntity=(AgentEntity[]) myAgent.getArguments();
//				�жϲ����Ƿ�Ϊ��
				if (agentEntity!=null) {
//					����JADE��Ϣ����
				ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
//				Ϊ��Ϣ������Ϣ�Ľ����ߣ�ǰ������Զ��ͨ�Ž����ߣ�����һ���Ǳ��ؽ�����
//				AID r=new AID("Cloud@192.168.1.128:1099/JADE");
//				r.addAddresses("http://hanyuping-PC:7778/acc");
				msg.addReceiver(new AID("Cloud", AID.ISLOCALNAME));
//				������ϢID
				msg.setConversationId("Agent-information");

	  	  		try {
//	  	  			������Ϣ����
					msg.setContentObject(agentEntity[0]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//	  	  		������Ϣ
	  	  		send(msg);
	  	  		
	  	  	//�洢������Ϣ
//	  	  		TransferTime ts=new TransferTime();
//	  	  		String date=ts.transferLongToDate("MM/ dd/yyyy HH:mm:ss",msg.getPostTimeStamp());
//		  	  ��ȡͨ��ʱ��
	  	  		Date i=new Date();		
//	  	  		ת��ʱ���ʽ
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	  	  		����������󣬱���ͨ�Ź���
				SaveCommunication saveCommunication=new SaveCommunication();
	  	  		saveCommunication.save(msg, agentEntity[0].getAgentName(), "Cloud",df.format(i));
				}
			}
			//ע�����������������״̬����������״̬����Ϊ��ʶ��
			public int onEnd(){
				return 1;
			}
		};
		
		////����һ����Ϊ����ע����񣬸�����JADE�ڲ���
		OneShotBehaviour registServiceBehaviour =new OneShotBehaviour() {
//			�ڴ˷�����������ִ�еĲ���
			@Override
			public void action() {
//				��ȡ��������
				Object object=myAgent.getArguments();
//				����AgentEntity�������
				AgentEntity []agentEntity=new AgentEntity[1];
//				��ȡ��������
				agentEntity=(AgentEntity[]) myAgent.getArguments();
//				�жϲ����Ƿ�Ϊ��			
				if (agentEntity!=null) {
//					����ServiceEntity����list
					MyList<ServiceEntity> manulservicelist=new MyList<ServiceEntity>();
					try {
						//��ȡ����,Supply��Manul,sell
						manulservicelist=getManulService(agentEntity[0].getAgentName());
					
//						����JADE��Ϣ����			
						ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
//						Ϊ��Ϣ������Ϣ�Ľ����ߣ�ǰ������Զ��ͨ�Ž����ߣ�����һ���Ǳ��ؽ�����
//						AID r=new AID("Cloud@192.168.1.128:1099/JADE");
//						r.addAddresses("http://hanyuping-PC:7778/acc");
						msg.addReceiver(new AID("Cloud", AID.ISLOCALNAME));
//						������ϢID
						msg.setConversationId("Service-register");
//		  	  			������Ϣ����
						msg.setContentObject(manulservicelist);
						//������Ϣ
						send(msg);
						//�洢������Ϣ
						//TransferTime ts=new TransferTime();
			  	  		//String date=ts.transferLongToDate("MM/ dd/yyyy HH:mm:ss",msg.getPostTimeStamp());
//					  	  ��ȡͨ��ʱ��
						Date i=new Date();	
//			  	  		ת��ʱ���ʽ
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			  	  		����������󣬱���ͨ�Ź���
			  	  		SaveCommunication saveCommunication=new SaveCommunication();
			  	  		saveCommunication.save(msg, agentEntity[0].getAgentName(), "Cloud",df.format(i));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			//ע�����������������״̬����������״̬����Ϊ��ʶ��
			public int onEnd(){
				return 2;
			}
		};
		//����һ������Ϊ�����ü���Ϊ������������Ž���ѭ������Ϊ
		Behaviour handle=new SimpleBehaviour() {
//			����������־����
			private boolean finish=false;	
			//״̬ת������
			int fsmparameter=0;	
//			�ڴ˷�����������ִ�еĲ���
				@Override
			public void action() {
					
//					����JADE��Ϣ�������ڽ�����Ϣ	
				ACLMessage msg1=receive();
//				�ж���Ϣ�Ƿ�Ϊ��
					if (msg1!=null) {
//						��Ϣ��Ϊ�գ��ж���ϢID
						switch (msg1.getConversationId()) {
//						����Agentע����Ϣ
						case "Agent-information":
//							��������������Ϊ�棬��������Ϊ
							finish=true;
//							�ж���Ϣ������
							if (msg1.getPerformative()==ACLMessage.INFORM) {
//								��ת̬������ֵΪ3��ʾע��Agent�ɹ�������ת����һ��ת̬
								fsmparameter=3;
							}else {
//								��ת̬������ֵΪ4��ʾע�᲻�ɹ�������ע��
								fsmparameter=4;
							}
							break;
//							��ϢID��ע�������Ϣ
						case "Service-register":
//						������������Ϊ�棬���Խ�������Ϊ������һ��״̬
							finish=true;
							if (msg1.getPerformative()==ACLMessage.INFORM) {
//							��ת̬������ֵΪ5��ʾע�����ɹ�������ת����һ��ת̬	
								fsmparameter=5;
							}else {
//								��ת̬������ֵΪ6��ʾע����񲻳ɹ���������ת����һ��ת̬
								fsmparameter=6;
							}
							
							break;
//						
						case "Cloud-result":
							
							
						
						default:
							
							break;
						}
						
						}else {
							finish=false;
//							��״̬������ֵΪ0������ѭ���ȴ���Ϣ
							fsmparameter=0;
						}
					
					
				}
//				���finish��ֵ�����ж��Ƿ������Ϊ
			@Override
				public boolean done() {
					
					return finish;
				}
//			����״̬ת������
				public int onEnd() {
					return fsmparameter;
				}
			};

//	����JADE�е�����״̬����Ϊ����������������Ϊ��ִ���߼�
		FSMBehaviour fsm=new FSMBehaviour(this);
//		������״̬������Agentע����Ϊ��һ��״̬��������ΪX
		fsm.registerFirstState(registAgent,"X");
//		������״̬��������Ϊ����ע����Ϊ��һ��״̬��������ΪY
		fsm.registerState(registServiceBehaviour,"Y");
//		����״̬������Ϊ������Ϊz
		fsm.registerState(handle, "Z");
		//ע��Agent
		fsm.registerTransition("X", "Z", 1);
		//ע��Agent�ɹ�
		fsm.registerTransition("Z", "Y", 3);
		//ע��Agent��Ϣ���ɹ�
		fsm.registerTransition("Z", "X", 4);
		
		//ע�����
		fsm.registerTransition("Y", "Z", 2);
		//ע�����ɹ�
		fsm.registerTransition("Z", "Z", 5);
		//ע�����ʧ��
		fsm.registerTransition("Z", "Y", 6);
//	��Agent���ӱ�����״̬����Ϊ
		this.addBehaviour(fsm);
		


	}
	//��ȡ��˾�ķ����б�������һ���б�����
	private static MyList<ServiceEntity> getManulService(String str)throws Exception {
//		�������ݿ����Ӷ����������ݿ⣬�������ݿ����
		SQLConnector sqlConnector=new SQLConnector();
		
		//�������ݿ������SQL��䣬��ѯ���ݿ����ȡ��˾�����б�
		String sql="select * From  cloud.t_"+str+";";
		//String sql="select * From  test.t_"+str+"where FirmID like"+"'"+"supply%"+"'"+";";		
//		ִ�в�ѯ���������������
		return sqlConnector.queryServiceEntities(sql);

	}
//	������������ǹ��ɹ�
	private boolean checkAction() {
	  	//�Ƿ�ͬ��
	 return (Math.random() > 0);
	}
}