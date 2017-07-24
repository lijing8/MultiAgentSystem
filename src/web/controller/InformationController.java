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
 * 此类为仿真信息管理Controller类,用注解@Controller 来标识该类是MVC架构中的控制类。
 * 访问路径用@RequestMapping(value="/information")来进行设置说明
 * @author hanyuping
 *
 */

@Controller
@RequestMapping(value="/information")
public class InformationController {
//	用注解来声明自定义ResultService类对象，自动将该类实例化
	@Autowired
	private ResultService rsService;
//	自定义DemandService类对象
	@Autowired
	private DemandService demandService;
//	自定义FirmService类对象
	@Autowired
	private FirmService firmService;
//	自定义AgentCommService类对象
	@Autowired
	private AgentCommService agentCommService;
//	自定义FirmServiceService类对象
	@Autowired
	private FirmServiceService firmServiceService;
	@Autowired
	private FirmServiceAHPService firmServiceAHPService;
	@Autowired
	private FirmServiceResultService firmServiceResultService;

//	JSP访问的过程中的错误页面，访问路径@RequestMapping(value="/error")来设置
	@RequestMapping(value="/error")
	public ModelAndView getindex( ) {		

//声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
		
		ma.setViewName("/error");
		
		return ma;
	}
	

	/**
	 * 	转向仿真页面，访问路径为	@RequestMapping(value="/simulationmain")
	 * @param request 页面请求对象
	 * @param userID 页面传入的参数
	 * @return 返回一个
	 */
	@RequestMapping(value="/simulationmain")
	public ModelAndView gotosimulation(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID) {		

//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		向视图添加参数
		ma.addObject("userID", userID);
//		设置视图
		ma.setViewName("/simulationmain");
//		返回视图
		return ma;
	}
	/**
	 * 获取仿真所有结果，访问路径为	@RequestMapping(value="/getresult")
	 * @param request 页面请求对象
	 * @param userID 页面传入的参数
	 * @return 返回一个
	 */
	
	@RequestMapping(value="/getresult")
	public ModelAndView getAllResult(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID) {		
//		定义ResultEntity对象列表，调用Service函数获取结果列表
		List<ResultEntity> rs = rsService.getAllResult();
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		向视图添加参数
		ma.addObject("userID", userID);
//		设置视图对象
		ma.setViewName("/result");
//		向视图添加结果集参数
		ma.addObject("result", rs);
//		返回视图
		return ma;
	}
/**
 * 获取当前仿真结果，访问路径为	@RequestMapping(value="/getthisresult")
 * @param request 页面请求对象
 * @param userID 页面传入的参数
 * @param demandID 页面传入的参数
 * @return 返回视图
 */
	@RequestMapping(value="/getthisresult")
	public ModelAndView getResult(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,
			@RequestParam(value="demandID" ,required=false)String demandID) {		
//		定义ResultEntity对象列表，调用Service函数获取结果列表
		List<ResultEntity> rs = rsService.getResultBySimID(demandID);
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();	
//		向视图添加参数
		ma.addObject("userID", userID);	
//		向视图添加参数
		ma.addObject("demandID", demandID);
//		向视图添加结果集参数
		ma.addObject("result", rs);
//		设置视图对象
		ma.setViewName("/result");
//		返回视图
		return ma;
	}

	
	/**
	 * 获取agent交互信息，访问路径为	@RequestMapping(value="/getallagentinformation")
	 * @param request 页面请求对象
	 * @param userID 页面传入的参数
	 * @return 返回一个视图
	 */
	@RequestMapping(value="/getallagentinformation")
	public ModelAndView getAllAgentComm(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID) {
//		定义AgentCommEntity对象列表，调用Service函数获取交互列表
		List<AgentCommEntity> agentComunicationlist = agentCommService.getAllAgentComm();
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		向视图添加参数
		ma.addObject("userID", userID);
//		设置视图对象
		ma.setViewName("/allagentinformation");
//		向视图添加仿真交互集参数
		ma.addObject("result", agentComunicationlist);
//		返回视图
		return ma;
	}
	
	


	/**
	 * 	用户输入需求，访问路径为	@RequestMapping(value="/toadddemand")
	 * @param request 页面请求
	 * @param userID 请求参数
	 * @return 返回视图
	 */
	@RequestMapping(value="/toadddemand")
	public ModelAndView toadddemand(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		向视图添加参数
		ma.addObject("userID", userID);
//		设置视图对象
		ma.setViewName("/addDemandScore");
//		返回视图
		return ma;
	}
	
	/**
	 * //添加需求 访问路径为	@RequestMapping(value="/listdemand")
	 * @param request 页面请求
	 * @return 返回视图
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
	 * //添加需求 访问路径为	@RequestMapping(value="/listonedemand")
	 * @param request 页面请求
	 * @return 返回视图
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
	 * //添加需求 访问路径为	@RequestMapping(value="/adddemand")
	 * @param request 页面请求
	 * @param userID 页面参数，用户ID
	 * @param demandID 页面参数，需求ID
	 * @param demandName 页面参数，需求名称
	 * @param demandNum 页面参数，需求数量
	 * @param delitime 页面参数，交货期
	 * @param demandType 页面参数，需求类型
	 * @param passrate 页面参数，合格率
	 * @param Lprice 页面参数，价格左
	 * @param Hprice 页面参数，价格右
	 * @param confde 页面参数，可信度
	 * @param credit 页面参数，信誉度
	 * @param retime 页面参数，返厂率
	 * @param flexi 页面参数，灵活性
	 * @param returnser 页面参数，退回服务
	 * @param samspeed 页面参数，送样速度
	 * @param carriage 页面参数，运费服务
	 * @return 返回视图
	 * @throws Exception
	 */
	@RequestMapping(value="/adddemand")
	public ModelAndView addDemand(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,
			String demandID,String demandName,String demandNum,String delitime,String demandType,
			String passrate,String Lprice,String Hprice,String confde,
			String credit,String retime,String flexi,String returnser,String samspeed,
			String carriage)throws Exception{
		//,@RequestParam(value="userID", required=false)String userID
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
		AHPwork mb=new AHPwork();
		
		 
		 
//		判断前台提交数据是否为空
		if(demandID==null || demandName.trim().length()==0){
//			清空前台界面控件内容，让用户重新填写
			ma.setViewName("/addDemand");
			ma.addObject("error", "需求基本信息不能为空");
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
//			返回视图
			return ma;
		}else {
			
		
//		调用Service中的addDemand 添加需求
		Boolean addBoolean=demandService.updateDemandbyid( demandID,demandName, demandType, demandNum, delitime, passrate,
				Lprice, Hprice, confde,credit, retime, flexi,samspeed, returnser, carriage);
//		判断是否添加成功
		if (addBoolean) {
//			添加成功
			//激活sell Agent向云发送消息
//			声明DemandEntity对象
			DemandEntity demandEntity=new DemandEntity();
//			为DemandEntity成员变量赋值
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
//			声明DemandEntity数组
			DemandEntity []demandEntity2=new DemandEntity[1];
//			项数组中添加元素
			demandEntity2[0]=demandEntity;
//			声明AgentStarter对象，启动DemandAgent
			AgentStarter agentStarter=new AgentStarter();
//			调用AgentStarter方法，启动DemandAgent，并向DemandAgent传递参数
			String localip;
			InetAddress ia=null;
			ia=ia.getLocalHost();		
			localip=ia.getHostAddress();
			agentStarter.startAgent(localip, "1099", "DemandAgent", "multiagent.agents.DemandAgent", demandEntity2);
		}
//		向视图添加参数
		ma.addObject("demandID", demandID);
//		向视图添加参数
		ma.addObject("userID", userID);
//		设置视图对象
		ma.setViewName("/bufferdemand");
//		返回视图
		return ma;
		}
	}

	
	/**
	 * 此类为仿真信息管理Controller类,用注解@Controller 来标识该类是MVC架构中的控制类。
	 * 访问路径用@RequestMapping(value="/evaluate")来进行设置说明
	 * @author lijing
	 *
	 */

	//服务发现计算成功
	@RequestMapping(value="/caldemand")
	public ModelAndView caldemand(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,@RequestParam(value="demandID" ,required=false)String demandID){
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		向视图添加参数
		ma.addObject("demandID", demandID);
//		向视图添加参数
		ma.addObject("userID", userID);
//		设置视图对象
		ma.setViewName("/demand");
//		返回视图
		return ma;
	}
	
	@RequestMapping(value="/toaddservice")
	public ModelAndView toaddservice(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		向视图添加参数
		
		 Date  now  =  new   Date();     
	     SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期式     
	     String  str= dateFormat.format(now);   
	     String serviceID = str.trim().replaceAll(":", "").replaceAll("-","").replaceAll(" ","");
	     serviceID=serviceID.substring(serviceID.length()-8,serviceID.length());
	     serviceID="Product"+serviceID;
	     System.out.println(serviceID);
		ma.addObject("userID", userID);
		ma.addObject("serviceID", serviceID);
//		设置视图对象
		ma.setViewName("/addFirmService");
//		返回视图
		return ma;
	}
	
	@RequestMapping(value="/toaddevaluate")
	public ModelAndView toaddevaluate(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		向视图添加参数
		ma.addObject("userID", userID);
//		设置视图对象
		ma.setViewName("/addevaluate");
//		返回视图
		return ma;
	}
	
	
	/**
	 * //添加需求 访问路径为	@RequestMapping(value="/addservice")
	 * @param request 页面请求
	 * @param userID 页面参数，用户ID
	 * @param demandID 页面参数，需求ID
	 * @param demandName 页面参数，需求名称
	 * @param demandNum 页面参数，需求数量
	 * @param delitime 页面参数，交货期
	 * @param demandType 页面参数，需求类型
	 * @param passrate 页面参数，合格率
	 * @param Lprice 页面参数，价格左
	 * @param Hprice 页面参数，价格右
	 * @param confde 页面参数，可信度
	 * @param credit 页面参数，信誉度
	 * @param retime 页面参数，返厂率
	 * @param flexi 页面参数，灵活性
	 * @param returnser 页面参数，退回服务
	 * @param samspeed 页面参数，送样速度
	 * @param carriage 页面参数，运费服务
	 * @return 返回视图
	 * @throws Exception
	 */
	
	@RequestMapping(value="/toaddindex")
	public ModelAndView toaddindex(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		向视图添加参数
		ma.addObject("userID", userID);
//		设置视图对象
		ma.setViewName("/addindex");
//		返回视图
		return ma;
	}
	
	
	@RequestMapping(value="/addindex")
	public ModelAndView addIndex(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,
			String serviceID){
		String serviceName=request.getParameter("serviceName");
		
		
		//产品质量，还差质量体系没有量化
		String qshengchan=request.getParameter("qshengchan");
		String qhege=request.getParameter("qhege");
		String qxiaoshou=request .getParameter("qxiaoshou");
		String qbaotui=request.getParameter("qbaotui");
		String qtixi=request.getParameter("qtixi");
		
		//这两个也是需要从系统中查出来的
//		String qyunfuwu=request.getParameter("qyunfuwu");
//		String qyunfuwuneed=request.getParameter("qyunfuwuneed");
		double  qyunfuwu1=firmServiceAHPService.getyunfuwu();
		System.out.println(qyunfuwu1);
		double qyunfuwuneed1=firmServiceAHPService.getyunfuwuneed(request.getParameter("firmID"));
		System.out.println(qyunfuwuneed1);
		
		
		double qhegerate=Double.parseDouble(qhege)/Double.parseDouble(qshengchan)*100;//产品合格率
		double qbaotuirate=(1-Double.parseDouble(qbaotui)/Double.parseDouble(qxiaoshou))*100;//报修退货率
		double qyunfuwurate=(qyunfuwuneed1/qyunfuwu1)*100+50;//云服务质量
		double qtixirate=0;//质量服务体系
		if(qtixi.equals("ISO/TS16949质量体系")){
			qtixirate=100;
		}else{
			qtixirate=80;
		}
		//成本
		String csheji=request.getParameter("csheji");
		String ccaigou=request.getParameter("ccaigou");
		String cyunshu=request .getParameter("cyunshu");
		String clirun=request .getParameter("clirun");
		String ctotal=request.getParameter("ctotal");
		
		double cshejirate=Double.parseDouble(csheji)/Double.parseDouble(ctotal)*100+40;//设计成本比重
		double ccaigourate=(1-Double.parseDouble(ccaigou)/Double.parseDouble(ctotal))*100;//采购成本比重
		double cyunshurate=(1-Double.parseDouble(cyunshu)/Double.parseDouble(ctotal))*100;//运输成本比重
		double cliyongrate=Double.parseDouble(clirun)/Double.parseDouble(ctotal)*100+40;//成本利用率
		
		//柔性
		String fzhonglei=request.getParameter("fzhonglei");
		String fnewzhonglei=request.getParameter("fnewzhonglei");
		String fsongshijian=request .getParameter("fsongshijian");
		String fshijian=request .getParameter("fshijian");
		double fshulaingneed1=firmServiceAHPService.getshuliangneed(serviceName);
		System.out.println(fshulaingneed1);
		
		double fzhongleirate=Double.parseDouble(fnewzhonglei)/Double.parseDouble(fzhonglei)*100+40;//种类柔性
		double fshijianrate=Double.parseDouble(fsongshijian)/Double.parseDouble(fshijian)*100+50;//时间柔性
		double fneed=firmServiceAHPService.getallneed(serviceName);
		System.out.println(fneed);
		double fshuliangrate=Double.parseDouble(qshengchan)/fneed*100+50;//数量柔性
		
		//信息化水平  云级别还没有处理
		String ixiaoshou=request.getParameter("ixiaoshou");
		String itouru=request.getParameter("itouru");
		String iyun=request .getParameter("iyun");
		String ijibie=request .getParameter("ijibie");
		
	
		
		double itoururate=Double.parseDouble(itouru)/Double.parseDouble(ixiaoshou)*100+50;//信息技术投入率
		double iyunrate=Double.parseDouble(iyun)/Double.parseDouble(ixiaoshou)*100+50;//		云平台投入率
		double ijibierate=0;//		信息化级别
		if(ijibie.equals("一级企业")){
			ijibierate=95;
		}else if(ijibie.equals("二级企业")){
			ijibierate=80;
		}
		else if(ijibie.equals("三级企业")){
			ijibierate=60;
		}
		else{
			ijibierate=50;
		}
		//伙伴关系
		
		String pjiaohuo=request.getParameter("pjiaohuo");
		String pzhunshi=request.getParameter("pzhunshi");
		String pmanyi=request .getParameter("pmanyi");
	
		
		double pjiaohuorate=Double.parseDouble(pzhunshi)/Double.parseDouble(pjiaohuo)*100;//准时交货率
		double pmanyirate=Double.parseDouble(pmanyi)/Double.parseDouble(pjiaohuo)*100;//订单满意率
		double  pzhanyourate=Double.parseDouble(qshengchan)/fshulaingneed1+50;//市场占有率	
		
		//财务能力
		String fzhanyong=request.getParameter("fzhanyong");
		String fpingzichan=request.getParameter("fpingzichan");
		String fzichan=request .getParameter("fzichan");
		String fshanglirun=request .getParameter("fshanglirun");
		String fliruncha=request .getParameter("fliruncha");
		String fshangxiaoshou=request .getParameter("fshangxiaoshou");
		String fxiaoshoucha=request .getParameter("fxiaoshoucha");
		
		
		double fshouyirate=Double.parseDouble(clirun)/Double.parseDouble(fzhanyong)*100+50;//资本收益率
		double fzichanrate=Double.parseDouble(fzichan)/Double.parseDouble(fpingzichan)*100+50;//净资产利用率
		double  flirunrate=Double.parseDouble(fliruncha)/Double.parseDouble(fshanglirun)*100+50;//利润增长率
		double fxiaoshourate=Double.parseDouble(fxiaoshoucha)/Double.parseDouble(fshangxiaoshou)*100+50;//销售增长率
		double  fchanchurate=(1-Double.parseDouble(ctotal)/Double.parseDouble(ixiaoshou))*100+60;//投入产出比

		
		//科技
		String tkaifa=request.getParameter("tkaifa");
		String tnewshouru=request.getParameter("tnewshouru");
		String tkejiren=request .getParameter("tkejiren");
		String ttotalren=request .getParameter("ttotalren");
		
		double tkaifarate=Double.parseDouble(tkaifa)/Double.parseDouble(ixiaoshou)*100+50;//研究开发投资率
		double tshoururate=Double.parseDouble(tnewshouru)/Double.parseDouble(ixiaoshou)*100+50;//新产品收入比率
		double  trenyuanrate=Double.parseDouble(tkejiren)/Double.parseDouble(ttotalren)*100+50;//科技开发人员比率
		
		//环保
		
		String ehuishou=request.getParameter("ehuishou");
		String etouru=request .getParameter("etouru");
		
		double exunhuanrate=Double.parseDouble(ehuishou)/Double.parseDouble(qshengchan)*100+80;//再循环资料利用率
		double enengyuanraterate=Double.parseDouble(etouru)/Double.parseDouble(ixiaoshou)*100+80;//能源消耗率
		
		
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
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		判断前台提交数据是否为空
		if(serviceID==null || serviceName.trim().length()==0){
//			清空前台界面控件内容，让用户重新填写
			ma.setViewName("/addFirmService");
			ma.addObject("error", "需求基本信息不能为空");
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

//			返回视图
			return ma;
		}else {
//		调用Service中的addFirmService 添加服务
		if(firmServiceAHPService.search(FirmID,serviceName,serviceType)){
			System.out.println("更新");
			firmServiceAHPService.updatefirmService( FirmID,serviceName,serviceNum, delitime,serviceID,
					passrate,Lprice, Hprice, confde,credit, retime, flexi,returnser,samspeed,carriage, serviceType);
		}else{
			System.out.println("添加");
			firmServiceAHPService.addfirmService( FirmID,serviceName,serviceNum, delitime,serviceType,
					passrate,Lprice, Hprice, confde,credit, retime, flexi,returnser,samspeed,carriage, serviceID);
		}
		
		
//		向视图添加参数
		ma.addObject("serviceName", serviceName);
//		向视图添加参数
		ma.addObject("userID", userID);
		ma.addObject("serviceName", serviceName);
		ma.addObject("serviceID",serviceID);
		ma.addObject("firmID",FirmID);
//		设置视图对象
//		返回视图
		
		ma.setViewName("/addindex");
		return ma;
		}
	}
	
	
	/**
	 * //添加需求 访问路径为	@RequestMapping(value="/listservice")
	 * @param request 页面请求
	 * @return 返回视图
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
	 * 修改用户数据 ，通过@RequestMapping("/getAllEditUser")设置访问路径
	 * @param request 页面请求
	 * @param userID 用户ID
	 * @return 返回视图
	 */
	@RequestMapping("/getAllfirm")
	public ModelAndView getAllEditUser(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		
//		声明视图对象，并对视图对象添加视图
		ModelAndView mav = new ModelAndView();
//		向视图添加参数
		mav.addObject("userlist",firmService.getAllFirms());
		mav.addObject("userID", userID);
//		设置视图对象
		mav.setViewName("/firmList");
		return mav;
	}
	/**
	 * //添加需求 访问路径为	@RequestMapping(value="/listoneservice")
	 * @param request 页面请求
	 * @return 返回视图
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
	 * 此类为仿真信息管理Controller类,用注解@Controller 来标识该类是MVC架构中的控制类。
	 * 访问路径用@RequestMapping(value="/evaluateresult")来进行设置说明
	 * 用来进行查询粗选的结果
	 * @author lijing
	 *
	 */

	@RequestMapping(value="/evaluateresult")
	public ModelAndView getevaluateResult(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID,
			@RequestParam(value="demandID" ,required=false)String demandID) {		
//		定义FirmServiceEntityResult对象列表，调用Service函数获取结果列表
		List<FirmServiceEntityResult> rss = firmServiceResultService.getResultBydemandID(demandID);

//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();	
//		向视图添加参数
		ma.addObject("userID", userID);	
//		向视图添加参数
		ma.addObject("demandID", demandID);
//		向视图添加结果集参数
		ma.addObject("result", rss);
//		设置视图对象
		ma.setViewName("/evaluateResult");
//		返回视图
		return ma;
	}
	
	@RequestMapping(value="/start")
	public ModelAndView startcloud(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID) {		

		//在Controller中启动云和agent
				Start start= new Start();
				try {
					start.allstart();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();	
//		向视图添加参数
		ma.addObject("userID", userID);	
//		设置视图对象
		ma.setViewName("/simulationmain");
//		返回视图
		return ma;
		}
	

	
	@RequestMapping(value="/generateID")
	public void valiateName(HttpServletRequest request,HttpServletResponse response) throws IOException, StaleProxyException {		
		 Date  now  =  new   Date();     
	        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期式     
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
				result="<font color='green'>资源不存在</font>";
				
			}else{
				
				result="<font color='red'>资源存在</font>";
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
				result="<font color='red'>资源不存在</font>";
				
			}else{
				
				result="<font color='green'>资源存在</font>";
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
			
			//AHP计算		
	        String indexname[]={"质量","成本","柔性","信息化","伙伴关系","财务能力","科技水平","环保水平"};
			
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
			 //价格
			 
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
				
		//成本
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
			
					//柔性
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
				
						//信息化
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
						
						//伙伴关系
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
			
						//财务
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
						
						//科技关系
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
						
						//环保水平
					    String h11=request.getParameter("h11");
						String h12=request.getParameter("h12");
						
						
						String h22=request.getParameter("h22");
	
						
						String[][] A18={{h11,h12},
							            {"0",h22}};
						
						AHPwork mb8=new AHPwork();
						double[] second8=mb8.strtodouble(A18);
						
						//将得出来的权重存到数据库库中，添加到需求表中。
						demandService.updataDemandahp(demandID,
								second1[0]*first[0],second1[1]*first[0],second1[2]*first[0],second1[3]*first[0],
								second2[0]*first[1],second2[1]*first[1],second2[2]*first[1],second2[3]*first[1],
								second3[0]*first[2],second3[1]*first[2],second3[2]*first[2],
								second4[0]*first[3],second4[1]*first[3],second4[2]*first[3],
                                second5[0]*first[4],second5[1]*first[4],second5[2]*first[4],
                                second6[0]*first[5],second6[1]*first[5],second6[2]*first[5],second6[3]*first[5],second6[4]*first[5],
                                second7[0]*first[6],second7[1]*first[6],second7[2]*first[6],
                                second8[0]*first[7],second8[1]*first[7]);
						
						
//			声明视图对象，并对视图对象添加视图
			ModelAndView ma = new ModelAndView();	
			
			//计算总分，将结果复制到另外一个表中
			AHPwork mb9=new AHPwork();
			mb9.result(demandID,demandName,demandType);
		
//			设置视图对象
			ma.setViewName("/addDemand");
			ma.addObject("userID", userID);
			ma.addObject("demandID", demandID);
			ma.addObject("demandType", demandType);
			ma.addObject("demandName", demandName);
//			返回视图
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
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		判断前台提交数据是否为空
		if(serviceID==null){
//			清空前台界面控件内容，让用户重新填写
			ma.setViewName("/addFirmServiceScore");
			ma.addObject("error", "需求基本信息不能为空");
			ma.addObject("userID", userID);

//			返回视图
			return ma;
		}else {
			
		
//		调用Service中的addFirmService 添加服务
			
		System.out.print("");


//		向视图添加参数
		ma.addObject("userID", userID);
		ma.addObject("serviceName", serviceName);
		ma.addObject("serviceNum", serviceNum);
		ma.addObject("delitime", delitime);
		ma.addObject("passrate", passrate);
		ma.addObject("credit", credit);
//		设置视图对象
		ma.setViewName("/firmservice");
//		返回视图
		return ma;
		}	
	}
	
	@RequestMapping(value="/listhelp")
	public ModelAndView listhelp(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID) {		
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();	
//		向视图添加参数
		ma.addObject("userID", userID);	
//		设置视图对象
		ma.setViewName("/help");
//		返回视图
		return ma;
		}
	
}
