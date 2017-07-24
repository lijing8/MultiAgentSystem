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

<title>需求添加</title>

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
				<div class="col-xs-9">
					<c items="${userID }" var="userID"></c>
                    <c items="${demandID }" var="demandID"></c>
                    <br/><br/>
                   <h3><p class="text-center">仿真计算结果</p></h3>
                   
                   <br/><br/><br/><br/><br/><br/><br/>
                   
                     <div class="col-xs-4">       
                     </div>
	                   <div class="col-xs-2">                  
	                <a class="btn btn-primary btn-sm" href="/MultiAgentSystem/information/getthisresult?userID=${userID }&demandID=${demandID }"> <p >服务发现结果查询</p></a>
	                   
	                   </div>
	                   <div class="col-xs-2"> 
	                <a class="btn btn-primary btn-sm" href="/MultiAgentSystem/information/evaluateresult?userID=${userID }&demandID=${demandID }"> <p >动态评价结果查询</p></a>
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