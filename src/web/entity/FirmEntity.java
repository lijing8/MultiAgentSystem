package web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ����Ϊʵ���࣬ʵ�����Լ�set��get����
 * ʵ�ֹ�ϵ���ݿ���ʵ�����ӳ�䡣��@entity ����ʶ
 * ��@Table(name="t_Firm")��ʶ��֮��Ӧ�Ĺ�ϵ���ݿ��еı�������ݿ���û�д˱�
 * ����һ��nameָ���ı�
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_Firm")
public class FirmEntity {
//	�������Ա�����������ݿ���е��������Ӧ����ָ���ó�Ա����Ϊ����
	@Id
	private String FirmID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200)
	private String FirmName;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200)
	
	private String FrimAddress;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200)
	private double FirmProper1;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200)
	private double FirmProper2;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200)
	private double FirmProper3;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200)
	private double FirmProper4;

	public String getFirmID() {
		return FirmID;
	}

	public void setFirmID(String firmID) {
		FirmID = firmID;
	}

	public String getFirmName() {
		return FirmName;
	}

	public void setFirmName(String firmName) {
		FirmName = firmName;
	}

	public String getFrimAddress() {
		return FrimAddress;
	}

	public void setFrimAddress(String frimAddress) {
		FrimAddress = frimAddress;
	}

	public double getFirmProper1() {
		return FirmProper1;
	}

	public void setFirmProper1(double firmProper1) {
		FirmProper1 = firmProper1;
	}

	public double getFirmProper2() {
		return FirmProper2;
	}

	public void setFirmProper2(double firmProper2) {
		FirmProper2 = firmProper2;
	}

	public double getFirmProper3() {
		return FirmProper3;
	}

	public void setFirmProper3(double firmProper3) {
		FirmProper3 = firmProper3;
	}

	public double getFirmProper4() {
		return FirmProper4;
	}

	public void setFirmProper4(double firmProper4) {
		FirmProper4 = firmProper4;
	}
	
}
