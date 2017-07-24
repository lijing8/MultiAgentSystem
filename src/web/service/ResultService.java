package web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.ResultDAO;
import web.entity.ResultEntity;




/**
 * ���ҵ���߼��࣬����ҵ����Service��������@Service���б�ע��
 * @author hanyuping
 *
 */
@Service
public class ResultService {
//	����@Autowired��UserDAO�������롣
	@Autowired
	private ResultDAO resultDAO;
//	��ȡ�����б���������ID��ѯ
	public List<ResultEntity> getResultBySimID(String SimID){
		return resultDAO.getResultBySimID(SimID);
	}
//	��ȡ���м�����
	public  List<ResultEntity> getAllResult() {
		return resultDAO.getAllResult();
	}
//	�������
	public void addResult(String SimID,String firmID,String serviceID, double demandconf,String SimDate){
//		����ResultEntityʵ��
		ResultEntity resultEntity=new ResultEntity();
//	����ʵ�����
		resultEntity.setID(SimID);;
		resultEntity.setFirmID(firmID);
		resultEntity.setServiceID(serviceID);
		resultEntity.setDemandconf(demandconf);;
		resultEntity.setDate(SimDate);
//		����resultDAO��Ӳ���
		resultDAO.addResult(resultEntity);
	}
}
