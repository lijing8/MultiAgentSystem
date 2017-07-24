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

<title>评价结果</title>

<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link
	href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css"
	rel="stylesheet" media="screen">
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	

<style>
 [class="col-xs-9"]{
    border-left:1px solid;
    border-color:rgba(86,61,124,.2);
    
    }
</style>
</head>
<body>
   <div class="container-fluid">
         <!--第一行 header-->
			<div class="row">
				<%@ include file="header.jsp"%>
			</div>
     <div class="row" id="main-part">
		     <!--左侧 导航-->
		     <c items="${userID }" var="userID"></c>
			    <div class="col-xs-2">
					<%@ include file="leftnav.jsp"%>
				</div>
                    <!-- 右边主体部分 -->

                  <div class="col-xs-9">
                   <ul class="breadcrumb" style="margin-bottom: 5px;">  
                        <li><a href="#">企业信息管理</a> <span class="divider">/</span></li>  
                        <li><a href="#">企业需求管理</a> <span class="divider">/</span></li>  
                        <li class="active">企业需求结果</li>  
                     </ul>  
                  <br/>
                  <table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>需求编号</th>
									<th>企业编号</th>
									<th>资源名称</th>
									<th>产品型号</th>
									<th>总体分数</th>
									
								
								</tr>
							</thead>
							<tbody>
							 <c:forEach items="${result}" var="rs">
								<tr>
								    <td>${rs.demandID}</td>
									<td>${rs.firmID}</td>
									<td>${rs.serviceName}</td>
									<td>${rs.serviceID}</td>
									<td>${rs.totalscore}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
           </div>
      </div>

</div>
<script src="<%=request.getContextPath()%>/js/jquery-1.11.2.min.js"></script>

<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</body>
</html>