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
 * �û�DAO��
 * DAO��ʹ��Hibernate������������Spring���й���
 * ��Ҫ�������ļ���������á���Dao���е���ͷʹ��@Autowiredע�⽫�Ի�ʵ�������룬
 * ����Hibernate��HQL�����ʵ�ֶԶ���ʵ���������ɾ���ġ���Ĳ���������ʵ�������ݵĳ־û�,
 * ��ע��@Repository���б�ʶ��@Transactional(rollbackOn = Exception.class)�������쳣�ع�
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class FirmServiceResultDAO {
//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
	public List<FirmServiceEntityResult> getResultBydemandID(String demandID) {
//		����hql���
		//String HQL="FROM ResultEntity  WHERE SimID like ?";
		System.out.print("��ѯ54");
		String HQL="from FirmServiceEntityResult a where a.demandID = "+"'"+demandID+"'";
//		�����ѯ����󣬲�ִ��
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
//		���ز�ѯ�б�
		return q.list();
	}
	
	
	
}
