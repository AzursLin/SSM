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
    <div class="row">
    <div class="col-lg-12" id="UEditor">
        <input id="title"  type="text" style="width:500px" placeholder="请输入标题"/></p>
        <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
        <a onclick="submitarticle()" type="button" class="btn btn-sm btn-warning">提交</a>
    </div>
    <!-- /.col-lg-12 -->
    </div>
    <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">动态列表</h1>
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
                        <c:if test="${!empty List}">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>标题</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${List}" var="AlumniMessage">
                                <tr class="odd gradeX" >
                                    <td>${AlumniMessage.id}</td>
                                    <td>${AlumniMessage.title}</td>
                                    <td>${AlumniMessage.creatTime}</td>
                                    <td id=${user.id}>
                                        <a onclick="getMsgDetail(this)"  id=${AlumniMessage.id}  type="button" class="btn btn-sm btn-warning">修改</a>
                                        <a onclick="deleteMsg(this)"  id=${AlumniMessage.id}  type="button" class="btn btn-sm btn-danger">删除</a>
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
    <script type="text/javascript" charset="utf-8" src="../../../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../../../ueditor/ueditor.all.min.js"> </script>
<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script type="text/javascript">
    var ue = UE.getEditor('editor',{
        toolbars: [
            ['fullscreen', 'source', 'undo', 'redo', 'bold', 'italic', 'simpleupload',
                'underline','fontborder', 'inserttable', 'deletetable',
                'justifyleft', 'justifyright','justifycenter', 'justifyjustify',
                'strikethrough','superscript', 'subscript', 'removeformat',
                'formatmatch','autotypeset', 'blockquote', 'pasteplain', '|',
                'forecolor', 'backcolor','insertorderedlist', 'insertunorderedlist',
                'selectall', 'cleardoc', 'link', 'unlink','emotion', 'help']
        ]
    });
    var nowID = 0;
    var action = '';
    $("#UEditor").hide();

    $(function(){
        $("#addUsers").click(function(){
            nowID = null;
            action = 'add';
            $("#title").val('');
            ue.setContent('');
            $("#UEditor").show();
        });

    });

    function getMsgDetail(obj){
        var id =  obj.id;
        var str = "/article/dynamic/update/"+id;
        $.ajax({
            type:"GET",
            url:str,
            dataType: "json",
            success: function (data)
            {
                $("#UEditor").show();
                if( data.id != null){
                    $("#title").val(data.title);
                    ue.setContent(data.content);
                    nowID = data.id;
                    action = 'update';
                    return true;
                }else{
                    alert("错误信息如下："+data.errorMsg);
                    return false;
                }
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {

            }
        })
    };

    function submitarticle(){
        if($("#title").val() == null){
            alert("标题不能为空");
        }
        else{
            var content = UE.getEditor('editor').getContent();
            $.ajax({
                type:'POST',
                url:"/article/sumbit/",
                data: {title:$("#title").val(), content:content,type:"dynamic",action:action,id:nowID},
                dataType: "json",
                success: function (data)
                {
                    if(true ==data.success){
                        alert(data.message);
                        $("#page-wrapper").load("/article/dynamic");
                        return true;
                    }else{
                        alert(data.message);
                        return false;
                    }
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("请求失败！");
                }
            })
        }
    };


    function deleteMsg(obj){
        $.ajax({
            type:'POST',
            url:"/article/sumbit/",
            data: {title:null, content:null,type:"dynamic",action:"delete",id:obj.id},
            dataType: "json",
            success: function (data)
            {
                if( data.success == true){
                    $("#page-wrapper").load("/article/dynamic");
                    return true;
                }else{
                    alert(data.message);
                    return false;
                }
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {

            }
        })};
</script>

</body>

</html>
