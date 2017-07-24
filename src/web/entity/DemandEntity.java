package web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 此类为需求实体类，实现序列化接口，实体属性及set和get方法
 * 实现关系数据库向实体类的映射。用@entity 来标识
 * 用@Table(name="t_Demand")标识与之对应的关系数据库中的表，如果数据库中没有此表，
 * 创建一个name指定的表
 * @author hanyuping
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_Demand")
public class DemandEntity  implements Serializable {
//	定义类成员变量并与数据库表中的属性相对应，并指定该成员变量为主键
	@Id
	@Column(name="需求ID")
	private String DemandID;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品名称")
	private String DemandName;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品型号")
	private String DemandType;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="产品数量")
	private String DemandNum;
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
	@Column(length=200,name="响应时间")
	private String Retime;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="生产灵活性")
	private String Flexi;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="送样速度")
	private String SamSpeed;
	
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="退货服务")
	private String ReturnSer;
//	定义类成员变量并与数据库表中的属性相对应
	@Column(length=200,name="运费是否承担")
	private String Carriage;
	
	
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
	public String getDemandID() {
		return DemandID;
	}
	public void setDemandID(String demandID) {
		DemandID = demandID;
	}
	public String getDemandName() {
		return DemandName;
	}
	public void setDemandName(String demandName) {
		DemandName = demandName;
	}
	public String getDemandType() {
		return DemandType;
	}
	public void setDemandType(String demandType) {
		DemandType = demandType;
	}
	public String getDemandNum() {
		return DemandNum;
	}
	public void setDemandNum(String demandNum) {
		DemandNum = demandNum;
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
	public String getCredit() {
		return Credit;
	}
	public void setCredit(String credit) {
		Credit = credit;
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
	
	@Column(length=200,name="合格率分数")
	private double Qhege;
	@Column(length=200,name="报修率分数")
	private double Qbaotui;
	@Column(length=200,name="质量体系分数")
	private double Qtixi;
	@Column(length=200,name="云服务分数")
	private double Qyunfuwu;
	
	@Column(length=200,name="设计成本分数")
	private double Csheji ;
	@Column(length=200,name="采购成本分数")
	private double Ccaigou;
	@Column(length=200,name="运输成本分数")
	private double Cyunshu ;
	@Column(length=200,name="成本利用率分数")
	private double Cliyong;
	
	@Column(length=200,name="品种柔性分数")
	private double Fzhonglei ;
	@Column(length=200,name="时间柔性分数")
	private double Fshijian ;
	@Column(length=200,name="数量柔性分数")
	private double Fshuliang;
	
	@Column(length=200,name="信息技术分数")
	private double  Itouru;
	@Column(length=200,name="云平投入分数")
	private double  Iyun;
	@Column(length=200,name="信息化级别分数")
	private double  Ijibie;
	
	@Column(length=200,name="准时交货分数")
	private double  Pjiaohuo;
	@Column(length=200,name="客户满意度分数")
	private double  Pmanyi ;
	@Column(length=200,name="市场占有率分数")
	private double  Pzhanyou;
	
	
	@Column(length=200,name="资本收益率分数")
	private double   Fshouyi ;
	@Column(length=200,name="净资产利用率分数")
	private double  Fzichan ;
	@Column(length=200,name="利润增长率分数")
	private double  Flirun ;
	@Column(length=200,name="销售增长率分数")
	private double  Fxiaosou ;
	@Column(length=200,name="投入产出比分数")
	private double  Fchanchu;
	
	@Column(length=200,name="开发投资率分数")
	private double  Tkaifa;
	@Column(length=200,name="新产品收入比率分数")
	private double  Tshouru;
	@Column(length=200,name="科技开发人员比率分数")
	private double  Trenyuan;
	
	@Column(length=200,name="再循环利用率分数")
	private double   Exunhuan ;
	@Column(length=200,name="能源消耗率分数")
	private double Enengyuan;

	public double getQhege() {
		return Qhege;
	}
	public void setQhege(double qhege) {
		Qhege = qhege;
	}
	public double getQbaotui() {
		return Qbaotui;
	}
	public void setQbaotui(double qbaotui) {
		Qbaotui = qbaotui;
	}
	public double getQtixi() {
		return Qtixi;
	}
	public void setQtixi(double qtixi) {
		Qtixi = qtixi;
	}
	public double getQyunfuwu() {
		return Qyunfuwu;
	}
	public void setQyunfuwu(double qyunfuwu) {
		Qyunfuwu = qyunfuwu;
	}
	public double getCsheji() {
		return Csheji;
	}
	public void setCsheji(double csheji) {
		Csheji = csheji;
	}
	public double getCcaigou() {
		return Ccaigou;
	}
	public void setCcaigou(double ccaigou) {
		Ccaigou = ccaigou;
	}
	public double getCyunshu() {
		return Cyunshu;
	}
	public void setCyunshu(double cyunshu) {
		Cyunshu = cyunshu;
	}
	public double getCliyong() {
		return Cliyong;
	}
	public void setCliyong(double cliyong) {
		Cliyong = cliyong;
	}
	public double getFzhonglei() {
		return Fzhonglei;
	}
	public void setFzhonglei(double fzhonglei) {
		Fzhonglei = fzhonglei;
	}
	public double getFshijian() {
		return Fshijian;
	}
	public void setFshijian(double fshijian) {
		Fshijian = fshijian;
	}
	public double getFshuliang() {
		return Fshuliang;
	}
	public void setFshuliang(double fshuliang) {
		Fshuliang = fshuliang;
	}
	public double getItouru() {
		return Itouru;
	}
	public void setItouru(double itouru) {
		Itouru = itouru;
	}
	public double getIyun() {
		return Iyun;
	}
	public void setIyun(double iyun) {
		Iyun = iyun;
	}
	public double getIjibie() {
		return Ijibie;
	}
	public void setIjibie(double ijibie) {
		Ijibie = ijibie;
	}
	public double getPjiaohuo() {
		return Pjiaohuo;
	}
	public void setPjiaohuo(double pjiaohuo) {
		Pjiaohuo = pjiaohuo;
	}
	public double getPmanyi() {
		return Pmanyi;
	}
	public void setPmanyi(double pmanyi) {
		Pmanyi = pmanyi;
	}
	public double getPzhanyou() {
		return Pzhanyou;
	}
	public void setPzhanyou(double pzhanyou) {
		Pzhanyou = pzhanyou;
	}
	public double getFshouyi() {
		return Fshouyi;
	}
	public void setFshouyi(double fshouyi) {
		Fshouyi = fshouyi;
	}
	public double getFzichan() {
		return Fzichan;
	}
	public void setFzichan(double fzichan) {
		Fzichan = fzichan;
	}
	public double getFlirun() {
		return Flirun;
	}
	public void setFlirun(double flirun) {
		Flirun = flirun;
	}
	public double getFxiaosou() {
		return Fxiaosou;
	}
	public void setFxiaosou(double fxiaosou) {
		Fxiaosou = fxiaosou;
	}
	public double getFchanchu() {
		return Fchanchu;
	}
	public void setFchanchu(double fchanchu) {
		Fchanchu = fchanchu;
	}
	public double getTkaifa() {
		return Tkaifa;
	}
	public void setTkaifa(double tkaifa) {
		Tkaifa = tkaifa;
	}
	public double getTshouru() {
		return Tshouru;
	}
	public void setTshouru(double tshouru) {
		Tshouru = tshouru;
	}
	public double getTrenyuan() {
		return Trenyuan;
	}
	public void setTrenyuan(double trenyuan) {
		Trenyuan = trenyuan;
	}
	public double getExunhuan() {
		return Exunhuan;
	}
	public void setExunhuan(double exunhuan) {
		Exunhuan = exunhuan;
	}
	public double getEnengyuan() {
		return Enengyuan;
	}
	public void setEnengyuan(double enengyuan) {
		Enengyuan = enengyuan;
	}

	
}
