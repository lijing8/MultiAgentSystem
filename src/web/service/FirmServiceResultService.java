package web.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import web.dao.FirmServiceResultDAO;
import web.entity.FirmServiceEntityResult;
/**
 * ����ҵ���߼��࣬����ҵ����Service��������@Service���б�ע��
 * @author lijing
 *
 */
@Service
public class FirmServiceResultService {
//	����@Autowired��UserDAO��������
	@Autowired
	private FirmServiceResultDAO firmServiceResultDAO;
	/**
	 * ��ȡ�����б�
	 * @return ���ط����б�
	 */
	
	public List<FirmServiceEntityResult> getResultBydemandID(String demandID) {
		System.out.print("��ѯ");
		return firmServiceResultDAO.getResultBydemandID(demandID);
	}
	
}
