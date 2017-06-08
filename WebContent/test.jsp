<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看servlet</title>
</head>
<body>

	<%-- jsp注释格式 --%>
	<!-- html注释格式 -->
	<!-- jsp文件必须在jsp服务器内运行；jsp文件必须生成servlet才能执行；每个jsp页面的第一个访问者速度较慢，要等待编译为servlet -->
	<!-- jsp页面输送到客户端的是标准html页面 -->

	<!-- <font>规定文本的字体、字体尺寸、字体颜 -->
	<!-- <br>为换行符 -->
	
	<!-- tomcat根据jsp页面生成对应servlet的java文件、class文件 -->
	<%
		for (int i = 0; i < 7; i++) {
			out.println("<font size='" + i + "'>");
	%>
	疯狂Java训练营(Wild Java Camp)</font>
	<br/>
	<%}%>
</body>
</html>