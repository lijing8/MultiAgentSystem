<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">

<title>资源指标分数添加</title>

<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link
	href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css"
	rel="stylesheet" media="screen">
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	
	<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	<script type="text/javascript">
    $(function(){
    	$(":input[name='serviceID']").change(function(){
    		var val=$(this).val();
    		val=$.trim(val);//去除空格
    		
    		if(val!=""){
    			var url="${pageContext.request.contextPath}/information/valiateserviceindex";
    			var args={"userName":val,"time":new Date()};
    			$.post(url, args, function(data){
    				$("#message").html(data);
    			});
    		}
    	});
    })


</script>
</head>
<body>
   <div class="container-fluid">
         <!--第一行 header-->
			<div class="row">
				<%@ include file="header.jsp"%>
			</div>
	      <div class="row" id="main-part" >
	         <!--左侧 导航-->
			    <div class="col-xs-2">
					<%@ include file="leftnav.jsp"%>
				</div>
		      <c items="${userID }" var="userID"></c>
		       <c items="${serviceID }" var="serviceID"></c>
		       <c items="${firmID }" var="firmID"></c>
		        <c items="${serviceName }" var="serviceName"></c>
		      <div class="col-xs-9">
		        
			    <div class="span10">
				   <div class="page-header">
					  <ul class="breadcrumb" style="margin-bottom: 5px;">  
                        <li><a href="#">企业信息管理</a> <span class="divider">/</span></li>  
                        <li><a href="#">企业资源信息管理</a> <span class="divider">/</span></li>  
                        <li class="active">企业资源指标添加</li>  
                     </ul>  
				   </div>
				<div class="row-fluid">
					 <div class="span1">
					 </div>
					 <div class="span9">
						
						<form action="http://localhost:8080/MultiAgentSystem/information/addindex?userID=${userID}&firmID=${firmID}&serviceName=${serviceName}"
							class="form-horizontal" method="post" role="form">
							
							<div class="control-group">
							  
								<label class="control-label" for="serviceID">产品编号</label>
								<div class="controls">
									<input name="serviceID" type="text" value="${serviceID}"/>	
								</div>	
								 <div class="controls" id="message">
										
								</div>
							</div>
								
				              	<div class="control-group">
								<label class="control-label" >质量指标</label>
								<div class="controls">
							
									年产品生产数
									<input name="qshengchan" type="text" />个 /年
								</div>
								<div class="controls">
							            
									年合格产品数<input name="qhege" type="text" />个 /年
								</div>
								<div class="controls">
									年产品销售数<input name="qxiaoshou" type="text" />个 /年
									
								</div>
								<div class="controls">
							                      年产品保修退货数<input name="qbaotui" type="text" />个 /年
									
								</div>
								<div class="controls">
									全程质量体系分数
					
									<div class="checkbox-inline">
                                        <label>
                                            <input type="radio" name="qtixi" id="optionsRadios1"  value="ISO/TS16949质量体系" checked>ISO/TS16949质量体系
                                         </label>
                                     </div>
                                   <div class="checkbox-inline">
                                           <label>
                                            <input type="radio" name="qtixi" id="optionsRadios2"  value="无">无
                                         </label>
                                   </div>
								</div>
                            <!-- 
								<div class="controls">
								        平台可提供的资源数<input name="qyunfuwu" type="text" />个
									
								</div>
								<div class="controls">
								   企业提供的资源数<input name="qyunfuwuneed" type="text" />个
									
								</div>
								 -->
							</div>
							
							
							<div class="control-group">
								<label class="control-label" >成本指标</label>
								<div class="controls">
									总成本<input name="ctotal" type="text" />万元/年
									
								</div>
								<div class="controls">
								        设计成本<input name="csheji" type="text" />万元/年
									
								</div>
								<div class="controls">
									采购成本<input name="ccaigou" type="text" />万元/年
									
								</div>
								<div class="controls">
									运输成本<input name="cyunshu" type="text" />万元/年
									
								</div>
								<div class="controls">
								          净利润<input name="clirun" type="text" />万元/年
									
								</div>
							</div>
							
							
							<div class="control-group">
								<label class="control-label" >柔性指标</label>
								<div class="controls">
									企业产品种类总数<input name="fzhonglei" type="text" />种
									
								</div>
								<div class="controls">
									企业新品种种类数<input name="fnewzhonglei" type="text" />种
									
								</div>
								<div class="controls">
								         松弛时间<input name="fsongshijian" type="text" />小时/季度(从完成需求到送货的时间之和)
									
								</div>
								<div class="controls">
								      总交货时间<input name="fshijian" type="text" />小时/季度(从提出需求到交货的时间之和)
									
								</div>
								
								<!--  <div class="controls">
									市场此产品需求总数<input name="fshuliangneed" type="text" />个
									
								</div>-->
							</div>
							<div class="control-group">
								<label class="control-label" >信息化水平</label>
								<div class="controls">
								          年销售额<input name="ixiaoshou" type="text" />万元/年
								
								</div>
								<div class="controls">
									年信息建设费用<input name="itouru" type="text" />万元/年     
								
								</div>
								<div class="controls">
								         年云平台使用费用<input name="iyun" type="text" />万元/年
									
								</div>
								<div class="controls">
									信息化级别分数
									<div class="checkbox">
                                        <label>
                                            <input type="radio" name="ijibie" id="optionsRadios1"  value="一级企业" checked>有信息化平台，并能很好使用
                                         </label>
                                     </div>
                                   <div class="checkbox">
                                           <label>
                                            <input type="radio" name="ijibie" id="optionsRadios2"  value="二级企业">有信息化平台，但不经常使用
                                         </label>
                                   </div>
                                   <div class="checkbox">
                                           <label>
                                            <input type="radio" name="ijibie" id="optionsRadios2"  value="三级企业">有信息化平台，但不使用
                                         </label>
                                   </div>
                                   <div class="checkbox">
                                           <label>
                                            <input type="radio" name="ijibie" id="optionsRadios2"  value="四级企业">没有信息化平台
                                         </label>
                                   </div>
								</div>
								
							</div>
								
						
							<div class="control-group">
								<label class="control-label" >伙伴关系</label>
								<div class="controls">
									总交货次数<input name="pjiaohuo" type="text" />次 /年
									
								</div>
								<div class="controls">
									准时交货次数<input name="pzhunshi" type="text" />次 /年
									
								</div>
								
								<div class="controls">
									满意订单数<input name="pmanyi" type="text" />次 /年
								</div>
								<!--  <div class="controls">
									市场同种产品数量<input name="pmarketnum" type="text" />个
								</div>
								<div class="controls">
									本供应链产品<input name="pthenum" type="text" />个
								</div>-->
							</div>
							
							<div class="control-group">
								<label class="control-label" >财务能力</label>
								<div class="controls">
								       资产占用额<input name="fzhanyong" type="text" />万元/年
		
								</div>
								
								<div class="controls">
									平均净资产<input name="fpingzichan" type="text" />万元/年
									
								</div>
								<div class="controls">
							                      净资产<input name="fzichan" type="text" />万元/年
									
								</div>
								<div class="controls">
									上期利润<input name="fshanglirun" type="text" />万元/年
									
								</div>
								<div class="controls">
									上下两期利润之差<input name="fliruncha" type="text" />万元/年
									
								</div>
								<div class="controls">
									 上期销售额<input name="fshangxiaoshou" type="text" />万元/年
									
								</div>
								<div class="controls">
									 上下两期销售之差<input name="fxiaoshoucha" type="text" />万元/年
									
								</div>
								</div>
								
								
							<div class="control-group">
								<label class="control-label" >科技水平</label>
								<div class="controls">
									研究开发费用<input name="tkaifa" type="text" />万元/年
								</div>
								<div class="controls">
									新产品销售额<input name="tnewshouru" type="text" />万元/年
									
								</div>
								<div class="controls">
									研发部门人员数量<input name="tkejiren" type="text" />位
								</div>
								<div class="controls">
									企业员工数量<input name="ttotalren" type="text" />位
								</div>
								
							</div>
							<div class="control-group">
								<label class="control-label" >环保水平</label>
								<div class="controls">
									回收产品数量<input name="ehuishou" type="text" />个 /年
								</div>
								
								<div class="controls">								
									环保投入费用<input name="etouru" type="text" />万元/年					
								</div>
							</div>
                           	<div class="control-group">
								<div class="controls">
									<input  class="btn btn-primary btn-sm" type="submit"  style="margin-left:70px;" value="提交" />
									<input class="btn btn-primary btn-sm"  type="reset" style="margin-left:140px;" value="重置" />
								</div>
							</div>
						</form>
						</div>
						
					</div>
					<div class="span1"></div>
				</div>
			</div>
		</div>
	</div>
	
	<!--第三行 foot-->
			<div class="row">			
				<%@ include file="footrow.jsp"%>
				
			</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.2.min.js"></script>

	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>