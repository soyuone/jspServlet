<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试config内置对象</title>
</head>

<!--config对象代表当前JSP配置信息，但JSP页面通常无须配置，因此也就不存在配置信息。该对象在JSP页面中比较少用，但在Servlet中则用处相对较大，因为Servlet需要在web.xml文件中进行配置 -->
<!--如果希望JSP页面可以获取web.xml配置文件中的配置信息，则必须通过为该JSP配置的路径来访问该页面，只有这样访问JSP页面才会让配置参数起作用 -->
<body>
<%=config.getInitParameter("name") %>
<%=config.getInitParameter("age") %>
</body>
</html>