<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>校友空间</title>

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
        <div class="space-left-content pull-left">
            <form action="">
                <button class="btn space-query-btn space-query-text">本科生查询</button>
                <button class="btn space-query-btn space-query-text space-query-right-btn">研究生查询</button><br>
                <label class="form-text">姓&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
                <input type="text" class="index-transparent space-input"><br>
                <label class="form-text">籍&nbsp;&nbsp;&nbsp;&nbsp;贯:</label>
                <input type="text" class="index-transparent space-input"><br>
                <label class="form-text">工作单位:</label>
                <input type="text" class="index-transparent space-input"><br>
                <label class="form-text">专&nbsp;&nbsp;&nbsp;&nbsp;业:</label>
                <input type="text" class="index-transparent space-input"><br>
                <label class="form-text">入学年份:</label>
                <input type="text" class="index-transparent space-input"><br>
                <button class="btn space-bottom-text space-bottom-btn">校友查询</button>
                <input class="btn space-bottom-text space-bottom-btn" type="reset">
            </form>
        </div>
        <div class="space-right-content pull-right index-transparent">
            <p class="inquiry-description">查询说明:</p>
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