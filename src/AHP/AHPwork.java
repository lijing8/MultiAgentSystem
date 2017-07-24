package AHP;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AHPwork {

	   int colwidth;
	   int rowhigth;
	   double x1[]=new double[20];
	   double x2[]=new double[20];
	   double s1[]=new double[20];
	   double standval[][]=new double[20][20];
	   double input[][]=new double[20][20];
	   double rollput[][]=new double[20][20];
	   double[][] myrollput;
	   double[] verifyput=new double[20];
	   double RI[]={0,0,0.52,0.89,1.12,1.26,1.36,1.41,1.46,1.49,1.52,1.54,1.56,1.58,1.59};
	    //RI���ݲ�����������Ҫ20����
	  
	   public void setValue(int v1,double[][] v2){
    	colwidth=v1;            //������Ƿ���      
    	rowhigth=v1;
    	input=v2;                //����

    }
	   
	   public double getcolsum(int colid,double[] inputval)//�������и���ֵ֮�ͣ���������һ��һ�е����
	   {                                                  
		   double x;
	       int i;

	       for(i=0;i<colwidth;i++){

	  		x1[colid]=x1[colid]+inputval[i];
	  		
	  	}
	  		x=x1[colid];

	       return x;

	   }


	   public double[] standardvalue(double gene,double[] inputval)//��׼��
	   {  
	        int i;    
	        for(i=0;i<colwidth;i++){
	          s1[i]=inputval[i]/gene;
	          System.out.println(s1[i]+"&");
	        }
	        return s1;//�õ�һ������
	   }
	   
	   public double[][] rollput()//ת��
	   {

	          int i,j;
	          for(i=0;i<rowhigth;i++){
	            for(j=0;j<colwidth;j++){

	              rollput[j][i]=input[i][j];
	              System.out.println(rollput[j][i]+"&"+i+"&"+j);
	            }
	          }
	         return rollput; 
	   }
	   
	   public double eigenvector(int rowid,double[] inputval)//������������
	   {
	         double x;
	         int i;
	         for(i=0;i<colwidth;i++){
	    		System.out.println(rowid);
	    		x1[rowid]=x1[rowid]+inputval[i];
	    		
	    	}
	    		x=x1[rowid];
	    		System.out.println(x);

	         return x/colwidth; //���ƽ����
	    }
	   
	   
	   public double[] getValue(){
		  	int i,j,k;
		        myrollput=rollput();//����ת��    
		          
		        for(i=0;i<colwidth;i++){
		               x1[i]=getcolsum(i,myrollput[i]);
		               System.out.println(x1[i]);
		        }
		         
		        //���

		           for(i=0;i<colwidth;i++){
		               standval[i]=standardvalue(x1[i],myrollput[i]);
		              for(j=0;j<colwidth;j++){
		               
		                 System.out.println(standval[i][j]+"&"+i+"&"+j);
		                for(k=0;k<rowhigth;k++){
		                  if(k==j){
		                   x2[k]=x2[k]+standval[i][j];
		                   System.out.println(x2[k]+"&"+standval[i][j]+k);
		      
		                  }
		              } 
		           }
		        }
		        

		        //��׼��
		           for(i=0;i<colwidth;i++){
		               x2[i]=x2[i]/colwidth;
		           }
		        //������������
		           for(i=0;i<colwidth;i++){
		               System.out.println(x2[i]);
		          }
		        return x2;
		         
		   } 
	   
	   public boolean getVerify(){
		     int i,j;
		     double[] xver;
		     double CI,CR=0;
		     double MIN_VALUE=0.1;
		     double myverify=0;
		     xver=getValue();
		     for(i=0;i<colwidth;i++){
		     	
		        for(j=0;j<colwidth;j++){
			
		           verifyput[i]=verifyput[i]+input[i][j]*xver[j];
		        }
		     }
		     //���㸳Ȩ֮��
		     for(i=0;i<colwidth;i++){   
		        verifyput[i]=verifyput[i]/xver[i];
		     }
		     
		     for(i=0;i<colwidth;i++){   
		        myverify=myverify+verifyput[i];
		     }   
		     myverify=myverify/colwidth;  
		     //����ƽ��ֵ
		     CI=(myverify-colwidth)/(colwidth-1);
		     i=0;
		     for(i=0;i<colwidth;i++){
		       if(i+1==colwidth){
		           CR=CI/RI[i];
		       }
		     }
		    //����һ������ 
		     if(CR<MIN_VALUE)
		     {
		        return true;
		     }
		     else
		     {
		        return false;
		     }
		  }  
	   
	   //result����ʵ�֣�������Ĳ�ѯ������� �浽��һ���� t_firmserviceresult����
	   public void result(String demandID,String demandName,String demandType)  throws Exception{
			//�������ݿ��ȡ�����������Դ
			Connection conn = null;
			String sql;
			String url="jdbc:mysql://127.0.0.1:3306/cloud?"
			+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
			try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);			
			sql="insert into t_firmserviceresult (`����ID`,`�˷��Ƿ�е�`,`�ɿ��̶�`,`������`,`������`,`�������`,`��ҵID`,`���������`,"
					+ "  `���Է���`,`�۸���`,`�۸���`,`������`,`��Ʒ�ϸ���`,`�۸�����`,`��������`,`��Ӧʱ��`,`�˻�����`,`�����ٶ�`,`��Ʒ���`,`��Ʒ����`,`����`,`��Ʒ�ͺ�`,`�Ƽ�ˮƽ`,`�����ܷ�`)"
					+ " (select "+"'"+demandID+"'"+",a.`�˷��Ƿ�е�`,a.`�ɿ��̶�`,a.`������`,a.`������`,a.`�������`,a.`��ҵID`,a.`���������`,"
					+ "a.`���Է���`,a.`�۸���`,a.`�۸���`,a.`������`,a.`��Ʒ�ϸ���`,a.`�۸�����`,a.`��������`,a.`��Ӧʱ��`,a.`�˻�����`,"
					+ "a.`�����ٶ�`,a.`��Ʒ���`,a.`��Ʒ����`,a.`����`,a.`��Ʒ�ͺ�`,a.`�Ƽ�ˮƽ`,round((a.`��Ƴɱ�����`* b.`��Ƴɱ�����`+ a.`�ɹ��ɱ�����`* b.`�ɹ��ɱ�����`+ a.`����ɱ�����`* b.`����ɱ�����`+ a.`�ɱ������ʷ���`* b.`�ɱ������ʷ���`"
					+ "+ a.`�ϸ��ʷ���`* b.`�ϸ��ʷ���`+ a.`�����ʷ���`* b.`�����ʷ���`+ a.`������ϵ����`* b.`������ϵ����`+ a.`�Ʒ������`* b.`�Ʒ������`"
					+ "+ a.`Ʒ�����Է���`* b.`Ʒ�����Է���`+ a.`ʱ�����Է���`* b.`ʱ�����Է���`+ a.`�������Է���`* b.`�������Է���` "
					+ " + a.`��Ϣ��������`* b.`��Ϣ��������`+ a.`��ƽͶ�����`* b.`��ƽͶ�����`+ a.`��Ϣ���������`* b.`��Ϣ���������`"
					+ "+ a.`׼ʱ��������`* b.`׼ʱ��������`+ a.`�ͻ�����ȷ���`* b.`�ͻ�����ȷ���`+ a.`�г�ռ���ʷ���`* b.`�г�ռ���ʷ���` "
					+ "+ a.`�ʱ������ʷ���`* b.`�ʱ������ʷ���`+ a.`���ʲ������ʷ���`* b.`���ʲ������ʷ���`+ a.`���������ʷ���`* b.`���������ʷ���`+ a.`���������ʷ���`* b.`���������ʷ���`+ a.`Ͷ������ȷ���`* b.`Ͷ������ȷ���` "
					+ "+ a.`����Ͷ���ʷ���`* b.`����Ͷ���ʷ���`+ a.`�²�Ʒ������ʷ���`* b.`�²�Ʒ������ʷ���`+ a.`�Ƽ�������Ա���ʷ���`* b.`�Ƽ�������Ա���ʷ���` "
					+ "+ a.`��ѭ�������ʷ���`* b.`��ѭ�������ʷ���`+ a.`��Դ�����ʷ���`* b.`��Դ�����ʷ���`),4) score"
					+ " from t_firmserviceahp a,t_demand b "
					+ " where b.`����ID`="+"'"+demandID+"' and a.`��Ʒ����` like "+"'%"+demandName+ "%' and a.`��Ʒ���` like "+"'%"+demandType+"%' "
					+ " order by  (score) DESC LIMIT 200)";
			
			System.out.print(sql);
			stmt.executeUpdate(sql);
			}
			catch(SQLException e){
				System.out.println("Mysql��������");
				e.printStackTrace();
			} 
			conn.close();
			
		  
	   }
	   
	 //insertscoreʵ�ֽ�һ����Դ�����ֲ��뵽���ݿ���
	   public boolean insertscore(String serviceID,  double  qhege,  double qbaotui,  double qtixi,  double qyunfuwu,
			   double csheji ,double ccaigou ,double cyunshu ,double cliyong,
			   double fzhonglei ,double fshijian ,double fshuliang,
			   double itouru ,double iyun ,double ijibie,
			   double pjiaohuo,double  pmanyi ,double pzhanyou,
			   double fshouyi ,double fzichan ,double flirun ,double fxiaosou,double  fchanchu,
			   double tkaifa ,double tshouru ,double  trenyuan,
			   double exunhuan ,double enengyuan)  throws Exception{
			//�������ݿ��ȡ�����������Դ
		   int i=0;
			Connection conn = null;
			String sql;
			String url="jdbc:mysql://127.0.0.1:3306/cloud?"
			+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
			try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //�������
			sql="update t_firmserviceahp a set a.`�ϸ��ʷ���`="+qhege+",a.`�����ʷ���`="+qbaotui+",a.`������ϵ����`="+qtixi+",a.`�Ʒ������`="+qyunfuwu+","
					+ "a.`��Ƴɱ�����`="+csheji+",a.`�ɹ��ɱ�����`="+ccaigou+",a.`����ɱ�����`="+cyunshu+",a.`�ɱ������ʷ���`="+cliyong+","
					+ "a.`Ʒ�����Է���`="+ fzhonglei+",a.`ʱ�����Է���`="+fshijian+",`�������Է���`="+fshuliang+","
					+ "a.`��Ϣ��������`="+itouru+",a.`��ƽͶ�����`="+iyun+",a.`��Ϣ���������`="+ijibie+","
					+ "a.`׼ʱ��������`="+pjiaohuo+",a.`�ͻ�����ȷ���`="+pmanyi +",a.`�г�ռ���ʷ���`="+pzhanyou+","
					+ "a.`�ʱ������ʷ���`="+fshouyi+",a.`���ʲ������ʷ���`="+fzichan+",a.`���������ʷ���`="+flirun+",a.`���������ʷ���`="+fxiaosou+",a.`Ͷ������ȷ���`="+fchanchu+","
					+ "a.`����Ͷ���ʷ���`="+tkaifa+",a.`�²�Ʒ������ʷ���`="+tshouru+",a.`�Ƽ�������Ա���ʷ���`="+trenyuan+","
					+ "a.`��ѭ�������ʷ���`="+exunhuan+",a.`��Դ�����ʷ���`="+enengyuan+" where a.`��Ʒ�ͺ�`='"+serviceID+"'";
			
			System.out.print(sql);
			i=stmt.executeUpdate(sql);
			}
			catch(SQLException e){
				System.out.println("Mysql��������");
				e.printStackTrace();
			} 
			conn.close();
			if(i>0){
				return true;
			}else {
				return false;
			}
			
		  
	   }
	   
	 
	   public double[] strtodouble(String[][] A)//��׼��
	   {  
	        int m;
	        m=A[0].length;
	        
	        for (int i=0; i<m; i++) {
				for (int j=0;j< m; j++) {
					if (A[i][j].equals("ͬ����Ҫ")){
						A[i][j]="1";
					}
					else if (A[i][j].equals("����Ҫ")) {
						A[i][j]="3";
					}  
					else if (A[i][j].equals("��Ҫ")) {
						A[i][j]="5";
					} 
					else if (A[i][j].equals("����Ҫ")) {
						A[i][j]="7";
					} 
					else if (A[i][j].equals("����Ҫ")) {
						A[i][j]="9";				
					} 
					else if (A[i][j].equals("0")) {
						A[i][j]=null;
					} 
					
				}
				
			}
	       
       double[][] C1=new double[m][m];
			
			for(int i=0;i<m;i++){
				for(int j=0;j<m;j++){
					
					if(j>=i){
						C1[i][j]=Double.valueOf((A[i][j])).doubleValue();
					}
					else{
						C1[i][j]=1/C1[j][i];
					}
				}
				
			}
			
			AHPwork mb=new AHPwork();
			 mb.setValue(m,C1);
			 double[] weight=new double[m];
			 weight=mb.getValue();
			 for(int j=0;j<m;j++){
				 BigDecimal bg = new BigDecimal(weight[j]);
				 weight[j] = bg.setScale(4, BigDecimal.ROUND_DOWN).doubleValue();
				System.out.println("a"+weight[j]); 
			 }
	        return weight;//�õ�һ������
	   }

	public void updateahp(String demandID, String demandName,
			String demandType, String demandNum, String delitime,
			String passrate, String lprice, String hprice, String confde,
			String credit, String retime, String flexi, String samspeed,
			String returnser, String carriage) throws Exception{
		//�������ݿ��ȡ�����������Դ
		
		Connection conn = null;
		String sql;
		String url="jdbc:mysql://127.0.0.1:3306/cloud?"
		+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url);
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //�������
		sql="update t_demand a set a.`��Ʒ�ͺ�`='"+demandType+"',a.`��Ʒ����`='"+demandNum+"',a.`������`='"+delitime+"',"
				+ "a.`��Ʒ�ϸ���`='"+passrate+"',a.`�۸���`='"+lprice+"',a.`�۸���`='"+hprice+"',a.`�ɿ��̶�`='"+confde+"',"
				+ "a.`������`='"+ credit+"',a.`��Ӧʱ��`='"+retime+"',`���������`='"+flexi+"',"
				+ "a.`�����ٶ�`='"+samspeed+"',a.`�˻�����`='"+returnser+"',a.`�˷��Ƿ�е�`='"+carriage+ "' ,a.`��Ʒ����`='"+demandName+ "'where a.`����ID`='"+demandID+"'";
		
		System.out.print(sql);
		 stmt.executeUpdate(sql);
		}
		catch(SQLException e){
			System.out.println("Mysql��������");
			e.printStackTrace();
		} 
		conn.close();
		
		
	} 
	   
}
