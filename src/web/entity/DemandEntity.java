package web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ����Ϊ����ʵ���࣬ʵ�����л��ӿڣ�ʵ�����Լ�set��get����
 * ʵ�ֹ�ϵ���ݿ���ʵ�����ӳ�䡣��@entity ����ʶ
 * ��@Table(name="t_Demand")��ʶ��֮��Ӧ�Ĺ�ϵ���ݿ��еı�������ݿ���û�д˱�
 * ����һ��nameָ���ı�
 * @author hanyuping
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_Demand")
public class DemandEntity  implements Serializable {
//	�������Ա�����������ݿ���е��������Ӧ����ָ���ó�Ա����Ϊ����
	@Id
	@Column(name="����ID")
	private String DemandID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ����")
	private String DemandName;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ�ͺ�")
	private String DemandType;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ����")
	private String DemandNum;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="������")
	private String Delitime;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ�ϸ���")
	private String Passrate;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�۸���")
	private String LPrice;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�۸���")
	private String HPrice;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�ɿ��̶�")
	private String Confde;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="������")
	private String Credit;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ӧʱ��")
	private String Retime;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="���������")
	private String Flexi;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�����ٶ�")
	private String SamSpeed;
	
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�˻�����")
	private String ReturnSer;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�˷��Ƿ�е�")
	private String Carriage;
	
	
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��������")
	private double Quality;//����
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�۸�����")
	private double Price;//�۸�
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="���Է���")
	private double Flexibilitynum;//����
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="������")
	private double Parenter;//����ϵ
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�������")
	private double Finance;//��������
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�Ƽ�ˮƽ")
	private double Technology;//�Ƽ�ˮƽ
	
//	ʹ��Set��get�����Գ�Ա������������
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
	
	@Column(length=200,name="�ϸ��ʷ���")
	private double Qhege;
	@Column(length=200,name="�����ʷ���")
	private double Qbaotui;
	@Column(length=200,name="������ϵ����")
	private double Qtixi;
	@Column(length=200,name="�Ʒ������")
	private double Qyunfuwu;
	
	@Column(length=200,name="��Ƴɱ�����")
	private double Csheji ;
	@Column(length=200,name="�ɹ��ɱ�����")
	private double Ccaigou;
	@Column(length=200,name="����ɱ�����")
	private double Cyunshu ;
	@Column(length=200,name="�ɱ������ʷ���")
	private double Cliyong;
	
	@Column(length=200,name="Ʒ�����Է���")
	private double Fzhonglei ;
	@Column(length=200,name="ʱ�����Է���")
	private double Fshijian ;
	@Column(length=200,name="�������Է���")
	private double Fshuliang;
	
	@Column(length=200,name="��Ϣ��������")
	private double  Itouru;
	@Column(length=200,name="��ƽͶ�����")
	private double  Iyun;
	@Column(length=200,name="��Ϣ���������")
	private double  Ijibie;
	
	@Column(length=200,name="׼ʱ��������")
	private double  Pjiaohuo;
	@Column(length=200,name="�ͻ�����ȷ���")
	private double  Pmanyi ;
	@Column(length=200,name="�г�ռ���ʷ���")
	private double  Pzhanyou;
	
	
	@Column(length=200,name="�ʱ������ʷ���")
	private double   Fshouyi ;
	@Column(length=200,name="���ʲ������ʷ���")
	private double  Fzichan ;
	@Column(length=200,name="���������ʷ���")
	private double  Flirun ;
	@Column(length=200,name="���������ʷ���")
	private double  Fxiaosou ;
	@Column(length=200,name="Ͷ������ȷ���")
	private double  Fchanchu;
	
	@Column(length=200,name="����Ͷ���ʷ���")
	private double  Tkaifa;
	@Column(length=200,name="�²�Ʒ������ʷ���")
	private double  Tshouru;
	@Column(length=200,name="�Ƽ�������Ա���ʷ���")
	private double  Trenyuan;
	
	@Column(length=200,name="��ѭ�������ʷ���")
	private double   Exunhuan ;
	@Column(length=200,name="��Դ�����ʷ���")
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
