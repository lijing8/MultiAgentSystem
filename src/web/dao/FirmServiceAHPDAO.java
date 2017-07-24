package web.dao;

import jade.util.leap.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.regexp.internal.recompile;

import web.entity.FirmServiceAHPEntity;


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
public class FirmServiceAHPDAO {
//	��@Autowiredע�⽫�Ի�ʵ�������룬
	@Autowired
	private SessionFactory sessionFactory;
	//��ȡ���з����б�
	public List<FirmServiceAHPEntity> getAllService() {
//		����hql���
		String hql = "from FirmServiceEntity";
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		���ط����б�
		return query.list();
	} 
	
	
	//���
	
//	��ȡ����ʵ�壬��ID����
	public FirmServiceAHPEntity getonefirmService(String firmserviceID) {
		String hql="from FirmServiceAHPEntity service where service.ID=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, firmserviceID);
		return (FirmServiceAHPEntity)query.uniqueResult();
	}
	
	//ɾ��
	public boolean delService(String serviceID){
//		����hql���
		String hql = "delete FirmServiceAHPEntity service where service.ServiceID=?"; //youxiewenti 
//		�����ѯ�����ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//		ִ�в�ѯ���� 
		query.setString(0, serviceID);  
//		���ز�ѯ�ǹ��ɹ�
		return (query.executeUpdate() > 0);  
	}

	public List<FirmServiceAHPEntity> getAllFirmService() {
		// TODO Auto-generated method stub
//		����hql���
		String hql = "from FirmServiceAHPEntity";
//		�����ѯ����󣬲�ִ��
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		���ط����б�
		return query.list();
	}


	public List<FirmServiceAHPEntity> getResultBydemandID() {
//		����hql���
		//String HQL="FROM ResultEntity  WHERE SimID like ?";
		System.out.print("��ѯ2");
		String HQL="from FirmServiceAHPEntity b";
//		�����ѯ����󣬲�ִ��
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
//		ִ��ģ����ѯ
	//	q.setString(0, "%"+SimID+"%");
//		���ز�ѯ�б�
		return q.list();
	}


	public Boolean addService(FirmServiceAHPEntity firmServiceAHPEntity) {
	 Boolean addBoolean=(sessionFactory.getCurrentSession().save(firmServiceAHPEntity)==firmServiceAHPEntity.getServiceID());
		
		return addBoolean;// TODO Auto-generated method stub
		
	}

//	��ȡ����ʵ�壬��ID����
	public FirmServiceAHPEntity validService(String serviceType) {
		String hql="from FirmServiceAHPEntity service where service.ServiceType=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, serviceType);
		return (FirmServiceAHPEntity)query.uniqueResult();
	}


	public boolean searchfirmService(String serviceType,String serviceName,String firmID ) throws SQLException {

		boolean i=false;
		Connection conn = null;
		String sql;
		 ResultSet rs ;
		String url="jdbc:mysql://127.0.0.1:3306/cloud?"
		+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		try{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn=DriverManager.getConnection(url);
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //�������
		sql="select * from t_firmserviceahp a where a.`��Ʒ����`='"+serviceName+"' and a.`��Ʒ���`='"+serviceType+"' and a.`��ҵID`='"+firmID+"'";
		
		 System.out.print(sql);
		// stmt.executeUpdate(sql);
		rs= stmt.executeQuery(sql);
		if(rs.next()){
			i=true;
		}else{
			i=false;
		}
		}
		catch(SQLException e){
			System.out.println("Mysql��������");
			e.printStackTrace();
		} 
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}


	public boolean deletesearch(String serviceName,String serviceID,String firmID) {
		 
		boolean i=false;
		int j=0;
		Connection conn = null;
		String sql;
		 ResultSet rs ;
		String url="jdbc:mysql://127.0.0.1:3306/cloud?"
		+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		try{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn=DriverManager.getConnection(url);
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //�������
		sql="delete from t_firmserviceahp   where  `��Ʒ����`='"+serviceName+"' and  `��Ʒ���`='"+serviceID+"' and  `��ҵID`='"+firmID+"'";
		
		 System.out.print(sql);
		 j=stmt.executeUpdate(sql);
		
		if(j>0){
			i=true;
		}else{
			i=false;
		}
		}
		catch(SQLException e){
			System.out.println("Mysql��������");
			e.printStackTrace();
		} 
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.print("ɾ��"+i);
		return i;
	}


	public double getyunfuwu() {
		String hql="select count(*)  from FirmServiceAHPEntity as service ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 Number num = (Number) query.list().get(0);  
		return num.doubleValue();
		
	}


	public double getyunfuwuneed(String firmID) {
		String hql="select count(*)  from FirmServiceAHPEntity as service where service.FirmID='"+firmID+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 Number num = (Number) query.list().get(0);  
		 return num.doubleValue();
			
	}


	public double getshuliangneed(String serviceName) {
		
		 Connection conn = null;
			String sql;
			 ResultSet rs ;
			 int num=0;
			String url="jdbc:mysql://127.0.0.1:3306/cloud?"
			+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
			try{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=DriverManager.getConnection(url);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        //�������
			sql="select sum(cast(a.`����` as SIGNED INTEGER))  num from t_firmserviceahp a where a.`��Ʒ����`='"+serviceName+"'";
			System.out.println(sql);
			rs= stmt.executeQuery(sql);
			if (rs.next()) {
				num=rs.getInt("num");
			}else{
				
			}
			}
			catch(SQLException e){
				System.out.println("Mysql��������");
				e.printStackTrace();
			} 
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return num;
	}


	public double getallneed(String serviceName) {
		Connection conn = null;
		String sql;
		 ResultSet rs ;
		 int num=0;
		String url="jdbc:mysql://127.0.0.1:3306/cloud?"
		+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		try{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn=DriverManager.getConnection(url);
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //�������
		sql="select sum(cast(a.`����` as SIGNED INTEGER))  num from t_firmserviceahp a where a.`��Ʒ����`='"+serviceName+"'";
		System.out.println(sql);
		rs= stmt.executeQuery(sql);
		if (rs.next()) {
			num=rs.getInt("num");
			
			
		}else{
			
		}
		}
		catch(SQLException e){
			System.out.println("Mysql��������");
			e.printStackTrace();
		} 
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	
	
}
