<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>中原E保商城 | 首页</title>
    <link rel="stylesheet" href="/static/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/ziy.css">

    <script type="text/javascript" src="/static/js/jquery-1.11.1.min.js"></script>
    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/js/jquery.SuperSlide.2.1.1.source.js"></script>
    <script src="/static/js/index.js"></script>
</head>
<body>
<!--侧边-->
<div class="jdm-toolbar-wrap J-wrap">
    <div class="jdm-toolbar J-toolbar">
        <div class="jdm-toolbar-panels J-panel"></div>
        <div class="jdm-toolbar-tabs J-tab">
            <a href="/insurance/order?ouid=${ordinaryUsers.ouid}">
                <div data-type="bar" class="J-trigger jdm-toolbar-tab jdm-tbar-tab-ger">
                    <i class="tab-ico"></i>
                    <em class="tab-text">我的保单</em>
                </div>
            </a>
            <a href="/insurance/favorite?ouid=${ordinaryUsers.ouid}">
                <div data-type="bar" class="J-trigger jdm-toolbar-tab jdm-tbar-tab-cart">
                    <i class="tab-ico"></i>
                    <em class="tab-text">我的收藏</em>
                </div>
            </a>
        </div>
    </div>
    <div class="jdm-toolbar-footer">
        <div data-type="link" id="#top" class="J-trigger jdm-toolbar-tab jdm-tbar-tab-top">
            <a href="#" clstag="h|keycount|cebianlan_h|top">
                <i class="tab-ico"></i>
                <em class="tab-text">顶部</em>
            </a>
        </div>
    </div>
    <div class="jdm-toolbar-mini"></div>
    <div id="J-toolbar-load-hook" clstag="h|keycount|cebianlan_h|load"></div>
</div>

<!--头部-->
<div id="header">
    <div class="header-box">
        <h3 class="huany">中原E保商城欢迎您的到来！</h3>
        <h3 class="huany"><a href="/company/info" style="font-size: 15px;color: #0f0f0f;font-weight: bold">关于公司</a></h3>
        <h3 class="huany"><a href="/insurance/introduce" style="font-size: 15px;color: #0f0f0f;font-weight: bold">投保说明</a></h3>
        <ul class="header-right">
            <c:if test="${ordinaryUsers != null}">
                <li class="denglu"><a href="/personal/info?ouid=${ordinaryUsers.ouid}" style="font-size: 15px;font-weight: bold">我的信息</a></li>
                <li class="denglu"><a href="/personal/info?ouid=${ordinaryUsers.ouid}" style="color: orangered">Hi~ ${ordinaryUsers.username}</a> 欢迎回来 <a class="red" href="/logout">[注销]</a></li>
            </c:if>
            <c:if test="${ordinaryUsers == null}">
                <li class="denglu">Hi~<a class="red" href="/login">请登录!</a> <a href="/register">[免费注册]</a></li>
            </c:if>
            <li class="shu"></li>
            <li class="denglu"><a class="ing_ps" href="/insurance/order?ouid=${ordinaryUsers.ouid}">我的保单</a></li>
        </ul>
    </div>
</div>

<!--搜索栏-->
<div class="toub_beij">
    <div class="logo"><a href="#"><img src="/static/images/logo.png"></a></div>
    <form action="/search" method="get">
        <div class="search">
            <input type="text" name="name" class="text" id="textt" placeholder="请输入保险的名称">
            <button type="submit" class="button">搜索</button>
        </div>
    </form>
    <div class="right">
        <i class="gw-left"></i>
        <a href="/insurance/favorite?ouid=${ordinaryUsers.ouid}">我的收藏</a>
    </div>
</div>

<!--轮播图上方导航栏  一栏-->
<div id="navv">
    <div class="focus">
        <div class="focus-a">
            <div class="fouc-font"><a href="/index">E保商城首页</a> </div>
        </div>
        <div class="focus-b">
            <ul>
                <c:forEach items="${category}" var="category">
                    <li><a href="/insurance_list?categoryId=${category.icid}">${category.name}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<!--简介-->
<div class="shangj_dianp_jiej">
    <div class="jianj_img"><img src="/static/images/baoxianbeijing.png"></div>
    <div class="beij_center fl_01">
        <div class="jianj_text">
            <div class="dianp_jianj">
                <c:forEach items="${companyInfo}" var="companyInfo">
                <h2>${companyInfo.title}</h2>
                <div class="haod_kz">
                    ${companyInfo.content}
                </div>
                </c:forEach>
            </div>
            <div class="dianp_jianj">
                <c:forEach items="${companyDev}" var="companyDev">
                <h2>${companyDev.title}</h2>
                <div class="haod_kz">
                    ${companyDev.content}
                </div>
                </c:forEach>
            </div>

        </div>
    </div>
</div>

<!--底部-->
<div class="dib_beij">
    <div class="dib_jvz_beij">
        <div class="shangp_baoz">
            <p>本地购物&nbsp;&nbsp;看得见的商品</p>
            <p class="beng1">正品行货&nbsp;&nbsp;购物无忧</p>
            <p class="beng2">低价实惠&nbsp;&nbsp;帮你省钱</p>
            <p class="beng3">本地直发&nbsp;&nbsp;专业配送</p>
        </div>
        <div class="beia_hao">
            <p>京ICP备：123456789号  </p>
            <p class="gonga_bei">京公网安备：123456789号</p>
            <div class="renz_">
                <span></span>
                <span class="span1"></span>
                <span class="span2"></span>
                <span class="span3"></span>
            </div>
        </div>
    </div>
</div>



</body>
</html>

