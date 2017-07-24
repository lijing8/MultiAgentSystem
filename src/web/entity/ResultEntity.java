package web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 此类为实体类，实体属性及set和get方法
 * 实现关系数据库向实体类的映射。用@entity 来标识
 * 用@Table(name="t_result")标识与之对应的关系数据库中的表，如果数据库中没有此表，
 * 创建一个name指定的表
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_result")
public class ResultEntity {
//	定义类成员变量并与数据库表中的属性相对应，并指定该成员变量为主键
	@Id
	@Column(name="KeyID")
	private int KeyID;
	
	@Column(name="SimID")
	private String ID;
	
//	定义类成员变量并与数据库表中的属性相对应
	@Column(name="FirmID",length=200)	
	private String firmID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(name="ServiceID",length=200)
	
	private String serviceID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="SimDate")
	private String date;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="需求符合度")
	private double demandconf;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFirmID() {
		return firmID;
	}

	public void setFirmID(String firmID) {
		this.firmID = firmID;
	}

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getDemandconf() {
		return demandconf;
	}

	public void setDemandconf(double demandconf) {
		this.demandconf = demandconf;
	}


	
	


	
	
	
	
}
