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
 * ��������Agent�����ݿ������ɾ�Ĳ�Ȳ���
 * @author hanyuping
 */
public class SQLConnector {
	/**
	 * �˷������ڴ������ݿ�����
	 * @return
	 * @throws Exception
	 */
	public  String sqlconn() throws Exception{
		//�������ݿ�������ӣ��û���Ϊroot������Ϊroot������IP�Ǳ��طֲ�ʽ��ʱ�򽫵�ַ��Ϊ192.168.1.156����Ҫ�رշ���ǽ
		String urlString="jdbc:mysql://127.0.0.1:3306/cloud?"
				+"user=root&password=root&userUnicode=true&characterEncoding=gbk";
		try{  
			//			�������ݿ�������
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){   
			System.out.println("�Ҳ������������� ����������ʧ�ܣ�");   
			e.printStackTrace() ;   
		}   
		return urlString;

	}

	/**
	 * �˳�Ա�������ڲ�ѯ���ݿ��е���ҵʵ���б�
	 * @param str ��ѯ��SQL���
	 * @return  ���ز�ѯ����ҵ�б�
	 * @throws Exception
	 */
	public List<FirmEntity> query( String str)throws Exception{
		//ʵ����������
		SQLConnector mysqlConnector = new SQLConnector(); 	
		//��������
		Connection conn=null;
		//		�������ݿ�����
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
		//		��ȡSQL���
		String sql=str;
		//		׼�����ݿ����������������쳣�ع�����
		java.sql.PreparedStatement statement=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		//		������������ִ��SQL����ȡִ�н��
		ResultSet rs=statement.executeQuery(sql);
		//		����FirmEntity���б�������ڻ�ȡ�����
		List<FirmEntity> firmList=new ArrayList<FirmEntity>();
		//		��firmlist׷�Ӷ���
		while (rs.next()) {
			//			����FirmEntity����
			FirmEntity firm=new FirmEntity();
			//			���firm�ĳ�Ա����ֵ���ս�������н��и�ֵ�����������ֱ�������ݿ��������Ӧ
			firm.setFirmID(rs.getString(1));
			firm.setFirmName(rs.getString(2));
			firm.setFrimAddress(rs.getString(3));	
			firm.setFirmProper1(rs.getDouble(4));
			firm.setFirmProper2(rs.getDouble(5));
			firm.setFirmProper3(rs.getDouble(6));
			firm.setFirmProper4(rs.getDouble(7));
			//			����ҵ�б�׷����ҵ����
			firmList.add(firm);

		}
		//		�����������ر����ݿ�����
		conn.close();
		//		 ������ҵ�б�
		return firmList;

	}
	/**
	 * 
	 * @param str ���ݿ��ѯ����SQL���
	 * @return ������ҵ����ʵ���б�
	 * @throws Exception
	 */
	public MyList<ServiceEntity> queryServiceEntities( String str)throws Exception{
		//ʵ����������
		SQLConnector mysqlConnector = new SQLConnector(); 	
		//��������
		Connection conn=null;
		//		�������ݿ�����
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
		//		��ȡSQL���
		String sql=str;
		//		׼�����ݿ����������������쳣�ع�����
		java.sql.PreparedStatement statement=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		//		������������ִ��SQL����ȡִ�н��
		ResultSet rs=statement.executeQuery(sql);
		//		����ServiceEntity���б�������ڻ�ȡ�����
		MyList<ServiceEntity> serviceList=new MyList<ServiceEntity>();
		//		��serviceList׷�Ӷ���
		while (rs.next()) {
			//			����ServiceEntity����
			ServiceEntity serviceEntity=new ServiceEntity();
			//			���serviceEntity�ĳ�Ա����ֵ���ս�������н��и�ֵ��
			//			���������ֱ�������ݿ��������Ӧ�����ձ��������и�ֵ
			serviceEntity.setServiceID(rs.getString("��ƷID"));
			serviceEntity.setServiceName(rs.getString("��Ʒ����"));
			serviceEntity.setServiceNum(rs.getString("����"));
			serviceEntity.setDelitime(rs.getString("������"));
			serviceEntity.setServiceType(rs.getString("��Ʒ�ͺ�"));			
			serviceEntity.setPassrate(rs.getString("��Ʒ�ϸ���"));
			serviceEntity.setLPrice(rs.getString("�۸���"));
			serviceEntity.setHPrice(rs.getString("�۸���"));
			serviceEntity.setConfde(rs.getString("�ɿ��̶�"));
			serviceEntity.setCredit(rs.getString("������"));
			serviceEntity.setRetime(rs.getString("��Ӧʱ��"));
			serviceEntity.setFlexi(rs.getString("���������"));
			serviceEntity.setSamSpeed(rs.getString("�����ٶ�"));
			serviceEntity.setReturnSer(rs.getString("�˻�����"));
			serviceEntity.setCarriage(rs.getString("�˷��Ƿ�е�"));
			serviceEntity.setFirmID(rs.getString("��ҵID"));
			//			����ҵ�����б�׷����ҵ�������		
			serviceList.add(serviceEntity);

		}
		//		�����������ر����ݿ�����
		conn.close();
		//		������ҵ�����б�
		return serviceList;

	}
	/**
	 * 
	 * @param str ���ݿ��ѯ����SQL���
	 * @return �����Ʒ����б�
	 * @throws Exception
	 */
	public MyList<FirmServiceEntity> queryFSEntities( String str)throws Exception{
		//ʵ����������
		SQLConnector mysqlConnector = new SQLConnector(); 	
		//��������
		Connection conn=null;
		//		�������ݿ�����
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
		//		��ȡSQL���
		String sql=str;
		//		׼�����ݿ����������������쳣�ع�����
		java.sql.PreparedStatement statement=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		//		������������ִ��SQL����ȡִ�н��
		ResultSet rs=statement.executeQuery(sql);
		//		����FirmServiceEntity���б�������ڻ�ȡ�����
		MyList<FirmServiceEntity> fsList=new MyList<FirmServiceEntity>();
		//		��fslist׷�Ӷ���
		while (rs.next()) {
			//			����FirmServiceEntity����
			FirmServiceEntity fs=new FirmServiceEntity();
			//			���fs�ĳ�Ա����ֵ���ս�������н��и�ֵ��
			//			���������ֱ�������ݿ��������Ӧ�����ձ��������и�ֵ
			fs.setFirmID(rs.getString("��ҵID"));
			fs.setServiceID(rs.getString("��Ʒ���"));
			fs.setServiceName(rs.getString("��Ʒ����"));
			fs.setServiceType(rs.getString("��Ʒ�ͺ�"));
			fs.setServiceNum(rs.getString("����"));
			fs.setDelitime(rs.getString("������"));
			fs.setPassrate(rs.getString("��Ʒ�ϸ���"));
			fs.setLPrice(rs.getString("�۸���"));
			fs.setHPrice(rs.getString("�۸���"));
			fs.setConfde(rs.getString("�ɿ��̶�"));
			fs.setCredit(rs.getString("������"));
			fs.setRetime(rs.getString("��Ӧʱ��"));
			fs.setFlexi(rs.getString("���������"));
			fs.setSamSpeed(rs.getString("�����ٶ�"));
			fs.setReturnSer(rs.getString("�˻�����"));
			fs.setCarriage(rs.getString("�˷��Ƿ�е�"));
			//			��fs׷�Ӷ���
			fsList.add(fs);

		}
		//		�����������ر����ݿ�����
		conn.close();
		//		�����Ʒ����б�
		return fsList;

	}
	//TODO��д�����ѯ���ݿ�
	/**
	 * 
	 * @param qosrs �Ʒ���ID����
	 * @return �����Ʒ����б�
	 * @throws Exception
	 */
	public MyList<FirmServiceEntity> queryFSEntities(int qosrs[] )throws Exception{
		//ʵ����������
		SQLConnector mysqlConnector = new SQLConnector(); 	
		//��������
		Connection conn=null;
		//		�������ݿ�����
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
		//		����FirmServiceEntity���б�������ڻ�ȡ�����
		MyList<FirmServiceEntity> fsList=new MyList<FirmServiceEntity>();
		//		�����Ʒ���ID��ѯ
		for (int j = 0; j < qosrs.length; j++) {		

			//		�����ѯSQL���
			String sql="select * from cloud.t_firmservice where  ��Դ���="+qosrs[j];
			//		�����ѯǰ׼����׼�����ݿ����������������쳣�ع�����
			java.sql.PreparedStatement statement=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//			������������ִ��SQL����ȡִ�н��
			ResultSet rs=statement.executeQuery(sql);
			//			��fslist׷�Ӷ���
			while (rs.next()) {	
				//			����FirmServiceEntity����
				FirmServiceEntity fs=new FirmServiceEntity();
				//			���fs�ĳ�Ա����ֵ���ս�������н��и�ֵ��
				//			���������ֱ�������ݿ��������Ӧ�����ձ��������и�ֵ
				//fs.setID(rs.getString(1));
				fs.setFirmID(rs.getString("��ҵID"));
				fs.setServiceID(rs.getString("��Ʒ���"));
				fs.setServiceName(rs.getString("��Ʒ����"));
				fs.setServiceType(rs.getString("��Ʒ�ͺ�"));
				fs.setServiceNum(rs.getString("����"));
				fs.setDelitime(rs.getString("������"));
				fs.setPassrate(rs.getString("��Ʒ�ϸ���"));
				fs.setLPrice(rs.getString("�۸���"));
				fs.setHPrice(rs.getString("�۸���"));
				fs.setConfde(rs.getString("�ɿ��̶�"));
				fs.setCredit(rs.getString("������"));
				fs.setRetime(rs.getString("��Ӧʱ��"));
				fs.setFlexi(rs.getString("���������"));
				fs.setSamSpeed(rs.getString("�����ٶ�"));
				fs.setReturnSer(rs.getString("�˻�����"));
				fs.setCarriage(rs.getString("�˷��Ƿ�е�"));
				//			��fsList׷�Ӷ���
				fsList.add(fs);

			}

		}
		//		�����������ر����ݿ�����
		conn.close();
		//		�����Ʒ����б�
		return fsList;

	}

	//���ͨ����Ϣ
	/**
	 * ����ע��Agent������Ϣ
	 * @param agentEntities AgentEntity ʵ���б�
	 * @return ���������Ŀ
	 * @throws Exception
	 */
	public int addAgent(List<AgentEntity> agentEntities)throws Exception{

		int i = 0;
		//ʵ����������
		SQLConnector mysqlConnector = new SQLConnector(); 				
		//��������
		Connection conn=null;
		//				�������ݿ�����
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
		//	            ����Statement ����
		Statement statement=conn.createStatement();
//		����ִ����Ӳ���
		for (int j = 0; j < agentEntities.size(); j++) {
//			�������ݿ���Ӳ�����SQL���
			String sql0="insert into t_agent (AgentID,AgentName,AgentRole,AgentAddress)";
			String sql1="values ('";
			String sql2=agentEntities.get(j).getAgentID()+"','"+agentEntities.get(j).getAgentName()+"','"+agentEntities.get(j).getAgentRole()+"','"+agentEntities.get(j).getAgentAddress()+"')";	
			String sql=sql0+sql1 +sql2;
//			ִ�в���
			i=i+statement.executeUpdate(sql);	
		}
//		�����������ر����ݿ�����
		conn.close();
//		���������Ŀ
		return i;  

	}



	//��ӷ���
	/**
	 * ����ע����ҵ����
	 * @param serviceEntities ��ҵ�����б�
	 * @param str1 ��ҵID
	 * @return �����������
	 * @throws Exception
	 */
	public int registeservice(List<ServiceEntity> serviceEntities,String str1) throws Exception {
		int i = 0;
		//ʵ����������
		SQLConnector mysqlConnector = new SQLConnector(); 				
		//��������
		Connection conn=null;
//		�������ݿ�����
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());	            
//		����Statement ����
		Statement statement=conn.createStatement();
//		����ִ����Ӳ���
		for (int j = 0; j < serviceEntities.size(); j++) {
//			�������ݿ���Ӳ�����SQL���
			String sql0="insert into t_firmservice (��ҵID,��Ʒ���,��Ʒ����,��Ʒ�ͺ�,����,������,��Ʒ�ϸ���,�۸���,�۸���,�ɿ��̶�,������,��Ӧʱ��,���������,�����ٶ�,�˻�����,�˷��Ƿ�е�)";
			String sql1="values ('";
			String sql2=str1+"','"+serviceEntities.get(j).getServiceID()+"','"+serviceEntities.get(j).getServiceName()+"','"
					+serviceEntities.get(j).getServiceType()+"','"+serviceEntities.get(j).getServiceNum()+"','"
					+serviceEntities.get(j).getDelitime()+"','"+serviceEntities.get(j).getPassrate()+"','"
					+serviceEntities.get(j).getLPrice()+"','"+serviceEntities.get(j).getHPrice()+"','"
					+serviceEntities.get(j).getConfde()+"','"+serviceEntities.get(j).getCredit()+"','"+serviceEntities.get(j).getRetime()+"','"
					+serviceEntities.get(j).getFlexi()+"','"+serviceEntities.get(j).getSamSpeed()+"','"+serviceEntities.get(j).getReturnSer()+"','"
					+serviceEntities.get(j).getCarriage()+"')";	
			String sql=sql0+sql1 +sql2;
//			ִ�в���
			i=i+statement.executeUpdate(sql);	

		}
//		�����������ر����ݿ�����
		conn.close();
//		���������Ŀ
		return i;  

	}
	
	/**
	 * //�洢�õ����
	 * @param rsEntities ����б�
	 * @return ����ִ�н����
	 * @throws Exception
	 */
	public int SaveResult(List<ResultEntity> rsEntities)throws Exception{

		int i = 0;
		//ʵ����������
		SQLConnector mysqlConnector = new SQLConnector(); 				
		//��������
		Connection conn=null;
//		�������ݿ�����
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
//		 ����Statement ����
		Statement statement=conn.createStatement();
//		����ִ����Ӳ���
		for (int j = 0; j < rsEntities.size(); j++) {
//			�������ݿ���Ӳ�����SQL���
			String sql0="insert into t_result (SimID,FirmID,ServiceID,������϶�,SimDate)";
			String sql1="values ('";
			String sql2=rsEntities.get(j).getID()+"','"+rsEntities.get(j).getFirmID()+"','"+rsEntities.get(j).getServiceID()+"','"
					+rsEntities.get(j).getDemandconf()+"','"+rsEntities.get(j).getDate()+"')";	
			String sql=sql0+sql1 +sql2;
//			ִ�в���
			i=i+statement.executeUpdate(sql);	
		}
//		�����������ر����ݿ�����
		conn.close();
//		���������Ŀ
		return i;  
	}
/**
 * ���Agent������Ϣ
 * @param ac AgentCommEntityʵ��
 * @throws Exception
 */

	public void  addAgentComm(AgentCommEntity ac)throws Exception{

		int i = 0;
		//ʵ����������
		SQLConnector mysqlConnector = new SQLConnector(); 				
		//��������
		Connection conn=null;
//		�������ݿ�����
		conn=DriverManager.getConnection(mysqlConnector.sqlconn());
//		  ����Statement ����
		Statement statement=conn.createStatement();


//		�������ݿ���Ӳ�����SQL���
		String sql0="insert into t_agentcommunication (CommunicationID,Sender,Receiver,CommunicationDate,CommunicationTheme,Communicationcontent)";
		String sql1="values ('";
		String sql2=ac.getACID()+"','"+ac.getACSender()+"','"+ac.getACReceiver()+"','"
				+ac.getACtime()+"','"+ac.getACTheme()+"','"+ac.getACcontent()+"')";	
		String sql=sql0+sql1 +sql2;
//		ִ�в���
		i=i+statement.executeUpdate(sql);	
//		�����������ر����ݿ�����
		conn.close();

	}

}
