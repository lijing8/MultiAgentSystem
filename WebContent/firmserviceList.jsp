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

<title>资源列表</title>

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
				<div class="page-header">
					  <ul class="breadcrumb" style="margin-bottom: 5px;">  
                        <li><a href="#">企业信息管理</a> <span class="divider">/</span></li>  
                        <li><a href="#">企业资源信息管理</a> <span class="divider">/</span></li>  
                        <li class="active">企业资源信息列表</li>  
                     </ul>  
				</div>
					<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th width="70">资源编号</th>
									<th width="70">企业ID</th>
									<th width="70">产品名称</th>
									<th width="70">交货期</th>
									<th width="70">产品合格率</th>
									<th width="70">操作</th>
									
								</tr>
							</thead>
							<tbody>
							  <c:forEach items="${servicelist}" var="rs">
							     <tr>
							          <td>${rs.ID}</td>
							          <td>${rs.firmID}</td>
							          <td>${rs.serviceName}</td>
							          <td>${rs.delitime}</td>
							          <td>${rs.passrate}</td>
							          <td><a href="http://localhost:8080/MultiAgentSystem/information/listoneservice?ID=${rs.ID}&userID=${userID }">查看</a></td>
							         
							      
							     </tr>
							  </c:forEach>
							</tbody>
			      </table>
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