package web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ����Ϊʵ���࣬ʵ�����Լ�set��get����
 * ʵ�ֹ�ϵ���ݿ���ʵ�����ӳ�䡣��@entity ����ʶ
 * ��@Table(name="t_service")��ʶ��֮��Ӧ�Ĺ�ϵ���ݿ��еı�������ݿ���û�д˱�
 * ����һ��nameָ���ı�
 * @author hanyuping
 *
 */
@Entity
@Table(name="t_service")
public class ServiceEntity implements Serializable {
//	�������Ա�����������ݿ���е��������Ӧ����ָ���ó�Ա����Ϊ����
	@Id
	@Column(name="��ƷID")
	private String ServiceID;
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(length=200,name="��ҵID")
	private String FirmID;
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
	public String getServiceID() {
		return ServiceID;
	}
	public void setServiceID(String serviceID) {
		ServiceID = serviceID;
	}
	public String getFirmID() {
		return FirmID;
	}
	public void setFirmID(String firmID) {
		FirmID = firmID;
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
		
	
}
