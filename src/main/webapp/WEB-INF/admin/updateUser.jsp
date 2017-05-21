<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-02-08
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<body>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">修改用户</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
    <form:form action="/admin/users/updateP" method="post" commandName="userP" role="form">
        <div class="form-group">
            <label for="name">Nickname:</label>
            <input type="text" class="form-control" style="width: 300px" id="name" name="name" placeholder="Enter name:"
                   value="${user.name}"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="Enter Password:"
                   value="${user.password}"/>
        </div>
        <div class="form-group">
            <label for="administrator">Last Name:</label>
            <input type="text" class="form-control" id="administrator" name="administrator" placeholder="Enter administrator:"
                   value="${user.administrator}"/>
        </div>
        <!-- 把 id 一并写入 userP 中 -->
        <input type="hidden" id="id" name="id" value="${user.id}"/>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>

