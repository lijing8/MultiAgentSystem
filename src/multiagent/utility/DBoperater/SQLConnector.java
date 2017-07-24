package multiagent.utility.DBoperater;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;

import multiagent.utility.others.MyList;
import web.entity.AgentCommEntity;
import web.entity.AgentEntity;
import web.entity.FirmEntity;
import web.entity.FirmServiceEntity;
import web.entity.ResultEntity;
import web.entity.ServiceEntity;

import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.regexp.internal.recompile;
/**
 * 此类用于Agent对数据库进行增删改查等操作
 * @author hanyuping
 */
public class SQLConnector {
	/**
	 * 此方法用于创建数据库链接
	 * @return
	 * @throws Exception
	 */
	public  String sqlconn() throws Exception{
		//声明数据库访问链接，用户名为root，密码为root，访问IP是本地分布式的时候将地址改为192.168.1.156，需要关闭防火墙
		String urlString="jdbc:mysql://127.0.0.1:3306/cloud?"
				+"user=root&password=root&userUnicode=true&characterEncoding=gbk";
		try{  
			//			查找数据库驱动类
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){   
			System.out.println("找不到驱动程序类 ，加载驱动失败！");   
			e.printStackTrace() ;   
		}   
		return urlString;

	}

	/**
	 * 此成员方法用于查询数据库中的企业实体列表
	 * @param str 查询的SQL语句
	 * @return  返回查询的企业列表
	 * @throws Exception
	 */
	public List<FirmEntity> query( String str)throws Exception{
		//实例化连接器
		SQLConnector mysqlConnector = new SQLConnector(); 	
		//建立连接
		Connection conn=null;
		//		建立数据库链接
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
		//		获取SQL语句
		String sql=str;
		//		准备数据库操作的条件，如果异常回滚操作
		java.sql.PreparedStatement statement=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		//		定义结果集对象，执行SQL语句获取执行结果
		ResultSet rs=statement.executeQuery(sql);
		//		定义FirmEntity类列表对象用于获取结果街
		List<FirmEntity> firmList=new ArrayList<FirmEntity>();
		//		向firmlist追加对象
		while (rs.next()) {
			//			定义FirmEntity对象
			FirmEntity firm=new FirmEntity();
			//			设计firm的成员参数值按照结果集的列进行赋值，结果集的列直接与数据库表的列相对应
			firm.setFirmID(rs.getString(1));
			firm.setFirmName(rs.getString(2));
			firm.setFrimAddress(rs.getString(3));	
			firm.setFirmProper1(rs.getDouble(4));
			firm.setFirmProper2(rs.getDouble(5));
			firm.setFirmProper3(rs.getDouble(6));
			firm.setFirmProper4(rs.getDouble(7));
			//			向企业列表追加企业对象
			firmList.add(firm);

		}
		//		操作结束，关闭数据库链接
		conn.close();
		//		 返回企业列表
		return firmList;

	}
	/**
	 * 
	 * @param str 数据库查询操作SQL语句
	 * @return 返回企业服务实体列表
	 * @throws Exception
	 */
	public MyList<ServiceEntity> queryServiceEntities( String str)throws Exception{
		//实例化连接器
		SQLConnector mysqlConnector = new SQLConnector(); 	
		//建立连接
		Connection conn=null;
		//		建立数据库链接
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
		//		获取SQL语句
		String sql=str;
		//		准备数据库操作的条件，如果异常回滚操作
		java.sql.PreparedStatement statement=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		//		定义结果集对象，执行SQL语句获取执行结果
		ResultSet rs=statement.executeQuery(sql);
		//		定义ServiceEntity类列表对象用于获取结果街
		MyList<ServiceEntity> serviceList=new MyList<ServiceEntity>();
		//		向serviceList追加对象
		while (rs.next()) {
			//			定义ServiceEntity对象
			ServiceEntity serviceEntity=new ServiceEntity();
			//			设计serviceEntity的成员参数值按照结果集的列进行赋值，
			//			结果集的列直接与数据库表的列相对应，按照表列名进行赋值
			serviceEntity.setServiceID(rs.getString("产品ID"));
			serviceEntity.setServiceName(rs.getString("产品名称"));
			serviceEntity.setServiceNum(rs.getString("数量"));
			serviceEntity.setDelitime(rs.getString("交货期"));
			serviceEntity.setServiceType(rs.getString("产品型号"));			
			serviceEntity.setPassrate(rs.getString("产品合格率"));
			serviceEntity.setLPrice(rs.getString("价格左"));
			serviceEntity.setHPrice(rs.getString("价格右"));
			serviceEntity.setConfde(rs.getString("可靠程度"));
			serviceEntity.setCredit(rs.getString("信誉度"));
			serviceEntity.setRetime(rs.getString("响应时间"));
			serviceEntity.setFlexi(rs.getString("生产灵活性"));
			serviceEntity.setSamSpeed(rs.getString("送样速度"));
			serviceEntity.setReturnSer(rs.getString("退货服务"));
			serviceEntity.setCarriage(rs.getString("运费是否承担"));
			serviceEntity.setFirmID(rs.getString("企业ID"));
			//			向企业服务列表追加企业服务对象		
			serviceList.add(serviceEntity);

		}
		//		操作结束，关闭数据库链接
		conn.close();
		//		返回企业服务列表
		return serviceList;

	}
	/**
	 * 
	 * @param str 数据库查询操作SQL语句
	 * @return 返回云服务列表
	 * @throws Exception
	 */
	public MyList<FirmServiceEntity> queryFSEntities( String str)throws Exception{
		//实例化连接器
		SQLConnector mysqlConnector = new SQLConnector(); 	
		//建立连接
		Connection conn=null;
		//		建立数据库链接
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
		//		获取SQL语句
		String sql=str;
		//		准备数据库操作的条件，如果异常回滚操作
		java.sql.PreparedStatement statement=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		//		定义结果集对象，执行SQL语句获取执行结果
		ResultSet rs=statement.executeQuery(sql);
		//		定义FirmServiceEntity类列表对象用于获取结果街
		MyList<FirmServiceEntity> fsList=new MyList<FirmServiceEntity>();
		//		向fslist追加对象
		while (rs.next()) {
			//			定义FirmServiceEntity对象
			FirmServiceEntity fs=new FirmServiceEntity();
			//			设计fs的成员参数值按照结果集的列进行赋值，
			//			结果集的列直接与数据库表的列相对应，按照表列名进行赋值
			fs.setFirmID(rs.getString("企业ID"));
			fs.setServiceID(rs.getString("产品编号"));
			fs.setServiceName(rs.getString("产品名称"));
			fs.setServiceType(rs.getString("产品型号"));
			fs.setServiceNum(rs.getString("数量"));
			fs.setDelitime(rs.getString("交货期"));
			fs.setPassrate(rs.getString("产品合格率"));
			fs.setLPrice(rs.getString("价格左"));
			fs.setHPrice(rs.getString("价格右"));
			fs.setConfde(rs.getString("可靠程度"));
			fs.setCredit(rs.getString("信誉度"));
			fs.setRetime(rs.getString("响应时间"));
			fs.setFlexi(rs.getString("生产灵活性"));
			fs.setSamSpeed(rs.getString("送样速度"));
			fs.setReturnSer(rs.getString("退货服务"));
			fs.setCarriage(rs.getString("运费是否承担"));
			//			向fs追加对象
			fsList.add(fs);

		}
		//		操作结束，关闭数据库链接
		conn.close();
		//		返回云服务列表
		return fsList;

	}
	//TODO　写数组查询数据库
	/**
	 * 
	 * @param qosrs 云服务ID数组
	 * @return 返回云服务列表
	 * @throws Exception
	 */
	public MyList<FirmServiceEntity> queryFSEntities(int qosrs[] )throws Exception{
		//实例化连接器
		SQLConnector mysqlConnector = new SQLConnector(); 	
		//建立连接
		Connection conn=null;
		//		建立数据库链接
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
		//		定义FirmServiceEntity类列表对象用于获取结果街
		MyList<FirmServiceEntity> fsList=new MyList<FirmServiceEntity>();
		//		按照云服务ID查询
		for (int j = 0; j < qosrs.length; j++) {		

			//		定义查询SQL语句
			String sql="select * from cloud.t_firmservice where  资源编号="+qosrs[j];
			//		定义查询前准备，准备数据库操作的条件，如果异常回滚操作
			java.sql.PreparedStatement statement=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//			定义结果集对象，执行SQL语句获取执行结果
			ResultSet rs=statement.executeQuery(sql);
			//			向fslist追加对象
			while (rs.next()) {	
				//			定义FirmServiceEntity对象
				FirmServiceEntity fs=new FirmServiceEntity();
				//			设计fs的成员参数值按照结果集的列进行赋值，
				//			结果集的列直接与数据库表的列相对应，按照表列名进行赋值
				//fs.setID(rs.getString(1));
				fs.setFirmID(rs.getString("企业ID"));
				fs.setServiceID(rs.getString("产品编号"));
				fs.setServiceName(rs.getString("产品名称"));
				fs.setServiceType(rs.getString("产品型号"));
				fs.setServiceNum(rs.getString("数量"));
				fs.setDelitime(rs.getString("交货期"));
				fs.setPassrate(rs.getString("产品合格率"));
				fs.setLPrice(rs.getString("价格左"));
				fs.setHPrice(rs.getString("价格右"));
				fs.setConfde(rs.getString("可靠程度"));
				fs.setCredit(rs.getString("信誉度"));
				fs.setRetime(rs.getString("响应时间"));
				fs.setFlexi(rs.getString("生产灵活性"));
				fs.setSamSpeed(rs.getString("送样速度"));
				fs.setReturnSer(rs.getString("退货服务"));
				fs.setCarriage(rs.getString("运费是否承担"));
				//			向fsList追加对象
				fsList.add(fs);

			}

		}
		//		操作结束，关闭数据库链接
		conn.close();
		//		返回云服务列表
		return fsList;

	}

	//添加通信信息
	/**
	 * 向云注册Agent自身信息
	 * @param agentEntities AgentEntity 实体列表
	 * @return 返回添加数目
	 * @throws Exception
	 */
	public int addAgent(List<AgentEntity> agentEntities)throws Exception{

		int i = 0;
		//实例化连接器
		SQLConnector mysqlConnector = new SQLConnector(); 				
		//建立连接
		Connection conn=null;
		//				建立数据库链接
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
		//	            创建Statement 对象
		Statement statement=conn.createStatement();
//		逐条执行添加操作
		for (int j = 0; j < agentEntities.size(); j++) {
//			定义数据库添加操作的SQL语句
			String sql0="insert into t_agent (AgentID,AgentName,AgentRole,AgentAddress)";
			String sql1="values ('";
			String sql2=agentEntities.get(j).getAgentID()+"','"+agentEntities.get(j).getAgentName()+"','"+agentEntities.get(j).getAgentRole()+"','"+agentEntities.get(j).getAgentAddress()+"')";	
			String sql=sql0+sql1 +sql2;
//			执行操作
			i=i+statement.executeUpdate(sql);	
		}
//		操作结束，关闭数据库链接
		conn.close();
//		返回添加数目
		return i;  

	}



	//添加服务
	/**
	 * 向云注册企业服务
	 * @param serviceEntities 企业服务列表
	 * @param str1 企业ID
	 * @return 返回添加行数
	 * @throws Exception
	 */
	public int registeservice(List<ServiceEntity> serviceEntities,String str1) throws Exception {
		int i = 0;
		//实例化连接器
		SQLConnector mysqlConnector = new SQLConnector(); 				
		//建立连接
		Connection conn=null;
//		建立数据库链接
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());	            
//		创建Statement 对象
		Statement statement=conn.createStatement();
//		逐条执行添加操作
		for (int j = 0; j < serviceEntities.size(); j++) {
//			定义数据库添加操作的SQL语句
			String sql0="insert into t_firmservice (企业ID,产品编号,产品名称,产品型号,数量,交货期,产品合格率,价格左,价格右,可靠程度,信誉度,响应时间,生产灵活性,送样速度,退货服务,运费是否承担)";
			String sql1="values ('";
			String sql2=str1+"','"+serviceEntities.get(j).getServiceID()+"','"+serviceEntities.get(j).getServiceName()+"','"
					+serviceEntities.get(j).getServiceType()+"','"+serviceEntities.get(j).getServiceNum()+"','"
					+serviceEntities.get(j).getDelitime()+"','"+serviceEntities.get(j).getPassrate()+"','"
					+serviceEntities.get(j).getLPrice()+"','"+serviceEntities.get(j).getHPrice()+"','"
					+serviceEntities.get(j).getConfde()+"','"+serviceEntities.get(j).getCredit()+"','"+serviceEntities.get(j).getRetime()+"','"
					+serviceEntities.get(j).getFlexi()+"','"+serviceEntities.get(j).getSamSpeed()+"','"+serviceEntities.get(j).getReturnSer()+"','"
					+serviceEntities.get(j).getCarriage()+"')";	
			String sql=sql0+sql1 +sql2;
//			执行操作
			i=i+statement.executeUpdate(sql);	

		}
//		操作结束，关闭数据库链接
		conn.close();
//		返回添加数目
		return i;  

	}
	
	/**
	 * //存储得到结果
	 * @param rsEntities 结果列表
	 * @return 返回执行结果数
	 * @throws Exception
	 */
	public int SaveResult(List<ResultEntity> rsEntities)throws Exception{

		int i = 0;
		//实例化连接器
		SQLConnector mysqlConnector = new SQLConnector(); 				
		//建立连接
		Connection conn=null;
//		建立数据库链接
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
//		 创建Statement 对象
		Statement statement=conn.createStatement();
//		逐条执行添加操作
		for (int j = 0; j < rsEntities.size(); j++) {
//			定义数据库添加操作的SQL语句
			String sql0="insert into t_result (SimID,FirmID,ServiceID,需求符合度,SimDate)";
			String sql1="values ('";
			String sql2=rsEntities.get(j).getID()+"','"+rsEntities.get(j).getFirmID()+"','"+rsEntities.get(j).getServiceID()+"','"
					+rsEntities.get(j).getDemandconf()+"','"+rsEntities.get(j).getDate()+"')";	
			String sql=sql0+sql1 +sql2;
//			执行操作
			i=i+statement.executeUpdate(sql);	
		}
//		操作结束，关闭数据库链接
		conn.close();
//		返回添加数目
		return i;  
	}
/**
 * 添加Agent交互信息
 * @param ac AgentCommEntity实体
 * @throws Exception
 */

	public void  addAgentComm(AgentCommEntity ac)throws Exception{

		int i = 0;
		//实例化连接器
		SQLConnector mysqlConnector = new SQLConnector(); 				
		//建立连接
		Connection conn=null;
//		建立数据库链接
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
//		  创建Statement 对象
		Statement statement=conn.createStatement();


//		定义数据库添加操作的SQL语句
		String sql0="insert into t_agentcommunication (CommunicationID,Sender,Receiver,CommunicationDate,CommunicationTheme,Communicationcontent)";
		String sql1="values ('";
		String sql2=ac.getACID()+"','"+ac.getACSender()+"','"+ac.getACReceiver()+"','"
				+ac.getACtime()+"','"+ac.getACTheme()+"','"+ac.getACcontent()+"')";	
		String sql=sql0+sql1 +sql2;
//		执行操作
		i=i+statement.executeUpdate(sql);	
//		操作结束，关闭数据库链接
		conn.close();

	}

}
