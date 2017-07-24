<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- The above meta tags *must* come first in the head; 
 any other head content must come *after* these tags -->

<title>MultiAgentSystem</title>

<link href="favicon.ico" rel="icon" type="image/x-icon" />
<link rel="icon" href="favicon.ico" >

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

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
		form.action="/MultiAgentSystem/agentsim/toadduser";
		form.method="post";
		form.submit();
	}
	function login(){
		var form = document.forms[0];
		form.action="/MultiAgentSystem/agentsim/getuser";
		form.method="post";
		form.submit();		
	}
</script>

<script type="text/javascript">
		//等待dom元素加载完毕.
			$(document).ready(function(){
				
				$("#header").load('header.jsp');
				$("#footrow").load('footrow.jsp');
				$("#sidebar").load('leftnav.jsp');
			});			
		</script> 
</head>
<body>

	<!-- 在此添加元素 -->

	<div class="container-fluid">
		   <!--第一行 header-->
			<div class="row">
				<div id="header">
					<div class="col-xs-12 header">
						<%@ include file="header.jsp"%>
					</div>
				</div>
			</div>
			<!--第二行 内容-->
			<div class="row" id="main-part">
			<!--左侧 导航-->
				<div class="col-xs-2">
				
				</div>
				
				<div class="col-xs-9">
				<!--面包屑导航-->
				<ol class="breadcrumb pinned" >
						<li class="active"><span class="glyphicon glyphicon-home"></span> 登录</li>
					</ol>
					<div class="span4">
				
					<c:if test="${!empty error}">
						<h2>${error }</h2>
					</c:if>
					<form class="form-horizontal" action="/MultiAgentSystem/agentsim/getuser"  method="POST">
						<div class="control-group">
							<label class="control-label" for="userID">账号</label>
							<div class="controls">
								<input name="userID" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputPassword">密码</label>
							<div class="controls">
								<input name="password" type="password" />
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<button type="submit" class="btn btn-primary btn-sm" >登陆</button>
								<button class="btn btn-primary btn-sm" type="reset">取消</button>
								<a href="/MultiAgentSystem/agentsim/toadduser">还未注册？</a>
								
							</div>
						</div>
					</form>
				</div>
				<div class="span1">
					
				</div>
				<div class="span6">
					 <img width="1020" height="420"  src="../img/product.jpg" /> 
				    <!----<img width="1020" height="420"  src="../img/open.png" />-->
				</div>
				
			       
			   </div>
			</div>
			
			<div class="row">			
				<div class="bg-info col-xs-12 text-center" id="footrow">
					<small class=""></small>
					<%@ include file="footrow.jsp"%>
				</div>
			</div>
			

	</div>
</body>


</html>