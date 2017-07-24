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
@Table(name="t_firmserviceresult")
public class FirmServiceEntityResult {
//	�������Ա�����������ݿ���е��������Ӧ����ָ���ó�Ա����Ϊ����
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@Column(name="��Դ���")
	private int ID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��ҵID")
	private String firmID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ���")
	private String serviceID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ����")
	private String serviceName;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ�ͺ�")
	private String serviceType;
	
	
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="����")
	private String serviceNum;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="������")
	private String delitime;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��Ʒ�ϸ���")
	private String passrate;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�۸���")
	private String lPrice;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�۸���")
	private String hPrice;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�ɿ��̶�")
	private String confde;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="������")
	private String credit;

//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��������")
	private double quality;//����
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�۸�����")
	private double price;//�۸�
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="���Է���")
	private double flexibilitynum;//����
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="������")
	private double parenter;//����ϵ
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�������")
	private double finance;//��������
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�Ƽ�ˮƽ")
	private double technology;//�Ƽ�ˮƽ
	
	
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="�����ܷ�")
	private double totalscore;//�Ƽ�ˮƽ
	
	@Column(name="����ID")
	private String demandID;
	
	@Column(length=200,name="��Ӧʱ��")
	private String retime;
	@Column(length=200,name="���������")
	private String flexi;
	
	@Column(length=200,name="�����ٶ�")
	private String samSpeed;

	@Column(length=200,name="�˻�����")
	private String returnSer;
	@Column(length=200,name="�˷��Ƿ�е�")
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
