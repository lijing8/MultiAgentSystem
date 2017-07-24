package web.controller;


import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import multiagent.utility.AgentStarter.AgentStarter;













import multiagent.utility.AgentStarter.Start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import AHP.AHPwork;
import web.entity.AgentCommEntity;
import web.entity.DemandEntity;
import web.entity.FirmServiceEntity;
import web.entity.FirmServiceEntityResult;
import web.entity.ResultEntity;
import web.service.AgentCommService;
import web.service.DemandService;
import web.service.FirmService;
import web.service.FirmServiceAHPService;
import web.service.FirmServiceResultService;
import web.service.FirmServiceService;
import web.service.ResultService;

/**
 * ����Ϊ������Ϣ����Controller��,��ע��@Controller ����ʶ������MVC�ܹ��еĿ����ࡣ
 * ����·����@RequestMapping(value="/information")����������˵��
 * @author hanyuping
 *
 */

@Controller
@RequestMapping(value="/information")
public class InformationController {
//	��ע���������Զ���ResultService������Զ�������ʵ����
	@Autowired
	private ResultService rsService;
//	�Զ���DemandService�����
	@Autowired
	private DemandService demandService;
//	�Զ���FirmService�����
	@Autowired
	private FirmService firmService;
//	�Զ���AgentCommService�����
	@Autowired
	private AgentCommService agentCommService;
//	�Զ���FirmServiceService�����
	@Autowired
	private FirmServiceService firmServiceService;
	@Autowired
	private FirmServiceAHPService firmServiceAHPService;
	@Autowired
	private FirmServiceResultService firmServiceResultService;

//	JSP���ʵĹ����еĴ���ҳ�棬����·��@RequestMapping(value="/error")������
	@RequestMapping(value="/error")
	public ModelAndView getindex( ) {		

//������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
		
		ma.setViewName("/error");
		
		return ma;
	}
	

	/**
	 * 	ת�����ҳ�棬����·��Ϊ	@RequestMapping(value="/simulationmain")
	 * @param request ҳ���������
	 * @param userID ҳ�洫��Ĳ���
	 * @return ����һ��
	 */
	@RequestMapping(value="/simulationmain")
	public ModelAndView gotosimulation(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID) {		

//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);
//		������ͼ
		ma.setViewName("/simulationmain");
//		������ͼ
		return ma;
	}
	/**
	 * ��ȡ�������н��������·��Ϊ	@RequestMapping(value="/getresult")
	 * @param request ҳ���������
	 * @param userID ҳ�洫��Ĳ���
	 * @return ����һ��
	 */
	
	@RequestMapping(value="/getresult")
	public ModelAndView getAllResult(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID) {		
//		����ResultEntity�����б�����Service������ȡ����б�
		List<ResultEntity> rs = rsService.getAllResult();
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);
//		������ͼ����
		ma.setViewName("/result");
//		����ͼ��ӽ��������
		ma.addObject("result", rs);
//		������ͼ
		return ma;
	}
/**
 * ��ȡ��ǰ������������·��Ϊ	@RequestMapping(value="/getthisresult")
 * @param request ҳ���������
 * @param userID ҳ�洫��Ĳ���
 * @param demandID ҳ�洫��Ĳ���
 * @return ������ͼ
 */
	@RequestMapping(value="/getthisresult")
	public ModelAndView getResult(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,
			@RequestParam(value="demandID" ,required=false)String demandID) {		
//		����ResultEntity�����б�����Service������ȡ����б�
		List<ResultEntity> rs = rsService.getResultBySimID(demandID);
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();	
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);	
//		����ͼ��Ӳ���
		ma.addObject("demandID", demandID);
//		����ͼ��ӽ��������
		ma.addObject("result", rs);
//		������ͼ����
		ma.setViewName("/result");
//		������ͼ
		return ma;
	}

	
	/**
	 * ��ȡagent������Ϣ������·��Ϊ	@RequestMapping(value="/getallagentinformation")
	 * @param request ҳ���������
	 * @param userID ҳ�洫��Ĳ���
	 * @return ����һ����ͼ
	 */
	@RequestMapping(value="/getallagentinformation")
	public ModelAndView getAllAgentComm(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID) {
//		����AgentCommEntity�����б�����Service������ȡ�����б�
		List<AgentCommEntity> agentComunicationlist = agentCommService.getAllAgentComm();
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);
//		������ͼ����
		ma.setViewName("/allagentinformation");
//		����ͼ��ӷ��潻��������
		ma.addObject("result", agentComunicationlist);
//		������ͼ
		return ma;
	}
	
	


	/**
	 * 	�û��������󣬷���·��Ϊ	@RequestMapping(value="/toadddemand")
	 * @param request ҳ������
	 * @param userID �������
	 * @return ������ͼ
	 */
	@RequestMapping(value="/toadddemand")
	public ModelAndView toadddemand(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);
//		������ͼ����
		ma.setViewName("/addDemandScore");
//		������ͼ
		return ma;
	}
	
	/**
	 * //������� ����·��Ϊ	@RequestMapping(value="/listdemand")
	 * @param request ҳ������
	 * @return ������ͼ
	 * @throws Exception
	 */
	@RequestMapping(value="/listdemand")
	public ModelAndView listDemand(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
		ModelAndView ma = new ModelAndView();
		ma.addObject("demandlist",demandService.getAllDemand());
		ma.addObject("userID", userID);
		ma.setViewName("/demandList");
		return ma;
	}
	
	/**
	 * //������� ����·��Ϊ	@RequestMapping(value="/listonedemand")
	 * @param request ҳ������
	 * @return ������ͼ
	 * @throws Exception
	 */
	@RequestMapping(value="/listonedemand")
	public ModelAndView listoneDemand(HttpServletRequest request,@RequestParam(value="demandID" ,required=false)String demandID,@RequestParam(value="userID" ,required=false)String userID){
		ModelAndView ma = new ModelAndView();
		ma.addObject("demandlist",demandService.getDemand(demandID));
		ma.addObject("userID", userID);
		ma.setViewName("/onedemandList");
		return ma;
	}
	/**
	 * //������� ����·��Ϊ	@RequestMapping(value="/adddemand")
	 * @param request ҳ������
	 * @param userID ҳ��������û�ID
	 * @param demandID ҳ�����������ID
	 * @param demandName ҳ���������������
	 * @param demandNum ҳ���������������
	 * @param delitime ҳ�������������
	 * @param demandType ҳ���������������
	 * @param passrate ҳ��������ϸ���
	 * @param Lprice ҳ��������۸���
	 * @param Hprice ҳ��������۸���
	 * @param confde ҳ����������Ŷ�
	 * @param credit ҳ�������������
	 * @param retime ҳ�������������
	 * @param flexi ҳ������������
	 * @param returnser ҳ��������˻ط���
	 * @param samspeed ҳ������������ٶ�
	 * @param carriage ҳ��������˷ѷ���
	 * @return ������ͼ
	 * @throws Exception
	 */
	@RequestMapping(value="/adddemand")
	public ModelAndView addDemand(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,
			String demandID,String demandName,String demandNum,String delitime,String demandType,
			String passrate,String Lprice,String Hprice,String confde,
			String credit,String retime,String flexi,String returnser,String samspeed,
			String carriage)throws Exception{
		//,@RequestParam(value="userID", required=false)String userID
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
		AHPwork mb=new AHPwork();
		
		 
		 
//		�ж�ǰ̨�ύ�����Ƿ�Ϊ��
		if(demandID==null || demandName.trim().length()==0){
//			���ǰ̨����ؼ����ݣ����û�������д
			ma.setViewName("/addDemand");
			ma.addObject("error", "���������Ϣ����Ϊ��");
			ma.addObject("userID", userID);
			//
			ma.addObject("demandID",demandID);
			ma.addObject("demandName",demandName);			
			ma.addObject("demandNum",demandNum);
			ma.addObject("delitime",delitime);
			ma.addObject("demandType",demandType);
			ma.addObject("passrate",passrate);
			ma.addObject("Lprice",Lprice);
			ma.addObject("Hprice",Hprice);
			ma.addObject("confde",confde);
			ma.addObject("credit",credit);
			ma.addObject("retime",retime);
			ma.addObject("flexi",flexi);			
			ma.addObject("returnser",returnser);
			ma.addObject("samspeed",samspeed);
			ma.addObject("carriage", carriage);
//			������ͼ
			return ma;
		}else {
			
		
//		����Service�е�addDemand �������
		Boolean addBoolean=demandService.updateDemandbyid( demandID,demandName, demandType, demandNum, delitime, passrate,
				Lprice, Hprice, confde,credit, retime, flexi,samspeed, returnser, carriage);
//		�ж��Ƿ���ӳɹ�
		if (addBoolean) {
//			��ӳɹ�
			//����sell Agent���Ʒ�����Ϣ
//			����DemandEntity����
			DemandEntity demandEntity=new DemandEntity();
//			ΪDemandEntity��Ա������ֵ
			demandEntity.setDemandID(demandID);
			demandEntity.setDemandName(demandName);
			demandEntity.setDemandType(demandType);
			demandEntity.setDemandNum(demandNum);
			demandEntity.setDelitime(delitime);
			demandEntity.setPassrate(passrate);
			demandEntity.setLPrice(Lprice);
			demandEntity.setHPrice(Hprice);
			demandEntity.setConfde(confde);
			demandEntity.setCredit(credit);
			demandEntity.setRetime(retime);
			demandEntity.setFlexi(flexi);
			demandEntity.setSamSpeed(samspeed);
			demandEntity.setReturnSer(returnser);
			demandEntity.setCarriage(carriage);
//			����DemandEntity����
			DemandEntity []demandEntity2=new DemandEntity[1];
//			�����������Ԫ��
			demandEntity2[0]=demandEntity;
//			����AgentStarter��������DemandAgent
			AgentStarter agentStarter=new AgentStarter();
//			����AgentStarter����������DemandAgent������DemandAgent���ݲ���
			String localip;
			InetAddress ia=null;
			ia=ia.getLocalHost();		
			localip=ia.getHostAddress();
			agentStarter.startAgent(localip, "1099", "DemandAgent", "multiagent.agents.DemandAgent", demandEntity2);
		}
//		����ͼ��Ӳ���
		ma.addObject("demandID", demandID);
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);
//		������ͼ����
		ma.setViewName("/bufferdemand");
//		������ͼ
		return ma;
		}
	}

	
	/**
	 * ����Ϊ������Ϣ����Controller��,��ע��@Controller ����ʶ������MVC�ܹ��еĿ����ࡣ
	 * ����·����@RequestMapping(value="/evaluate")����������˵��
	 * @author lijing
	 *
	 */

	//�����ּ���ɹ�
	@RequestMapping(value="/caldemand")
	public ModelAndView caldemand(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,@RequestParam(value="demandID" ,required=false)String demandID){
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		����ͼ��Ӳ���
		ma.addObject("demandID", demandID);
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);
//		������ͼ����
		ma.setViewName("/demand");
//		������ͼ
		return ma;
	}
	
	@RequestMapping(value="/toaddservice")
	public ModelAndView toaddservice(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		����ͼ��Ӳ���
		
		 Date  now  =  new   Date();     
	     SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//���Է�����޸�����ʽ     
	     String  str= dateFormat.format(now);   
	     String serviceID = str.trim().replaceAll(":", "").replaceAll("-","").replaceAll(" ","");
	     serviceID=serviceID.substring(serviceID.length()-8,serviceID.length());
	     serviceID="Product"+serviceID;
	     System.out.println(serviceID);
		ma.addObject("userID", userID);
		ma.addObject("serviceID", serviceID);
//		������ͼ����
		ma.setViewName("/addFirmService");
//		������ͼ
		return ma;
	}
	
	@RequestMapping(value="/toaddevaluate")
	public ModelAndView toaddevaluate(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);
//		������ͼ����
		ma.setViewName("/addevaluate");
//		������ͼ
		return ma;
	}
	
	
	/**
	 * //������� ����·��Ϊ	@RequestMapping(value="/addservice")
	 * @param request ҳ������
	 * @param userID ҳ��������û�ID
	 * @param demandID ҳ�����������ID
	 * @param demandName ҳ���������������
	 * @param demandNum ҳ���������������
	 * @param delitime ҳ�������������
	 * @param demandType ҳ���������������
	 * @param passrate ҳ��������ϸ���
	 * @param Lprice ҳ��������۸���
	 * @param Hprice ҳ��������۸���
	 * @param confde ҳ����������Ŷ�
	 * @param credit ҳ�������������
	 * @param retime ҳ�������������
	 * @param flexi ҳ������������
	 * @param returnser ҳ��������˻ط���
	 * @param samspeed ҳ������������ٶ�
	 * @param carriage ҳ��������˷ѷ���
	 * @return ������ͼ
	 * @throws Exception
	 */
	
	@RequestMapping(value="/toaddindex")
	public ModelAndView toaddindex(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);
//		������ͼ����
		ma.setViewName("/addindex");
//		������ͼ
		return ma;
	}
	
	
	@RequestMapping(value="/addindex")
	public ModelAndView addIndex(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,
			String serviceID){
		String serviceName=request.getParameter("serviceName");
		
		
		//��Ʒ����������������ϵû������
		String qshengchan=request.getParameter("qshengchan");
		String qhege=request.getParameter("qhege");
		String qxiaoshou=request .getParameter("qxiaoshou");
		String qbaotui=request.getParameter("qbaotui");
		String qtixi=request.getParameter("qtixi");
		
		//������Ҳ����Ҫ��ϵͳ�в������
//		String qyunfuwu=request.getParameter("qyunfuwu");
//		String qyunfuwuneed=request.getParameter("qyunfuwuneed");
		double  qyunfuwu1=firmServiceAHPService.getyunfuwu();
		System.out.println(qyunfuwu1);
		double qyunfuwuneed1=firmServiceAHPService.getyunfuwuneed(request.getParameter("firmID"));
		System.out.println(qyunfuwuneed1);
		
		
		double qhegerate=Double.parseDouble(qhege)/Double.parseDouble(qshengchan)*100;//��Ʒ�ϸ���
		double qbaotuirate=(1-Double.parseDouble(qbaotui)/Double.parseDouble(qxiaoshou))*100;//�����˻���
		double qyunfuwurate=(qyunfuwuneed1/qyunfuwu1)*100+50;//�Ʒ�������
		double qtixirate=0;//����������ϵ
		if(qtixi.equals("ISO/TS16949������ϵ")){
			qtixirate=100;
		}else{
			qtixirate=80;
		}
		//�ɱ�
		String csheji=request.getParameter("csheji");
		String ccaigou=request.getParameter("ccaigou");
		String cyunshu=request .getParameter("cyunshu");
		String clirun=request .getParameter("clirun");
		String ctotal=request.getParameter("ctotal");
		
		double cshejirate=Double.parseDouble(csheji)/Double.parseDouble(ctotal)*100+40;//��Ƴɱ�����
		double ccaigourate=(1-Double.parseDouble(ccaigou)/Double.parseDouble(ctotal))*100;//�ɹ��ɱ�����
		double cyunshurate=(1-Double.parseDouble(cyunshu)/Double.parseDouble(ctotal))*100;//����ɱ�����
		double cliyongrate=Double.parseDouble(clirun)/Double.parseDouble(ctotal)*100+40;//�ɱ�������
		
		//����
		String fzhonglei=request.getParameter("fzhonglei");
		String fnewzhonglei=request.getParameter("fnewzhonglei");
		String fsongshijian=request .getParameter("fsongshijian");
		String fshijian=request .getParameter("fshijian");
		double fshulaingneed1=firmServiceAHPService.getshuliangneed(serviceName);
		System.out.println(fshulaingneed1);
		
		double fzhongleirate=Double.parseDouble(fnewzhonglei)/Double.parseDouble(fzhonglei)*100+40;//��������
		double fshijianrate=Double.parseDouble(fsongshijian)/Double.parseDouble(fshijian)*100+50;//ʱ������
		double fneed=firmServiceAHPService.getallneed(serviceName);
		System.out.println(fneed);
		double fshuliangrate=Double.parseDouble(qshengchan)/fneed*100+50;//��������
		
		//��Ϣ��ˮƽ  �Ƽ���û�д���
		String ixiaoshou=request.getParameter("ixiaoshou");
		String itouru=request.getParameter("itouru");
		String iyun=request .getParameter("iyun");
		String ijibie=request .getParameter("ijibie");
		
	
		
		double itoururate=Double.parseDouble(itouru)/Double.parseDouble(ixiaoshou)*100+50;//��Ϣ����Ͷ����
		double iyunrate=Double.parseDouble(iyun)/Double.parseDouble(ixiaoshou)*100+50;//		��ƽ̨Ͷ����
		double ijibierate=0;//		��Ϣ������
		if(ijibie.equals("һ����ҵ")){
			ijibierate=95;
		}else if(ijibie.equals("������ҵ")){
			ijibierate=80;
		}
		else if(ijibie.equals("������ҵ")){
			ijibierate=60;
		}
		else{
			ijibierate=50;
		}
		//����ϵ
		
		String pjiaohuo=request.getParameter("pjiaohuo");
		String pzhunshi=request.getParameter("pzhunshi");
		String pmanyi=request .getParameter("pmanyi");
	
		
		double pjiaohuorate=Double.parseDouble(pzhunshi)/Double.parseDouble(pjiaohuo)*100;//׼ʱ������
		double pmanyirate=Double.parseDouble(pmanyi)/Double.parseDouble(pjiaohuo)*100;//����������
		double  pzhanyourate=Double.parseDouble(qshengchan)/fshulaingneed1+50;//�г�ռ����	
		
		//��������
		String fzhanyong=request.getParameter("fzhanyong");
		String fpingzichan=request.getParameter("fpingzichan");
		String fzichan=request .getParameter("fzichan");
		String fshanglirun=request .getParameter("fshanglirun");
		String fliruncha=request .getParameter("fliruncha");
		String fshangxiaoshou=request .getParameter("fshangxiaoshou");
		String fxiaoshoucha=request .getParameter("fxiaoshoucha");
		
		
		double fshouyirate=Double.parseDouble(clirun)/Double.parseDouble(fzhanyong)*100+50;//�ʱ�������
		double fzichanrate=Double.parseDouble(fzichan)/Double.parseDouble(fpingzichan)*100+50;//���ʲ�������
		double  flirunrate=Double.parseDouble(fliruncha)/Double.parseDouble(fshanglirun)*100+50;//����������
		double fxiaoshourate=Double.parseDouble(fxiaoshoucha)/Double.parseDouble(fshangxiaoshou)*100+50;//����������
		double  fchanchurate=(1-Double.parseDouble(ctotal)/Double.parseDouble(ixiaoshou))*100+60;//Ͷ�������

		
		//�Ƽ�
		String tkaifa=request.getParameter("tkaifa");
		String tnewshouru=request.getParameter("tnewshouru");
		String tkejiren=request .getParameter("tkejiren");
		String ttotalren=request .getParameter("ttotalren");
		
		double tkaifarate=Double.parseDouble(tkaifa)/Double.parseDouble(ixiaoshou)*100+50;//�о�����Ͷ����
		double tshoururate=Double.parseDouble(tnewshouru)/Double.parseDouble(ixiaoshou)*100+50;//�²�Ʒ�������
		double  trenyuanrate=Double.parseDouble(tkejiren)/Double.parseDouble(ttotalren)*100+50;//�Ƽ�������Ա����
		
		//����
		
		String ehuishou=request.getParameter("ehuishou");
		String etouru=request .getParameter("etouru");
		
		double exunhuanrate=Double.parseDouble(ehuishou)/Double.parseDouble(qshengchan)*100+80;//��ѭ������������
		double enengyuanraterate=Double.parseDouble(etouru)/Double.parseDouble(ixiaoshou)*100+80;//��Դ������
		
		
		boolean i=firmServiceAHPService.addfirmServiceIndex(serviceID,qhegerate, qbaotuirate, qtixirate, qyunfuwurate,
				cshejirate , ccaigourate , cyunshurate , cliyongrate,
				 fzhongleirate ,fshijianrate , fshuliangrate,
				 itoururate , iyunrate , ijibierate,//
				 pjiaohuorate, pmanyirate , pzhanyourate,
				 fshouyirate , fzichanrate ,flirunrate , fxiaoshourate,  fchanchurate,
				 tkaifarate , tshoururate ,  trenyuanrate,
				 exunhuanrate , enengyuanraterate);		
		ModelAndView ma = new ModelAndView();
		if(i){
			ma.addObject("userID", userID);
			ma.setViewName("/insertsuccess");
		}
		return ma;
    
}
	
	@RequestMapping(value="/addservice")
	public ModelAndView addService(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,
			String serviceID,String serviceName,String serviceNum,String delitime,String serviceType,
			String passrate,String Lprice,String Hprice,String confde,
			String credit,String retime,String flexi,String returnser,String samspeed,
			String carriage,String FirmID)throws Exception{
		//,@RequestParam(value="userID", required=false)String userID
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		�ж�ǰ̨�ύ�����Ƿ�Ϊ��
		if(serviceID==null || serviceName.trim().length()==0){
//			���ǰ̨����ؼ����ݣ����û�������д
			ma.setViewName("/addFirmService");
			ma.addObject("error", "���������Ϣ����Ϊ��");
			ma.addObject("userID", userID);
			//
			ma.addObject("userID",userID);
			ma.addObject("serviceName",serviceName);			
			ma.addObject("serviceNum",serviceNum);
			ma.addObject("delitime",delitime);
			ma.addObject("serviceType",serviceType);
			ma.addObject("passrate",passrate);
			ma.addObject("Lprice",Lprice);
			ma.addObject("Hprice",Hprice);
			ma.addObject("confde",confde);
			ma.addObject("credit",credit);
			ma.addObject("retime",retime);
			ma.addObject("flexi",flexi);			
			ma.addObject("returnser",returnser);
			ma.addObject("samspeed",samspeed);
			ma.addObject("carriage", carriage);

//			������ͼ
			return ma;
		}else {
//		����Service�е�addFirmService ��ӷ���
		if(firmServiceAHPService.search(FirmID,serviceName,serviceType)){
			System.out.println("����");
			firmServiceAHPService.updatefirmService( FirmID,serviceName,serviceNum, delitime,serviceID,
					passrate,Lprice, Hprice, confde,credit, retime, flexi,returnser,samspeed,carriage, serviceType);
		}else{
			System.out.println("���");
			firmServiceAHPService.addfirmService( FirmID,serviceName,serviceNum, delitime,serviceType,
					passrate,Lprice, Hprice, confde,credit, retime, flexi,returnser,samspeed,carriage, serviceID);
		}
		
		
//		����ͼ��Ӳ���
		ma.addObject("serviceName", serviceName);
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);
		ma.addObject("serviceName", serviceName);
		ma.addObject("serviceID",serviceID);
		ma.addObject("firmID",FirmID);
//		������ͼ����
//		������ͼ
		
		ma.setViewName("/addindex");
		return ma;
		}
	}
	
	
	/**
	 * //������� ����·��Ϊ	@RequestMapping(value="/listservice")
	 * @param request ҳ������
	 * @return ������ͼ
	 * @throws Exception
	 */
	@RequestMapping(value="/listservice")
	public ModelAndView listService(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
		ModelAndView ma = new ModelAndView();
		ma.addObject("servicelist",firmServiceAHPService.getAllService());
		ma.addObject("userID", userID);
		ma.setViewName("/firmserviceList");
		return ma;
	}
	
	/**
	 * �޸��û����� ��ͨ��@RequestMapping("/getAllEditUser")���÷���·��
	 * @param request ҳ������
	 * @param userID �û�ID
	 * @return ������ͼ
	 */
	@RequestMapping("/getAllfirm")
	public ModelAndView getAllEditUser(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView mav = new ModelAndView();
//		����ͼ��Ӳ���
		mav.addObject("userlist",firmService.getAllFirms());
		mav.addObject("userID", userID);
//		������ͼ����
		mav.setViewName("/firmList");
		return mav;
	}
	/**
	 * //������� ����·��Ϊ	@RequestMapping(value="/listoneservice")
	 * @param request ҳ������
	 * @return ������ͼ
	 * @throws Exception
	 */
	@RequestMapping(value="/listoneservice")
	public ModelAndView listoneService(HttpServletRequest request,@RequestParam(value="ID" ,required=false)String ServiceID,@RequestParam(value="userID" ,required=false)String userID){
		ModelAndView ma = new ModelAndView();
		ma.addObject("servicelist",firmServiceAHPService.getonefirmService(ServiceID));
		ma.addObject("userID", userID);	
		ma.setViewName("/onefirmserviceList");
		return ma;
	}
	/**
	 * ����Ϊ������Ϣ����Controller��,��ע��@Controller ����ʶ������MVC�ܹ��еĿ����ࡣ
	 * ����·����@RequestMapping(value="/evaluateresult")����������˵��
	 * �������в�ѯ��ѡ�Ľ��
	 * @author lijing
	 *
	 */

	@RequestMapping(value="/evaluateresult")
	public ModelAndView getevaluateResult(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,
			@RequestParam(value="demandID" ,required=false)String demandID) {		
//		����FirmServiceEntityResult�����б�����Service������ȡ����б�
		List<FirmServiceEntityResult> rss = firmServiceResultService.getResultBydemandID(demandID);

//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();	
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);	
//		����ͼ��Ӳ���
		ma.addObject("demandID", demandID);
//		����ͼ��ӽ��������
		ma.addObject("result", rss);
//		������ͼ����
		ma.setViewName("/evaluateResult");
//		������ͼ
		return ma;
	}
	
	@RequestMapping(value="/start")
	public ModelAndView startcloud(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID) {		

		//��Controller�������ƺ�agent
				Start start= new Start();
				try {
					start.allstart();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();	
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);	
//		������ͼ����
		ma.setViewName("/simulationmain");
//		������ͼ
		return ma;
		}
	

	
	@RequestMapping(value="/generateID")
	public void valiateName(HttpServletRequest request,HttpServletResponse response) throws IOException, StaleProxyException {		
		 Date  now  =  new   Date();     
	        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//���Է�����޸�����ʽ     
	        String  str= dateFormat.format(now);   
	        String strran = str.trim().replaceAll(":", "").replaceAll("-","").replaceAll(" ","");
	        System.out.println(strran);
	
		    String demandID="demand"+strran;
			StringBuilder result=new StringBuilder();
				result.append("{")
			      .append("\"demandID\":\""+demandID+"\"")
			      .append("}");
	
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(result);
		}
	
	@RequestMapping(value="/valiateservice")
	public void valiateservice(HttpServletRequest request,HttpServletResponse response) throws IOException, StaleProxyException {		
		

			String serviceID=request.getParameter("userName");
			System.out.print(serviceID);
			int i=0;
			if(firmServiceAHPService.valiateyes(serviceID)==null){
				 i=0;
			}else{
				i=1;
			}
			String result=null;
			System.out.print(i);
			if(i==0){
				result="<font color='green'>��Դ������</font>";
				
			}else{
				
				result="<font color='red'>��Դ����</font>";
			}
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(result);
		}
	
	@RequestMapping(value="/valiateserviceindex")
	public void valiateserviceindex(HttpServletRequest request,HttpServletResponse response) throws IOException, StaleProxyException {		
		

			String serviceID=request.getParameter("userName");
			System.out.print(serviceID);
			int i=0;
			//firmServiceAHPService.getonefirmService(serviceID);
			if(firmServiceAHPService.valiateyes(serviceID)==null){
				 i=0;
			}else{
				i=1;
			}
			String result=null;
			System.out.print(i);
			if(i==0){
				result="<font color='red'>��Դ������</font>";
				
			}else{
				
				result="<font color='green'>��Դ����</font>";
			}
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(result);
		}
	
	@RequestMapping(value="/valiateahp")
	public ModelAndView ahpinsert(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="userID" ,required=false)String userID) throws Exception {		
		
		   String demandID=request.getParameter("demandID");
		   String demandName=request.getParameter("demandName");
		   String demandType=request.getParameter("demandType");
		   
			String a1=request.getParameter("a1");
			String a2=request.getParameter("a2");
			String a3=request.getParameter("a3");
			String a4=request.getParameter("a4");
			String a5=request.getParameter("a5");
			String a6=request.getParameter("a6");
			String a7=request.getParameter("a7");
			String a8=request.getParameter("a8");
			

			String b2=request.getParameter("b2");
			String b3=request.getParameter("b3");
			String b4=request.getParameter("b4");
			String b5=request.getParameter("b5");
			String b6=request.getParameter("b6");
			String b7=request.getParameter("b7");
			String b8=request.getParameter("b8");
		
			String c3=request.getParameter("c3");
			String c4=request.getParameter("c4");
			String c5=request.getParameter("c5");
			String c6=request.getParameter("c6");
			String c7=request.getParameter("c7");
			String c8=request.getParameter("c8");
		
			String d4=request.getParameter("d4");
			String d5=request.getParameter("d5");
			String d6=request.getParameter("d6");
			String d7=request.getParameter("d7");
			String d8=request.getParameter("d8");
			
			String e5=request.getParameter("e5");
			String e6=request.getParameter("e6");
			String e7=request.getParameter("e7");
			String e8=request.getParameter("e8");
			
			String f6=request.getParameter("f6");
			String f7=request.getParameter("f7");
			String f8=request.getParameter("f8");
			
			String g7=request.getParameter("g7");
			String g8=request.getParameter("g8");
			
			String h8=request.getParameter("h8");
			
			System.out.print(a1);
			
			//AHP����		
	        String indexname[]={"����","�ɱ�","����","��Ϣ��","����ϵ","��������","�Ƽ�ˮƽ","����ˮƽ"};
			
			String[][] A1={{a1,a2,a3,a4,a5,a6,a7,a8},
					       {"0",b2,b3,b4,b5,b6,b7,b8},
					       {"0","0",c3,c4,c5,c6,c7,c8},
					       {"0","0","0",d4,d5,d6,d7,d8},
					       {"0","0","0","0",e5,e6,e7,e8},
					       {"0","0","0","0","0",f6,f7,f8},
					       {"0","0","0","0","0","0",g7,g8},
					       {"0","0","0","0","0","0","0",h8}};

			AHPwork mb=new AHPwork();
			double[] first=mb.strtodouble(A1);
			 //�۸�
			 
			   String a11=request.getParameter("a11");
				String a12=request.getParameter("a12");
				String a13=request.getParameter("a13");
				String a14=request.getParameter("a14");
				
				String a22=request.getParameter("a22");
				String a23=request.getParameter("a23");
				String a24=request.getParameter("a24");
				
				String a33=request.getParameter("a33");
				String a34=request.getParameter("a34");
				
				String a44=request.getParameter("a44");
				
				String[][] A11={{a11,a12,a13,a14},
					            {"0",a22,a23,a24},
					            {"0","0",a33,a34},
					            {"0","0","0",a44}};
				
				AHPwork mb1=new AHPwork();
				double[] second1=mb1.strtodouble(A11);
				
		//�ɱ�
				 String b11=request.getParameter("b11");
					String b12=request.getParameter("b12");
					String b13=request.getParameter("b13");
					String b14=request.getParameter("b14");
					
					String b22=request.getParameter("b22");
					String b23=request.getParameter("b23");
					String b24=request.getParameter("b24");
					
					String b33=request.getParameter("b33");
					String b34=request.getParameter("b34");
					
					String b44=request.getParameter("b44");
					
					String[][] A12={{b11,b12,b13,b14},
						            {"0",b22,b23,b24},
						            {"0","0",b33,b34},
						            {"0","0","0",b44}};
					
					AHPwork mb2=new AHPwork();
					double[] second2=mb2.strtodouble(A12);	    
			
					//����
					    String c11=request.getParameter("c11");
						String c12=request.getParameter("c12");
						String c13=request.getParameter("c13");
						
						
						String c22=request.getParameter("c22");
						String c23=request.getParameter("c23");
				
						
						String c33=request.getParameter("c33");
						
						
						
						String[][] A13={{c11,c12,c13},
							            {"0",c22,c23},
							            {"0","0",c33}};
						
						AHPwork mb3=new AHPwork();
						double[] second3=mb3.strtodouble(A13);	    
				
						//��Ϣ��
					    String d11=request.getParameter("d11");
						String d12=request.getParameter("d12");
						String d13=request.getParameter("d13");
						
						
						String d22=request.getParameter("d22");
						String d23=request.getParameter("d23");
				
					
						String d33=request.getParameter("d33");
						
						
						
						String[][] A14={{d11,d12,d13},
							            {"0",d22,d23},
							            {"0","0",d33}};
						
						AHPwork mb4=new AHPwork();
						double[] second4=mb4.strtodouble(A14);
						
						//����ϵ
					    String e11=request.getParameter("e11");
						String e12=request.getParameter("e12");
						String e13=request.getParameter("e13");
						
						
						String e22=request.getParameter("e22");
						String e23=request.getParameter("e23");
				
					
						String e33=request.getParameter("e33");
						
						
						
						String[][] A15={{e11,e12,e13},
							            {"0",e22,e23},
							            {"0","0",e33}};
						
						AHPwork mb5=new AHPwork();
						double[] second5=mb5.strtodouble(A15);
			
						//����
					    String f11=request.getParameter("f11");
						String f12=request.getParameter("f12");
						String f13=request.getParameter("f13");
						String f14=request.getParameter("f14");
						String f15=request.getParameter("f15");
						
						String f22=request.getParameter("f22");
						String f23=request.getParameter("f23");
						String f24=request.getParameter("f24");
						String f25=request.getParameter("f25");
					
						String f33=request.getParameter("f33");
						String f34=request.getParameter("f34");
						String f35=request.getParameter("f35");
						
						String f44=request.getParameter("f44");
						String f45=request.getParameter("f45");
						
						String f55=request.getParameter("f55");
						
						
						
						
						String[][] A16={{f11,f12,f13,f14,f15},
							            {"0",f22,f23,f24,f25},
							            {"0","0",f33,f34,f35},
							            {"0","0","0",f44,f45},
							            {"0","0","0","0",f55}};
						
						AHPwork mb6=new AHPwork();
						double[] second6=mb6.strtodouble(A16);
						
						//�Ƽ���ϵ
					    String g11=request.getParameter("g11");
						String g12=request.getParameter("g12");
						String g13=request.getParameter("g13");
						
						
						String g22=request.getParameter("g22");
						String g23=request.getParameter("g23");
				
					
						String g33=request.getParameter("g33");
						
						
						
						String[][] A17={{g11,g12,g13},
							            {"0",g22,g23},
							            {"0","0",g33}};
						
						AHPwork mb7=new AHPwork();
						double[] second7=mb7.strtodouble(A17);
						
						//����ˮƽ
					    String h11=request.getParameter("h11");
						String h12=request.getParameter("h12");
						
						
						String h22=request.getParameter("h22");
	
						
						String[][] A18={{h11,h12},
							            {"0",h22}};
						
						AHPwork mb8=new AHPwork();
						double[] second8=mb8.strtodouble(A18);
						
						//���ó�����Ȩ�ش浽���ݿ���У���ӵ�������С�
						demandService.updataDemandahp(demandID,
								second1[0]*first[0],second1[1]*first[0],second1[2]*first[0],second1[3]*first[0],
								second2[0]*first[1],second2[1]*first[1],second2[2]*first[1],second2[3]*first[1],
								second3[0]*first[2],second3[1]*first[2],second3[2]*first[2],
								second4[0]*first[3],second4[1]*first[3],second4[2]*first[3],
                                second5[0]*first[4],second5[1]*first[4],second5[2]*first[4],
                                second6[0]*first[5],second6[1]*first[5],second6[2]*first[5],second6[3]*first[5],second6[4]*first[5],
                                second7[0]*first[6],second7[1]*first[6],second7[2]*first[6],
                                second8[0]*first[7],second8[1]*first[7]);
						
						
//			������ͼ���󣬲�����ͼ���������ͼ
			ModelAndView ma = new ModelAndView();	
			
			//�����ܷ֣���������Ƶ�����һ������
			AHPwork mb9=new AHPwork();
			mb9.result(demandID,demandName,demandType);
		
//			������ͼ����
			ma.setViewName("/addDemand");
			ma.addObject("userID", userID);
			ma.addObject("demandID", demandID);
			ma.addObject("demandType", demandType);
			ma.addObject("demandName", demandName);
//			������ͼ
			return ma;
		}


	@RequestMapping(value="/addservicescore")
	public ModelAndView addServiceScore(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,
			String serviceID,String serviceName,String serviceNum,String delitime,String serviceType,
			String passrate,String Lprice,String Hprice,String confde,String credit,String retime,
			String flexi,String returnser,String samspeed,String carriage,
			String qhege, String qbaotui,String qtixi,String qyunfuwu,
			String csheji ,String ccaigou ,String cyunshu ,String cliyong,
			String fzhonglei ,String fshijian ,String fshuliang,
			String itouru ,String iyun ,String ijibie,
			String pjiaohuo,String  pmanyi ,String pzhanyou,
			String fshouyi ,String fzichan ,String flirun ,String fxiaosou,String  fchanchu,
			String tkaifa ,String tshouru ,String  trenyuan,
			String exunhuan ,String enengyuan)throws Exception{
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		�ж�ǰ̨�ύ�����Ƿ�Ϊ��
		if(serviceID==null){
//			���ǰ̨����ؼ����ݣ����û�������д
			ma.setViewName("/addFirmServiceScore");
			ma.addObject("error", "���������Ϣ����Ϊ��");
			ma.addObject("userID", userID);

//			������ͼ
			return ma;
		}else {
			
		
//		����Service�е�addFirmService ��ӷ���
			
		System.out.print("");


//		����ͼ��Ӳ���
		ma.addObject("userID", userID);
		ma.addObject("serviceName", serviceName);
		ma.addObject("serviceNum", serviceNum);
		ma.addObject("delitime", delitime);
		ma.addObject("passrate", passrate);
		ma.addObject("credit", credit);
//		������ͼ����
		ma.setViewName("/firmservice");
//		������ͼ
		return ma;
		}	
	}
	
	@RequestMapping(value="/listhelp")
	public ModelAndView listhelp(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID) {		
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();	
//		����ͼ��Ӳ���
		ma.addObject("userID", userID);	
//		������ͼ����
		ma.setViewName("/help");
//		������ͼ
		return ma;
		}
	
}
