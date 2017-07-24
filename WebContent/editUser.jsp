<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		
		<title>  
			云环境下汽车制造业供应链服务发现与协同机制仿真平台
		</title>
		
		<link href="favicon.ico" rel="icon" type="image/x-icon" />
		
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

		<!-- 可选的Bootstrap主题文件（一般不用引入） -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		
</head>
<body>
     <div class="container-fluid">
         <!--第一行 header-->
			<div class="row">
				<%@ include file="header.jsp"%>
			</div>
			
			<!--第二行 内容-->
			<div class="row" id="main-part">
			   <!--左侧 导航-->
			    <div class="col-xs-2">
					<%@ include file="leftnav.jsp"%>
				</div>
				<div class="col-xs-9">
				
		<c items="${userID }" var="userID"></c>
				   <div class="span12">
					<!--面包屑导航-->
					<div class="page-header">
					<ol class="breadcrumb pinned" >
						<li class="active"><span ></span>企业信息</li>
						<li class="active"><span ></span>当前用户信息</li>
					</ol>
					</div>
					
					   <div class="container-fluid" >
		                  <div class="col-xs-3"> </div>  
			             <c items="${user }" var="user"></c>        
					    <div class="col-xs-6">
						    <if> <c:if test="${!empty error}">
							   <h2>${error }</h2>
						    </c:if> 
						    </if>
						    
						    <form class="form-horizontal" action="/MultiAgentSystem/agentsim/adduser">
							   <div class="control-group">
							  	   <label class="control-label" for="userID">账号</label>
								    <div class="controls">
									<input id="userID" type="text" value="${user.userID }" />
								    </div>
							   </div>
							   <div class="control-group">
								   <label class="control-label" for="username">用户名称</label>
								   <div class="controls">
									  <input id="username" type="text" value="${user.userName }" />
								    </div>
							   </div>
							   <div class="control-group">
								   <label class="control-label" for="inputPassword">密码</label>
								   <div class="controls">
									  <input id="inputPassword" type="password"
										value="${user.userPassword }" />
								   </div>
							   </div>
							   <div class="control-group">
								   <label class="control-label" for="userrole">用户角色</label>
								   <div class="controls">
									  <input id="userrole" type="text" value="${user.userRole }" />
								   </div>
							   </div>
							   <div class="control-group">
								   <div class="controls">
									  <br/>
								   </div>
							   </div>
							   <div class="control-group">
								   <div class="controls">
									  <button class="btn btn-primary btn-sm" type="submit">确定</button>
									  <button type="reset" class="btn btn-primary btn-sm" style="margin-left:50px;">重置</button>
								   </div>
							   </div>
					      </form>
					      </div>
                          
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