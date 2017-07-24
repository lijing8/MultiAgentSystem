package web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ����Ϊʵ���࣬ʵ�����Լ�set��get����
 * ʵ�ֹ�ϵ���ݿ���ʵ�����ӳ�䡣��@entity ����ʶ
 * ��@Table(name="t_result")��ʶ��֮��Ӧ�Ĺ�ϵ���ݿ��еı�������ݿ���û�д˱�
 * ����һ��nameָ���ı�
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_result")
public class ResultEntity {
//	�������Ա�����������ݿ���е��������Ӧ����ָ���ó�Ա����Ϊ����
	@Id
	@Column(name="KeyID")
	private int KeyID;
	
	@Column(name="SimID")
	private String ID;
	
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(name="FirmID",length=200)	
	private String firmID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(name="ServiceID",length=200)
	
	private String serviceID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="SimDate")
	private String date;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="������϶�")
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
