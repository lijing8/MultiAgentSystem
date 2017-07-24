package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.FSDAO;
import web.entity.FirmServiceEntity;
/**
 * 云服务业务逻辑类，负责业务处理，Service层的组件用@Service进行标注，
 * @author hanyuping
 *
 */

@Service
public class FSService {
//	利用@Autowired将UserDAO对象引入。
	@Autowired
	private FSDAO fsDAO;
//	获取按 企业ID和服务ID获取用户返回用户实体
	public FirmServiceEntity  getFSByFSID(String FirmID,String ServiceID){
		return fsDAO.getFSByFSID(FirmID, ServiceID);
	}
	public List<FirmServiceEntity> getAllFirmService() {
		return fsDAO.getAllFirmService();
	}

//删除操作
	public boolean delFirmService(String id){
		return fsDAO.delFirmService(id);
	}
	
}
