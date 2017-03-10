<%--
  Created by IntelliJ IDEA.
  User: Azurs
  Date: 2017-01-26
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">


<body>

<div id="wrapper">




    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">用户列表</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a href="javascript:;" id="addUsers" type="button" class="btn btn-sm btn-primary">添加</a>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <!-- 如果用户列表非空 -->
                        <c:if test="${!empty userList}">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>用户名</th>
                                <th>密码</th>
                                <th>管理权限</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${userList}" var="user">
                                <tr class="odd gradeX">
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.password}</td>
                                    <td>${user.administrative}</td>
                                    <td>
                                        <a href="/admin/users/show/${user.id}" type="button" class="btn btn-sm btn-success">详情</a>
                                        <a href="/admin/users/update/${user.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                                        <a href="/admin/users/delete/${user.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        </c:if>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="../../../vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../../../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../../../vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="../../../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../../../vendor/datatables-responsive/dataTables.responsive.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../../../dist/js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script type="text/javascript">
    $(function(){
        $("#addUsers").click(function(){
            $("#wrapper").load("/admin/users/add/");
        });
    });
</script>

</body>

</html>
