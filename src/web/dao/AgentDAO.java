package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.AgentEntity;
/**
 * @author hanyuping
 * AgentDAO类
 * DAO层使用Hibernate技术，它交由Spring进行管理，
 * 需要在配置文件里进行配置。在Dao层中的类头使用@Autowired注解将对话实体类引入，
 * 利用Hibernate的HQL语句来实现对对象实体类的增、删、改、查的操作，进而实现了数据的持久化,
 * 用注解@Repository进行标识，@Transactional(rollbackOn = Exception.class)来设置异常回滚
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class AgentDAO {
//	用@Autowired注解将对话实体类引入，
	@Autowired
	private SessionFactory sessionFactory;
	
	//查找用户
	public AgentEntity getAgentByAgentID(String AgentID){
		String HQL="FROM AgentEntity agent WHERE agent.AgentID=?";
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
		q.setString(0, AgentID);
		return (AgentEntity)q.uniqueResult();
	}
//	获取所有Agent信息
	public List<AgentEntity> getAllAgent() {
		String hql = "from AgentEntity";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
	//注册
	public void addAgent(AgentEntity agentEntity){
		sessionFactory.getCurrentSession().save(agentEntity);
	}
	//删除
	public boolean delAgent(String agentid){
		 String hql = "delete AgentEntity agent where agent.AgentID=?";  
	     Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	     query.setString(0, agentid);  
	     return (query.executeUpdate() > 0);  
	}
	public boolean updataAgent(AgentEntity AgentEntity){
		String hql = "update AgentEntity agent set agent.AgentID=?,agent.AgentName=?,agent.AgentRole=?,agent.AgentAddress=? where agent.AgentID=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, AgentEntity.getAgentID());  
        query.setString(1, AgentEntity.getAgentName());  
        query.setString(2, AgentEntity.getAgentRole());  
        query.setString(3, AgentEntity.getAgentAddress());  
       
        return (query.executeUpdate() > 0);  
	}
}
