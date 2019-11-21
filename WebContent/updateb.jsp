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
                <h1>更新学生</h1><br>
                <form action="/updateb" method="post">
                    <div class="form-group">
                        <label>学生ID</label>
                        <input type="hidden" class="form-control" name=studentId value="${student.studentId}">
                    </div>
                    <div class="form-group">
                        <label>学生学院</label>
                        <input type="text" class="form-control" name="studentCollege" value="${student.studentCollege}">
                    </div>
                    <div class="form-group">
                        <label>学生姓名</label>
                        <input type="text" class="form-control" name="studentName" value="${student.studentName}">
                    </div>
                    <div class="form-group">
                        <label>学生年龄</label>
                        <input type="text" class="form-control" name="studentAge" value="${student.studentAge}">
                    </div>
                    <div class="form-group">
                        
                                <label class="radio-inline">
                                          <input type="radio" name="studentSex" id="studentSex" value="1"> 男
                                        </label>
                                <label class="radio-inline">
                                          <input type="radio" name="studentSex" id="studentSex" value="0"> 女
                                        </label>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-info">更新学生</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>