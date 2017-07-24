package web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 此类为云服务实体类，实体属性及set和get方法
 * 实现关系数据库向实体类的映射。用@entity 来标识
 * 用@Table(name="t_firmservice")标识与之对应的关系数据库中的表，如果数据库中没有此表，
 * 创建一个name指定的表
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_firmservice")
public class FirmServiceEntity {
//	定义类成员变量并与数据库表中的属性相对应，并指定该成员变量为主键
	@Id
	@Column(name="资源编号")
	private int ID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="企业ID")
	private String FirmID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品编号")
	private String ServiceID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品名称")
	private String ServiceName;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品型号")
	private String ServiceType;
	
	
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="数量")
	private String ServiceNum;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="交货期")
	private String Delitime;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品合格率")
	private String Passrate;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="价格左")
	private String LPrice;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="价格右")
	private String HPrice;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="可靠程度")
	private String Confde;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="信誉度")
	private String Credit;

//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="质量分数")
	private double Quality;//质量
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="价格优势")
	private double Price;//价格
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="柔性分数")
	private double Flexibilitynum;//柔性
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="伙伴分数")
	private double Parenter;//伙伴关系
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="财务分数")
	private double Finance;//财务能力
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="科技水平")
	private double Technology;//科技水平
	
	
//	使用Set和get函数对成员变量进行设置
	public String getCredit() {
		return Credit;
	}
	public void setCredit(String credit) {
		Credit = credit;
	}
	@Column(length=200,name="响应时间")
	private String Retime;
	@Column(length=200,name="生产灵活性")
	private String Flexi;
	
	@Column(length=200,name="送样速度")
	private String SamSpeed;

	@Column(length=200,name="退货服务")
	private String ReturnSer;
	@Column(length=200,name="运费是否承担")
	private String Carriage;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirmID() {
		return FirmID;
	}
	public void setFirmID(String firmID) {
		FirmID = firmID;
	}
	public String getServiceID() {
		return ServiceID;
	}
	public void setServiceID(String serviceID) {
		ServiceID = serviceID;
	}
	
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	
	public String getServiceType() {
		return ServiceType;
	}
	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}
	public String getServiceNum() {
		return ServiceNum;
	}
	public void setServiceNum(String serviceNum) {
		ServiceNum = serviceNum;
	}
	public String getDelitime() {
		return Delitime;
	}
	public void setDelitime(String delitime) {
		Delitime = delitime;
	}
	public String getPassrate() {
		return Passrate;
	}
	public void setPassrate(String passrate) {
		Passrate = passrate;
	}
	public String getLPrice() {
		return LPrice;
	}
	public void setLPrice(String lPrice) {
		LPrice = lPrice;
	}
	public String getHPrice() {
		return HPrice;
	}
	public void setHPrice(String hPrice) {
		HPrice = hPrice;
	}
	public String getConfde() {
		return Confde;
	}
	public void setConfde(String confde) {
		Confde = confde;
	}
	public String getRetime() {
		return Retime;
	}
	public void setRetime(String retime) {
		Retime = retime;
	}
	public String getFlexi() {
		return Flexi;
	}
	public void setFlexi(String flexi) {
		Flexi = flexi;
	}
	public String getSamSpeed() {
		return SamSpeed;
	}
	public void setSamSpeed(String samSpeed) {
		SamSpeed = samSpeed;
	}
	public String getReturnSer() {
		return ReturnSer;
	}
	public void setReturnSer(String returnSer) {
		ReturnSer = returnSer;
	}
	public String getCarriage() {
		return Carriage;
	}
	public void setCarriage(String carriage) {
		Carriage = carriage;
	}
	public double getQuality() {
		return Quality;
	}
	public void setQuality(double quality) {
		Quality = quality;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getFlexibilitynum() {
		return Flexibilitynum;
	}
	public void setFlexibilitynum(double flexibilitynum) {
		Flexibilitynum = flexibilitynum;
	}
	public double getParenter() {
		return Parenter;
	}
	public void setParenter(double parenter) {
		Parenter = parenter;
	}
	public double getFinance() {
		return Finance;
	}
	public void setFinance(double finance) {
		Finance = finance;
	}
	public double getTechnology() {
		return Technology;
	}
	public void setTechnology(double technology) {
		Technology = technology;
	}
	


	
	
}
