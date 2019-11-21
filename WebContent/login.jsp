<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>学生管理系统</title>
</head>
<body>
	<div>
		<h1>登陆</h1>
	</div>
	
	<div>
		<label>用户名</label>
        <input type="text" class="form-control" name="adminName">
	</div>
	
	<div>
		<label>密码</label>
        <input type="password" class="form-control" name="adminPassword">
	</div>
	
	<div>
        <button type="btn btn-info" onclick="window.location.href='/Login'">登陆</button>
    </div>

</body>
</html>