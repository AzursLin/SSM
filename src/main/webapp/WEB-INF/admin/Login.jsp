<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>后台登录</title>

    <!-- Bootstrap -->
    <link href="../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../dist/js/html5shiv.min.js"></script>
    <script src="../dist/js/respond.min.js"></script>
    <![endif]-->
    <style>
        body{
            margin-left:auto;
            margin-right:auto;
            margin-TOP:100PX;
            width:20em;
        }
    </style>
</head>
<body>
<!--下面是用户名输入框-->
<div class="input-group">
    <span class="input-group-addon" id="basic-addon1">@</span>
    <input id="userName" type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
</div>
<br>
<!--下面是密码输入框-->
<div class="input-group">
    <span class="input-group-addon" id="basic-addon1">@</span>
    <input id="passWord" type="text" class="form-control" placeholder="密码" aria-describedby="basic-addon1">
</div>
<br>
<!--下面是登陆按钮,包括颜色控制-->
<button onclick="Login(this)" type="button" style="width:280px;" class="btn btn-default">登 录</button>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../dist/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../dist/js/bootstrap.min.js"></script>

<script type="text/javascript">

    function Login(obj){
        $.ajax({
            type:'POST',
            url:"/admin/Logining",
            data: {userName:$("#userName").val(), passWord:$("#passWord").val()},
            dataType: "json",
            success: function (data)
            {
                if( true ==data.success){
                    alert(data.message);
                    window.location.href='/admin/myCMS';
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