package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.FirmServiceEntity;
import web.entity.ServiceEntity;

/**
 * @author lijing
 * 用户DAO类
 * DAO层使用Hibernate技术，它交由Spring进行管理，
 * 需要在配置文件里进行配置。在Dao层中的类头使用@Autowired注解将对话实体类引入，
 * 利用Hibernate的HQL语句来实现对对象实体类的增、删、改、查的操作，进而实现了数据的持久化,
 * 用注解@Repository进行标识，@Transactional(rollbackOn = Exception.class)来设置异常回滚
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class FirmServiceDAO {
//	用@Autowired注解将对话实体类引入，
	@Autowired
	private SessionFactory sessionFactory;
	//获取所有服务列表
	public List<FirmServiceEntity> getAllService() {
//		定义hql语句
		String hql = "from FirmServiceEntity";
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		返回服务列表
		return query.list();
	} 
	
	

//	获取服务实体，按ID查找
	public FirmServiceEntity getonefirmService(String firmserviceID) {
		String hql="from FirmServiceEntity service where service.ID=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, firmserviceID);
		return (FirmServiceEntity)query.uniqueResult();
	}
	
	//删除
	public boolean delService(String serviceID){
//		定义hql语句
		String hql = "delete FirmServiceEntity service where service.ServiceID=?"; //youxiewenti 
//		定义查询类对象，执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//		执行查询操作 
		query.setString(0, serviceID);  
//		返回查询是够成功
		return (query.executeUpdate() > 0);  
	}
	//修改数据
	public boolean updataService(ServiceEntity serviceEntity){
		String hql = "update ServiceEntity service set service.ServiceID=?,service.ServiceName=?,service.ServiceProper1=?,service.ServiceProper2=?,service.ServiceProper3=?,service.ServiceProper4=?,service.FirmID=? where service.ServiceID=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//        
        return (query.executeUpdate() > 0);  
	}
//	获取服务实体，按ID查找
	public ServiceEntity getService(String serviceID) {
		String hql="from ServiceEntity service where service.ServiceID=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, serviceID);
		return (ServiceEntity)query.uniqueResult();
	}
	public List<FirmServiceEntity> getAllFirmService() {
		// TODO Auto-generated method stub
//		定义hql语句
		String hql = "from FirmServiceEntity";
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		返回服务列表
		return query.list();
	}


	public List<FirmServiceEntity> getResultBydemandID() {
//		定义hql语句
		//String HQL="FROM ResultEntity  WHERE SimID like ?";
		System.out.print("查询2");
		String HQL="from FirmServiceEntity b";
//		定义查询类对象，并执行
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);

//		返回查询列表
		return q.list();
	}
	
	
	
}
