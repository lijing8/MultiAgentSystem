package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.FirmDAO;
import web.entity.FirmEntity;

/**
 * ��ҵҵ���߼��࣬����ҵ����Service��������@Service���б�ע��
 * @author hanyuping
 *
 */
@Service
public class FirmService {
//	����@Autowired��UserDAO�������롣
	@Autowired
	private FirmDAO firmDAO;
	/**
	 * ��ȡ��ҵ
	 * @return �����û��б�
	 */
	public List<FirmEntity> getAllFirms() {
		return firmDAO.getAllFirms();
	}
	/**
	 * �����ҵ
	 * @param firmID ��ҵID
	 * @param firmName ��ҵ����
	 * @param firmAddress ��ҵ��ַ
	 * @param firmProper1 ��ҵ����
	 * @param firmProper2 ��ҵ����
	 * @param firmProper3 ��ҵ����
	 * @param firmProper4 ��ҵ����
	 */
	public void addFirm(String firmID,String firmName,String firmAddress,Double firmProper1,Double firmProper2,Double firmProper3,Double firmProper4){
//		����FirmEntity�����
		FirmEntity firmEntity=new FirmEntity();
//		����FirmEntity��Ա������
		firmEntity.setFirmID(firmID);
		firmEntity.setFirmName(firmName);
		firmEntity.setFrimAddress(firmAddress);
		firmEntity.setFirmProper1(firmProper1);
		firmEntity.setFirmProper2(firmProper2);
		firmEntity.setFirmProper3(firmProper3);
		firmEntity.setFirmProper4(firmProper4);
//		����DAO��ӷ�����
		firmDAO.addFirm(firmEntity);
			
	}
	//ɾ��
	public boolean delFirm(String FirmID){
		return firmDAO.delFirm(FirmID);
	}
	//�޸�����
	public boolean updataFirm(FirmEntity firmEntity){
		return firmDAO.updataFirm(firmEntity);
	}
//	��ȡ��ҵ��������ҵʵ��
	public FirmEntity getFirm(String firmID) {
		return firmDAO.getFirm(firmID);
	}
}
