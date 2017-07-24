package multiagent.utility.DBoperater;

import java.util.Date;
import java.util.UUID;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import web.entity.AgentCommEntity;
/**
 * 此类用于向数据库存储Agent交互信息。具有一个方法save()
 * @author hanyuping
 */
public class SaveCommunication {

	/**
	 * 
	 * @param msg JADE消息类对象
	 * @param agentname 消息发送者名称
	 * @param receiveragent 接受者名称
	 * @param date 交互日期
	 */
	public void save(ACLMessage msg,String agentname,String receiveragent,String date){
		//存储交互信息
//		定义交互信息表的ID，随机编码
		String ID=UUID.randomUUID().toString();
		//String ID=String.valueOf(msg.getPostTimeStamp());
//		定义消息发送者参数获取传入的数据
		String sender=agentname;
//		定义消息接收者参数获取传入的数据
		String  receiver =receiveragent;
//		定义参数获取传入的数据消息的ID
		String thremString=msg.getConversationId();
//		定义参数获取传入的数据消息的内容
		String content;
		
		try {
		content = msg.getConversationId();
//		定义AgentCommEntity对象
		AgentCommEntity ac=new AgentCommEntity();
//		设置AgentCommEntity对象成员参数值
		ac.setACID(ID);;
		ac.setACSender(sender);
		ac.setACReceiver(receiver);
		ac.setACtime(date);
		ac.setACTheme(thremString);
		ac.setACcontent(content);
//		定义SQLConnector打开数据库进行存储操作
		SQLConnector sqlConnector=new SQLConnector();
//		调用SQLConnectors添加交互信息函数
		sqlConnector.addAgentComm(ac);
		} catch (UnreadableException e) {
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}
}
