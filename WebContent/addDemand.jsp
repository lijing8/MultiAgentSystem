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

<title>需求添加</title>

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
    	$(":input[name='demandIDd']").change(function(){
    		var val=$(this).val();
    		val=$.trim(val);//去除空格
    		
    		if(val!=""){
    			var url="${pageContext.request.contextPath}/information/valiate";
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
		      <c items="${demandID }" var="demandID"></c>
		      <c items="${demandName }" var="demandName"></c>
		       <c items="${demandType }" var="demandType"></c>
		      <div class="col-xs-9">
			    <div class="span12">
				<div class="page-header">
					  <ul class="breadcrumb" style="margin-bottom: 5px;">  
                        <li><a href="#">企业信息管理</a> <span class="divider">/</span></li>  
                        <li><a href="#">企业需求信息管理</a> <span class="divider">/</span></li>  
                        <li class="active">企业需求信息添加</li>  
                     </ul>  
				</div>
				<div class="row-fluid">
					<div class="span1"></div>
					<div class="span10">
						
						<form action="http://localhost:8080/MultiAgentSystem/information/adddemand?userID=${userID }"
							class="form-horizontal" method="post" role="form">
							<div class="control-group">
							  
								<label class="control-label" for="demandID">需求ID</label>
								<div class="controls">
									<input name="demandID" type="text" value="${demandID}"/>
										
								</div>
						         <div class="controls" id="message">
										
								</div>
								
							</div>
							<div class="control-group">
								<label class="control-label" for="demandName">产品名称</label>
								<div class="controls">
									<input name="demandName" type="text" value="${demandName}" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="demandNum">产品数量</label>
								<div class="controls">
									<input name="demandNum" type="text" /> 1——1000
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="delitime">交货期</label>
								<div class="controls">
									<input name="delitime" type="text" />天
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="demandType">产品型号</label>
								<div class="controls">
									<input name="demandType" type="text" value="${demandType}"/>
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
									<input  class="btn btn-primary btn-sm" type="submit"  style="margin-left:70px;" value="提交" />
									<input class="btn btn-primary btn-sm"  type="reset" style="margin-left:140px;" value="重置" />
								</div>
							</div>
						</form>
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