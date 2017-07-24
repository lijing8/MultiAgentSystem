package web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 此类为Agent实体类，实现序列化接口，实体属性及set和get方法
 * 实现关系数据库向实体类的映射。用@entity 来标识
 * 用@Table(name="t_agent")标识与之对应的关系数据库中的表，如果数据库中没有此表，
 * 创建一个name指定的表
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_agent")
public class AgentEntity implements Serializable {
//	定义类成员变量并与数据库表中的属性相对应，并指定该成员变量为主键
	@Id
	private int ID;
	@Column(length=200)
	private String AgentID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200)
	private String AgentName;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200)
	private String AgentRole;
//	定义类成员变量并与数据库表中的属性相对应
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
