package web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * ����Ϊ�Ʒ���ʵ���࣬ʵ�����Լ�set��get����
 * ʵ�ֹ�ϵ���ݿ���ʵ�����ӳ�䡣��@entity ����ʶ
 * ��@Table(name="t_firmservice")��ʶ��֮��Ӧ�Ĺ�ϵ���ݿ��еı�������ݿ���û�д˱�
 * ����һ��nameָ���ı�
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_firmservice")
public class FirmServiceEntity {
//	�������Ա�����������ݿ���е��������Ӧ����ָ���ó�Ա����Ϊ����
	@Id
	@Column(name="��Դ���")
	private int ID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��ҵID")
	private String FirmID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ���")
	private String ServiceID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ����")
	private String ServiceName;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ�ͺ�")
	private String ServiceType;
	
	
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="����")
	private String ServiceNum;
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
	public String getCredit() {
		return Credit;
	}
	public void setCredit(String credit) {
		Credit = credit;
	}
	@Column(length=200,name="��Ӧʱ��")
	private String Retime;
	@Column(length=200,name="���������")
	private String Flexi;
	
	@Column(length=200,name="�����ٶ�")
	private String SamSpeed;

	@Column(length=200,name="�˻�����")
	private String ReturnSer;
	@Column(length=200,name="�˷��Ƿ�е�")
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
