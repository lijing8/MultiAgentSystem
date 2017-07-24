package web.dao;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;





import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import multiagent.utility.AgentStarter.AgentStarter;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.DemandEntity;

/**
 * @author hanyuping
 * 需求DAO类
 * DAO层使用Hibernate技术，它交由Spring进行管理，
 * 需要在配置文件里进行配置。在Dao层中的类头使用@Autowired注解将对话实体类引入，
 * 利用Hibernate的HQL语句来实现对对象实体类的增、删、改、查的操作，进而实现了数据的持久化,
 * 用注解@Repository进行标识，@Transactional(rollbackOn = Exception.class)来设置异常回滚
 */


@Repository
@Transactional(rollbackOn = Exception.class)
public class DemandDAO {
//	用@Autowired注解将对话实体类引入，
	@Autowired
	private SessionFactory sessionFactory;
	
//	获取需求列表
	public List<DemandEntity> getAllDemand() {
//		定义hql语句
		String hql = "from DemandEntity";
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		返回查询列表
		return query.list();
	}
	//添加需求，返回是否成功添加
	public Boolean addDemand(DemandEntity demandEntity) throws StaleProxyException{
//		对话对象获取当前对话保存实体
		//sessionFactory.getCurrentSession().save(demandEntity);
//		定义Boolean对象，判断是否添加成功
		Boolean addBoolean=(sessionFactory.getCurrentSession().save(demandEntity)==demandEntity.getDemandID());
		
		return addBoolean;
		
		
		
	}

	//删除
	public boolean delDemand(String demandID){
		 String hql = "delete DemandEntity demand where demand.DemandID=?";  
	     Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	     query.setString(0, demandID);  
	     return (query.executeUpdate() > 0);  
	}
	//修改数据
	public boolean updataDemand(DemandEntity demandEntity){
		String hql = "update DemandEntity demand set demand.DemandID=?,demand.DemandName=?,demand.DemandProper1=?,demand.DemandProper2=?,demand.DemandProper3=?,demand.DemandProper4=? where demand.DemandID=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
       
        return (query.executeUpdate() > 0);  
	}
//	按照ID查询，返回DemandEntity实体
	public DemandEntity getDemand(String demandID) {
		String hql="from DemandEntity demand where demand.DemandID=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, demandID);
		return (DemandEntity)query.uniqueResult();
	}
	
	
	
}
