<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp-include测试</title>
</head>
<body>
	<jsp:include page="forward-result.jsp">
		<jsp:param value="40" name="age" />
	</jsp:include>
</body>
</html>