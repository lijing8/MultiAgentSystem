<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎注册</title>
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
		  <c items="${userID }" var="userID"></c>
		     <!--左侧 导航-->
			    <div class="col-xs-2">
				
				</div>
		<div class="col-xs-9">
			<div class="span12">
				<div class="page-header">
					  <ul class="breadcrumb" style="margin-bottom: 5px;">  
                        
                        <li class="active">用户注册</li>  
                     </ul>  
				</div>
				<div class="row-fluid">
					<div class="span3">	
					</div>
					<div class="span4">
						<div class="span12">
							<div class="page-header">
								<h1 class="text-center"></h1>
								<c:if test="${!empty error}">
									<h1>${error }</h1>
								</c:if>
							</div>
						</div>

						<form class="form-horizontal"
							action="/MultiAgentSystem/agentsim/adduser?userID=${userID }">
							<div class="control-group">
								<label class="control-label" for="UserID">账号</label>
								<div class="controls">
									<input name="UserID" type="text" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="UserName">用户名称</label>
								<div class="controls">
									<input name="UserName" type="text" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">密码</label>
								<div class="controls">
									<input name="password" type="password" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="UserRole">用户角色</label>
								<div class="controls">
									
                                          <label class="checkbox-inline">
                                          <input type="checkbox" id="inlineCheckbox1" name="UserRole" value="普通用户" checked/> 普通用户
                                          </label>
                                           <label class="checkbox-inline">
                                          <input type="checkbox" id="inlineCheckbox2" name="UserRole" value="系统管理员"/> 系统管理员
                                          </label>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button class="btn btn-primary btn-sm" type="submit" class="btn" style="margin-left:10px;">确定</button>
									<button class="btn btn-primary btn-sm" type="reset" class="btn" style="margin-left:70px;">重置</button>
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