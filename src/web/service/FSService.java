package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.FSDAO;
import web.entity.FirmServiceEntity;
/**
 * �Ʒ���ҵ���߼��࣬����ҵ����Service��������@Service���б�ע��
 * @author hanyuping
 *
 */

@Service
public class FSService {
//	����@Autowired��UserDAO�������롣
	@Autowired
	private FSDAO fsDAO;
//	��ȡ�� ��ҵID�ͷ���ID��ȡ�û������û�ʵ��
	public FirmServiceEntity  getFSByFSID(String FirmID,String ServiceID){
		return fsDAO.getFSByFSID(FirmID, ServiceID);
	}
	public List<FirmServiceEntity> getAllFirmService() {
		return fsDAO.getAllFirmService();
	}

//ɾ������
	public boolean delFirmService(String id){
		return fsDAO.delFirmService(id);
	}
	
}
