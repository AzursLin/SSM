<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/12 0012
  Time: 下午 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="row">
    <div class="col-lg-12">
        <h1>文章发布</h1>
        <hr/>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <input id="title"  type="text" style="width:500px" placeholder="请输入标题"/></p>
        <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
        <hr/>
    </div>
</div>
<div class="row">
    <a onclick="submitarticle()" type="button" class="btn btn-sm btn-warning">提交</a>
</div>


<script type="text/javascript" charset="utf-8" src="../../../ueditor/1ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="../../../ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript">

    //实例化编辑器
    var ue = UE.getEditor('editor');

    function submitarticle(){
        if($("#title").val() == null){
            alert("标题不能为空");
        }
        else{
            var content = UE.getEditor('editor').getContent();
            $.ajax({
                type:'POST',
                url:"/article/sumbit/",
                data: {title:$("#title").val(), content:content},
                dataType: "json",
                success: function (data)
                {
                    if(true ==data.success){
                        alert(data.message);
                        return true;
                    }else{
                        alert("错误信息如下："+data.errorMsg);
                        return false;
                    }
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("请求失败！");
                }
            })
        }
    };

</script>
</body>
</html>
