<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <div class="container-fluid">
         <!--第一行 header-->
			<div class="row">
				<div id="header">
					<div class="col-xs-12 header">
						<h1>　　　　</h1>
					</div>
				</div>
			</div>
			
			<!--第二行 内容-->
			<div class="row" id="main-part">
			   <!--左侧 导航-->
			    <div class="col-xs-2">
					<div class="pinned" id="sidebar">
					</div>
				</div>
				<div class="col-xs-10">
					<!--面包屑导航-->
					<ol class="breadcrumb pinned" >
						<li class="active"><span class="glyphicon glyphicon-home"></span> 首页</li>
					</ol>
					<div class="span6">
					    <img width="820" height="420"  src="../MultiAgentSystem/img/2.jpg" />
				    </div>
				</div>
			</div>
			
			<!--第三行 foot-->
			<div class="row">			
				<div class="bg-info col-xs-12 text-center" id="footrow">
					<%@ include file="footrow.jsp"%>
				</div>
			</div>
      
      
      
      </div>
</body>
</html>