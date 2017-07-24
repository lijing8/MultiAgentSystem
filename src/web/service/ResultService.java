package web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.ResultDAO;
import web.entity.ResultEntity;




/**
 * 结果业务逻辑类，负责业务处理，Service层的组件用@Service进行标注，
 * @author hanyuping
 *
 */
@Service
public class ResultService {
//	利用@Autowired将UserDAO对象引入。
	@Autowired
	private ResultDAO resultDAO;
//	获取服务列表，按照需求ID查询
	public List<ResultEntity> getResultBySimID(String SimID){
		return resultDAO.getResultBySimID(SimID);
	}
//	获取所有计算结果
	public  List<ResultEntity> getAllResult() {
		return resultDAO.getAllResult();
	}
//	添加需求
	public void addResult(String SimID,String firmID,String serviceID, double demandconf,String SimDate){
//		定义ResultEntity实体
		ResultEntity resultEntity=new ResultEntity();
//	设置实体参数
		resultEntity.setID(SimID);;
		resultEntity.setFirmID(firmID);
		resultEntity.setServiceID(serviceID);
		resultEntity.setDemandconf(demandconf);;
		resultEntity.setDate(SimDate);
//		调用resultDAO添加操作
		resultDAO.addResult(resultEntity);
	}
}
