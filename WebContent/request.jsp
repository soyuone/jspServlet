<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取请求头，请求参数</title>
</head>
<body>
	<%
		//获取所有请求头的名称
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			out.println(headerName + "-->" + request.getHeader(headerName)
					+ "<br/>");
		}
		out.println("<hr/");
		//如果POST请求的请求参数中含非西欧字符，必须在获取请求参数之前先调用setCharacterEncoding设置编码的字符集
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] color = request.getParameterValues("color");
		String country = request.getParameter("country");
	%>

	名字：<%=name%><hr />
	性别:<%=gender%><hr />
	喜欢的颜色:<%
		for (String c : color) {
			out.println(c + "");
		}
	%><hr />
	来自于:<%=country%><hr />
</body>
</html>