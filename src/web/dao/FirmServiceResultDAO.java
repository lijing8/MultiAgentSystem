package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.FirmServiceEntity;
import web.entity.FirmServiceEntityResult;
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
public class FirmServiceResultDAO {
//	用@Autowired注解将对话实体类引入，
	@Autowired
	private SessionFactory sessionFactory;
	public List<FirmServiceEntityResult> getResultBydemandID(String demandID) {
//		定义hql语句
		//String HQL="FROM ResultEntity  WHERE SimID like ?";
		System.out.print("查询54");
		String HQL="from FirmServiceEntityResult a where a.demandID = "+"'"+demandID+"'";
//		定义查询类对象，并执行
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
//		返回查询列表
		return q.list();
	}
	
	
	
}
