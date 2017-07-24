<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,java.io.*"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
    + request.getServerName() + ":" + request.getServerPort()
    + path + "/pdf/";
//String p="D:/Students/pdf/"+request.getParameter("addr");
//String p=request.getParameter("addr");
String p="D:/MultiAgentSystem/help.pdf";
System.out.println(p);
%>
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
   out.clear();
   out = pageContext.pushBody();
   response.setContentType("application/pdf");
   try {
    String strPdfPath = new String(p);
    
    //判断该路径下的文件是否存在
    File file = new File(strPdfPath);
    if (file.exists()) {
     DataOutputStream temps = new DataOutputStream(response
       .getOutputStream());
     DataInputStream in = new DataInputStream(
       new FileInputStream(strPdfPath));
     byte[] b = new byte[2048];
     while ((in.read(b)) != -1) {
      temps.write(b);
      temps.flush();
     }
     in.close();
     temps.close();
    } else {
     out.print(strPdfPath + " 文件不存在!");
    }
   } catch (Exception e) {
    out.println(e.getMessage());
   }
%>
<body>
 <br>
 <script src="<%=request.getContextPath()%>/js/jquery-1.11.2.min.js"></script>

	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>

</html>