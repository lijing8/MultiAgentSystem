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
 * 用户DAO类
 * DAO层使用Hibernate技术，它交由Spring进行管理，
 * 需要在配置文件里进行配置。在Dao层中的类头使用@Autowired注解将对话实体类引入，
 * 利用Hibernate的HQL语句来实现对对象实体类的增、删、改、查的操作，进而实现了数据的持久化,
 * 用注解@Repository进行标识，@Transactional(rollbackOn = Exception.class)来设置异常回滚
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class FirmServiceAHPDAO {
//	用@Autowired注解将对话实体类引入，
	@Autowired
	private SessionFactory sessionFactory;
	//获取所有服务列表
	public List<FirmServiceAHPEntity> getAllService() {
//		定义hql语句
		String hql = "from FirmServiceEntity";
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		返回服务列表
		return query.list();
	} 
	
	
	//添加
	
//	获取服务实体，按ID查找
	public FirmServiceAHPEntity getonefirmService(String firmserviceID) {
		String hql="from FirmServiceAHPEntity service where service.ID=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, firmserviceID);
		return (FirmServiceAHPEntity)query.uniqueResult();
	}
	
	//删除
	public boolean delService(String serviceID){
//		定义hql语句
		String hql = "delete FirmServiceAHPEntity service where service.ServiceID=?"; //youxiewenti 
//		定义查询类对象，执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//		执行查询操作 
		query.setString(0, serviceID);  
//		返回查询是够成功
		return (query.executeUpdate() > 0);  
	}

	public List<FirmServiceAHPEntity> getAllFirmService() {
		// TODO Auto-generated method stub
//		定义hql语句
		String hql = "from FirmServiceAHPEntity";
//		定义查询类对象，并执行
		Query query = sessionFactory.getCurrentSession().createQuery(hql);	
//		返回服务列表
		return query.list();
	}


	public List<FirmServiceAHPEntity> getResultBydemandID() {
//		定义hql语句
		//String HQL="FROM ResultEntity  WHERE SimID like ?";
		System.out.print("查询2");
		String HQL="from FirmServiceAHPEntity b";
//		定义查询类对象，并执行
		Query q=sessionFactory.getCurrentSession().createQuery(HQL);
//		执行模糊查询
	//	q.setString(0, "%"+SimID+"%");
//		返回查询列表
		return q.list();
	}


	public Boolean addService(FirmServiceAHPEntity firmServiceAHPEntity) {
	 Boolean addBoolean=(sessionFactory.getCurrentSession().save(firmServiceAHPEntity)==firmServiceAHPEntity.getServiceID());
		
		return addBoolean;// TODO Auto-generated method stub
		
	}

//	获取服务实体，按ID查找
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
        //插入语句
		sql="select * from t_firmserviceahp a where a.`产品名称`='"+serviceName+"' and a.`产品编号`='"+serviceType+"' and a.`企业ID`='"+firmID+"'";
		
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
			System.out.println("Mysql操作错误");
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
        //插入语句
		sql="delete from t_firmserviceahp   where  `产品名称`='"+serviceName+"' and  `产品编号`='"+serviceID+"' and  `企业ID`='"+firmID+"'";
		
		 System.out.print(sql);
		 j=stmt.executeUpdate(sql);
		
		if(j>0){
			i=true;
		}else{
			i=false;
		}
		}
		catch(SQLException e){
			System.out.println("Mysql操作错误");
			e.printStackTrace();
		} 
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.print("删除"+i);
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
	        //插入语句
			sql="select sum(cast(a.`数量` as SIGNED INTEGER))  num from t_firmserviceahp a where a.`产品名称`='"+serviceName+"'";
			System.out.println(sql);
			rs= stmt.executeQuery(sql);
			if (rs.next()) {
				num=rs.getInt("num");
			}else{
				
			}
			}
			catch(SQLException e){
				System.out.println("Mysql操作错误");
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
        //插入语句
		sql="select sum(cast(a.`数量` as SIGNED INTEGER))  num from t_firmserviceahp a where a.`产品名称`='"+serviceName+"'";
		System.out.println(sql);
		rs= stmt.executeQuery(sql);
		if (rs.next()) {
			num=rs.getInt("num");
			
			
		}else{
			
		}
		}
		catch(SQLException e){
			System.out.println("Mysql操作错误");
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
