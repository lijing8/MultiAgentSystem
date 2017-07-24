package multiagent.agents;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





import fuzzyCMeans.QOS;
import multiagent.utility.DBoperater.SQLConnector;
import multiagent.utility.DBoperater.SaveCommunication;
import multiagent.utility.others.MyList;
import web.entity.AgentEntity;
import web.entity.DemandEntity;
import web.entity.FirmServiceEntity;
import web.entity.ResultEntity;
import web.entity.ServiceEntity;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

/**
 * 模拟云服务过程，该Agent继承JADE的Agent父类，
 * 拥有一个循环行为，等待消息，根据消息的类别执行不同的操作。
 * @author hanyuping
 *
 */
public class CloudAgent extends Agent  {
	@SuppressWarnings("deprecation")
	//父类方法，在此方法体内编写Agent需要执行的操作
	protected void setup(){	


		@SuppressWarnings("serial")
		//声明一个循环行为，循环等待消息，该类属于JADE内部类
		Behaviour loop =new CyclicBehaviour() {

			@Override
			//在每一个行为都需要编写action（）要执行的内容
			public void action() {	
				//实例化jade内部类ACLMessage用于接收消息
				ACLMessage msg =myAgent.receive();

				//判断消息是否为空，不为空执行大括号内的操作
				if (msg!=null) {
					//String agentAID=msg.getSender().toString();
//					用Swith。。。case语句将消息分类
					switch (msg.getConversationId()) {
					//Agent注册信息
					case "Agent-information":
						try {
							//获得消息内容，此处的消息内容为序列化对象类型
							Object recontent=msg.getContentObject();
							//判断消息内同是否为AgentEntity类型
							if (recontent instanceof AgentEntity ) {
//								强制转换
								AgentEntity agentEntity=(AgentEntity)recontent;

								System.out.println(agentEntity.getAgentID());
								//调用数据库连接器
								SQLConnector sqladd=new SQLConnector();
//								声明一个 AgentEntity类型的List
								List<AgentEntity> agentEntities=new ArrayList<AgentEntity>();
//								向List中添加AgentEntity对象
								agentEntities.add(agentEntity);
								//获取条件完成后的返回值
								int i=sqladd.addAgent(agentEntities);
//								声明ACLMessage对象，创建消息回复
								ACLMessage reply= msg.createReply();
//								设置消息ID
								reply.setConversationId(msg.getConversationId());
//								获取通讯当前时间
								Date i1=new Date();			
//								声明日期格式对象
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//								声明保存通信过程对象
								SaveCommunication saveCommunication=new SaveCommunication();
								//获取消息的接收者
								String string=agentEntity.getAgentID();
								//获得消息发送者的名称
								String getSignInfo = string.substring(string.indexOf("t") + 1);
								//判断是够注册成功
								if (i>0) {
//									设置消息类型
									reply.setPerformative(ACLMessage.INFORM);
//									添加消息内同
									reply.setContent("注册成功");
//									发送回复消息
									send(reply);
//									调用SaveCommunication的save()成员方法保存通讯内容
									saveCommunication.save(reply, "Cloud", getSignInfo,df.format(i1));
								}else {
									reply.setPerformative(ACLMessage.FAILURE);
									reply.setContent("注册失败");
									send(reply);
									saveCommunication.save(reply, "Cloud", getSignInfo,df.format(i1));
								}

							}
						} catch (UnreadableException e) {

							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
						break;
//						服务注册消息
					case "Service-register":
						try {
							//获取消息
							MyList<ServiceEntity> recontent=(MyList<ServiceEntity>) msg.getContentObject();	
//							判断消息类型是否为ServiceEntity
							if (recontent.get(0) instanceof ServiceEntity ) {
								MyList<ServiceEntity> serviceEntitys=recontent;									
								//	System.out.println(serviceEntitys.get(0).getServiceID());
								//调用数据库连接器
								SQLConnector sqladd=new SQLConnector();
								//获取条件完成后的返回值
								int i=sqladd.registeservice(serviceEntitys, serviceEntitys.get(0).getFirmID());
//								声明ACLMessage对象，创建消息回复
								ACLMessage reply= msg.createReply();
//								设置消息ID
								reply.setConversationId(msg.getConversationId());
//								获取通讯当前时间
								Date i1=new Date();	
//								声明日期格式对象
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//								声明保存通信过程对象
								SaveCommunication saveCommunication=new SaveCommunication();
								//判断是够注册成功
								if (i>0) {
//									设置消息类型
									reply.setPerformative(ACLMessage.INFORM);
//									添加消息内容
									reply.setContent("服务注册成功");
//									发送回复消息
									send(reply);
//									调用SaveCommunication的save()成员方法保存通讯内容
									saveCommunication.save(reply, "Cloud", serviceEntitys.get(0).getFirmID(),df.format(i1));
								}else {
//										设置消息类型
									reply.setPerformative(ACLMessage.FAILURE);
//									添加消息内容
									reply.setContent("服务注册失败");
//									发送回复消息
									send(reply);
//									调用SaveCommunication的save()成员方法保存通讯内容
									saveCommunication.save(reply, "Cloud", serviceEntitys.get(0).getFirmID(),df.format(i1));
								}


							}
						} catch (UnreadableException e) {

							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
						break;
//						需求类型
					case "demand-information":
						try {
//							获得消息内容
							Object recontent=msg.getContentObject();
							//判断消息内同是否为AgentEntity类型
							if (recontent instanceof DemandEntity ) {
//								强制转换
								DemandEntity demandEntity=(DemandEntity)recontent;
								//TODO 任务分解

								//TODO 根据分解进行调用QOS


								//进行服务发现与匹配计算的出一个合理的结果
								//将用户需求存入String数组
								String demand[]={demandEntity.getDemandName(),demandEntity.getDemandNum(),
										demandEntity.getDelitime(),demandEntity.getDemandType(),demandEntity.getPassrate(),demandEntity.getLPrice(),demandEntity.getHPrice(),
										demandEntity.getConfde(),demandEntity.getCredit(),demandEntity.getRetime(),demandEntity.getFlexi(),
										demandEntity.getReturnSer(),demandEntity.getSamSpeed(),  demandEntity.getCarriage()};
								//调用QOS
								QOS qos =null;
								qos=new QOS();
								//声明数组获得计算结果
								double[][] qosrs=qos.fuzzyqos(demand);
								int m1=qosrs.length;
								//声明int型数组存放计算结果中的序号列
								int[] fsqos=new int[qosrs.length-1];
								//声明double型数组存放计算结果中的相似度列
								double[] fsqosconf=new double[qosrs.length-1];

								//将计算结果中相似度较好的分别存入数组
								for (int i = 0; i < fsqos.length; i++) {
									if (qosrs[i+1][1]>0.6) {								

										fsqos[i]=(int) qosrs[i+1][0];
										fsqosconf[i]=qosrs[i+1][1];
									}
								}

								//获取服务列表
								MyList<FirmServiceEntity> fslist=new MyList<FirmServiceEntity>();
//								声明数据库连接打开数据库连接器
								SQLConnector sql=new SQLConnector();
//								获取服务列表
								fslist=sql.queryFSEntities(fsqos);
								//System.out.println(fslist.get(0).getFirmID());

								//通知相关supply 提供服务								
								for (int j = 0; j < fslist.size(); j++) {
//									声明ACLMessage对象，创建消息
									ACLMessage msg1=new ACLMessage(ACLMessage.REQUEST);
//									获得消息的接收者
									String str=fslist.get(j).getFirmID();
									String firmtype=str.substring(0, 4);
//									判断企业类型
									switch (firmtype) {
									case "Supp":
//										声明消息接收者地址
										msg1.addReceiver(new AID("Cloud", AID.ISLOCALNAME));
//										AID r=new AID(str+"@192.168.1.122:1099/JADE");
////										添加地址
//										r.addAddresses("http://han-PC:7778/acc");
//										msg1.addReceiver(r);
										break;
									case "Sell":
//										声明消息接收者地址
										msg1.addReceiver(new AID("Cloud", AID.ISLOCALNAME));
//										AID r1=new AID(str+"@192.168.1.98:1099/JADE");
////										添加地址
//										r1.addAddresses("http://Wallace-PC:7778/acc");
//										msg1.addReceiver(r1);
										break;
									case "Manu":
//										声明消息接收者地址
										msg1.addReceiver(new AID("Cloud", AID.ISLOCALNAME));
//										AID r2=new AID(str+"@192.168.1.51:1099/JADE");
////										添加地址
//										r2.addAddresses("http://Dreamer10-PC:7778/acc");
//										msg1.addReceiver(r2);
										break;
									default:
										break;
									}

//									设置消息ID
									msg1.setConversationId("Cloud-result");

//									添加消息接收者
									
//									本地消息接收者
									//msg1.addReceiver(new AID(str,AID.ISLOCALNAME));
//									添加消息内容
									msg1.setContent("供货");
//									发送消息
									send(msg1);
//									获取当前通讯时间
									Date i2=new Date();	
//									转换日期格式
									SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//									存储通信内容
									SaveCommunication saveCommunication=new SaveCommunication();
//									调用SaveCommunication的save()成员方法保存通讯内容
									saveCommunication.save(msg1, "Cloud", str,df1.format(i2));

								}

								//存储计算结果
								//声明存储结果对象列表
								List<ResultEntity> rslist=new ArrayList<ResultEntity>();
								System.out.println(fsqos.length);
								System.out.println(fslist.size());
								//for (int j = 0; j < fsqos.length; j++) {   这是原来的，
								for (int j = 0; j < fsqos.length; j++) {
//									声明ResultEntity对象设置数据表属性值
									ResultEntity re=new ResultEntity();	
//									设置数据表属性值
									re.setID(demandEntity.getDemandID()+fslist.get(j).getFirmID()+fslist.get(j).getServiceID());
									re.setFirmID(fslist.get(j).getFirmID());
									re.setServiceID(fslist.get(j).getServiceID());
									//re.setDemandconf(qosrs[j+1][1]);
									DecimalFormat decimalFormat=new DecimalFormat(".000000");//构造方法的字符格式这里如果小数不足2位,会以0补足.
									String p=decimalFormat.format(qosrs[j+1][1]);//format 返回的是字符串
									re.setDemandconf(Double.parseDouble(p));//取小数后面4位
//									获取当前时间
									Date i1=new Date();	
//									转换格式
									SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									re.setDate(df.format(i1));
//									项结果列表添加对象
									rslist.add(re);
									System.out.println(re.getID()+"\t"+re.getFirmID()+"\t"+re.getDemandconf());
								}
								//声明数据库连接类，对数据库进行操作
								SQLConnector sqlConnector=new SQLConnector();
								sqlConnector.SaveResult(rslist);
								//实例化连接器
								SQLConnector mysqlConnector = new SQLConnector(); 				
								//建立连接
								Connection conn=null;
//								建立数据库链接
								conn=DriverManager.getConnection(mysqlConnector.sqlconn());
//								  创建Statement 对象
								Statement statement=conn.createStatement();
                                String sql2="delete from t_result where KeyID not in (select minid from (select min(KeyID) as minid from t_result group by SimID ) b);";
		                        int m=statement.executeUpdate(sql2);//删除重复项
		




							}
						} catch (UnreadableException e) {

							e.printStackTrace();
						}catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
						break;


					default:
						break;
					}
				}
			}

		};
//		向本Agent添加循环行为对象loop
		this.addBehaviour(loop);


	}






}
