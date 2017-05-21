<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>校友寄语</title>

    <!-- Bootstrap -->
    <link href="../dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../dist/css/message.css">
    <link rel="stylesheet" href="../dist/css/anniversary-style.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../dist/js/html5shiv.min.js"></script>
    <script src="../dist/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <img src="" alt="" class="anniversary-image pull-left">
        <div class="anniversary-content pull-right index-transparent">
            <p class="content-title">校友寄语：</p>
            <p class="content-title">${AlumniMessage.title}</p>
            <p class="content-title">${AlumniMessage.content}</p>
        </div>
    </div>
    <div class="row clearfix">
        <div class="sxau-crest pull-left"><img src="" alt=""></div>
        <div class="sxau-copyright pull-left">
            <p class="copyright-text pull-left">版权所有：山西农业大学校庆办</p><br>
            <p class="address-text pull-left">地 址：山西省太谷县</p>
        </div>
        <div class="weixin-qr-code pull-right"><img src="" alt=""></div>
        <div class="QQ-qr-code pull-right"><img src="" alt=""></div>
        <div class="sxau-link pull-right">
            <a href="" class="official-website ">【农大官网】</a><br>
            <a href="index.html" class="return-home-page ">【返回首页】</a>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../dist/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../dist/js/bootstrap.min.js"></script>
</body>
</html>