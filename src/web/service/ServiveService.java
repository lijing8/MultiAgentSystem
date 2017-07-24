package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.ServiceDAO;

import web.entity.ServiceEntity;
/**
 * ����ҵ���߼��࣬����ҵ����Service��������@Service���б�ע��
 * @author hanyuping
 *
 */
@Service
public class ServiveService {
//	����@Autowired��UserDAO��������
	@Autowired
	private ServiceDAO serviceDAO;
	/**
	 * ��ȡ�����б�
	 * @return ���ط����б�
	 */
	public List<ServiceEntity> getAllService() {
		return serviceDAO.getAllService();
	}

	//ɾ��
	public boolean delService(String serviceID){
		return serviceDAO.delService(serviceID);
	}
	//�޸�����
	public boolean updataService(ServiceEntity serviceEntity){
		return serviceDAO.updataService(serviceEntity);
	}
	//��ȡ���񣬷��ط���ʵ��
	public ServiceEntity getService(String serviceID) {
		return serviceDAO.getService(serviceID);
	}
}
