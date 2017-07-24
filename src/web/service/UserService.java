package web.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.UserDAO;
import web.entity.UserEntity;

/**
 * �û�ҵ���߼��࣬����ҵ����Service��������@Service���б�ע��
 * @author hanyuping
 *
 */
@Service
public class UserService {
//	����@Autowired��UserDAO�������롣
	@Autowired
	private UserDAO userDAO;
	//��ȡ��UseID��ȡ�û������û�ʵ��
	public UserEntity getUserByUsername(String userID){
		return userDAO.getUserByUserID(userID);
	}
	/**
	 * ��ȡ�û��б�
	 * @return �����û��б�
	 */
	public  List<UserEntity> getAllUser() {
		return userDAO.getAllUser();
	}
	/**
	 * ����û�ʵ��
	 * @param userID �û�ID
	 * @param userName ����
	 * @param password ����
	 * @param userRole ��ɫ
	 */
	public void addUser(String userID, String userName,String password,String userRole){
//		�����û�ʵ��
		UserEntity userEntity=new UserEntity();
//		�����û�ʵ���Ա����
		userEntity.setUserID(userID);
		userEntity.setUserName(userName);
		userEntity.setUserPassword(password);
		userEntity.setUserRole(userRole);
//		����userDAO��addUser();
		userDAO.addUser(userEntity);
	}
	/**
	 * ɾ������
	 * @param id �����û�IDɾ��
	 * @return ����ɾ���Ƿ�ɹ�
	 */
	public boolean delUser(String id){
		return userDAO.delUser(id);
	}
	/**
	 * �����û���Ϣ
	 * @param user UserEntityʵ�����
	 * @return ����ɾ���ǹ��ɹ�
	 */
	public boolean updateUser(UserEntity user){
		return userDAO.updataUser(user);
	}
	/**
	 * ��ȡ�û�ʵ��
	 * @param id ����ID��ѯ
	 * @return �ϻ��û�ʵ��
	 */
	public UserEntity getUser(String id) {
		return userDAO.getUser(id);
	}
	
}
