package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.FirmDAO;
import web.entity.FirmEntity;

/**
 * 企业业务逻辑类，负责业务处理，Service层的组件用@Service进行标注，
 * @author hanyuping
 *
 */
@Service
public class FirmService {
//	利用@Autowired将UserDAO对象引入。
	@Autowired
	private FirmDAO firmDAO;
	/**
	 * 获取企业
	 * @return 返回用户列表
	 */
	public List<FirmEntity> getAllFirms() {
		return firmDAO.getAllFirms();
	}
	/**
	 * 添加企业
	 * @param firmID 企业ID
	 * @param firmName 企业名称
	 * @param firmAddress 企业地址
	 * @param firmProper1 企业属性
	 * @param firmProper2 企业属性
	 * @param firmProper3 企业属性
	 * @param firmProper4 企业属性
	 */
	public void addFirm(String firmID,String firmName,String firmAddress,Double firmProper1,Double firmProper2,Double firmProper3,Double firmProper4){
//		声明FirmEntity类对象
		FirmEntity firmEntity=new FirmEntity();
//		设置FirmEntity成员变量。
		firmEntity.setFirmID(firmID);
		firmEntity.setFirmName(firmName);
		firmEntity.setFrimAddress(firmAddress);
		firmEntity.setFirmProper1(firmProper1);
		firmEntity.setFirmProper2(firmProper2);
		firmEntity.setFirmProper3(firmProper3);
		firmEntity.setFirmProper4(firmProper4);
//		调用DAO添加方法。
		firmDAO.addFirm(firmEntity);
			
	}
	//删除
	public boolean delFirm(String FirmID){
		return firmDAO.delFirm(FirmID);
	}
	//修改数据
	public boolean updataFirm(FirmEntity firmEntity){
		return firmDAO.updataFirm(firmEntity);
	}
//	获取企业，返回企业实体
	public FirmEntity getFirm(String firmID) {
		return firmDAO.getFirm(firmID);
	}
}
