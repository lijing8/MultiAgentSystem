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
 * 用户DAO类
 * DAO层使用Hibernate技术，它交由Spring进行管理，
 * 需要在配置文件里进行配置。在Dao层中的类头使用@Autowired注解将对话实体类引入，
 * 利用Hibernate的HQL语句来实现对对象实体类的增、删、改、查的操作，进而实现了数据的持久化,
 * 用注解@Repository进行标识，@Transactional(rollbackOn = Exception.class)来设置异常回滚
 */
@Repository
@Transactional(rollbackOn = Exception.class)
public class UserDAO {
//	用@Autowired注解将对话实体类引入，
	@Autowired
	private SessionFactory sessionFactory;
	
	//查找用户
	public UserEntity getUserByUserID(String UserID){
		String HQL="FROM UserEntity user WHERE user.userID=?";
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
		q.setString(0, UserID);
		return (UserEntity)q.uniqueResult();
	}
//	获取所有用户列表
	public List<UserEntity> getAllUser() {
//		定义hql语句
		String hql = "from UserEntity";
//		定义查询类对象，
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		返回查询列表
		return query.list();
	}
	//添加用户实体
	public void addUser(UserEntity userEntity){
//		对话对象获取当前对话保存实体
		sessionFactory.getCurrentSession().save(userEntity);
	}
	//删除
	public boolean delUser(String id){
//		定义hql语句
		 String hql = "delete UserEntity user where user.userID=?";  
//			定义查询类对象，
	     Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//	   执行查询操作
	     query.setString(0, id);  
//	     返回查询是够成功
	     return (query.executeUpdate() > 0);  
	}
//	修改用户数据
	public boolean updataUser(UserEntity userEntity){
//		定义hql语句
		String hql = "update UserEntity user set user.userID=?,user.userName=?,user.userPassword=?,user.userRole=? where user.userID=?";  
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//        设置更改内容，按照数据库表列进行修改设置
        query.setString(0, userEntity.getUserID());  
        query.setString(1, userEntity.getUserName());  
        query.setString(2, userEntity.getUserPassword());  
        query.setString(3, userEntity.getUserRole());  
//       返回是够成功
        return (query.executeUpdate() > 0);  
	}
	//按ID查找
	public UserEntity getUser(String id) {
//		定义hql语句
		String hql="from UserEntity user where user.userID=?";
//		定义查询类对象，并执行
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
//      返回是够成功	
		return (UserEntity)query.uniqueResult();
	}
}
