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
	    //RI数据不够，至少需要20个数
	  
	   public void setValue(int v1,double[][] v2){
    	colwidth=v1;            //输入的是方阵      
    	rowhigth=v1;
    	input=v2;                //矩阵

    }
	   
	   public double getcolsum(int colid,double[] inputval)//求数组中各列值之和，，，，是一列一列的求的
	   {                                                  
		   double x;
	       int i;

	       for(i=0;i<colwidth;i++){

	  		x1[colid]=x1[colid]+inputval[i];
	  		
	  	}
	  		x=x1[colid];

	       return x;

	   }


	   public double[] standardvalue(double gene,double[] inputval)//标准化
	   {  
	        int i;    
	        for(i=0;i<colwidth;i++){
	          s1[i]=inputval[i]/gene;
	          System.out.println(s1[i]+"&");
	        }
	        return s1;//得到一个数组
	   }
	   
	   public double[][] rollput()//转置
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
	   
	   public double eigenvector(int rowid,double[] inputval)//计算特征向量
	   {
	         double x;
	         int i;
	         for(i=0;i<colwidth;i++){
	    		System.out.println(rowid);
	    		x1[rowid]=x1[rowid]+inputval[i];
	    		
	    	}
	    		x=x1[rowid];
	    		System.out.println(x);

	         return x/colwidth; //求个平均数
	    }
	   
	   
	   public double[] getValue(){
		  	int i,j,k;
		        myrollput=rollput();//数组转置    
		          
		        for(i=0;i<colwidth;i++){
		               x1[i]=getcolsum(i,myrollput[i]);
		               System.out.println(x1[i]);
		        }
		         
		        //求和

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
		        

		        //标准化
		           for(i=0;i<colwidth;i++){
		               x2[i]=x2[i]/colwidth;
		           }
		        //计算特征向量
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
		     //计算赋权之和
		     for(i=0;i<colwidth;i++){   
		        verifyput[i]=verifyput[i]/xver[i];
		     }
		     
		     for(i=0;i<colwidth;i++){   
		        myverify=myverify+verifyput[i];
		     }   
		     myverify=myverify/colwidth;  
		     //计算平均值
		     CI=(myverify-colwidth)/(colwidth-1);
		     i=0;
		     for(i=0;i<colwidth;i++){
		       if(i+1==colwidth){
		           CR=CI/RI[i];
		       }
		     }
		    //计算一致性率 
		     if(CR<MIN_VALUE)
		     {
		        return true;
		     }
		     else
		     {
		        return false;
		     }
		  }  
	   
	   //result函数实现，两个表的查询，将结果 存到另一个表（ t_firmserviceresult）中
	   public void result(String demandID,String demandName,String demandType)  throws Exception{
			//链接数据库读取满足需求的资源
			Connection conn = null;
			String sql;
			String url="jdbc:mysql://127.0.0.1:3306/cloud?"
			+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
			try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);			
			sql="insert into t_firmserviceresult (`需求ID`,`运费是否承担`,`可靠程度`,`信誉度`,`交货期`,`财务分数`,`企业ID`,`生产灵活性`,"
					+ "  `柔性分数`,`价格右`,`价格左`,`伙伴分数`,`产品合格率`,`价格优势`,`质量分数`,`响应时间`,`退货服务`,`送样速度`,`产品编号`,`产品名称`,`数量`,`产品型号`,`科技水平`,`评价总分`)"
					+ " (select "+"'"+demandID+"'"+",a.`运费是否承担`,a.`可靠程度`,a.`信誉度`,a.`交货期`,a.`财务分数`,a.`企业ID`,a.`生产灵活性`,"
					+ "a.`柔性分数`,a.`价格右`,a.`价格左`,a.`伙伴分数`,a.`产品合格率`,a.`价格优势`,a.`质量分数`,a.`响应时间`,a.`退货服务`,"
					+ "a.`送样速度`,a.`产品编号`,a.`产品名称`,a.`数量`,a.`产品型号`,a.`科技水平`,round((a.`设计成本分数`* b.`设计成本分数`+ a.`采购成本分数`* b.`采购成本分数`+ a.`运输成本分数`* b.`运输成本分数`+ a.`成本利用率分数`* b.`成本利用率分数`"
					+ "+ a.`合格率分数`* b.`合格率分数`+ a.`报修率分数`* b.`报修率分数`+ a.`质量体系分数`* b.`质量体系分数`+ a.`云服务分数`* b.`云服务分数`"
					+ "+ a.`品种柔性分数`* b.`品种柔性分数`+ a.`时间柔性分数`* b.`时间柔性分数`+ a.`数量柔性分数`* b.`数量柔性分数` "
					+ " + a.`信息技术分数`* b.`信息技术分数`+ a.`云平投入分数`* b.`云平投入分数`+ a.`信息化级别分数`* b.`信息化级别分数`"
					+ "+ a.`准时交货分数`* b.`准时交货分数`+ a.`客户满意度分数`* b.`客户满意度分数`+ a.`市场占有率分数`* b.`市场占有率分数` "
					+ "+ a.`资本收益率分数`* b.`资本收益率分数`+ a.`净资产利用率分数`* b.`净资产利用率分数`+ a.`利润增长率分数`* b.`利润增长率分数`+ a.`销售增长率分数`* b.`销售增长率分数`+ a.`投入产出比分数`* b.`投入产出比分数` "
					+ "+ a.`开发投资率分数`* b.`开发投资率分数`+ a.`新产品收入比率分数`* b.`新产品收入比率分数`+ a.`科技开发人员比率分数`* b.`科技开发人员比率分数` "
					+ "+ a.`再循环利用率分数`* b.`再循环利用率分数`+ a.`能源消耗率分数`* b.`能源消耗率分数`),4) score"
					+ " from t_firmserviceahp a,t_demand b "
					+ " where b.`需求ID`="+"'"+demandID+"' and a.`产品名称` like "+"'%"+demandName+ "%' and a.`产品编号` like "+"'%"+demandType+"%' "
					+ " order by  (score) DESC LIMIT 200)";
			
			System.out.print(sql);
			stmt.executeUpdate(sql);
			}
			catch(SQLException e){
				System.out.println("Mysql操作错误");
				e.printStackTrace();
			} 
			conn.close();
			
		  
	   }
	   
	 //insertscore实现讲一个资源的评分插入到数据库中
	   public boolean insertscore(String serviceID,  double  qhege,  double qbaotui,  double qtixi,  double qyunfuwu,
			   double csheji ,double ccaigou ,double cyunshu ,double cliyong,
			   double fzhonglei ,double fshijian ,double fshuliang,
			   double itouru ,double iyun ,double ijibie,
			   double pjiaohuo,double  pmanyi ,double pzhanyou,
			   double fshouyi ,double fzichan ,double flirun ,double fxiaosou,double  fchanchu,
			   double tkaifa ,double tshouru ,double  trenyuan,
			   double exunhuan ,double enengyuan)  throws Exception{
			//链接数据库读取满足需求的资源
		   int i=0;
			Connection conn = null;
			String sql;
			String url="jdbc:mysql://127.0.0.1:3306/cloud?"
			+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
			try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //插入语句
			sql="update t_firmserviceahp a set a.`合格率分数`="+qhege+",a.`报修率分数`="+qbaotui+",a.`质量体系分数`="+qtixi+",a.`云服务分数`="+qyunfuwu+","
					+ "a.`设计成本分数`="+csheji+",a.`采购成本分数`="+ccaigou+",a.`运输成本分数`="+cyunshu+",a.`成本利用率分数`="+cliyong+","
					+ "a.`品种柔性分数`="+ fzhonglei+",a.`时间柔性分数`="+fshijian+",`数量柔性分数`="+fshuliang+","
					+ "a.`信息技术分数`="+itouru+",a.`云平投入分数`="+iyun+",a.`信息化级别分数`="+ijibie+","
					+ "a.`准时交货分数`="+pjiaohuo+",a.`客户满意度分数`="+pmanyi +",a.`市场占有率分数`="+pzhanyou+","
					+ "a.`资本收益率分数`="+fshouyi+",a.`净资产利用率分数`="+fzichan+",a.`利润增长率分数`="+flirun+",a.`销售增长率分数`="+fxiaosou+",a.`投入产出比分数`="+fchanchu+","
					+ "a.`开发投资率分数`="+tkaifa+",a.`新产品收入比率分数`="+tshouru+",a.`科技开发人员比率分数`="+trenyuan+","
					+ "a.`再循环利用率分数`="+exunhuan+",a.`能源消耗率分数`="+enengyuan+" where a.`产品型号`='"+serviceID+"'";
			
			System.out.print(sql);
			i=stmt.executeUpdate(sql);
			}
			catch(SQLException e){
				System.out.println("Mysql操作错误");
				e.printStackTrace();
			} 
			conn.close();
			if(i>0){
				return true;
			}else {
				return false;
			}
			
		  
	   }
	   
	 
	   public double[] strtodouble(String[][] A)//标准化
	   {  
	        int m;
	        m=A[0].length;
	        
	        for (int i=0; i<m; i++) {
				for (int j=0;j< m; j++) {
					if (A[i][j].equals("同等重要")){
						A[i][j]="1";
					}
					else if (A[i][j].equals("略重要")) {
						A[i][j]="3";
					}  
					else if (A[i][j].equals("重要")) {
						A[i][j]="5";
					} 
					else if (A[i][j].equals("很重要")) {
						A[i][j]="7";
					} 
					else if (A[i][j].equals("极重要")) {
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
	        return weight;//得到一个数组
	   }

	public void updateahp(String demandID, String demandName,
			String demandType, String demandNum, String delitime,
			String passrate, String lprice, String hprice, String confde,
			String credit, String retime, String flexi, String samspeed,
			String returnser, String carriage) throws Exception{
		//链接数据库读取满足需求的资源
		
		Connection conn = null;
		String sql;
		String url="jdbc:mysql://127.0.0.1:3306/cloud?"
		+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url);
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //插入语句
		sql="update t_demand a set a.`产品型号`='"+demandType+"',a.`产品数量`='"+demandNum+"',a.`交货期`='"+delitime+"',"
				+ "a.`产品合格率`='"+passrate+"',a.`价格左`='"+lprice+"',a.`价格右`='"+hprice+"',a.`可靠程度`='"+confde+"',"
				+ "a.`信誉度`='"+ credit+"',a.`响应时间`='"+retime+"',`生产灵活性`='"+flexi+"',"
				+ "a.`送样速度`='"+samspeed+"',a.`退货服务`='"+returnser+"',a.`运费是否承担`='"+carriage+ "' ,a.`产品名称`='"+demandName+ "'where a.`需求ID`='"+demandID+"'";
		
		System.out.print(sql);
		 stmt.executeUpdate(sql);
		}
		catch(SQLException e){
			System.out.println("Mysql操作错误");
			e.printStackTrace();
		} 
		conn.close();
		
		
	} 
	   
}
