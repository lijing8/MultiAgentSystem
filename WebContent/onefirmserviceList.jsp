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

<title>资源详情</title>

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
	      <div class="row" id="main-part" >
	         <!--左侧 导航-->
	         <c items="${userID }" var="userID"></c>
			    <div class="col-xs-2">
					<%@ include file="leftnav.jsp"%>
				</div>
		     
		      <div class="col-xs-9">
			    <div class="span12">
				<div class="page-header">
					  <ul class="breadcrumb" style="margin-bottom: 5px;">  
                        <li><a href="#">企业信息管理</a> <span class="divider">/</span></li>  
                        <li><a href="#">企业需求信息管理</a> <span class="divider">/</span></li>  
                        <li class="active">企业需求信息详情</li>  
                     </ul>  
				</div>
				<div class="row-fluid">
					<div class="span2"></div>
					<div class="span8">
						 
						<form action="http://localhost:8080/MultiAgentSystem/information/listservice?userID=${userID }"
							class="form-horizontal" method="post" role="form">
							
							
							<div class="control-group">
								<label class="control-label" >产品名称</label>
								<div class="controls">
									<input name="serviceName" type="text" value="${servicelist.serviceName }"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >产品数量</label>
								<div class="controls">
									<input name="serviceNum" type="text" value="${servicelist.serviceNum}" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >交货期</label>
								<div class="controls">
									<input name="delitime" type="text" value="${servicelist.delitime }"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="serviceType">产品型号</label>
								<div class="controls">
									<input name="serviceType" type="text" value="${servicelist.serviceType }"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="passrate">产品合格率</label>
								<div class="controls">
									<input name="passrate" type="text" value="${servicelist.passrate }"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Lprice">价格左</label>
								<div class="control-group">
									<div class="controls">
										¥<input name="Lprice" type="text" value="${servicelist.LPrice }" />.00
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Lprice">价格右</label>
								<div class="control-group">
									<div class="controls">
										¥<input name="Hprice" type="text" value="${servicelist.HPrice }"/>.00
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="confde">可靠程度</label>
								<div class="controls">
									<select class="form-control" name="confde">
									<option>${servicelist.confde }</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="credit">信誉度</label>
								<div class="controls">
									<select class="form-control" name="credit">
									<option>${servicelist.credit }</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="retime">响应时间</label>
								<div class="controls">
									<select class="form-control" name="retime">
										<option>${servicelist.retime}</option>
										</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="flexi">生产灵活度</label>
								<div class="controls">
									<select class="form-control" name="flexi">
										<option>${servicelist.flexi}</option>
										</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="returnser">退货服务</label>
								<div class="controls">
									<select class="form-control" name="returnser">
									<option>${servicelist.returnSer}</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="samspeed">送样速度</label>
								<div class="controls">
									<select class="form-control" name="samspeed">
									<option>${servicelist.samSpeed}</option></select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="carriage">是否承担运费</label>
								<div class="controls">
									<select class="form-control" name="carriage">
									<option>${servicelist.carriage}</option>
									</select>
								</div>
							</div>
							<!-- 
							<div class="control-group">
								<label class="control-label" for="demandNum">产品质量分数</label>
								<div class="controls">
									<input name="quality" type="text" value="${servicelist.quality }" />
								</div>
							</div>
							
							
							<div class="control-group">
								<label class="control-label" for="demandNum">价格优势分数</label>
								<div class="controls">
									<input name="price" type="text" value="${servicelist.price }" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="demandNum">柔性分数</label>
								<div class="controls">
									<input name="flexibility" type="text" value="${servicelist.flexibilitynum}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="demandNum">伙伴关系分数</label>
								<div class="controls">
									<input name="parenter" type="text" value="${servicelist.parenter }"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="demandNum">财务水平分数</label>
								<div class="controls">
									<input name="finance" type="text" value="${servicelist.finance }"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="demandNum">科技水平分数</label>
								<div class="controls">
									<input name="technology" type="text" value="${servicelist.technology }" />
								</div>
							</div>-->
							
							<div class="control-group">
								<label class="control-label" >质量指标</label>
								<div class="controls">
									产品合格率 <input name="qhege" type="text"  value="${servicelist.qhege }" />1——100分
									
								</div>
								<div class="controls">
								          报修退货率<input name="qbaotui" type="text"  value="${servicelist.qbaotui }"/>1——100分
									
								</div>
								<div class="controls">
									全程质量体系<input name="qtixi" type="text"  value="${servicelist.qtixi }"/>1——100分
									
								</div>
								<div class="controls">
									云平台服务质量<input name="qyunfuwu" type="text"  value="${servicelist.qyunfuwu }"/>1——100分
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >成本指标</label>
								<div class="controls">
									设计成本比重分数<input name="csheji" type="text" value="${servicelist.csheji }" />1——100分
									
								</div>
								<div class="controls">
									采购成本比重分数<input name="ccaigou" type="text"  value="${servicelist.ccaigou }"/>1——100分
									
								</div>
								<div class="controls">
									运输成本比重分数<input name="cyunshu" type="text"  value="${servicelist.cyunshu }"/>1——100分
									
								</div>
								<div class="controls">
								       成本利用率分数<input name="cliyong" type="text"  value="${servicelist.cliyong }"/>1——100分
									
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" >柔性指标</label>
								<div class="controls">
									产品品种柔性分数<input name="fzhonglei" type="text"  value="${servicelist.fzhonglei }"/>1——100分
									
								</div>
								<div class="controls">
									时间柔性分数<input name="fshijian" type="text"  value="${servicelist.fshijian }"/>1——100分
									
								</div>
								<div class="controls">
									产品数量柔性分数<input name="fshuliang" type="text"  value="${servicelist.fshuliang }"/>1——100分
									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >信息化水平</label>
								<div class="controls">
									信息技术投入分数<input name="itouru" type="text"  value="${servicelist.itouru }" />1——100分
								
								</div>
								<div class="controls">
									云平台投入率分数<input name="iyun" type="text"  value="${servicelist.iyun }"/>1——100分
									
								</div>
								<div class="controls">
									信息化级别分数<input name="ijibie" type="text"  value="${servicelist.ijibie }"/>1——100分
									
								</div>
								
								
							</div>
							<div class="control-group">
								<label class="control-label" >伙伴关系</label>
								<div class="controls">
									准时交货率分数<input name="pjiaohuo" type="text"  value="${servicelist.pjiaohuo }"/>1——100分
									
								</div>
								
								<div class="controls">
									客户满意率分数<input name="pmanyi" type="text"  value="${servicelist.pmanyi }"/>1——100分
								</div>
								<div class="controls">
									市场占有率分数<input name="pzhanyou" type="text"  value="${servicelist.pzhanyou }"/>1——100分
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >财务能力</label>
								<div class="controls">
									资本收益率分数<input name="fshouyi" type="text"  value="${servicelist.fshouyi }"/>1——100分
		
								</div>
								<div class="controls">
									净资产利用率分数<input name="fzichan" type="text"  value="${servicelist.fzichan }"/>1——100分
									
								</div>
								<div class="controls">
									利润增长率分数<input name="flirun" type="text"  value="${servicelist.flirun }"/>1——100分
									
								</div>
								<div class="controls">
									销售增长率分数<input name="fxiaoshou" type="text"  value="${servicelist.fxiaosou }"/>1——100分
									
								</div>
								<div class="controls">
									投入产出比分数<input name="fchanchu" type="text"  value="${servicelist.fchanchu }" />1——100分
									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >科技水平</label>
								<div class="controls">
									研究开发投资率分数<input name="tkaifa" type="text"  value="${servicelist.tkaifa }"/>1——100分
								</div>
								<div class="controls">
									新产品收入比率分数<input name="tshouru" type="text"  value="${servicelist.tshouru }"/>1——100分
									
								</div>
								<div class="controls">
									
									科技开发人员比率分数<input name="trenyuan" type="text"  value="${servicelist.trenyuan }"/>1——100分
								</div>
								
							</div>
							<div class="control-group">
								<label class="control-label" >环保水平</label>
								<div class="controls">
									再循环资料利用率分数<input name="exunhuan" type="text"  value="${servicelist.exunhuan }"/>1——100分
									
								</div>
								<div class="controls">
									
									能源消耗率分数<input name="enengyuan" type="text"  value="${servicelist.enengyuan }"/>1——100分
								</div>
                           	<div class="control-group">
							<div class="control-group">
								<div class="controls">
									<input class="btn btn-primary btn-sm"  type="submit" value="返回" />
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