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
 * AgentDAO��
 * DAO��ʹ��Hibernate������������Spring���й���
 * ��Ҫ�������ļ���������á���Dao���е���ͷʹ��@Autowiredע�⽫�Ի�ʵ�������룬
 * ����Hibernate��HQL�����ʵ�ֶԶ���ʵ���������ɾ���ġ���Ĳ���������ʵ�������ݵĳ־û�,
 * ��ע��@Repository���б�ʶ��@Transactional(rollbackOn = Exception.class)�������쳣�ع�
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class AgentDAO {
//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
	
	//�����û�
	public AgentEntity getAgentByAgentID(String AgentID){
		String HQL="FROM AgentEntity agent WHERE agent.AgentID=?";
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
		q.setString(0, AgentID);
		return (AgentEntity)q.uniqueResult();
	}
//	��ȡ����Agent��Ϣ
	public List<AgentEntity> getAllAgent() {
		String hql = "from AgentEntity";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
	//ע��
	public void addAgent(AgentEntity agentEntity){
		sessionFactory.getCurrentSession().save(agentEntity);
	}
	//ɾ��
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
