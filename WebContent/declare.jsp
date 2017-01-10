<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP声明</title>
</head>

<body>
<!-- html注释格式 -->

<%--jsp注释格式 --%>

<%--jsp脚本(<% %>) --%>

<%--jsp声明格式(<%! %>) --%>

<%--jsp输出表达式值(<%= %>),最后不要有分号 --%>

<!-- 下面是jsp声明部分:jsp页面的声明部分将转换成对应servlet的成员变量和成员方法-->
<%-- JSP页面会被编译成一个servlet类，每个servlet在容器中只有一个实例，在JSP中声明的变量是成员变量，成员变量只在创建实例时初始化 --%>

<%!
//声明一个整型变量
public int count;
//声明一个方法
public String info(){
	return "加油!";
}
%>

<%out.println(count++);%>
<br>
使用输出表达式输出变量值：
<%=count++%>

<br/>

<%out.println(info());%>
<br>
使用表达式输出方法返回值:
<%=info()%>
</body>
</html>