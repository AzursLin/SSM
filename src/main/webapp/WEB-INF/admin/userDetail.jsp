<%--
  Created by IntelliJ IDEA.
  User: Azurs
  Date: 2017-01-27
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<body>
<div id="wrapper">

    <div id="page-wrapper">
    <h1>SpringMVC 用户详情</h1>
    <hr/>

    <table class="table table-bordered table-striped">
        <tr>
            <th>ID</th>
            <td>${user.id}</td>
        </tr>
        <tr>
            <th>用户名</th>
            <td>${user.name}</td>
        </tr>
        <tr>
            <th>密码</th>
            <td>${user.password}</td>
        </tr>
        <tr>
            <th>管理权限</th>
            <td>${user.administrator}</td>
        </tr>
    </table>
    </div>
</div>
</body>
</html>