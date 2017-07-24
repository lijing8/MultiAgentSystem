package multiagent.agents;

import java.io.IOException;
import java.io.Serializable;

import web.entity.DemandEntity;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
/**
 * DemandAgent��������Webǰ̨��������Ͷ�Agentϵͳ���м����
 * ��һ����ʱAgent������פϵͳ��ͨ���̳�Agent���࣬ӵ��Agent��ͨ�ù�����Ϊ
 * ����Ҫ�߱�������Ϣ�������� * Ϊ��Agent���һ����Ϊ�������Ʒ�������ϢOneShotBehaviour��
 * @author hanyuping
 *
 */
public class DemandAgent extends Agent implements Serializable {


	protected void setup(){
		//		���JADEһ������Ϊ
		addBehaviour(new OneShotBehaviour(this) {

			@Override
			//			��action���������������ִ������
			public void action() {
				//				��ȡAgent��������
				Object object=myAgent.getArguments();
				//				����DemandEntity��������
				DemandEntity []demandEntity=new DemandEntity[1];
				//				ǿ��ת��
				demandEntity=(DemandEntity[]) myAgent.getArguments();
				//				�жϲ����ǹ�Ϊ��
				if (demandEntity!=null) {


					//	System.out.println(demandEntity.getDemandID()+";"+demandEntity.getDemandName());
//					����JADE��Ϣ����
					ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
//					Ϊ��Ϣ��ӽ�����
					//				AID r=new AID("Cloud@192.168.1.128:1099/JADE");
					//				r.addAddresses("http://hanyuping-PC:7778/acc");
					msg.addReceiver(new AID("Cloud", AID.ISLOCALNAME));

					try {
//						������ϢID
						msg.setConversationId("demand-information");
//						�����Ϣ����
						msg.setContentObject(demandEntity[0]);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					������Ϣ
					send(msg);
//					����doDelete()�����Լ�
					myAgent.doDelete();
				}else {
					myAgent.doDelete();
				}
			}
		});


	}

}
