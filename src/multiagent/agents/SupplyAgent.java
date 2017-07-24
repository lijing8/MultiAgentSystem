package multiagent.agents;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;




import javassist.bytecode.analysis.ControlFlow.Block;
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
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

/**
* SupplyAgent类用于对汽车制造供应链上供应商行为的的模拟。
* 通过继承Agent父类，拥有Agent的通用功能行为。
* 为该Agent添加三个行为，分别为OneShotBehaviour、OneShotBehaviour以及SimpleBehaviour。
* 分别用于向云注册自身Agent基本信息以及本企业提供的服务信息，以及处理来自云的消息。
* 用FSMBehaviour组织这些行为的逻辑
* @author hanyuping
*/

public class SupplyAgent extends Agent{

	protected void setup(){	
		//声明一次 行为向云注册Agent，该类是JADE内部类
	
		OneShotBehaviour registAgent=new OneShotBehaviour() {
//			在此方法体中添加执行的操作
			@Override
			public void action() {
//				获取启动参数
				Object object=myAgent.getArguments();
//				声明AgentEntity数组对象
				AgentEntity []agentEntity=new AgentEntity[1];
//				获取启动参数
				agentEntity=(AgentEntity[]) myAgent.getArguments();
//				判断参数是否为空
				if (agentEntity!=null) {
//					声明JADE消息对象
				ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
//				为消息添加消息的接收者，前两行是远程通信接收者，后面一行是本地接收者
//				AID r=new AID("Cloud@192.168.1.156:1099/JADE");
//				r.addAddresses("http://hanyuping-PC:7778/acc");
				msg.addReceiver(new AID("Cloud", AID.ISLOCALNAME));
//				设置消息ID
				msg.setConversationId("Agent-information");

	  	  		try {
//	  	  			添加消息内容
					msg.setContentObject(agentEntity[0]);
				} catch (IOException e) {
					e.printStackTrace();
				}
//	  	  		发送消息
	  	  		send(msg);
				
				//存储交互信息
//	  	  		TransferTime ts=new TransferTime();
//	  	  		String date=ts.transferLongToDate("MM/ dd/yyyy HH:mm:ss",msg.getPostTimeStamp());
//	  	  	获取通信时间
	  	  		Date i=new Date();		
//	  	  		转换时间格式
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	  	  		声明保存对象，保存通信过程
				SaveCommunication saveCommunication=new SaveCommunication();
	  	  		saveCommunication.save(msg, agentEntity[0].getAgentName(), "Cloud",df.format(i));
				}
			}
//			注册结束后标记自身结束状态，用于有限状态机行为的识别
			public int onEnd(){
				return 1;
			}
		};
		//声明一次行为向云注册服务，该类是JADE内部类
		OneShotBehaviour registServiceBehaviour =new OneShotBehaviour() {
//			在此方法体中添加执行的操作
			@Override
			public void action() {
//				获取启动参数
				Object object=myAgent.getArguments();
//				声明AgentEntity数组对象
				AgentEntity []agentEntity=new AgentEntity[1];
//				获取启动参数
				agentEntity=(AgentEntity[]) myAgent.getArguments();
//				判断参数是否为空
				if (agentEntity!=null) {
//					声明ServiceEntity对象list
					MyList<ServiceEntity> suplyservicelist=new MyList<ServiceEntity>();
					try {
						//获取服务,Supply，Manul,sell
						suplyservicelist=getSupplyService(agentEntity[0].getAgentName());
					
						//声明JADE消息对象				
						ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
//						为消息添加消息的接收者，前两行是远程通信接收者，后面一行是本地接收者
//						AID r=new AID("Cloud@192.168.1.128:1099/JADE");
//						r.addAddresses("http://hanyuping-PC:7778/acc");
						msg.addReceiver(new AID("Cloud", AID.ISLOCALNAME));
//						设置消息ID
						msg.setConversationId("Service-register");
//						添加消息内容
						msg.setContentObject(suplyservicelist);
//						发送消息
						send(msg);
						//存储交互信息，
//						获取通信时间
						Date i=new Date();	
//						转换时间格式
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//						声明保存对象，保存通信过程
						SaveCommunication saveCommunication=new SaveCommunication();
			  	  		saveCommunication.save(msg, agentEntity[0].getAgentName(), "Cloud",df.format(i));
					
					} catch (UnreadableException e) {
							e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
//			注册结束后标记自身结束状态，用于有限状态机行为的识别
			public int onEnd(){
				return 2;
			}
		};
//		声明一个简单行为，将该简单行为设计满足条件才进入循环的行为
		Behaviour handle=new SimpleBehaviour() {
//			声明结束标志参数
			private boolean finish=false;	
			//状态转换参数
			int fsmparameter=0;	
//			在此方法体中添加执行的操作
				@Override
			public void action() {
//					声明JADE消息对象，用于接收消息
					ACLMessage msg1=receive();
//					判断消息是否为空
					if (msg1!=null) {
//						消息不为空，判断消息ID
						switch (msg1.getConversationId()) {
//						自身Agent注册信息
						case "Agent-information":
//							将结束参数设置为真，结束此行为
							finish=true;
//							判断消息的类型
							if (msg1.getPerformative()==ACLMessage.INFORM) {
//								向转态参数赋值为3表示注册Agent成功，可以转向下一个转态
								fsmparameter=3;
							}else {
//								向转态参数赋值为4表示注册不成功，重新注册
								fsmparameter=4;
							}
							break;
//							消息ID是注册服务消息
						case "Service-register":
//							结束参数设置为真，可以结束此行为进入下一个状态
							finish=true;
							if (msg1.getPerformative()==ACLMessage.INFORM) {
//								向转态参数赋值为5表示注册服务成功，可以转向下一个转态
								fsmparameter=5;
							}else {
//								向转态参数赋值为6表示注册服务不成功，不可以转向下一个转态
								fsmparameter=6;
							}
							
							break;
//							消息ID是注册服务消息
						case "Cloud-result":
							if (checkAction()) {
								System.out.println("supply:"+"Agent "+getLocalName()+": Agree");
								ACLMessage agree = msg1.createReply();
								agree.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
								agree.setPerformative(ACLMessage.AGREE);
								agree.setConversationId("Cloud-result");
								send(agree);
								
							}
							else {
								// We refuse to perform the action
								System.out.println("supply:"+"Agent "+getLocalName()+": Refuse");
								//throw new RefuseException("check-failed");
								ACLMessage Refuse = msg1.createReply();
								Refuse.setPerformative(ACLMessage.REFUSE);
								Refuse.setContent("refuse");
								Refuse.setConversationId("Cloud-result");
								send(Refuse);
							}
							
						
						default:
							
							break;
						}
						
						}else {
							finish=false;
//							向状态参数赋值为0，继续循环等待消息
							fsmparameter=0;
						}
					
					
				}
//				监测finish的值，来判断是否结束行为
			@Override
				public boolean done() {
					
					return finish;
				}	
//			返回状态转换参数
				public int onEnd() {
					return fsmparameter;
				}
			};

//			声明JADE中的有限状态机行为，管理上述三个行为的执行逻辑
		FSMBehaviour fsm=new FSMBehaviour(this);
//		向有限状态机添加Agent注册作为第一个状态，并命名为X
		fsm.registerFirstState(registAgent,"X");
//		向有限状态机添加行为服务注册作为另一个状态，并命名为Y
		fsm.registerState(registServiceBehaviour,"Y");
//		添加状态，简单行为，命名为z
		fsm.registerState(handle, "Z");
		//注册Agent
		fsm.registerTransition("X", "Z", 1);
		//注册Agent成功
		fsm.registerTransition("Z", "Y", 3);
		//注册Agent信息不成功
		fsm.registerTransition("Z", "X", 4);
		
		//注册服务
		fsm.registerTransition("Y", "Z", 2);
		//注册服务成功
		fsm.registerTransition("Z", "Z", 5);
		//注册服务失败
		fsm.registerTransition("Z", "Y", 6);
		
		this.addBehaviour(fsm);
		
		/*
		 
		SequentialBehaviour sq=new SequentialBehaviour();
		sq.addSubBehaviour(registAgent);
		sq.addSubBehaviour(registServiceBehaviour);
		this.addBehaviour(sq);
		Behaviour cycBehaviour=new CyclicBehaviour(this) {
			
			@Override
			public void action() {
				ACLMessage msg =myAgent.receive();
				if (msg!=null) {

					if (msg.getConversationId().equals("Cloud-result")) {
						if (checkAction()) {
								System.out.println("supply:"+"Agent "+getLocalName()+": Agree");
								ACLMessage agree = msg.createReply();
								agree.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
								agree.setPerformative(ACLMessage.AGREE);
								agree.setConversationId("Cloud-result");
								send(agree);
								
							}
							else {
								// We refuse to perform the action
								System.out.println("supply:"+"Agent "+getLocalName()+": Refuse");
								//throw new RefuseException("check-failed");
								ACLMessage Refuse = msg.createReply();
								Refuse.setPerformative(ACLMessage.REFUSE);
								Refuse.setContent("refuse");
								Refuse.setConversationId("Cloud-result");
								send(Refuse);
							}
					}
				}
			
			}
		};
		*/
	}
//	获取公司的服务列表，返回一个列表参数
	private static MyList<ServiceEntity> getSupplyService(String str)throws Exception {
//		声明数据库连接对象，连接数据库，进行数据库操作
		SQLConnector sqlConnector=new SQLConnector();
		
		//声明数据库操作的SQL语句，查询数据库表获取公司服务列表
		String sql="select * From  cloud.t_"+str+";";
		//String sql="select * From  test.t_"+str+"where FirmID like"+"'"+"supply%"+"'"+";";		
//		执行查询操作并将结果返回
		return sqlConnector.queryServiceEntities(sql);

	}
	private boolean checkAction() {
	  	//是否同意
	 return (Math.random() > 0);
	}
}
