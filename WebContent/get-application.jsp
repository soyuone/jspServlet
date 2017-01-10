<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>从application中取值</title>
</head>
<body>
	<%=application.getAttribute("counter") %>
	<%--application可以使用getInitParameter(Name)方法来获取Web应用的配置参数，这些配置参数在web.xml文件中--%>
	<%--使用context-param元素配置，每个context-param元素配置一个参数 ，该元素下有两个子元素：param-name和param-value--%>
	<%=application.getInitParameter("driver")%>
</body>
</html>