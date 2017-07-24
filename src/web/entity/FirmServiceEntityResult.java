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
@Table(name="t_firmserviceresult")
public class FirmServiceEntityResult {
//	定义类成员变量并与数据库表中的属性相对应，并指定该成员变量为主键
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@Column(name="资源编号")
	private int ID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="企业ID")
	private String firmID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品编号")
	private String serviceID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品名称")
	private String serviceName;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品型号")
	private String serviceType;
	
	
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="数量")
	private String serviceNum;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="交货期")
	private String delitime;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品合格率")
	private String passrate;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="价格左")
	private String lPrice;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="价格右")
	private String hPrice;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="可靠程度")
	private String confde;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="信誉度")
	private String credit;

//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="质量分数")
	private double quality;//质量
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="价格优势")
	private double price;//价格
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="柔性分数")
	private double flexibilitynum;//柔性
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="伙伴分数")
	private double parenter;//伙伴关系
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="财务分数")
	private double finance;//财务能力
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="科技水平")
	private double technology;//科技水平
	
	
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="评价总分")
	private double totalscore;//科技水平
	
	@Column(name="需求ID")
	private String demandID;
	
	@Column(length=200,name="响应时间")
	private String retime;
	@Column(length=200,name="生产灵活性")
	private String flexi;
	
	@Column(length=200,name="送样速度")
	private String samSpeed;

	@Column(length=200,name="退货服务")
	private String returnSer;
	@Column(length=200,name="运费是否承担")
	private String carriage;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
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
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getServiceNum() {
		return serviceNum;
	}
	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}
	public String getDelitime() {
		return delitime;
	}
	public void setDelitime(String delitime) {
		this.delitime = delitime;
	}
	public String getPassrate() {
		return passrate;
	}
	public void setPassrate(String passrate) {
		this.passrate = passrate;
	}
	public String getlPrice() {
		return lPrice;
	}
	public void setlPrice(String lPrice) {
		this.lPrice = lPrice;
	}
	public String gethPrice() {
		return hPrice;
	}
	public void sethPrice(String hPrice) {
		this.hPrice = hPrice;
	}
	public String getConfde() {
		return confde;
	}
	public void setConfde(String confde) {
		this.confde = confde;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public double getQuality() {
		return quality;
	}
	public void setQuality(double quality) {
		this.quality = quality;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getFlexibilitynum() {
		return flexibilitynum;
	}
	public void setFlexibilitynum(double flexibilitynum) {
		this.flexibilitynum = flexibilitynum;
	}
	public double getParenter() {
		return parenter;
	}
	public void setParenter(double parenter) {
		this.parenter = parenter;
	}
	public double getFinance() {
		return finance;
	}
	public void setFinance(double finance) {
		this.finance = finance;
	}
	public double getTechnology() {
		return technology;
	}
	public void setTechnology(double technology) {
		this.technology = technology;
	}
	public double getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(double totalscore) {
		this.totalscore = totalscore;
	}
	public String getDemandID() {
		return demandID;
	}
	public void setDemandID(String demandID) {
		this.demandID = demandID;
	}
	public String getRetime() {
		return retime;
	}
	public void setRetime(String retime) {
		this.retime = retime;
	}
	public String getFlexi() {
		return flexi;
	}
	public void setFlexi(String flexi) {
		this.flexi = flexi;
	}
	public String getSamSpeed() {
		return samSpeed;
	}
	public void setSamSpeed(String samSpeed) {
		this.samSpeed = samSpeed;
	}
	public String getReturnSer() {
		return returnSer;
	}
	public void setReturnSer(String returnSer) {
		this.returnSer = returnSer;
	}
	public String getCarriage() {
		return carriage;
	}
	public void setCarriage(String carriage) {
		this.carriage = carriage;
	}
	
	

	


	


	
	
}
