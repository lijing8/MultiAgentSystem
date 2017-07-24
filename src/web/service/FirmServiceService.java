package web.service;

import jade.wrapper.StaleProxyException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.FirmServiceDAO;
import web.entity.FirmServiceEntity;
/**
 * ����ҵ���߼��࣬����ҵ����Service��������@Service���б�ע��
 * @author lijing
 *
 */
@Service
public class FirmServiceService {
//	����@Autowired��UserDAO��������
	@Autowired
	private FirmServiceDAO firmserviceDAO;
	/**
	 * ��ȡ�����б�
	 * @return ���ط����б�
	 */
	
	public  void  addfirmService(String userID,String serviceName,String serviceNum,
			String delitime,String serviceType,String passrate,String Lprice,String Hprice,String confde,
			String credit,String retime,String flexi,String returnser,String samspeed,String carriage,
			String quality,String price ,String flexibility,String parenter,String finance ,String technology) throws StaleProxyException{
		
		FirmServiceEntity firmServiceEntity=new FirmServiceEntity();
		firmServiceEntity.setFirmID(userID);
		firmServiceEntity.setServiceName(serviceName);
		firmServiceEntity.setServiceNum(serviceNum);
		firmServiceEntity.setServiceType(serviceType);
		firmServiceEntity.setDelitime(delitime);
		firmServiceEntity.setPassrate(passrate);
		firmServiceEntity.setLPrice(Lprice);
		firmServiceEntity.setHPrice(Hprice);
		firmServiceEntity.setConfde(confde);
		firmServiceEntity.setCredit(credit);
		firmServiceEntity.setRetime(retime);
		firmServiceEntity.setFlexi(flexi);
		firmServiceEntity.setReturnSer(returnser);
		firmServiceEntity.setSamSpeed(samspeed);
		firmServiceEntity.setCarriage(carriage);
		//�����¼ӵ�����
		
		double pricea=Double.valueOf(price).doubleValue();
		double qualitya=Double.valueOf(quality).doubleValue();
		double flexibilitya=Double.valueOf(flexibility).doubleValue();
		double parentera=Double.valueOf(parenter).doubleValue();
		double financea=Double.valueOf(finance).doubleValue();
		double technologya=Double.valueOf(technology).doubleValue();
		
		firmServiceEntity.setQuality(qualitya);
		firmServiceEntity.setPrice(pricea);
		firmServiceEntity.setFlexibilitynum(flexibilitya);
		firmServiceEntity.setParenter(parentera);
		firmServiceEntity.setFinance(financea);
		firmServiceEntity.setTechnology(technologya);

	    // firmserviceDAO.addService(firmServiceEntity);
			
	}
	public List<FirmServiceEntity> getAllService() {
		return firmserviceDAO.getAllFirmService();
	}
	
	public FirmServiceEntity getonefirmService(String firmserviceID) {
		return firmserviceDAO.getonefirmService(firmserviceID);
	}

	//ɾ��
	public boolean delFirmService(String serviceID){
		return firmserviceDAO.delService(serviceID);
	}
	public List<FirmServiceEntity> getResultBydemandID(String demandID) {
		System.out.print("��ѯ");
		return firmserviceDAO.getResultBydemandID();
	}
	
}
