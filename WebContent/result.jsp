<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>仿真结果</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
                       
                        <li class="active">仿真结果</li>  
                     </ul>  
				</div>
				<div class="row-fluid">
					<div class="span3"></div>
					<div class="span7">
						
                           </div>  

						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>编号</th>
									<th>企业编号</th>
									<th>服务编号</th>
									<th>需求满意度</th>
									<th>仿真时间</th>
								</tr>
							</thead>
							<tbody>
							 <c:forEach items="${result }" var="rs">
								<tr>
									<td>${rs.ID}</td>
									<td>${rs.firmID}</td>
									<td>${rs.serviceID}</td>
									<td>${rs.demandconf}</td>
									<td>${rs.date}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="span2"></div>
				</div>
			</div>
		</div>
		</div>
	</div>
	
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.2.min.js"></script>

	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>