<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>java Bean测试</title>
</head>
<body>
	<jsp:useBean id="p1" class="com.song.jspservlet.Person" scope="page" />
	<jsp:setProperty property="name" name="p1" value="waou" />
	<jsp:setProperty property="age" name="p1" value="40" />
	<jsp:getProperty property="name" name="p1" /><br />
	<jsp:getProperty property="age" name="p1" />
</body>
</html>