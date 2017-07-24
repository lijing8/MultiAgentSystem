<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">

<title></title>

<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link
	href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css"
	rel="stylesheet" media="screen">
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	
<style>
 [class="col-xs-9"]{
    border-left:1px solid;
    border-color:rgba(86,61,124,.2);
    
    }
</style>
</head>
<body>
<c items="${userID }" var="userID"></c>
<c items="${serviceName }" var="serviceName"></c>
<c items="${serviceNum}" var="serviceNum"></c>
<c items="${delitime }" var="delitime"></c>
<c items="${passrate}" var="passrate"></c>
<c items="${credit}" var="credit"></c>
  <div class="container-fluid">
         <!--第一行 header-->
			<div class="row">
				<%@ include file="header.jsp"%>
			</div>
			
	    <div class="row" id="main-part">
		  <c items="${userID }" var="userID"></c>
		     <!--左侧 导航-->
			    <div class="col-xs-2">
					<%@ include file="leftnav.jsp"%>
				</div>
           <div class="col-xs-9">
             <table class="table table-striped">
							<thead>
								<tr>
									<th width="70">服务名称</th>
									<th width="70">数量</th>
									<th width="70">交货期</th>
									<th width="70">产品合格率</th>
									<th width="70">信誉度</th>
								</tr>
							</thead>
							<tbody>
							  <tr>
							    <td width="70">${serviceName }</td>
							    <td width="70">${serviceNum}</td> 
							    <td width="70">${delitime }</td> 
							    <td width="70">${passrate}</td>
							    <td width="70">${credit}</td>
							  </tr>
							</tbody>
			</table>
			<div  class="text-right">
	           <a class="btn btn-primary btn-sm" href="http://localhost:8080/MultiAgentSystem/information/toaddservice?userID=${userID }">
	           <span class="glyphicon glyphicon-chevron-up"></span>返回</a>
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