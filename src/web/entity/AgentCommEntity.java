package web.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ����Ϊʵ���࣬ʵ�����Լ�set��get����
 * ʵ�ֹ�ϵ���ݿ���ʵ�����ӳ�䡣��@entity ����ʶ
 * ��@Table(name="t_agentcommunication")��ʶ��֮��Ӧ�Ĺ�ϵ���ݿ��еı�������ݿ���û�д˱�
 * ����һ��nameָ���ı�
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_agentcommunication")
public class AgentCommEntity {
//	�������Ա�����������ݿ���е��������Ӧ����ָ���ó�Ա����Ϊ����
	//ͨ��ID
		@Id
		@Column(name="CommunicationID")
		private String ACID;
		//ͨ������
		@Column(name="Sender",length=500)
		private String ACSender;
//		�������Ա�����������ݿ���е��������Ӧ
		@Column(name="Receiver",length=200)
		private String ACReceiver;
//		�������Ա�����������ݿ���е��������Ӧ
		@Column(name="CommunicationDate",length=500)
		private String ACtime;
//		�������Ա�����������ݿ���е��������Ӧ
		@Column(name="CommunicationTheme",length=200)
		private String ACTheme;
//		�������Ա�����������ݿ���е��������Ӧ
		@Column(name="Communicationcontent",length=200)
		private String ACcontent;
//		ʹ��Set��get�����Գ�Ա������������
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
