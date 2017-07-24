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
 * ����DAO��
 * DAO��ʹ��Hibernate������������Spring���й���
 * ��Ҫ�������ļ���������á���Dao���е���ͷʹ��@Autowiredע�⽫�Ի�ʵ�������룬
 * ����Hibernate��HQL�����ʵ�ֶԶ���ʵ���������ɾ���ġ���Ĳ���������ʵ�������ݵĳ־û�,
 * ��ע��@Repository���б�ʶ��@Transactional(rollbackOn = Exception.class)�������쳣�ع�
 */


@Repository
@Transactional(rollbackOn = Exception.class)
public class DemandDAO {
//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
	
//	��ȡ�����б�
	public List<DemandEntity> getAllDemand() {
//		����hql���
		String hql = "from DemandEntity";
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		���ز�ѯ�б�
		return query.list();
	}
	//������󣬷����Ƿ�ɹ����
	public Boolean addDemand(DemandEntity demandEntity) throws StaleProxyException{
//		�Ի������ȡ��ǰ�Ի�����ʵ��
		//sessionFactory.getCurrentSession().save(demandEntity);
//		����Boolean�����ж��Ƿ���ӳɹ�
		Boolean addBoolean=(sessionFactory.getCurrentSession().save(demandEntity)==demandEntity.getDemandID());
		
		return addBoolean;
		
		
		
	}

	//ɾ��
	public boolean delDemand(String demandID){
		 String hql = "delete DemandEntity demand where demand.DemandID=?";  
	     Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	     query.setString(0, demandID);  
	     return (query.executeUpdate() > 0);  
	}
	//�޸�����
	public boolean updataDemand(DemandEntity demandEntity){
		String hql = "update DemandEntity demand set demand.DemandID=?,demand.DemandName=?,demand.DemandProper1=?,demand.DemandProper2=?,demand.DemandProper3=?,demand.DemandProper4=? where demand.DemandID=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
       
        return (query.executeUpdate() > 0);  
	}
//	����ID��ѯ������DemandEntityʵ��
	public DemandEntity getDemand(String demandID) {
		String hql="from DemandEntity demand where demand.DemandID=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, demandID);
		return (DemandEntity)query.uniqueResult();
	}
	
	
	
}
