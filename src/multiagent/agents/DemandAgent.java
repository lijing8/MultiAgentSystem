package multiagent.agents;

import java.io.IOException;
import java.io.Serializable;

import web.entity.DemandEntity;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
/**
 * DemandAgent类是连接Web前台交互界面和多Agent系统的中间件，
 * 是一个即时Agent，不常驻系统。通过继承Agent父类，拥有Agent的通用功能行为
 * ，主要具备发送消息的能力。 * 为该Agent添加一个行为用于向云服务发送消息OneShotBehaviour。
 * @author hanyuping
 *
 */
public class DemandAgent extends Agent implements Serializable {


	protected void setup(){
		//		添加JADE一次性行为
		addBehaviour(new OneShotBehaviour(this) {

			@Override
			//			在action（）方法体中添加执行内容
			public void action() {
				//				获取Agent启动参数
				Object object=myAgent.getArguments();
				//				声明DemandEntity对象数组
				DemandEntity []demandEntity=new DemandEntity[1];
				//				强制转换
				demandEntity=(DemandEntity[]) myAgent.getArguments();
				//				判断参数是够为空
				if (demandEntity!=null) {


					//	System.out.println(demandEntity.getDemandID()+";"+demandEntity.getDemandName());
//					声明JADE消息对象
					ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
//					为消息添加接收者
					//				AID r=new AID("Cloud@192.168.1.128:1099/JADE");
					//				r.addAddresses("http://hanyuping-PC:7778/acc");
					msg.addReceiver(new AID("Cloud", AID.ISLOCALNAME));

					try {
//						设置消息ID
						msg.setConversationId("demand-information");
//						添加消息内容
						msg.setContentObject(demandEntity[0]);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					发送消息
					send(msg);
//					调用doDelete()消灭自己
					myAgent.doDelete();
				}else {
					myAgent.doDelete();
				}
			}
		});


	}

}
