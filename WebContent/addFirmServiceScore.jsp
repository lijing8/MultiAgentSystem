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

<title>资源添加</title>

<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link
	href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css"
	rel="stylesheet" media="screen">
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	
</head>
<body>
     <div class="container-fluid">
         <!--第一行 header-->
			<div class="row">
				<%@ include file="header.jsp"%>
			</div>
	 
	  <div class="row" id="main-part">
		     <!--左侧 导航-->
		     <c items="${userID }" var="userID"></c>
		     <c items="${serviceID}" var="serviceID"></c>
			    <div class="col-xs-2">
					<%@ include file="leftnav.jsp"%>
				</div>
		  
		  <div class="col-xs-9">
			<div class="span12">
				<div class="page-header">
					<ul class="breadcrumb" style="margin-bottom: 5px;">  
                        <li><a href="#">企业信息管理</a> <span class="divider">/</span></li>  
                        <li><a href="#">企业资源管理</a> <span class="divider">/</span></li>  
                        <li class="active">企业资源信息添加</li>  
                     </ul>  
				</div>
				<div class="row-fluid">
					<div class="span2"></div>
					<div class="span8">
						<form action="http://localhost:8080/MultiAgentSystem/information/addservicescore?userID=${userID }"
							class="form-horizontal" method="post" role="form">
							<div class="control-group">
								<label class="control-label" for="serviceID">产品编号</label> 
								<div class="controls">
									<input name="serviceID" type="text" value="${serviceID}" />
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" >质量指标</label>
								<div class="controls">
									产品合格率分数:&nbsp;&nbsp;&nbsp;年产品生产数<input name="qshengchan" type="text" /> 年合格产品数<input name="qhege" type="text" />
									
								</div>
								<div class="controls">
									报修退货率分数<input name="qbaotui" type="text" />年产品销售数<input name="qxiaoshou" type="text" /> 年产品保修退货数<input name="qbaotui" type="text" />
									
								</div>
								<div class="controls">
									全程质量体系分数<input name="qtixi" type="text" />1——100分
									
								</div>
								<div class="controls">
								        云服务质量分数<input name="qyunfuwu" type="text" />云平台可提供的资源数<input name="qyunfuwu" type="text" />企业一次需要的资源数<input name="qyunfuwu" type="text" />
									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >成本指标</label>
								<div class="controls">
									设计成本比重分数<input name="csheji" type="text" />总成本<input name="csheji" type="text" />设计成本<input name="csheji" type="text" />
									
								</div>
								<div class="controls">
									采购成本比重分数<input name="ccaigou" type="text" />总成本<input name="ccaigou" type="text" />采购成本<input name="ccaigou" type="text" />
									
								</div>
								<div class="controls">
									运输成本比重分数<input name="cyunshu" type="text" />总成本<input name="cyunshu" type="text" />运输成本<input name="cyunshu" type="text" />
									
								</div>
								<div class="controls">
								          成本利用率分数<input name="cliyong" type="text" />总成本<input name="cliyong" type="text" />净利润<input name="cliyong" type="text" />
									
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" >柔性指标</label>
								<div class="controls">
									产品品种柔性分数<input name="fzhonglei" type="text" />产品种类总数<input name="fzhonglei" type="text" />新品种种类数<input name="fzhonglei" type="text" />
									
								</div>
								<div class="controls">
									时间柔性分数<input name="fshijian" type="text" />松弛时间<input name="fzhonglei" type="text" />总交货时间<input name="fzhonglei" type="text" />
									
								</div>
								<div class="controls">
									产品数量柔性分数<input name="fshuliang" type="text" />产品数量<input name="fzhonglei" type="text" />市场需求总数<input name="fzhonglei" type="text" />
									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >信息化水平</label>
								<div class="controls">
									信息技术投入分数<input name="itouru" type="text" />信息建设费用<input name="itouru" type="text" />销售额<input name="itouru" type="text" />
								
								</div>
								<div class="controls">
									云平台投入率分数<input name="iyun" type="text" />云平台费用<input name="itouru" type="text" />销售额<input name="itouru" type="text" />
									
								</div>
								<div class="controls">
									信息化级别分数<input name="ijibie" type="text" /><input name="itouru" type="text" />
									
								</div>
								
							</div>
							<div class="control-group">
								<label class="control-label" >伙伴关系</label>
								<div class="controls">
									准时交货率分数<input name="pjiaohuo" type="text" />总交货次数<input name="pjiaohuo" type="text" />准时交货次数<input name="pjiaohuo" type="text" />
									
								</div>
								
								<div class="controls">
									客户满意率分数<input name="pmanyi" type="text" />总交货次数<input name="pjiaohuo" type="text" />满意订单数<input name="pjiaohuo" type="text" />
								</div>
								<div class="controls">
									市场占有率分数<input name="pzhanyou" type="text" />市场同种产品总<input name="pjiaohuo" type="text" />本供应链产品<input name="pjiaohuo" type="text" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >财务能力</label>
								<div class="controls">
									资本收益率分数<input name="fshouyi" type="text" />资产占用额<input name="fshouyi" type="text" />利润总额<input name="fshouyi" type="text" />
		
								</div>
								<div class="controls">
									净资产利用率分数<input name="fzichan" type="text" />平均净资产<input name="fshouyi" type="text" />净资产<input name="fshouyi" type="text" />
									
								</div>
								<div class="controls">
									利润增长率分数<input name="flirun" type="text" />上期利润<input name="fshouyi" type="text" />上下两期利润之差<input name="fshouyi" type="text" />
									
								</div>
								<div class="controls">
									销售增长率分数<input name="fxiaosou" type="text" />上期销售之差<input name="fshouyi" type="text" />上下两期销售之差<input name="fshouyi" type="text" />
									
								</div>
								<div class="controls">
									投入产出比分数<input name="fchanchu" type="text" />销售额<input name="fshouyi" type="text" />投入成本<input name="fshouyi" type="text" />
									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >科技水平</label>
								<div class="controls">
									研究开发投资率分数<input name="tkaifa" type="text" />销售额<input name="tkaifa" type="text" />研究开发费用<input name="tkaifa" type="text" />
								</div>
								<div class="controls">
									新产品收入比率分数<input name="tshouru" type="text" /><input name="tshouru" type="text" /><input name="tshouru" type="text" />
									
								</div>
								<div class="controls">
									
									科技开发人员比率分数<input name="trenyuan" type="text" /><input name="tshouru" type="text" /><input name="tshouru" type="text" />
								</div>
								
							</div>
							<div class="control-group">
								<label class="control-label" >环保水平</label>
								<div class="controls">
									再循环资料利用率分数<input name="exunhuan" type="text" />废弃物量<input name="exunhuan" type="text" />同期回收利用量<input name="exunhuan" type="text" />
								</div>
								<div class="controls">
								
									能源消耗率分数<input name="enengyuan" type="text" />同期能源消耗量<input name="exunhuan" type="text" />产量<input name="exunhuan" type="text" />
									
								</div>
								
								
							</div>
							<div class="control-group">
								<div class="controls">
									<input class="btn btn-primary btn-sm"  type="submit" value="添加" />
									<input class="btn btn-primary btn-sm"  type="reset" />
								</div>
							</div>
						</form>
					</div>
					<div class="span2"></div>
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