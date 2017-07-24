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

<title>所有用户列表</title>

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
			    <div class="col-xs-2">
			    
					<%@ include file="leftnav.jsp"%>
				</div>
				<c items="${userID }" var="userID"></c>
				<div class="col-xs-9">
				<!--面包屑导航-->
					<div class="page-header">
					
						<ul class="breadcrumb" style="margin-bottom: 5px;">  
                        <li><a href="#">企业信息</a> <span class="divider">/</span></li>  
                        
                        <li class="active">所有用户信息</li>  
                     </ul> 
				
					</div>
					<table class=" table table-bordered table-hover ">
							<thead>
								<tr>
								    <th width="70">用户ID</th>
									<th width="70">用户名</th>
									<th width="70">密码</th>
									<th width="70">用户角色</th>
									<th width="70">操作</th>
									
								</tr>
							</thead>
							<tbody>
							  <c:forEach items="${result}" var="rs">
							     <tr>
							          <td>${rs.userID}</td>
							          <td>${rs.userName}</td>
							          <td>${rs.userPassword}</td>
							          <td>${rs.userRole}</td>
							          <td><a href="http://localhost:8080/MultiAgentSystem/agentsim/getEditUser?userID=${rs.userID}">查看</a>
							          <a href="http://localhost:8080/MultiAgentSystem/agentsim/delUser?userID=${rs.userID}">删除</a>
							          </td>
							         
							      
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