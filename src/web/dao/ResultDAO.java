package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.ResultEntity;

/**
 * @author hanyuping
 * �û�DAO��
 * DAO��ʹ��Hibernate������������Spring���й���
 * ��Ҫ�������ļ���������á���Dao���е���ͷʹ��@Autowiredע�⽫�Ի�ʵ�������룬
 * ����Hibernate��HQL�����ʵ�ֶԶ���ʵ���������ɾ���ġ���Ĳ���������ʵ�������ݵĳ־û�,
 * ��ע��@Repository���б�ʶ��@Transactional(rollbackOn = Exception.class)�������쳣�ع�
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class ResultDAO {
//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
//	���շ���ID����
	public List<ResultEntity> getResultBySimID(String SimID){
//		����hql���
		String HQL="FROM ResultEntity  WHERE SimID like ?";
		
//		�����ѯ����󣬲�ִ��
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
//		ִ��ģ����ѯ
		q.setString(0, "%"+SimID+"%");
//		���ز�ѯ�б�
		return q.list();
	}
//	��ȡ���з�������
	public List<ResultEntity> getAllResult() {
//		����hql���
		String hql = "from ResultEntity";
		
		
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		���ز�ѯ�б�
		return query.list();
	}
//	��ӽ��
	public void addResult(ResultEntity resultEntity){
		sessionFactory.getCurrentSession().save(resultEntity);
	}
}
