package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.FirmServiceEntity;
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
public class FSDAO {
//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
	
	//���ҷ���
	public FirmServiceEntity getFSByFSID(String FirmID,String ServiceID){
//		����hql���
		String HQL="FROM FirmServiceEntity firmservice WHERE firmservice.FirmID=? and firmservice.ServiceID =��";
//		�����ѯ����󣬲�ִ��
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
		
		q.setString(0, FirmID);
		q.setString(1, ServiceID);
//		���ز�ѯ�б�
		return (FirmServiceEntity)q.uniqueResult();
	}
//	��ȡ���з�������
	public List<FirmServiceEntity> getAllFirmService() {
//		����hql���
		String hql = "from FirmServiceEntity";
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		���ز�ѯ�б�
		return query.list();
	}
	//ע��
	public void addFirmService(FirmServiceEntity firmservice){
//		�Ի������ȡ��ǰ�Ի�����ʵ��
		sessionFactory.getCurrentSession().save(firmservice);
	}
	//ɾ��
	public boolean delFirmService(String id){
//		����hql���
		String hql = "delete FirmServiceEntity firmservice where firmservice.id=?";  
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	     query.setString(0, id);  
//	     �����Ƿ�ִ�гɹ�
	     return (query.executeUpdate() > 0);  
	}
	

	
}
