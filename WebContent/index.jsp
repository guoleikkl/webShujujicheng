<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="utf-8">
        <title>学生管理系统</title>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    </head>
<body>
<div>
	<h1>学生信息管理系统</h1>
</div>
<div>
<button class="btn btn-success" onclick="window.location.href='/list.jsp'">schoolA学生管理</button>
<button class="btn btn-success" onclick="window.location.href='/listb.jsp'">schoolB学生管理</button>
</div>
<div><p> </p></div>
<div>
<button class="btn btn-success" onclick="window.location.href='/listall.jsp'">总体学生管理</button>
</div>
<div><p> </p> </div>
<div>
<button class="btn btn-success" onclick="window.location.href='/find.jsp'">总体学生查询</button>
</div>
</body>
</html>