package web.service;


import jade.wrapper.StaleProxyException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AHP.AHPwork;
import web.dao.DemandDAO;
import web.entity.DemandEntity;



@Service
public class DemandService {

	@Autowired
	private DemandDAO demandDAO;
	
	//查询所有的需求数据
	public List<DemandEntity> getAllDemand() {
		return demandDAO.getAllDemand();
	}
	
	public  Boolean  addDemand(String demandID,String demandName,String demandType,String demandNum
			,String delitime,String passrate,String Lprice,String Hprice,String confde,
			String credit,String retime,String flexi,String samspeed,String returnser,
			String carriage) throws StaleProxyException{
		
		DemandEntity demandEntity=new DemandEntity();
		demandEntity.setDemandID(demandID);
		demandEntity.setDemandName(demandName);
		demandEntity.setDemandType(demandType);
		demandEntity.setDemandNum(demandNum);
		demandEntity.setDelitime(delitime);
		demandEntity.setPassrate(passrate);
		demandEntity.setLPrice(Lprice);
		demandEntity.setHPrice(Hprice);
		demandEntity.setConfde(confde);
		demandEntity.setCredit(credit);
		demandEntity.setRetime(retime);
		demandEntity.setFlexi(flexi);
		demandEntity.setSamSpeed(samspeed);
		demandEntity.setReturnSer(returnser);
		demandEntity.setCarriage(carriage);
		

		return demandDAO.addDemand(demandEntity);
			
	}
	//删除
	public boolean delDemand(String demandID){
		return demandDAO.delDemand(demandID);
	}
	//修改数据
	public boolean updataDemand(DemandEntity demandEntity){
		return demandDAO.updataDemand(demandEntity);
	}
	
	public DemandEntity getDemand(String demandID) {
		return demandDAO.getDemand(demandID);
	}

	public void updataDemandahp(String demandID, double qhege,double qbaotui ,double qtixi ,double qyunfuwu,
			double csheji ,double ccaigou ,double cyunshu ,double cliyong,
			double fzhonglei ,double fshijian ,double fshuliang,
			double itouru ,double iyun ,double ijibie,
			double pjiaohuo,double  pmanyi ,double pzhanyou,
			double fshouyi ,double fzichan ,double flirun ,double fxiaosou,double  fchanchu,
			double tkaifa ,double tshouru ,double  trenyuan,
			double exunhuan ,double enengyuan) throws StaleProxyException {
		
		DemandEntity demandEntity=new DemandEntity();
		demandEntity.setDemandID(demandID);
		
		demandEntity.setQhege(qhege);
		demandEntity.setQbaotui(qbaotui);
		demandEntity.setQtixi(qtixi);
		demandEntity.setQyunfuwu(qyunfuwu);
		
		demandEntity.setCsheji(csheji);
		demandEntity.setCcaigou(ccaigou);
		demandEntity.setCyunshu(cyunshu);
		demandEntity.setCliyong(cliyong);
		
		demandEntity.setFzhonglei(fzhonglei);
		demandEntity.setFshijian(fshijian);
		demandEntity.setFshuliang(fshuliang);
		
		demandEntity.setItouru(itouru);
		demandEntity.setIjibie(ijibie);
		demandEntity.setIyun(iyun);
		
		demandEntity.setPjiaohuo(pjiaohuo);
		demandEntity.setPmanyi(pmanyi);
		demandEntity.setPzhanyou(pzhanyou);
		
		demandEntity.setFshouyi(fshouyi);
		demandEntity.setFzichan(fzichan);
		demandEntity.setFlirun(flirun);
		demandEntity.setFxiaosou(fxiaosou);
		demandEntity.setFchanchu(fchanchu);
		
		demandEntity.setTkaifa(tkaifa);
		demandEntity.setTshouru(tshouru);
		demandEntity.setTrenyuan(trenyuan);
		
		demandEntity.setExunhuan(exunhuan);
		demandEntity.setEnengyuan(enengyuan);
		 demandDAO.addDemand(demandEntity);

	}

	public Boolean addDemandid(String userName) throws StaleProxyException {
		// TODO Auto-generated method stub
		DemandEntity demandEntity=new DemandEntity();
		demandEntity.setDemandID(userName);
		return demandDAO.addDemand(demandEntity);
	}

	public Boolean updateDemandbyid(String demandID, String demandName,
			String demandType, String demandNum, String delitime,
			String passrate, String lprice, String hprice, String confde,
			String credit, String retime, String flexi, String samspeed,
			String returnser, String carriage) {
		// TODO Auto-generated method stub
		AHPwork ahpwork=new AHPwork();
		Boolean i=true;
	    try {
			ahpwork.updateahp(demandID,demandName,
					 demandType, demandNum, delitime,
					 passrate,lprice,  hprice, confde,
					 credit,retime,flexi,  samspeed,
					returnser, carriage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return i;
	}

	
}
