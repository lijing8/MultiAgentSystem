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
	<script type="text/javascript">
    $(function(){
    	$(":input[name='serviceID']").change(function(){
    		var val=$(this).val();
    		val=$.trim(val);//去除空格
    		
    		if(val!=""){
    			var url="${pageContext.request.contextPath}/information/valiateservice";
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
	 
	  <div class="row" id="main-part">
		     <!--左侧 导航-->
		     <c items="${userID }" var="userID"></c>
		      <c items="${serviceID }" var="serviceID"></c>
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
						<form action="http://localhost:8080/MultiAgentSystem/information/addservice?userID=${userID }"
							class="form-horizontal" method="post" role="form">
							<div class="control-group">
								<label class="control-label" for="serviceID">资源编号</label> 
								<div class="controls">
									<input name="serviceID" type="text"  value="${serviceID}"/>
								</div>
								<div class="controls" id="message">
										
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="serviceName">资源名称</label>
								<div class="controls">
									<input name="serviceName" type="text" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="serviceNum">资源数量</label>
								<div class="controls">
									<input name="serviceNum" type="text" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="delitime">交货期</label>
								<div class="controls">
									<input name="delitime" type="text" />天
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="serviceType">资源型号</label>
								<div class="controls">
									<input name="serviceType" type="text" />例如：1001032
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="passrate">产品合格率</label>
								<div class="controls">
									<input name="passrate" type="text" />%
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Lprice">最低价</label>
								<div class="control-group">
									<div class="controls">
										¥<input name="Lprice" type="text" />元
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Lprice">最高价</label>
								<div class="control-group">
									<div class="controls">
										¥<input name="Hprice" type="text" />元
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="FirmID">企业编号</label>
								<div class="controls">
									<select class="form-control" name="FirmID">
									    <option>Manul001</option>
										<option>Manul002</option>
										<option>Manul003</option>
										<option>Manul004</option>
										<option>Manul005</option>
										<option>Manul006</option>
										<option>Manul007</option>
										<option>Sell001</option>
										<option>Sell002</option>
										<option>Sell003</option>
										<option>Sell004</option>
										<option>Sell005</option>
										<option>Sell002</option>
										<option>Supply001</option>
										<option>Supply002</option>
										<option>Supply003</option>
										<option>Supply004</option>
										<option>Supply005</option>
										<option>Supply006</option>
										<option>Supply007</option>
										<option>Supply008</option>
										<option>Supply009</option>
										<option>Supply010</option>
										<option>Supply011</option>
										<option>Supply012</option>
										<option>Supply013</option>
										<option>Supply014</option>
									    <option>Supply015</option></select>


								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="confde">可靠程度</label>
								<div class="controls">
									<select class="form-control" name="confde"><option>高</option>
										<option>中</option>
										<option>很高</option>
										<option>完全</option>
										<option>微高</option>
										<option>低</option>
										<option>微低</option></select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="credit">信誉度</label>
								<div class="controls">
									<select class="form-control" name="credit"><option>高</option>
										<option>中</option>
										<option>很高</option>
										<option>完全</option>
										<option>微高</option>
										<option>低</option>
										<option>微低</option></select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="retime">响应时间</label>
								<div class="controls">
									<select class="form-control" name="retime"><option>高</option>
										<option>中</option>
										<option>很高</option>
										<option>完全</option>
										<option>微高</option>
										<option>低</option>
										<option>微低</option></select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="flexi">生产灵活度</label>
								<div class="controls">
									<select class="form-control" name="flexi"><option>高</option>
										<option>中</option>
										<option>很高</option>
										<option>完全</option>
										<option>微高</option>
										<option>低</option>
										<option>微低</option></select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="returnser">退货服务</label>
								<div class="controls">
									<select class="form-control" name="returnser"><option>是</option>
										<option>否</option></select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="samspeed">送样速度</label>
								<div class="controls">
									<select class="form-control" name="samspeed"><option>高</option>
										<option>中</option>
										<option>很高</option>
										<option>完全</option>
										<option>微高</option>
										<option>低</option>
										<option>微低</option></select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="carriage">是否承担运费</label>
								<div class="controls">
									<select class="form-control" name="carriage"><option>是</option>
										<option>否</option></select>
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