package web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.entity.FirmEntity;
/**
 * @author hanyuping
 * ��ҵDAO��
 * DAO��ʹ��Hibernate������������Spring���й���
 * ��Ҫ�������ļ���������á���Dao���е���ͷʹ��@Autowiredע�⽫�Ի�ʵ�������룬
 * ����Hibernate��HQL�����ʵ�ֶԶ���ʵ���������ɾ���ġ���Ĳ���������ʵ�������ݵĳ־û�,
 * ��ע��@Repository���б�ʶ��@Transactional(rollbackOn = Exception.class)�������쳣�ع�
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class FirmDAO {
//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
//	��ȡ��ҵ�б�
	public List<FirmEntity> getAllFirms() {
//		����hql���
		String hql = "from FirmEntity";
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
		
		return query.list();
	}
	//�������
	public void addFirm(FirmEntity firmEntity){
		
		sessionFactory.getCurrentSession().save(firmEntity);
	}
	//ɾ��
	public boolean delFirm(String FirmID){
//		����hql���
		String hql = "delete FirmEntity firm where service.FirmID=?";  
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	     
		query.setString(0, FirmID);  
	     return (query.executeUpdate() > 0);  
	}
	//�޸�����
	public boolean updataFirm(FirmEntity firmEntity){
//		����hql���
		String hql = "update FirmEntity firm set firm.FirmID=?,firm.FirmName=?,firm.FirmAddress=?,firm.FirmProper1=?,firm.FirmProper2=?,firm.FirmProper3=?,firm.FirmProper4=? where firm.FirmID=?";  
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        
        query.setString(0, firmEntity.getFirmID());  
        query.setString(1, firmEntity.getFirmName()); 
        query.setString(2, firmEntity.getFrimAddress());
        query.setDouble(3, firmEntity.getFirmProper1());  
        query.setDouble(4, firmEntity.getFirmProper2()); 
        query.setDouble(5, firmEntity.getFirmProper3());  
        query.setDouble(6, firmEntity.getFirmProper4()); 
        
        return (query.executeUpdate() > 0);  
	}
	public FirmEntity getFirm(String FirmID) {
//		����hql���
		String hql="from FirmEntity firm where firm.FirmID=?";
//		�����ѯ����󣬲�ִ��
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, FirmID);
		return (FirmEntity)query.uniqueResult();
	}
}
