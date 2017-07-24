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

<title>需求分数添加</title>

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
    $(function(){
    	$(":input[name='demandType']").change(function(){
    		//var val=$(this).val();
    		//val=$.trim(val);//去除空格
    		var args={"time":new Date()};
    		var url="${pageContext.request.contextPath}/information/generateID";
    		$.getJSON(url, args, function(data){
    				document.getElementById("demandID").value=data.demandID;//设置为空即可。
    			});
    		
    	});
    })


</script>
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
			    <div class="span12">
				<div class="page-header">
					  <ul class="breadcrumb" style="margin-bottom: 5px;">  
                        <li><a href="#">企业信息管理</a> <span class="divider">/</span></li>  
                        <li><a href="#">企业需求信息管理</a> <span class="divider">/</span></li>  
                        <li class="active">企业需求信息添加</li>  
                     </ul>  
				</div>
				<div class="row-fluid">
					<div class="span1"></div>
					<div class="span10">
						
						<form action="http://localhost:8080/MultiAgentSystem/information/valiateahp?userID=${userID}"
							class="form-horizontal" method="post" role="form">
							
							
							<div class="control-group">
								<label class="control-label" for="demandName">产品名称</label>
								<div class="controls">
									<input name="demandName" type="text" />
								</div>
							</div>	
							<div class="control-group">
								<label class="control-label" for="demandType">产品型号</label>
								<div class="controls">
									<input name="demandType" type="text" />
								</div>
							</div>	
							
							<div class="control-group">
							  
								<label class="control-label" for="demandID" >需求ID</label>
								<div class="controls">
									<input name="demandID" id="demandID" type="text" />	
								</div>
						         
								
							</div>	
				<table class="table table-striped table-bordered">
                 <thead>
                    <tr>
                    <td width="70">横向对纵向的重要程度</td>
                    <td width="70">质量</td>
                    <td width="70">价格</td>
                    <td width="70">柔性</td>
                   <td width="70">信息化水平</td>
                    <td width="70">伙伴关系</td>
                    <td width="70">财务能力</td>
                    <td width="70">科技水平</td>
                    <td width="70">环保水平</td>
                  
                  
                    </tr> 
                 </thead>
                 <tbody>
                 
                  <tr>
                        <td width="70">质量</td> 
                        <td width="70" ><input type="text" class="form-control" name="a1" value="同等重要">
                        <td width="70"><select name="a2" class="form-control"><option >同等重要</option><option >略重要</option><option >重要</option><option >很重要</option><option>极重要</option></select> </td>
				
                        <td width="70"><select name="a3" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
						
                        <td width="70"><select name="a4" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="a5" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                          <td width="70"><select name="a6" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                       <td width="70"><select name="a7" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                   <td width="70"><select name="a8" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
		              </tr>
		              <tr>
                        <td width="70">成本</td>
                        <td width="70" ></td>
                        <td width="70" ><input type="text" class="form-control" name="b2" value="同等重要"></td>
                          <td width="70"><select name="b3" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                          <td width="70"><select name="b4" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                          <td width="70"><select name="b5" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                          <td width="70"><select name="b6" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="b7" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="b8" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                          
		              </tr>
		              <tr>
                        <td width="70">柔性</td>
                   
                        <td width="70"></td>
                        <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="c3" value="同等重要"></td>
                          <td width="70"><select name="c4" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                          <td width="70"><select name="c5" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                          <td width="70"><select name="c6" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                          <td width="70"><select name="c7" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                          <td width="70"><select name="c8" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
		              </tr>
		               <tr>
                        <td width="70">信息化水平</td>
                    
                        <td width="70"></td>
                        <td width="70"></td>
                         <td width="70"></td> 
                          <td width="70"><input type="text" class="form-control" name="d4" value="同等重要"></td>
                         <td width="70"><select name="d5" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="d6" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="d7" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="d8" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
		              </tr>
		              <tr>
                       <td width="70">伙伴关系</td>
                    
                        <td width="70"></td>
                        <td width="70"></td>
                         <td width="70"></td> 
                         <td width="70"></td> 
                         <td width="70"><input type="text" class="form-control" name="e5" value="同等重要"></td>
                         <td width="70"><select name="e6" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                           <td width="70"><select name="e7" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                        <td width="70"><select name="e8" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                       
        
		              </tr>
		              <tr>
                       <td width="70">财务能力</td>
                    
                        <td width="70"></td>
                        <td width="70"></td>
                         <td width="70"></td> 
                         <td width="70"></td>
                         <td width="70"></td>
                          <td width="70"><input type="text" class="form-control" name="f6" value="同等重要"></td>
                           <td width="70"><select name="f7" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="f8" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                        
                   
		              </tr>
		              <tr>
                        <td width="70">科技水平</td>
                    
                        <td width="70"></td>
                        <td width="70"></td>
                         <td width="70"></td> 
                         <td width="70"></td>
                         <td width="70"></td>  
                         <td width="70"></td>   
                          <td width="70"><input type="text" class="form-control" name="g7" value="同等重要"></td>
                        <td width="70"><select name="g8" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                       
		              </tr>
		              <tr>
                         <tr>
                        <td width="70">环保水平</td>
                    
                        <td width="70"></td>
                        <td width="70"></td>
                         <td width="70"></td> 
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"></td>
                          <td width="70"><input type="text" class="form-control" name="h8" value="同等重要"></td>
                      
                      
		              </tr>    
		              
                 </tbody>     
              </table> 
              
              
          <label class="control-label" >质量</label>
          
							
				<table class="table table-striped table-bordered">
                 <thead>
                    <tr>
                    <td width="70">横向对纵向的重要程度</td>
                    <td width="70">产品合格率</td>
                    <td width="70">产品报退率</td>
                    <td width="70">产品服务体系</td>
                    <td width="70">云服务质量</td>

                    </tr> 
                 </thead>
                 <tbody>
                  <tr>
                       <td width="70">产品合格率</td>
                         <td width="70"><input type="text" class="form-control" name="a11" value="同等重要"></td>
                         <td width="70"><select name="a12" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="a13" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="a14" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
        
		              </tr>
		              
		              <tr>
                       <td width="70">产品报退率</td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="a22" value="同等重要"></td>
                         <td width="70"><select name="a23" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="a24" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                        
        
		              </tr>
		               <tr>
                       <td width="70">产品服务体系</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="a33" value="同等重要"></td>
                         <td width="70"><select name="a34" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
        
		              </tr>
		               <tr>
                       <td width="70">云服务质量</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="a44" value="同等重要"></td>
                         
        
		              </tr>
                 
                 </tbody>
                 </table>
                 
                 <label class="control-label" >成本</label>
                 <table class="table table-striped table-bordered">
                 <thead>
                    <tr>
                    <td width="70">横向对纵向的重要程度</td>
                    <td width="70">设计成本比重</td>
                    <td width="70">采购成本比重</td>
                    <td width="70">运输成本比重</td>
                    <td width="70">成本利用率</td>

                    </tr> 
                 </thead>
                  <tbody>
                  <tr>
                       <td width="70">设计成本比重</td>
                         <td width="70"><input type="text" class="form-control" name="b11" value="同等重要"></td>
                         <td width="70"><select name="b12" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="b13" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="b14" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
        
		              </tr>
		              
		              <tr>
                       <td width="70">采购成本比重</td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="b22" value="同等重要"></td>
                         <td width="70"><select name="b23" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="b24" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                        
        
		              </tr>
		               <tr>
                       <td width="70">运输成本比重</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="b33" value="同等重要"></td>
                         <td width="70"><select name="b34" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
        
		              </tr>
		               <tr>
                       <td width="70">成本利用率</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="b44" value="同等重要"></td>
                         
        
		              </tr>
                 
                 </tbody>
                 </table>
                 
                 <label class="control-label" >柔性</label>
                 <table class="table table-striped table-bordered">
                 <thead>
                    <tr>
                    <td width="70">横向对纵向的重要程度</td>
                    <td width="70">品种柔性</td>
                    <td width="70">时间柔性</td>
                    <td width="70">数量柔性</td>
                    

                    </tr> 
                 </thead>
                 <tbody>
                 <tr>
                       <td width="70">品种柔性</td>
                         <td width="70"><input type="text" class="form-control" name="c11" value="同等重要"></td>
                         <td width="70"><select name="c12" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="c13" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         
		              </tr>
		              
		              <tr>
                       <td width="70">时间柔性</td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="c22" value="同等重要"></td>
                         <td width="70"><select name="c23" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                        
        
		              </tr>
		               <tr>
                       <td width="70">数量柔性</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="c33" value="同等重要"></td>
                        
		              </tr>
		              
                 
                 </tbody>
                 </table>
                 
                 <label class="control-label" >信息化</label>
                 <table class="table table-striped table-bordered">
                 <thead>
                    <tr>
                    <td width="70">横向对纵向的重要程度</td>
                    <td width="70">信息技术投入</td>
                    <td width="70">云平台投入</td>
                    <td width="70">信息化级别</td>
                   

                    </tr> 
                 </thead>
                 <tbody>
                 
                  <tr>
                       <td width="70">信息技术投入</td>
                         <td width="70"><input type="text" class="form-control" name="d11" value="同等重要"></td>
                         <td width="70"><select name="d12" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="d13" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         
		              </tr>
		              
		              <tr>
                       <td width="70">云平台投入</td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="d22" value="同等重要"></td>
                         <td width="70"><select name="d23" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                        
        
		              </tr>
		               <tr>
                       <td width="70">信息化级别</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="d33" value="同等重要"></td>
                        
		              </tr>
		              
                 
                 </tbody>
                 </table>
                 
                 <label class="control-label" >伙伴关系</label>
                 <table class="table table-striped table-bordered">
                 <thead>
                    <tr>
                    <td width="70">横向对纵向的重要程度</td>
                    <td width="70">准时交货率</td>
                    <td width="70">客户满意率</td>
                    <td width="70">市场占有率</td>
                   

                    </tr> 
                 </thead>
                 <tbody>
                 
                 <tr>
                       <td width="70">准时交货率</td>
                         <td width="70"><input type="text" class="form-control" name="e11" value="同等重要"></td>
                         <td width="70"><select name="e12" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="e13" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         
		              </tr>
		              
		              <tr>
                       <td width="70">客户满意率</td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="e22" value="同等重要"></td>
                         <td width="70"><select name="e23" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                        
        
		              </tr>
		               <tr>
                       <td width="70">市场占有率</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="e33" value="同等重要"></td>
                        
		              </tr>
                 </tbody>
                 </table>
                 
                 <label class="control-label" >财务能力</label>
                 <table class="table table-striped table-bordered">
                 <thead>
                    <tr>
                    <td width="70">横向对纵向的重要程度</td>
                    <td width="70">资本收益率</td>
                    <td width="70">净资产利用率</td>
                    <td width="70">利润增长率</td>
                    <td width="70">销售增长率</td>
                    <td width="70">投入产出比</td>

                    </tr> 
                 </thead>
                 <tbody>
                  <tr>
                       <td width="70">资本收益率</td>
                         <td width="70"><input type="text" class="form-control" name="f11" value="同等重要"></td>
                         <td width="70"><select name="f12" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="f13" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="f14" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                          <td width="70"><select name="f15" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
        
		              </tr>
		              
		              <tr>
                       <td width="70">净资产利用率</td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="f22" value="同等重要"></td>
                         <td width="70"><select name="f23" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="f24" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="f25" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
        
        
		              </tr>
		               <tr>
                       <td width="70">利润增长率</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="f33" value="同等重要"></td>
                         <td width="70"><select name="f34" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="f35" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
        
		              </tr>
		               <tr>
                       <td width="70">销售增长率</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="f44" value="同等重要"></td>
                          <td width="70"><select name="f45" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
        
        
		              </tr>
		              <tr>
                       <td width="70">投入产出比</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"></td>
                          <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="f55" value="同等重要"></td>
                         
        
		              </tr>
                 
                 
                 </tbody>
                 </table>
                 
                 <label class="control-label" >科技水平</label>
                 <table class="table table-striped table-bordered">
                 <thead>
                    <tr>
                    <td width="70">横向对纵向的重要程度</td>
                    <td width="70">研究开发投资率</td>
                    <td width="70">新产品收入比率</td>
                    <td width="70">科技开发人员比率</td>
                   
                    </tr> 
                 </thead>
                 <tbody>
                 
                   <tr>
                       <td width="70">研究开发投资率</td>
                         <td width="70"><input type="text" class="form-control" name="g11" value="同等重要"></td>
                         <td width="70"><select name="g12" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         <td width="70"><select name="g13" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                         
		              </tr>
		              
		              <tr>
                       <td width="70">新产品收入比率</td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="g22" value="同等重要"></td>
                         <td width="70"><select name="g23" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                        
        
		              </tr>
		               <tr>
                       <td width="70">科技开发人员比率</td>
                         <td width="70"></td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="g33" value="同等重要"></td>
                        
		              </tr>
                 </tbody>
                 </table>
                 
                 <label class="control-label" >环保水平</label>
                 <table class="table table-striped table-bordered">
                 <thead>
                    <tr>
                    <td width="70">横向对纵向的重要程度</td>
                    <td width="70">再循环资料利用率</td>
                    <td width="70">能源消耗率分数</td>

                    </tr> 
                 </thead>
                 <tbody>
                    <tr>
                       <td width="70">再循环资料利用率</td>
                         <td width="70"><input type="text" class="form-control" name="h11" value="同等重要"></td>
                         <td width="70"><select name="h12" class="form-control"><option>同等重要</option><option>略重要</option><option>重要</option><option>很重要</option><option>极重要</option></select> </td>
                        
		              </tr>
		               <tr>
                       <td width="70">能源消耗率分数</td>
                         <td width="70"></td>
                         <td width="70"><input type="text" class="form-control" name="h22" value="同等重要"></td>
                        
		              </tr>
                 
                 </tbody>
                 </table>
							
							
							
							<div class="control-group">
								<div class="controls">
									<input  class="btn btn-primary btn-sm" type="submit"  style="margin-left:70px;" value="提交" />
									<input class="btn btn-primary btn-sm"  type="reset" style="margin-left:140px;" value="重置" />
								</div>
							</div>
						</form>
					</div>
					<div class="span1"></div>
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