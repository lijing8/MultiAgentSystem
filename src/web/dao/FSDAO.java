package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.FirmServiceEntity;
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
public class FSDAO {
//	用@Autowired注解将对话实体类引入，
	@Autowired
	private SessionFactory sessionFactory;
	
	//查找服务
	public FirmServiceEntity getFSByFSID(String FirmID,String ServiceID){
//		定义hql语句
		String HQL="FROM FirmServiceEntity firmservice WHERE firmservice.FirmID=? and firmservice.ServiceID =？";
//		定义查询类对象，并执行
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
		
		q.setString(0, FirmID);
		q.setString(1, ServiceID);
//		返回查询列表
		return (FirmServiceEntity)q.uniqueResult();
	}
//	获取所有服务内容
	public List<FirmServiceEntity> getAllFirmService() {
//		定义hql语句
		String hql = "from FirmServiceEntity";
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		返回查询列表
		return query.list();
	}
	//注册
	public void addFirmService(FirmServiceEntity firmservice){
//		对话对象获取当前对话保存实体
		sessionFactory.getCurrentSession().save(firmservice);
	}
	//删除
	public boolean delFirmService(String id){
//		定义hql语句
		String hql = "delete FirmServiceEntity firmservice where firmservice.id=?";  
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	     query.setString(0, id);  
//	     返回是否执行成功
	     return (query.executeUpdate() > 0);  
	}
	

	
}
