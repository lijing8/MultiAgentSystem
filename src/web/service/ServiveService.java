package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.ServiceDAO;

import web.entity.ServiceEntity;
/**
 * 服务业务逻辑类，负责业务处理，Service层的组件用@Service进行标注，
 * @author hanyuping
 *
 */
@Service
public class ServiveService {
//	利用@Autowired将UserDAO对象引入
	@Autowired
	private ServiceDAO serviceDAO;
	/**
	 * 获取服务列表
	 * @return 返回服务列表
	 */
	public List<ServiceEntity> getAllService() {
		return serviceDAO.getAllService();
	}

	//删除
	public boolean delService(String serviceID){
		return serviceDAO.delService(serviceID);
	}
	//修改数据
	public boolean updataService(ServiceEntity serviceEntity){
		return serviceDAO.updataService(serviceEntity);
	}
	//获取服务，返回服务实体
	public ServiceEntity getService(String serviceID) {
		return serviceDAO.getService(serviceID);
	}
}
