<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page info="this is a jsp."%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试page指令的info属性</title>
</head>

<!-- JSP的编译指令是通知JSP引擎（tomcat）的消息，它不直接生成输出，编译指令都有默认值 -->

<body>
	<!-- 输出info信息 -->
	<%=getServletInfo()%>
</body>
</html>