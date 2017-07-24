package web.service;

import jade.wrapper.StaleProxyException;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AHP.AHPwork;
import web.dao.FirmServiceAHPDAO;
import web.entity.FirmServiceAHPEntity;

/**
 * 服务业务逻辑类，负责业务处理，Service层的组件用@Service进行标注，
 * @author lijing
 *
 */
@Service
public class FirmServiceAHPService {
//	利用@Autowired将UserDAO对象引入
	@Autowired
	private FirmServiceAHPDAO firmserviceAHPDAO;
	/**
	 * 获取服务列表
	 * @return 返回服务列表
	 */
	
	public  void  addfirmService(String FirmID,String serviceName,String serviceNum,
			String delitime,String serviceID,String passrate,String Lprice,String Hprice,String confde,
			String credit,String retime,String flexi,String returnser,String samspeed,String carriage,String serviceType) throws StaleProxyException{
		
		FirmServiceAHPEntity firmServiceAHPEntity=new FirmServiceAHPEntity();
		
		firmServiceAHPEntity.setFirmID(FirmID);
		firmServiceAHPEntity.setServiceName(serviceName);
		firmServiceAHPEntity.setServiceNum(serviceNum);
		firmServiceAHPEntity.setServiceType(serviceType);
		firmServiceAHPEntity.setDelitime(delitime);
		firmServiceAHPEntity.setPassrate(passrate);
		firmServiceAHPEntity.setLPrice(Lprice);
		firmServiceAHPEntity.setHPrice(Hprice);
		firmServiceAHPEntity.setConfde(confde);
		firmServiceAHPEntity.setCredit(credit);
		firmServiceAHPEntity.setRetime(retime);
		firmServiceAHPEntity.setFlexi(flexi);
		firmServiceAHPEntity.setReturnSer(returnser);
		firmServiceAHPEntity.setSamSpeed(samspeed);
		firmServiceAHPEntity.setCarriage(carriage);
		firmServiceAHPEntity.setServiceID(serviceID);
		//加上新加的内容

		firmserviceAHPDAO.addService(firmServiceAHPEntity);
			
	}
	public List<FirmServiceAHPEntity> getAllService() {
		return firmserviceAHPDAO.getAllFirmService();
	}
	
	public FirmServiceAHPEntity getonefirmService(String firmserviceID) {
		return firmserviceAHPDAO.getonefirmService(firmserviceID);
	}

	//删除
	public boolean delFirmService(String serviceID){
		return firmserviceAHPDAO.delService(serviceID);
	}
	
	public  void  addfirmServiceScore(String serviceID,String qhege,String qbaotui ,String qtixi ,String qyunfuwu,
			String csheji ,String ccaigou ,String cyunshu ,String cliyong,
			String fzhonglei ,String fshijian ,String fshuliang,
			String itouru ,String iyun ,String ijibie,
			String pjiaohuo,String  pmanyi ,String pzhanyou,
			String fshouyi ,String fzichan ,String flirun ,String fxiaosou,String  fchanchu,
			String tkaifa ,String tshouru ,String  trenyuan,
			String exunhuan ,String enengyuan) throws StaleProxyException{
		
		FirmServiceAHPEntity firmServiceAHPEntity=new FirmServiceAHPEntity();
		
		firmServiceAHPEntity.setServiceID(serviceID);
		//加上新加的内容
		double sqhege=Double.valueOf(qhege).doubleValue();
		double sqbaotui=Double.valueOf(qbaotui).doubleValue();
		double sqtixi=Double.valueOf(qtixi).doubleValue();
		double sqyunfuwu=Double.valueOf(qyunfuwu).doubleValue();
		
		double scsheji=Double.valueOf(csheji).doubleValue();
		double sccaigou=Double.valueOf(ccaigou).doubleValue();
		double scyunshu=Double.valueOf(cyunshu).doubleValue();
		double scliyong=Double.valueOf(cliyong).doubleValue();
		
		double sfzhonglei=Double.valueOf(fzhonglei).doubleValue();
		double sfshijian=Double.valueOf(fshijian).doubleValue();
		double sfshuliang=Double.valueOf(fshuliang).doubleValue();
		
		double sitouru=Double.valueOf(itouru).doubleValue();
		double siyun=Double.valueOf(iyun).doubleValue();
		double sijibie=Double.valueOf(ijibie).doubleValue();
		
		double spjiaohuo=Double.valueOf(pjiaohuo).doubleValue();
		double spmanyi=Double.valueOf(pmanyi).doubleValue();
		double spzhanyou=Double.valueOf(pzhanyou).doubleValue();
		
		double sfshouyi=Double.valueOf(fshouyi).doubleValue();
		double sfzichan=Double.valueOf(fzichan).doubleValue();
		double sflirun=Double.valueOf(flirun).doubleValue();
		double sfxiaosou=Double.valueOf(fxiaosou).doubleValue();
		double sfchanchu=Double.valueOf(fchanchu).doubleValue();
		 
		double stkaifa=Double.valueOf(tkaifa).doubleValue();
		double stshouru=Double.valueOf(tshouru).doubleValue();
		double strenyuan=Double.valueOf(trenyuan).doubleValue();
		
		double sexunhuan=Double.valueOf(exunhuan).doubleValue();
		double senengyuan=Double.valueOf(enengyuan).doubleValue();
		
		
		
		
		
		
		firmServiceAHPEntity.setQuality(scsheji);

	    AHPwork ahpwork=new AHPwork();
	    try {
			ahpwork.insertscore(serviceID, sqhege,sqbaotui,sqtixi,sqyunfuwu,
					scsheji, sccaigou, scyunshu, scliyong, 
					sfzhonglei, sfshijian, sfshuliang,
					sitouru, siyun, sijibie,
					spjiaohuo, spmanyi, spzhanyou,
					sfshouyi,sfzichan, sflirun, sfxiaosou, sfchanchu, 
					stkaifa, stshouru, strenyuan,
					sexunhuan, senengyuan);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean addfirmServiceIndex(String serviceID, double qhege,
			double qbaotui, double qtixi, double qyunfuwu, double csheji,
			double ccaigou, double cyunshu, double cliyong, double fzhonglei,
			double fshijian, double fshuliang, double itouru, double iyun,
			double ijibie, double pjiaohuo, double pmanyi, double pzhanyou,
			double fshouyi, double fzichan, double flirun, double fxiaoshou,
			double fchanchu, double tkaifa, double tshouru, double trenyuan,
			double exunhuan, double enengyuan) {
		
		 AHPwork ahpwork=new AHPwork();
		boolean i=true;
		    try {
				i=ahpwork.insertscore(serviceID, qhege,qbaotui,qtixi,qyunfuwu,
						csheji, ccaigou, cyunshu, cliyong, 
						fzhonglei, fshijian, fshuliang,
						itouru, iyun, ijibie,
						pjiaohuo, pmanyi, pzhanyou,
						fshouyi,fzichan,flirun, fxiaoshou, fchanchu, 
						tkaifa, tshouru, trenyuan,
						exunhuan, enengyuan);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		    if(i){
				return true;
			}else {
				return false;
			}
	}
	public FirmServiceAHPEntity valiateyes(String serviceType) {
		// TODO Auto-generated method stub
		return firmserviceAHPDAO.validService(serviceType);
	}
	public void updatefirmService(String firmID, String serviceName,
			String serviceNum, String delitime, String serviceType,
			String passrate, String lprice, String hprice, String confde,
			String credit, String retime, String flexi, String returnser,
			String samspeed, String carriage, String serviceID) {
		
        FirmServiceAHPEntity firmServiceAHPEntity=new FirmServiceAHPEntity();
		
		firmServiceAHPEntity.setFirmID(firmID);
		firmServiceAHPEntity.setServiceName(serviceName);
		firmServiceAHPEntity.setServiceNum(serviceNum);
		firmServiceAHPEntity.setServiceType(serviceType);
		firmServiceAHPEntity.setDelitime(delitime);
		firmServiceAHPEntity.setPassrate(passrate);
		firmServiceAHPEntity.setLPrice(lprice);
		firmServiceAHPEntity.setHPrice(hprice);
		firmServiceAHPEntity.setConfde(confde);
		firmServiceAHPEntity.setCredit(credit);
		firmServiceAHPEntity.setRetime(retime);
		firmServiceAHPEntity.setFlexi(flexi);
		firmServiceAHPEntity.setReturnSer(returnser);
		firmServiceAHPEntity.setSamSpeed(samspeed);
		firmServiceAHPEntity.setCarriage(carriage);
		firmServiceAHPEntity.setServiceID(serviceID);
		firmserviceAHPDAO.deletesearch(serviceName,serviceID,firmID);
		System.out.println("型号"+serviceID);
		firmserviceAHPDAO.addService(firmServiceAHPEntity);
	}
	
	
	public boolean search(String firmID, String serviceName, String serviceType) throws SQLException {
        
		FirmServiceAHPEntity firmServiceAHPEntity=new FirmServiceAHPEntity();
		
		firmServiceAHPEntity.setFirmID(firmID);
		firmServiceAHPEntity.setServiceName(serviceName);
		firmServiceAHPEntity.setServiceType(serviceType);

	     return firmserviceAHPDAO.searchfirmService(serviceType,serviceName,firmID);
	}
	public double getyunfuwu() {
		// TODO Auto-generated method stub
		return firmserviceAHPDAO.getyunfuwu();
	}
	public double getyunfuwuneed(String firmID) {
		// TODO Auto-generated method stub
		return firmserviceAHPDAO.getyunfuwuneed(firmID);
	}
	public double getshuliangneed(String serviceName) {
		// TODO Auto-generated method stub
		return firmserviceAHPDAO.getshuliangneed(serviceName);
	}
	public double getallneed(String serviceName) {
		// TODO Auto-generated method stub
		return firmserviceAHPDAO.getallneed(serviceName);
	}
}
