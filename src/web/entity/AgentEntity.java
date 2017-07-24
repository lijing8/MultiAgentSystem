package web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ����ΪAgentʵ���࣬ʵ�����л��ӿڣ�ʵ�����Լ�set��get����
 * ʵ�ֹ�ϵ���ݿ���ʵ�����ӳ�䡣��@entity ����ʶ
 * ��@Table(name="t_agent")��ʶ��֮��Ӧ�Ĺ�ϵ���ݿ��еı�������ݿ���û�д˱�
 * ����һ��nameָ���ı�
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_agent")
public class AgentEntity implements Serializable {
//	�������Ա�����������ݿ���е��������Ӧ����ָ���ó�Ա����Ϊ����
	@Id
	private int ID;
	@Column(length=200)
	private String AgentID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200)
	private String AgentName;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200)
	private String AgentRole;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200)
	private String AgentAddress;

	public String getAgentID() {
		return AgentID;
	}

	public void setAgentID(String agentID) {
		AgentID = agentID;
	}

	public String getAgentName() {
		return AgentName;
	}

	public void setAgentName(String agentName) {
		AgentName = agentName;
	}

	public String getAgentRole() {
		return AgentRole;
	}

	public void setAgentRole(String agentRole) {
		AgentRole = agentRole;
	}

	public String getAgentAddress() {
		return AgentAddress;
	}

	public void setAgentAddress(String agentAddress) {
		AgentAddress = agentAddress;
	}


	
	
}
