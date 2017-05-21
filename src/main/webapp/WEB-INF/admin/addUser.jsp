<%--
  Created by IntelliJ IDEA.
  User: Azurs
  Date: 2017-01-27
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">添加用户</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
    <form:form action="/admin/users/addP" method="post" commandName="user" role="form">
        <div class="form-group">
            <label for="name">用户名:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="输入用户名:"/>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="输入密码:"/>
        </div>
        <div class="form-group">
            <label for="administrator">管理权限:</label>
            <input type="text" class="form-control" id="administrator" name="administrator" placeholder="权限:"/>
        </div>
        <div class="form-group">
            <a onclick="postAddUser()" type="button" class="btn btn-sm btn-success">提交</a>
        </div>
    </form:form>
    </div>
        </div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
    function postAddUser(){
        $.ajax({
            type:"POST",
            url:"/admin/users/addP",
            dataType: "json",
            data:{ name:encodeURI($("#name").val()),
                    password:encodeURI($("#password").val()),
                      administrator:encodeURI($("#administrator").val())},
            success: function (data ,textStatus, jqXHR)
            {
                if("true"==data.flag){
                    $("#page-wrapper").load("/admin/users");
                    return true;
                }else{
                    alert("不合法！错误信息如下："+data.errorMsg);
                    return false;
                }
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
    })};
</script>
</body>
</html>