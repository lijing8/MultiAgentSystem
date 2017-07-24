<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
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
	
<script type="text/javascript">
	function addUser(){
		var form = document.forms[0];
		form.action="/SpringSC/agentsim/toadduser";
		form.method="post";
		form.submit();
	}
	function login(){
		var form = document.forms[0];
		form.action="/SpringSC/agentsim/getuser";
		form.method="post";
		form.submit();
	
		
		
	}
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
			    <div class="col-xs-2">
					<%@ include file="leftnav.jsp"%>
				</div>
				<div class="col-xs-9">
				<div class="span12">
				<div class="span3">
				</div>
				<div class="span6">
				<h3>欢迎登录</h3>
	                <c:if test="${!empty error}">
	                     <h2> ${error }</h2></c:if>
	                     <br/>
	              <form >
	               	用户：<input type="text" name="name" >
		            <br/>
		                                    密码：<input type="password" name="password" >
		             <br>
		                 <input class="btn btn-primary btn-sm" type="button" value="登录" onclick="login()" >
		                 <input class="btn btn-primary btn-sm"  type="button" value="注册" onclick="addUser()" >
		               
	               </form>
				</div>
				<div class="span3"></div>
				
				</div>
				</div>
			</div>
			 <!--第三行 foot-->
			<div class="row">			
				<%@ include file="footrow.jsp"%>
				
			</div>
	 </div>
</body>


</html>