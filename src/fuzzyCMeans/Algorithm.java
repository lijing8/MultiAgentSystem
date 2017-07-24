package fuzzyCMeans;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;


public class Algorithm {
	public preliminaryresult algorithm(String demand[])
	{
		double standad=0.18;
		preliminaryresult ResultBeforeSelect =new preliminaryresult();
		preliminaryresult ResultAfterSelect =new preliminaryresult();
		try {					

			ResultBeforeSelect=algorithm(demand[0],standad);
			
			ResultAfterSelect.preliminaryresult1=ResultBeforeSelect.preliminaryresult1;
			ResultAfterSelect.preliminaryresult2=ResultBeforeSelect.preliminaryresult2;
			ResultAfterSelect.ResultAfterSelect =resource(ResultBeforeSelect,demand);				
			int count=0;
			for(int i=0;i<2000;i++)
			{				
				if(ResultBeforeSelect.ResultAfterSelect[i][0]==null)
				{
					break;
				}
				count++;
			}

			return ResultAfterSelect;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultAfterSelect;
		}
	}
	public static String[][] resource(preliminaryresult ResultBeforeSelect,String[] demand)throws Exception
	{
		String[][] result=new String[2000][16];
		int resultrow=0;
		//链接数据库读取满足需求的资源
		Connection conn = null;
		String sql;
		String url="jdbc:mysql://127.0.0.1:3306/cloud?"
		+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url);
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		sql="select * from t_firmservice";// 改成这个可不可以 t_firmserviceresult
		ResultSet rs = stmt.executeQuery(sql);
		int k=0;
		while(rs.next())
		{
			for(int i=0;i<arraylong(ResultBeforeSelect.preliminaryresult1);i++)
			{
						
				if(rs.getString("产品名称").equals(ResultBeforeSelect.preliminaryresult1[i])==true)
				{
				
					if(Integer.parseInt(rs.getString("数量"))>=Integer.parseInt(demand[1]))
					{
					
						if(Integer.parseInt(rs.getString("交货期"))<=Integer.parseInt(demand[2]))
						{
						
							if(Integer.parseInt(rs.getString("产品型号").trim())==(Integer.parseInt(demand[3].trim())))
							{
							
								if(Integer.parseInt(rs.getString("产品合格率"))>=Integer.parseInt(demand[4]))
								{
								
									if((Integer.parseInt(rs.getString("价格左"))<Integer.parseInt(demand[5])&&Integer.parseInt(demand[5])<Integer.parseInt(rs.getString("价格右")))||(Integer.parseInt(rs.getString("价格左"))<Integer.parseInt(demand[6])&&Integer.parseInt(demand[6])<Integer.parseInt(rs.getString("价格右"))))
									{
										for(int j=0;j<16;j++)
										{
											result[resultrow][j]=rs.getString(j+1);										
										}
										resultrow++;				
									}
								}
							}
						}
					}
				}
		}
		}
		result[resultrow][0]="2001";
		result[resultrow][1]="2001";
		for(int a=2;a<16;a++){
			result[resultrow][a]=demand[a-2];
		}
		}
		
		catch(SQLException e){
			System.out.println("Mysql操作错误");
			e.printStackTrace();
		}
		conn.close();
		return result;
	}


	public static preliminaryresult algorithm(String test,double standard) throws Exception{
		
		int distance;//距离
		double a1;//重合度
		double a2;//深度
		double similarity;//相似度
		String[] parentarray1= new String[6];
		String[] parentarray2= new String[6];
		int i=0;
		preliminaryresult a = new preliminaryresult();
		int resultnumber=0;
		Connection conn = null;
		String sql;
		String url="jdbc:mysql://127.0.0.1:3306/cloud?"
		+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		
		try{
			//链接数据库，并查找结果集
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sql="select * from sheet1";
			ResultSet rs = stmt.executeQuery(sql);
		
			//将结果集存入二维数组中方便操作
			 rs.last();
			 int x;
			 x=rs.getRow();
			 String[][] set = new String[x][3];
			 rs.beforeFirst();;
			while(rs.next())
			{
				set[i][0]=rs.getString(1);
				set[i][1]=rs.getString(2);
				set[i][2]=rs.getString(3);
				i++;				
			}
			
			
			//查找目标节点所有父节点
			parentarray1 = findparent(test,set,x);
			
			//计算所有节点与目标结点的相似度
			for(i=0;i<x;i++)
			{
				//查找各节点的所有父节点
				parentarray2 = findparent(set[i][2],set,x);
				//计算各节点与目标结点的距离
				distance = calculatedistance(parentarray1,parentarray2);
				//计算各节点与目标结点的重合度指标
				a1=chonghedu(parentarray1,parentarray2);
				//计算各节点与目标几点得深度指标
				a2=shendu(parentarray1,parentarray2);
				//计算各节点与目标结点的相似度
				similarity=xiangsidu(distance,a1,a2);

				if(similarity>standard)
				{
					
					a.preliminaryresult1[resultnumber]=set[i][2];
					a.preliminaryresult2[resultnumber]=similarity;
					resultnumber++;
				}
			}
			return a;
			
		    }
		    catch(SQLException e)
			{
				System.out.println("Mysql操作错误");
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally{
				conn.close();
			}
		return a;
	}	
	
	public static int arraylong(String[] a)
	{
		int result=0;
		for(int i=0;i<a.length;i++)
		{			
			if(a[i]==null)
			{
				break;
			}
			result++;
		}
		return result;
	}
	public static String[] findparent(String nodetext, String[][] set, int x)
	{
		String[] a= new String[6];
		
		//找到目标的所有父节点
		for(int i=0;i<x;i++)
		{
			//找到目标节点
			if(set[i][2].equals(nodetext)==true)
			{
				a[0]=set[i][0];
				a[1]=set[i][1];
				if(a[1].equals("01")==false)
				{
					//第一层查找
					for(int j=0;j<x;j++)
					{
						if(set[j][0].equals(set[i][1])==true)
						{
							a[2]=set[j][1];
							if(a[2].equals("01")==false)
							{
								//第二层查找
								for(int k=0;k<x;k++)
								{
									if(set[k][0].equals(set[j][1])==true)
									{
										a[3]=set[k][1];
										if(a[3].equals("01")==false)
										{
											//第三层查找
											for(int l=0;l<x;l++)
											{
												if(set[l][0].equals(set[k][1])==true)
												{
													a[4]=set[l][1];
													if(a[4].equals("01")==false)
													{
														//第四层查找
														for(int m=0;m<x;m++)
														{
															if(set[m][0].equals(set[l][1])==true)
															{
																a[5]=set[m][1];
																break;
															}
														}
													}
													break;
												}
											}
										}
										break;
									}
								}
							}
							break;
						}
					}
				}
				break;
			}
		}
		return a;
	}
	public static int calculatedistance(String[] a,String[] b)
	{
		int distance;
		int x=0;
		int y=0;
		boolean finish=false;
		for(int i =0;i<5;i++)
		{	
			y=0;
			for(int j =0;j<5;j++)
			{				
				if(a[i].equals(b[j])==true)
				{
					finish = true;
					break;
				}
				y++;
			}
			if(finish == true)
			{
				break;
			}
			x++;
		}
		distance=x+y;
		return distance; 
	}
	public static double chonghedu(String[] a,String[] b)
	{
		double r1=3;
		double result=0;
		double x=0;
		double y=0;
		boolean finish=false;
		for(int i =0;i<5;i++)
		{				
			for(int j =0;j<5;j++)
			{				
				if(a[i].equals(b[j])==true)
				{
					if(i==0||j==0)
					{
						x=arraylong(a)-i-1;
					}
					else
					{
						x=Math.max(arraylong(a), arraylong(b))-i;
					}
					finish = true;
					break;
				}
			}
			if(finish == true)
			{
				break;
			}
		}
		y=Math.max(arraylong(a)-1, arraylong(b)-1);
		result= Math.pow(x/y,1.0/r1);
		return result;
	}
	public static double shendu(String[] a,String[] b)
	{
		double result=0;
		double r2=3;
		result=Math.pow((1-((double)Math.abs(arraylong(a)-arraylong(b)))/(double)(arraylong(a)+arraylong(b))),1.0/r2);
		return result;
	}
	public static double xiangsidu(int a, double b, double c)
	{
		double result=0;
		double n=1;
		double n1=0.5;
		double n2=0.5;
		result=n/(n+a)*(n1*b+n2*c);
		return result;
	}
}
