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
 * ģ���Ʒ�����̣���Agent�̳�JADE��Agent���࣬
 * ӵ��һ��ѭ����Ϊ���ȴ���Ϣ��������Ϣ�����ִ�в�ͬ�Ĳ�����
 * @author hanyuping
 *
 */
public class CloudAgent extends Agent  {
	@SuppressWarnings("deprecation")
	//���෽�����ڴ˷������ڱ�дAgent��Ҫִ�еĲ���
	protected void setup(){	


		@SuppressWarnings("serial")
		//����һ��ѭ����Ϊ��ѭ���ȴ���Ϣ����������JADE�ڲ���
		Behaviour loop =new CyclicBehaviour() {

			@Override
			//��ÿһ����Ϊ����Ҫ��дaction����Ҫִ�е�����
			public void action() {	
				//ʵ����jade�ڲ���ACLMessage���ڽ�����Ϣ
				ACLMessage msg =myAgent.receive();

				//�ж���Ϣ�Ƿ�Ϊ�գ���Ϊ��ִ�д������ڵĲ���
				if (msg!=null) {
					//String agentAID=msg.getSender().toString();
//					��Swith������case��佫��Ϣ����
					switch (msg.getConversationId()) {
					//Agentע����Ϣ
					case "Agent-information":
						try {
							//�����Ϣ���ݣ��˴�����Ϣ����Ϊ���л���������
							Object recontent=msg.getContentObject();
							//�ж���Ϣ��ͬ�Ƿ�ΪAgentEntity����
							if (recontent instanceof AgentEntity ) {
//								ǿ��ת��
								AgentEntity agentEntity=(AgentEntity)recontent;

								System.out.println(agentEntity.getAgentID());
								//�������ݿ�������
								SQLConnector sqladd=new SQLConnector();
//								����һ�� AgentEntity���͵�List
								List<AgentEntity> agentEntities=new ArrayList<AgentEntity>();
//								��List�����AgentEntity����
								agentEntities.add(agentEntity);
								//��ȡ������ɺ�ķ���ֵ
								int i=sqladd.addAgent(agentEntities);
//								����ACLMessage���󣬴�����Ϣ�ظ�
								ACLMessage reply= msg.createReply();
//								������ϢID
								reply.setConversationId(msg.getConversationId());
//								��ȡͨѶ��ǰʱ��
								Date i1=new Date();			
//								�������ڸ�ʽ����
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//								��������ͨ�Ź��̶���
								SaveCommunication saveCommunication=new SaveCommunication();
								//��ȡ��Ϣ�Ľ�����
								String string=agentEntity.getAgentID();
								//�����Ϣ�����ߵ�����
								String getSignInfo = string.substring(string.indexOf("t") + 1);
								//�ж��ǹ�ע��ɹ�
								if (i>0) {
//									������Ϣ����
									reply.setPerformative(ACLMessage.INFORM);
//									�����Ϣ��ͬ
									reply.setContent("ע��ɹ�");
//									���ͻظ���Ϣ
									send(reply);
//									����SaveCommunication��save()��Ա��������ͨѶ����
									saveCommunication.save(reply, "Cloud", getSignInfo,df.format(i1));
								}else {
									reply.setPerformative(ACLMessage.FAILURE);
									reply.setContent("ע��ʧ��");
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
//						����ע����Ϣ
					case "Service-register":
						try {
							//��ȡ��Ϣ
							MyList<ServiceEntity> recontent=(MyList<ServiceEntity>) msg.getContentObject();	
//							�ж���Ϣ�����Ƿ�ΪServiceEntity
							if (recontent.get(0) instanceof ServiceEntity ) {
								MyList<ServiceEntity> serviceEntitys=recontent;									
								//	System.out.println(serviceEntitys.get(0).getServiceID());
								//�������ݿ�������
								SQLConnector sqladd=new SQLConnector();
								//��ȡ������ɺ�ķ���ֵ
								int i=sqladd.registeservice(serviceEntitys, serviceEntitys.get(0).getFirmID());
//								����ACLMessage���󣬴�����Ϣ�ظ�
								ACLMessage reply= msg.createReply();
//								������ϢID
								reply.setConversationId(msg.getConversationId());
//								��ȡͨѶ��ǰʱ��
								Date i1=new Date();	
//								�������ڸ�ʽ����
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//								��������ͨ�Ź��̶���
								SaveCommunication saveCommunication=new SaveCommunication();
								//�ж��ǹ�ע��ɹ�
								if (i>0) {
//									������Ϣ����
									reply.setPerformative(ACLMessage.INFORM);
//									�����Ϣ����
									reply.setContent("����ע��ɹ�");
//									���ͻظ���Ϣ
									send(reply);
//									����SaveCommunication��save()��Ա��������ͨѶ����
									saveCommunication.save(reply, "Cloud", serviceEntitys.get(0).getFirmID(),df.format(i1));
								}else {
//										������Ϣ����
									reply.setPerformative(ACLMessage.FAILURE);
//									�����Ϣ����
									reply.setContent("����ע��ʧ��");
//									���ͻظ���Ϣ
									send(reply);
//									����SaveCommunication��save()��Ա��������ͨѶ����
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
//						��������
					case "demand-information":
						try {
//							�����Ϣ����
							Object recontent=msg.getContentObject();
							//�ж���Ϣ��ͬ�Ƿ�ΪAgentEntity����
							if (recontent instanceof DemandEntity ) {
//								ǿ��ת��
								DemandEntity demandEntity=(DemandEntity)recontent;
								//TODO ����ֽ�

								//TODO ���ݷֽ���е���QOS


								//���з�������ƥ�����ĳ�һ������Ľ��
								//���û��������String����
								String demand[]={demandEntity.getDemandName(),demandEntity.getDemandNum(),
										demandEntity.getDelitime(),demandEntity.getDemandType(),demandEntity.getPassrate(),demandEntity.getLPrice(),demandEntity.getHPrice(),
										demandEntity.getConfde(),demandEntity.getCredit(),demandEntity.getRetime(),demandEntity.getFlexi(),
										demandEntity.getReturnSer(),demandEntity.getSamSpeed(),  demandEntity.getCarriage()};
								//����QOS
								QOS qos =null;
								qos=new QOS();
								//���������ü�����
								double[][] qosrs=qos.fuzzyqos(demand);
								int m1=qosrs.length;
								//����int�������ż������е������
								int[] fsqos=new int[qosrs.length-1];
								//����double�������ż������е����ƶ���
								double[] fsqosconf=new double[qosrs.length-1];

								//�������������ƶȽϺõķֱ��������
								for (int i = 0; i < fsqos.length; i++) {
									if (qosrs[i+1][1]>0.6) {								

										fsqos[i]=(int) qosrs[i+1][0];
										fsqosconf[i]=qosrs[i+1][1];
									}
								}

								//��ȡ�����б�
								MyList<FirmServiceEntity> fslist=new MyList<FirmServiceEntity>();
//								�������ݿ����Ӵ����ݿ�������
								SQLConnector sql=new SQLConnector();
//								��ȡ�����б�
								fslist=sql.queryFSEntities(fsqos);
								//System.out.println(fslist.get(0).getFirmID());

								//֪ͨ���supply �ṩ����								
								for (int j = 0; j < fslist.size(); j++) {
//									����ACLMessage���󣬴�����Ϣ
									ACLMessage msg1=new ACLMessage(ACLMessage.REQUEST);
//									�����Ϣ�Ľ�����
									String str=fslist.get(j).getFirmID();
									String firmtype=str.substring(0, 4);
//									�ж���ҵ����
									switch (firmtype) {
									case "Supp":
//										������Ϣ�����ߵ�ַ
										msg1.addReceiver(new AID("Cloud", AID.ISLOCALNAME));
//										AID r=new AID(str+"@192.168.1.122:1099/JADE");
////										��ӵ�ַ
//										r.addAddresses("http://han-PC:7778/acc");
//										msg1.addReceiver(r);
										break;
									case "Sell":
//										������Ϣ�����ߵ�ַ
										msg1.addReceiver(new AID("Cloud", AID.ISLOCALNAME));
//										AID r1=new AID(str+"@192.168.1.98:1099/JADE");
////										��ӵ�ַ
//										r1.addAddresses("http://Wallace-PC:7778/acc");
//										msg1.addReceiver(r1);
										break;
									case "Manu":
//										������Ϣ�����ߵ�ַ
										msg1.addReceiver(new AID("Cloud", AID.ISLOCALNAME));
//										AID r2=new AID(str+"@192.168.1.51:1099/JADE");
////										��ӵ�ַ
//										r2.addAddresses("http://Dreamer10-PC:7778/acc");
//										msg1.addReceiver(r2);
										break;
									default:
										break;
									}

//									������ϢID
									msg1.setConversationId("Cloud-result");

//									�����Ϣ������
									
//									������Ϣ������
									//msg1.addReceiver(new AID(str,AID.ISLOCALNAME));
//									�����Ϣ����
									msg1.setContent("����");
//									������Ϣ
									send(msg1);
//									��ȡ��ǰͨѶʱ��
									Date i2=new Date();	
//									ת�����ڸ�ʽ
									SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//									�洢ͨ������
									SaveCommunication saveCommunication=new SaveCommunication();
//									����SaveCommunication��save()��Ա��������ͨѶ����
									saveCommunication.save(msg1, "Cloud", str,df1.format(i2));

								}

								//�洢������
								//�����洢��������б�
								List<ResultEntity> rslist=new ArrayList<ResultEntity>();
								System.out.println(fsqos.length);
								System.out.println(fslist.size());
								//for (int j = 0; j < fsqos.length; j++) {   ����ԭ���ģ�
								for (int j = 0; j < fsqos.length; j++) {
//									����ResultEntity�����������ݱ�����ֵ
									ResultEntity re=new ResultEntity();	
//									�������ݱ�����ֵ
									re.setID(demandEntity.getDemandID()+fslist.get(j).getFirmID()+fslist.get(j).getServiceID());
									re.setFirmID(fslist.get(j).getFirmID());
									re.setServiceID(fslist.get(j).getServiceID());
									//re.setDemandconf(qosrs[j+1][1]);
									DecimalFormat decimalFormat=new DecimalFormat(".000000");//���췽�����ַ���ʽ�������С������2λ,����0����.
									String p=decimalFormat.format(qosrs[j+1][1]);//format ���ص����ַ���
									re.setDemandconf(Double.parseDouble(p));//ȡС������4λ
//									��ȡ��ǰʱ��
									Date i1=new Date();	
//									ת����ʽ
									SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									re.setDate(df.format(i1));
//									�����б���Ӷ���
									rslist.add(re);
									System.out.println(re.getID()+"\t"+re.getFirmID()+"\t"+re.getDemandconf());
								}
								//�������ݿ������࣬�����ݿ���в���
								SQLConnector sqlConnector=new SQLConnector();
								sqlConnector.SaveResult(rslist);
								//ʵ����������
								SQLConnector mysqlConnector = new SQLConnector(); 				
								//��������
								Connection conn=null;
//								�������ݿ�����
								conn=DriverManager.getConnection(mysqlConnector.sqlconn());
//								  ����Statement ����
								Statement statement=conn.createStatement();
                                String sql2="delete from t_result where KeyID not in (select minid from (select min(KeyID) as minid from t_result group by SimID ) b);";
		                        int m=statement.executeUpdate(sql2);//ɾ���ظ���
		




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
//		��Agent���ѭ����Ϊ����loop
		this.addBehaviour(loop);


	}






}
