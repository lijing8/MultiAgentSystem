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

<title>需求详情</title>

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
						 
						<form action="http://localhost:8080/MultiAgentSystem/information/listdemand?userID=${userID }"
							class="form-horizontal" method="post" role="form">
							
							<div class="control-group">
								<label class="control-label" >需求ID</label>
								<div class="controls">
									<input type="text" value="${demandlist.demandID}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >产品名称</label>
								<div class="controls">
									<input name="demandName" type="text" value="${demandlist.demandName}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">产品数量</label>
								<div class="controls">
									<input name="demandNum" type="text" value="${demandlist.demandNum}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >交货期</label>
								<div class="controls">
									<input name="delitime" type="text" value="${demandlist.delitime}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >产品型号</label>
								<div class="controls">
									<input name="demandType" type="text"  value="${demandlist.demandType}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >产品合格率</label>
								<div class="controls">
									<input name="passrate" type="text" value="${demandlist.passrate}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >价格左</label>
								<div class="control-group">
									<div class="controls">
										¥<input name="Lprice" type="text" value="${demandlist.LPrice}"/>.00
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >价格右</label>
								<div class="control-group">
									<div class="controls">
										¥<input name="Hprice" type="text" value="${demandlist.HPrice}"/>.00
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >可靠程度</label>
								<div class="controls">
									<select class="form-control" name="confde">
									    <option>${demandlist.confde}</option>
										</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >信誉度</label>
								<div class="controls">
									<select class="form-control" name="credit">
									<option>${demandlist.credit}</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">响应时间</label>
								<div class="controls">
									<select class="form-control" name="retime">
									<option>${demandlist.retime}</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >生产灵活度</label>
								<div class="controls">
									<select class="form-control" name="flexi">
									<option>${demandlist.flexi}</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >退货服务</label>
								<div class="controls">
									<select class="form-control" name="returnser">
									<option>${demandlist.returnSer}</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >送样速度</label>
								<div class="controls">
									<select class="form-control" name="samspeed">
									<option>${demandlist.samSpeed}</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" >是否承担运费</label>
								<div class="controls">
									<select class="form-control" name="carriage">
									<option>${demandlist.carriage}</option>
									</select>
								</div>
							</div>
							
				<!--  <table class="table table-striped table-bordered">
                 <thead>
                    <tr>
                    <td width="70">质量权重</td>
                    <td width="70">价格权重</td>
                    <td width="70">柔性权重</td>
                  
                    <td width="70">伙伴关系权重</td>
                    <td width="70">财务能力权重</td>
                    <td width="70">科技水平权重</td>
                  
                  
                    </tr> 
                 </thead>
                 <tbody>
                    <tr>
                    <td width="70">${demandlist.quality}</td>
                    <td width="70">${demandlist.price}</td>
                    <td width="70">${demandlist.flexibilitynum}</td>
                    <td width="70">${demandlist.parenter}</td>
                    <td width="70">${demandlist.finance}</td>
                    <td width="70">${demandlist.technology}</td>
              
                 
                    </tr>
                  </tbody>
                  
              </table> -->

							
							<div class="control-group">
								<div class="controls">
									<input class="btn btn-primary btn-sm" type="submit" value="返回" />
									
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