<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收集参数的表单页</title>
</head>

<body>
<form id="form" method="post" action="request.jsp">

用户名:<br>
<input type="text" name="name"><hr/>

性别:<br/>
男:<input type="radio" name="gender" value="男">
女:<input type="radio" name="gender" value="女"><hr/>

喜欢的颜色:<br/>
红:<input type="checkbox" name="color" value="红">
绿:<input type="checkbox" name="color" value="绿">
蓝:<input type="checkbox" name="color" value="蓝"> 

<br/>来自的国家:
<select name="country">
<option value="中国">中国</option>
<option value="日本">日本</option>
<option value="美国">美国</option>
</select><hr/>

<input type="submit" value="提交">
<input type="reset" value="重置">
</form>
</body>
</html>