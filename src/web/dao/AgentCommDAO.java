package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.AgentCommEntity;

/**
 * @author hanyuping
 * Agent交互DAO类
 * DAO层使用Hibernate技术，它交由Spring进行管理，
 * 需要在配置文件里进行配置。在Dao层中的类头使用@Autowired注解将对话实体类引入，
 * 利用Hibernate的HQL语句来实现对对象实体类的增、删、改、查的操作，进而实现了数据的持久化,
 * 用注解@Repository进行标识，@Transactional(rollbackOn = Exception.class)来设置异常回滚
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class AgentCommDAO {

//	用@Autowired注解将对话实体类引入，
	@Autowired
	private SessionFactory sessionFactory;
//	获取交互数据
	public List<AgentCommEntity> getAllAgentComm() {
//		定义hql语句
		String hql = "from AgentCommEntity";
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		返回查询列表
		return query.list();
	}
}
