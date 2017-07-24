package web.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 此类为实体类，实体属性及set和get方法
 * 实现关系数据库向实体类的映射。用@entity 来标识
 * 用@Table(name="t_agentcommunication")标识与之对应的关系数据库中的表，如果数据库中没有此表，
 * 创建一个name指定的表
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_agentcommunication")
public class AgentCommEntity {
//	定义类成员变量并与数据库表中的属性相对应，并指定该成员变量为主键
	//通信ID
		@Id
		@Column(name="CommunicationID")
		private String ACID;
		//通信内容
		@Column(name="Sender",length=500)
		private String ACSender;
//		定义类成员变量并与数据库表中的属性相对应
		@Column(name="Receiver",length=200)
		private String ACReceiver;
//		定义类成员变量并与数据库表中的属性相对应
		@Column(name="CommunicationDate",length=500)
		private String ACtime;
//		定义类成员变量并与数据库表中的属性相对应
		@Column(name="CommunicationTheme",length=200)
		private String ACTheme;
//		定义类成员变量并与数据库表中的属性相对应
		@Column(name="Communicationcontent",length=200)
		private String ACcontent;
//		使用Set和get函数对成员变量进行设置
		public String getACID() {
			return ACID;
		}
		public void setACID(String aCID) {
			ACID = aCID;
		}
		public String getACSender() {
			return ACSender;
		}
		public void setACSender(String aCSender) {
			ACSender = aCSender;
		}
		public String getACReceiver() {
			return ACReceiver;
		}
		public void setACReceiver(String aCReceiver) {
			ACReceiver = aCReceiver;
		}
		public String getACtime() {
			return ACtime;
		}
		public void setACtime(String aCtime) {
			ACtime = aCtime;
		}
		public String getACTheme() {
			return ACTheme;
		}
		public void setACTheme(String aCTheme) {
			ACTheme = aCTheme;
		}
		public String getACcontent() {
			return ACcontent;
		}
		public void setACcontent(String aCcontent) {
			ACcontent = aCcontent;
		}

	
	
	
}
