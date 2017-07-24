package web.service;

import jade.wrapper.StaleProxyException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.FirmServiceDAO;
import web.entity.FirmServiceEntity;
/**
 * 服务业务逻辑类，负责业务处理，Service层的组件用@Service进行标注，
 * @author lijing
 *
 */
@Service
public class FirmServiceService {
//	利用@Autowired将UserDAO对象引入
	@Autowired
	private FirmServiceDAO firmserviceDAO;
	/**
	 * 获取服务列表
	 * @return 返回服务列表
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
		//加上新加的内容
		
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

	//删除
	public boolean delFirmService(String serviceID){
		return firmserviceDAO.delService(serviceID);
	}
	public List<FirmServiceEntity> getResultBydemandID(String demandID) {
		System.out.print("查询");
		return firmserviceDAO.getResultBydemandID();
	}
	
}
