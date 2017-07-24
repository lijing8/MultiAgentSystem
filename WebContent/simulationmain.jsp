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
<title></title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">


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
			    <div class="col-xs-2">
					<%@ include file="leftnav.jsp"%>
				</div>
		<c items="${userID }" var="userID"></c>
		 <div class="col-xs-9">
			<div class="span12">
				<div class="page-header">
					<ul class="breadcrumb" style="margin-bottom: 5px;">  
                        <li class="active">首页<span class="divider">/</span></li>  
                        
                     </ul>
				</div>
				<div class="row-fluid">
					<div class="span2"></div>
					<div class="span8">
						<h2>系统简介</h2>
						<p>本系统是一个多Agent仿真系统，用于仿真云环境下汽车供应链，通过输入一定的仿真参数可以获得一个仿真结果</p>
						<br/>
						<br/>
						<br/>
					    <a  class="btn btn-primary btn-sm"  href="http://localhost:8080/MultiAgentSystem/information/start?userID=${userID}"><p class="text-center">启动云服务</p></a> 
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