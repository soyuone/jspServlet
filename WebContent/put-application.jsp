<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application测试</title>
</head>
<body>
	<%!int i;%>
	<%
		application.setAttribute("counter", String.valueOf(++i));
	%>
	<%=i%>
</body>
</html>