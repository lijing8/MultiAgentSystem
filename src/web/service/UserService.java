package web.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.UserDAO;
import web.entity.UserEntity;

/**
 * 用户业务逻辑类，负责业务处理，Service层的组件用@Service进行标注，
 * @author hanyuping
 *
 */
@Service
public class UserService {
//	利用@Autowired将UserDAO对象引入。
	@Autowired
	private UserDAO userDAO;
	//获取按UseID获取用户返回用户实体
	public UserEntity getUserByUsername(String userID){
		return userDAO.getUserByUserID(userID);
	}
	/**
	 * 获取用户列表
	 * @return 返回用户列表
	 */
	public  List<UserEntity> getAllUser() {
		return userDAO.getAllUser();
	}
	/**
	 * 添加用户实体
	 * @param userID 用户ID
	 * @param userName 名称
	 * @param password 密码
	 * @param userRole 角色
	 */
	public void addUser(String userID, String userName,String password,String userRole){
//		声明用户实体
		UserEntity userEntity=new UserEntity();
//		设置用户实体成员参数
		userEntity.setUserID(userID);
		userEntity.setUserName(userName);
		userEntity.setUserPassword(password);
		userEntity.setUserRole(userRole);
//		调用userDAO的addUser();
		userDAO.addUser(userEntity);
	}
	/**
	 * 删除操作
	 * @param id 按照用户ID删除
	 * @return 返回删除是否成功
	 */
	public boolean delUser(String id){
		return userDAO.delUser(id);
	}
	/**
	 * 更新用户信息
	 * @param user UserEntity实体对象
	 * @return 返回删除是够成功
	 */
	public boolean updateUser(UserEntity user){
		return userDAO.updataUser(user);
	}
	/**
	 * 获取用户实体
	 * @param id 按照ID查询
	 * @return 赶回用户实体
	 */
	public UserEntity getUser(String id) {
		return userDAO.getUser(id);
	}
	
}
