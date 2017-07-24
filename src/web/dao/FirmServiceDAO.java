package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.FirmServiceEntity;
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
public class FirmServiceDAO {
//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
	//��ȡ���з����б�
	public List<FirmServiceEntity> getAllService() {
//		����hql���
		String hql = "from FirmServiceEntity";
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		���ط����б�
		return query.list();
	} 
	
	

//	��ȡ����ʵ�壬��ID����
	public FirmServiceEntity getonefirmService(String firmserviceID) {
		String hql="from FirmServiceEntity service where service.ID=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, firmserviceID);
		return (FirmServiceEntity)query.uniqueResult();
	}
	
	//ɾ��
	public boolean delService(String serviceID){
//		����hql���
		String hql = "delete FirmServiceEntity service where service.ServiceID=?"; //youxiewenti 
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
//        
        return (query.executeUpdate() > 0);  
	}
//	��ȡ����ʵ�壬��ID����
	public ServiceEntity getService(String serviceID) {
		String hql="from ServiceEntity service where service.ServiceID=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, serviceID);
		return (ServiceEntity)query.uniqueResult();
	}
	public List<FirmServiceEntity> getAllFirmService() {
		// TODO Auto-generated method stub
//		����hql���
		String hql = "from FirmServiceEntity";
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		���ط����б�
		return query.list();
	}


	public List<FirmServiceEntity> getResultBydemandID() {
//		����hql���
		//String HQL="FROM ResultEntity  WHERE SimID like ?";
		System.out.print("��ѯ2");
		String HQL="from FirmServiceEntity b";
//		�����ѯ����󣬲�ִ��
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);

//		���ز�ѯ�б�
		return q.list();
	}
	
	
	
}
