package multiagent.utility.DBoperater;

import java.util.Date;
import java.util.UUID;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import web.entity.AgentCommEntity;
/**
 * �������������ݿ�洢Agent������Ϣ������һ������save()
 * @author hanyuping
 */
public class SaveCommunication {

	/**
	 * 
	 * @param msg JADE��Ϣ�����
	 * @param agentname ��Ϣ����������
	 * @param receiveragent ����������
	 * @param date ��������
	 */
	public void save(ACLMessage msg,String agentname,String receiveragent,String date){
		//�洢������Ϣ
//		���彻����Ϣ���ID���������
		String ID=UUID.randomUUID().toString();
		//String ID=String.valueOf(msg.getPostTimeStamp());
//		������Ϣ�����߲�����ȡ���������
		String sender=agentname;
//		������Ϣ�����߲�����ȡ���������
		String  receiver =receiveragent;
//		���������ȡ�����������Ϣ��ID
		String thremString=msg.getConversationId();
//		���������ȡ�����������Ϣ������
		String content;
		
		try {
		content = msg.getConversationId();
//		����AgentCommEntity����
		AgentCommEntity ac=new AgentCommEntity();
//		����AgentCommEntity�����Ա����ֵ
		ac.setACID(ID);;
		ac.setACSender(sender);
		ac.setACReceiver(receiver);
		ac.setACtime(date);
		ac.setACTheme(thremString);
		ac.setACcontent(content);
//		����SQLConnector�����ݿ���д洢����
		SQLConnector sqlConnector=new SQLConnector();
//		����SQLConnectors��ӽ�����Ϣ����
		sqlConnector.addAgentComm(ac);
		} catch (UnreadableException e) {
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}
}
