<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>时间页面</title>
</head>
<body>
<!-- JSP通过在标准的HTML页面中嵌入Java代码，其静态的部分无须Java程序控制，只有那些需要从数据库读取或需要动态生成的页面内容，才使用Java脚本控制 -->

<!-- JSP页面的内容由如下两部分组成：静态部分(标准的HTML标签，静态的页面内容)，动态部分(受Java程序控制的内容) -->

<!-- <%%>之间的是java脚本，而不是静态内容，通过这种方式就可以把java代码嵌入html中，这就变成了动态的JSP页面,这种页面只有在web应用中才有效-->

<!-- JSP的本质依然是servlet，每个jsp页面都是一个servlet实例（由Servlet容器生成对应的servlet，servlet再负责响应用户请求），jsp是servlet的一种简化 -->

<!-- web应用中的每个jsp页面都会由servlet容器生成对应的servlet，对于tomcat而言，jsp页面生成的servlet放在work路径对应的web应用下 -->

欢迎学习Java Web知识，现在时间是：
<%out.println(new java.util.Date()); %>
</body>
</html>