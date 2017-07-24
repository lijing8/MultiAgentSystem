package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.ServiceEntity;

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
public class ServiceDAO {
//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
	//��ȡ���з����б�
	public List<ServiceEntity> getAllService() {
//		����hql���
		String hql = "from ServiceEntity";
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		���ط����б�
		return query.list();
	}
	//���
	public void addService(ServiceEntity serviceEntity){
//		�Ի������ȡ��ǰ�Ի�����ʵ��
		sessionFactory.getCurrentSession().save(serviceEntity);
	}
	//ɾ��
	public boolean delService(String serviceID){
//		����hql���
		String hql = "delete ServiceEntity service where service.ServiceID=?";  
//		�����ѯ�����ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//		ִ�в�ѯ���� 
		query.setString(0, serviceID);  
//		���ز�ѯ�ǹ��ɹ�
		return (query.executeUpdate() > 0);  
	}
	//�޸�����
	public boolean updataService(ServiceEntity serviceEntity){
		String hql = "update ServiceEntity service set service.ServiceID=?,service.ServiceName=?,service.ServiceProper1=?,service.ServiceProper2=?,service.ServiceProper3=?,service.ServiceProper4=?,service.FirmID=? where service.ServiceID=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
       
        return (query.executeUpdate() > 0);  
	}
//	��ȡ����ʵ�壬��ID����
	public ServiceEntity getService(String serviceID) {
		String hql="from ServiceEntity service where service.ServiceID=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, serviceID);
		return (ServiceEntity)query.uniqueResult();
	}
	
	
	
}
