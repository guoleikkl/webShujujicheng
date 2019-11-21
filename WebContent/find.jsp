<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>学生管理系统</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>
<body>
<form></form>
	<div>
		学号：
		<input type="text" name="studentId">
	</div>
	<div class="form-group">
    	<button type="submit" class="btn btn-info">查找</button>
    </div>
    <div>
    	<table class="table">
                    <thead>
                        <td>学生学院</td>
                        <td>学生姓名</td>
                        <td>学生年龄</td>
                        <td>学生性别</td>
                    </thead>
                    <tbody>
                            <tr>
                                <td>${student.studentCollege}</td>
                                <td>${student.studentName}</td>
                                <td>${student.studentAge}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${student.studentSex == 0}">女</c:when>
                                        <c:when test="${student.studentSex == 1}">男</c:when>
                                    </c:choose>
                                </td>
                            </tr>
                    </tbody>
                </table>
    </div>
</form>
</body>
</html>