<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>校庆主页</title>

    <!-- Bootstrap -->
    <link href="../dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../dist/css/index-style-t.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../dist/js/html5shiv.min.js"></script>
    <script src="../dist/js/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="../dist/css/liMarquee.css">
    <style>
        .dowebok {
            width: 790px;
            height: 500px;
            margin: 100px auto;
            font-size: 14px;
            background: hsla(0, 0%, 100%, .0);
        }

        .dowebok ul {
            margin: 0;
            line-height: 30px;
        }

        .dowebok a {
            color: #333;
            text-decoration: none;
        }

        .dowebok a:hover {
            text-decoration: underline;
        }

        .str_wrap.str_active {
            background: hsla(0, 0%, 100%, .0);
        }
    </style>
</head>
<body>
<div class="index-header container-fluid">
</div>
<div class="container">
    <div class="row clearfix">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                <li data-target="#carousel-example-generic" data-slide-to="4"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" style="text-align:center">
                <div class="item">
                    <img alt="First slide" src="../dist/images/图层-14.png">
                </div>
                <div class="item">
                    <img alt="Second slide" src="../dist/images/图层-14.png">
                </div>
                <div class="item active">
                    <img alt="Third slide" src="../dist/images/图层-14.png">
                </div>
                <div class="item">
                    <img alt="Fourth slide" src="../dist/images/图层-14.png">
                </div>
                <div class="item">
                    <img alt="Fifth slide" src="../dist/images/图层-14.png">
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="cut-off-rule"></div>
    </div>
    <div class="row clearfix">
        <ul>
            <li class="index-button"><a class="index-link btn btn-default index-left-button"
                                        href="anniversary-announcementlist?page=1">校庆公告</a></li>
            <li class="index-button"><a class="index-link btn btn-default"
                                        href="anniversary-dynamiclist?page=1">校庆动态</a></li>
            <li class="index-button"><a class="index-link btn btn-default" href="alumni-space.html">校友空间</a></li>
            <li class="index-button"><a class="index-link btn btn-default" href="alumni-messagelist?page=1">校友寄语</a>
            </li>
            <li class="index-button"><a class="index-link btn btn-default" href="data-download.html">资料下载</a></li>
        </ul>
    </div>
    <div class="row clearfix">
        <div class="wrap">
            <div class="left-content">
                <div class="top-side-bar index-transparent ">
                    <p class="content-title pull-left">校庆公告:</p>
                    <c:if test="${!empty AnniversaryAnnouncementList}">
                        <a href="" class="index-more pull-right">+more</a>
                        <div class="dowebok">
                            <ul>
                                <c:forEach items="${AnniversaryAnnouncementList}" var="AnniversaryAnnouncement">
                                    <a href="anniversary-announcement?id=${AnniversaryAnnouncement.id}&code=${AnniversaryAnnouncement.creatTime}">
                                        <li class="specific-content-list"> ${AnniversaryAnnouncement.title}</li>
                                    </a>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                </div>
                <div class="button-side-bar index-transparent">
                    <p class="content-title pull-left">校庆动态:</p>
                    <c:if test="${!empty AnniversaryDynamicList}">
                        <a href="" class="index-more pull-right">+more</a>
                        <div class="specific-content">
                            <ul>
                                <c:forEach items="${AnniversaryDynamicList}" var="AnniversaryDynamic">
                                    <a href="anniversary-dynamic?id=${AnniversaryDynamic.id}&code=${AnniversaryDynamic.creatTime}">
                                        <li class="specific-content-list"> ${AnniversaryDynamic.title}</li>
                                    </a>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="right-content index-transparent">
                <p class="content-title pull-left">校友寄语:</p>
                <c:if test="${!empty AlumniMessageList}">
                    <a href="" class="index-more pull-right">+more</a>
                    <div class="specific-content">
                        <ul>
                            <c:forEach items="${AlumniMessageList}" var="AlumniMessage">
                                <a href="alumni-message?id=${AlumniMessage.id}&code=${AlumniMessage.creatTime}">
                                    <li class="specific-content-list"> ${AlumniMessage.title}</li>
                                </a>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<div class="clearfix index-footer container-fluid">
    <div class="row clearfix">
        <div class="cut-off-rule"></div>
    </div>
    <div class="sxau-crest pull-left"><img src="" alt=""></div>
    <div class="sxau-copyright pull-left">
        <p class="copyright-text pull-left">版权所有：山西农业大学校庆办</p><br>
        <p class="address-text pull-left">地 址：山西省太谷县</p>
    </div>
    <div class="weixin-qr-code pull-right"><img src="" alt=""></div>
    <div class="QQ-qr-code pull-right"><img src="" alt=""></div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../dist/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../dist/js/bootstrap.min.js"></script>
<script src="../dist/js/jquery.liMarquee.js"></script>
<script>
    $('.carousel').carousel('cycle');
    $(function () {
        $('.dowebok').liMarquee({
            direction: 'down'
        });
    });
</script>
<script type="text/javascript">

</script>
</body>
</html>