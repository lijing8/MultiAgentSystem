<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
        <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="panel-group" id="accordion2">
          <ul class="nav nav-pills nav-stacked">
				<li><a href="http://localhost:8080/MultiAgentSystem/information/simulationmain?userID=${userID }"><h4><span class="glyphicon glyphicon-home"></span>首页</h4></a></li>
	      </ul>
	     
							
			
			<div class="panel panel-info">
				<div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#needplanr">
					<span class="glyphicon glyphicon-calendar"></span>企业需求信息管理
				</div>
				<div id="needplanr" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							      <li><a href="http://localhost:8080/MultiAgentSystem/information/toadddemand?userID=${userID }" role="menuitem" tabindex="-1">企业需求信息添加</a>
							      </li>
							      <li><a href="http://localhost:8080/MultiAgentSystem/information/listdemand?userID=${userID }" role="menuitem" tabindex="-1">企业需求信息列表</a>
							      </li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#needplan">
					<span class="glyphicon glyphicon-briefcase"></span>企业资源信息管理
				</div>
				<div id="needplan" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							      <li><a href="http://localhost:8080/MultiAgentSystem/information/toaddservice?userID=${userID }" role="menuitem" tabindex="-1">企业资源信息添加</a>
							      </li>
							      <li><a href="http://localhost:8080/MultiAgentSystem/information/listservice?userID=${userID }" role="menuitem" tabindex="-1">企业资源信息列表</a>
							      </li>
							       <li><a href="http://localhost:8080/MultiAgentSystem/information/toaddindex?userID=${userID }" role="menuitem" tabindex="-1">企业资源指标分数添加</a>
							      </li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#servmession">
					<span class="glyphicon glyphicon-tasks"></span>Agent交互查询
				</div>
				<div id="servmession" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							<li><a
								href="http://localhost:8080/MultiAgentSystem/information/getallagentinformation?userID=${userID }">Agent交互查询</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="panel panel-info">
				<div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#servservres">
					<span class="glyphicon glyphicon-cloud-upload"></span>仿真结果
				</div>
				<div id="servservres" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							<li><a
								href="http://localhost:8080/MultiAgentSystem/information/getresult?userID=${userID }">仿真结果</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="panel panel-info">
				<div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#veluenet">
					<span class="glyphicon glyphicon-user"></span>用户信息
				</div>
				<div id="veluenet" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							<li><a
								href="http://localhost:8080/MultiAgentSystem/agentsim/getEditUser?userID=${userID }">当前用户信息</a>
							</li>
							<li><a
								href="http://localhost:8080/MultiAgentSystem/agentsim/getalluser?userID=${userID }">所有用户信息</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
           <div class="panel panel-info">
				  <div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#help">
					<span class="glyphicon glyphicon-globe"></span>帮助文档
				  </div>
				  <div id="help" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							<li><a
								href="http://localhost:8080/MultiAgentSystem/information/listhelp" target = "_blank">帮助文档</a>
							</li>
						</ul>
					</div>
				  </div>
			      </div>
          </div>
    
    <div class="text-right">
         <a class="btn btn-primary btn-sm" href=""><span class="glyphicon glyphicon-chevron-up"></span>返回</a>
    </div>
</body>
</html>