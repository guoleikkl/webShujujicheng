<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>学生管理系统</title>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    </head>
    <body style="padding-top: 20px;">
        <div class="container">
            <div class="col-md-8 col-md-offset-2">
                <h1>学生列表</h1><br>
                <table class="table">
                    <thead>
                        <td>学生ID</td>
                        <td>学生学院</td>
                        <td>学生姓名</td>
                        <td>学生年龄</td>
                        <td>学生性别</td>
                        <td>操作</td>
                    </thead>
                    <tbody>
                        <c:forEach items="${studentList}" var="student">
                            <tr>
                                <td>${student.studentId}</td>
                                <td>${student.studentCollege}</td>
                                <td>${student.studentName}</td>
                                <td>${student.studentAge}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${student.studentSex == 0}">女</c:when>
                                        <c:when test="${student.studentSex == 1}">男</c:when>
                                    </c:choose>
                                </td>
                                <td>
                                    <a class="btn btn-info btn-sm" href="/update?studentId=${student.studentId}">更 新</a>
                                    <a class="btn btn-danger btn-sm" href="/delete?studentId=${student.studentId}">删 除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button class="btn btn-success" onclick="window.location.href='/add'">添加学生</button>
                <button class="btn btn-info" onclick="window.location.href='/ListServlet'">刷新列表</button>
            </div>
        </div>
    </body>
</html>