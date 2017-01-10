<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读取cookie</title>
</head>
<body>
<%
  Cookie[] cArry = request.getCookies();
  for(Cookie c:cArry){
	if(c.getName().equals("username")){
		out.println(c.getName() +":"+c.getValue());	
		}
}
	out.println("查看所有cookie.");
	for(Cookie d:cArry){
		out.println(d.getName()+":"+d.getValue());
	}
%>
</body>
</html>