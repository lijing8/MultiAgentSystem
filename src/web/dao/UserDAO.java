package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.UserEntity;
/**
 * @author hanyuping
 * �û�DAO��
 * DAO��ʹ��Hibernate������������Spring���й���
 * ��Ҫ�������ļ���������á���Dao���е���ͷʹ��@Autowiredע�⽫�Ի�ʵ�������룬
 * ����Hibernate��HQL�����ʵ�ֶԶ���ʵ���������ɾ���ġ���Ĳ���������ʵ�������ݵĳ־û�,
 * ��ע��@Repository���б�ʶ��@Transactional(rollbackOn = Exception.class)�������쳣�ع�
 */
@Repository
@Transactional(rollbackOn = Exception.class)
public class UserDAO {
//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
	
	//�����û�
	public UserEntity getUserByUserID(String UserID){
		String HQL="FROM UserEntity user WHERE user.userID=?";
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
		q.setString(0, UserID);
		return (UserEntity)q.uniqueResult();
	}
//	��ȡ�����û��б�
	public List<UserEntity> getAllUser() {
//		����hql���
		String hql = "from UserEntity";
//		�����ѯ�����
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		���ز�ѯ�б�
		return query.list();
	}
	//����û�ʵ��
	public void addUser(UserEntity userEntity){
//		�Ի������ȡ��ǰ�Ի�����ʵ��
		sessionFactory.getCurrentSession().save(userEntity);
	}
	//ɾ��
	public boolean delUser(String id){
//		����hql���
		 String hql = "delete UserEntity user where user.userID=?";  
//			�����ѯ�����
	     Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//	   ִ�в�ѯ����
	     query.setString(0, id);  
//	     ���ز�ѯ�ǹ��ɹ�
	     return (query.executeUpdate() > 0);  
	}
//	�޸��û�����
	public boolean updataUser(UserEntity userEntity){
//		����hql���
		String hql = "update UserEntity user set user.userID=?,user.userName=?,user.userPassword=?,user.userRole=? where user.userID=?";  
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//        ���ø������ݣ��������ݿ���н����޸�����
        query.setString(0, userEntity.getUserID());  
        query.setString(1, userEntity.getUserName());  
        query.setString(2, userEntity.getUserPassword());  
        query.setString(3, userEntity.getUserRole());  
//       �����ǹ��ɹ�
        return (query.executeUpdate() > 0);  
	}
	//��ID����
	public UserEntity getUser(String id) {
//		����hql���
		String hql="from UserEntity user where user.userID=?";
//		�����ѯ����󣬲�ִ��
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
//      �����ǹ��ɹ�	
		return (UserEntity)query.uniqueResult();
	}
}
