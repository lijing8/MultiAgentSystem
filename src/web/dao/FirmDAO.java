package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.FirmEntity;
/**
 * @author hanyuping
 * 企业DAO类
 * DAO层使用Hibernate技术，它交由Spring进行管理，
 * 需要在配置文件里进行配置。在Dao层中的类头使用@Autowired注解将对话实体类引入，
 * 利用Hibernate的HQL语句来实现对对象实体类的增、删、改、查的操作，进而实现了数据的持久化,
 * 用注解@Repository进行标识，@Transactional(rollbackOn = Exception.class)来设置异常回滚
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class FirmDAO {
//	用@Autowired注解将对话实体类引入，
	@Autowired
	private SessionFactory sessionFactory;
//	获取企业列表
	public List<FirmEntity> getAllFirms() {
//		定义hql语句
		String hql = "from FirmEntity";
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
		
		return query.list();
	}
	//添加物料
	public void addFirm(FirmEntity firmEntity){
		
		sessionFactory.getCurrentSession().save(firmEntity);
	}
	//删除
	public boolean delFirm(String FirmID){
//		定义hql语句
		String hql = "delete FirmEntity firm where service.FirmID=?";  
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	     
		query.setString(0, FirmID);  
	     return (query.executeUpdate() > 0);  
	}
	//修改数据
	public boolean updataFirm(FirmEntity firmEntity){
//		定义hql语句
		String hql = "update FirmEntity firm set firm.FirmID=?,firm.FirmName=?,firm.FirmAddress=?,firm.FirmProper1=?,firm.FirmProper2=?,firm.FirmProper3=?,firm.FirmProper4=? where firm.FirmID=?";  
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        
        query.setString(0, firmEntity.getFirmID());  
        query.setString(1, firmEntity.getFirmName()); 
        query.setString(2, firmEntity.getFrimAddress());
        query.setDouble(3, firmEntity.getFirmProper1());  
        query.setDouble(4, firmEntity.getFirmProper2()); 
        query.setDouble(5, firmEntity.getFirmProper3());  
        query.setDouble(6, firmEntity.getFirmProper4()); 
        
        return (query.executeUpdate() > 0);  
	}
	public FirmEntity getFirm(String FirmID) {
//		定义hql语句
		String hql="from FirmEntity firm where firm.FirmID=?";
//		定义查询类对象，并执行
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, FirmID);
		return (FirmEntity)query.uniqueResult();
	}
}
