package web.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import web.dao.FirmServiceResultDAO;
import web.entity.FirmServiceEntityResult;
/**
 * 服务业务逻辑类，负责业务处理，Service层的组件用@Service进行标注，
 * @author lijing
 *
 */
@Service
public class FirmServiceResultService {
//	利用@Autowired将UserDAO对象引入
	@Autowired
	private FirmServiceResultDAO firmServiceResultDAO;
	/**
	 * 获取服务列表
	 * @return 返回服务列表
	 */
	
	public List<FirmServiceEntityResult> getResultBydemandID(String demandID) {
		System.out.print("查询");
		return firmServiceResultDAO.getResultBydemandID(demandID);
	}
	
}
