package web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 此类为实体类，实体属性及set和get方法
 * 实现关系数据库向实体类的映射。用@entity 来标识
 * 用@Table(name="t_Firm")标识与之对应的关系数据库中的表，如果数据库中没有此表，
 * 创建一个name指定的表
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_Firm")
public class FirmEntity {
//	定义类成员变量并与数据库表中的属性相对应，并指定该成员变量为主键
	@Id
	private String FirmID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200)
	private String FirmName;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200)
	
	private String FrimAddress;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200)
	private double FirmProper1;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200)
	private double FirmProper2;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200)
	private double FirmProper3;
//	定义类成员变量并与数据库表中的属性相对应
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
