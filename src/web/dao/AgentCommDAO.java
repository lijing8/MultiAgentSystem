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
 * Agent����DAO��
 * DAO��ʹ��Hibernate������������Spring���й���
 * ��Ҫ�������ļ���������á���Dao���е���ͷʹ��@Autowiredע�⽫�Ի�ʵ�������룬
 * ����Hibernate��HQL�����ʵ�ֶԶ���ʵ���������ɾ���ġ���Ĳ���������ʵ�������ݵĳ־û�,
 * ��ע��@Repository���б�ʶ��@Transactional(rollbackOn = Exception.class)�������쳣�ع�
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class AgentCommDAO {

//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
//	��ȡ��������
	public List<AgentCommEntity> getAllAgentComm() {
//		����hql���
		String hql = "from AgentCommEntity";
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		���ز�ѯ�б�
		return query.list();
	}
}
