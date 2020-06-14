<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>中原E保商城 | 提交保单</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <link rel="stylesheet" type="text/css" href="/static/css/ziy.css">
    <script src="/static/js/jquery-1.11.3.min.js" ></script>
    <script type="text/javascript" src="/static/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery.SuperSlide.2.1.1.source.js"></script>

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
<c:if test="${ordinaryUsers.ouid != null}" >
    <div class="beij_center">
        <div class="checkout-tit">
            <span class="tit-txt">填写并核对订单信息</span>
        </div>
        <div class="checkout_steps">
            <div class="step-tit">
                <h3>请填写被保人信息</h3>
            </div>
            <form action="/insurance/up" method="post" id="insert">
                <input type="hidden" id="ordinaryUsers.ouid" name="ordinaryUsers.ouid" value="${ordinaryUsers.ouid}">
                <c:forEach items="${singleProduct}" var="singleProduct">
                    <input type="hidden" id="insurance.iid" name="insurance.iid" value="${singleProduct.iid}">
                </c:forEach>
                <div class="jies_y_shouh_diz shiq_1">
                    <div>
                        <label for="name" style="margin-left: 50px;font-size: 18px">被保人姓名：</label>
                        <input id="name" name="name" value="${order.name}" type="text" style="margin-left: 10px;width: 200px;height: 26px;border: solid 1px #c0c0c0">
                        <label for="name" style="margin-left: 50px;font-size: 18px;color:red;">${name.message}</label>
                    </div>
                </div>
                <div class="jies_y_shouh_diz shiq_2">
                    <div>
                        <label for="identityCard" style="margin-left: 32px;font-size: 18px">被保人身份证：</label>
                        <input id="identityCard" name="identityCard" value="${order.identityCard}" type="text" style="margin-left: 10px;width: 200px;height: 26px;border: solid 1px #c0c0c0">
                        <label for="name" style="margin-left: 50px;font-size: 18px;color:red;">${card.message}</label>
                    </div>
                </div>
                <div class="jies_y_shouh_diz shiq_2">
                    <div>
                        <label for="phone" style="margin-left: 50px;font-size: 18px">被保人手机：</label>
                        <input id="phone" name="phone" value="${order.phone}" type="text" style="margin-left: 10px;width: 200px;height: 26px;border: solid 1px #c0c0c0">
                        <label for="name" style="margin-left: 50px;font-size: 18px;color:red;">${phone.message}</label>
                    </div>
                </div>
            </form>
            <div class="step-tit">
                <h3>保险清单</h3>
            </div>
            <c:forEach items="${singleProduct}" var="singleProduct">
                <div class="beij_center" style="margin-left: -20px">
                    <div class="cart-main-header clearfix">
                        <div class="cart-col-3" style="margin-left: 80px">保险图片</div>
                        <div class="cart-col-4">
                            <div class="cart-good-real-price">保险名称</div>
                        </div>
                        <div class="cart-col-5" style="margin-left: 120px">保险价格</div>
                        <div class="cart-col-6">
                            <div class="cart-good-amount">保障期限</div>
                        </div>
                        <div class="cart-col-6">
                            <div class="cart-good-amount">付款金额</div>
                        </div>
                    </div>
                </div>
                <div class="cart-shop-good">
                    <div class="cart-col-2" style="height: 60px;margin-left: 50px">
                        <a href="" target="_blank" class="g-img"><img src="${singleProduct.pictrue}" alt=""></a>
                    </div>
                    <div class="fl houj_c">
                        <div class="cart-col-3" style="margin-left: 120px;margin-top: 20px"><a href="#" target="_blank">${singleProduct.name}</a></div>
                        <div class="cart-col-4" ><div class="cart-good-real-price "style="margin-left: 100px;margin-top: 20px">¥&nbsp;${singleProduct.price}</div><div class="red"></div></div>
                        <div class="cart-col-5">
                            <div class="gui-count cart-count" style="margin-left: 160px;margin-top: 20px">
                                <span >一年</span>
                            </div>
                        </div>
                        <div class="cart-col-6 ">
                            <div class="cart-good-amount" style="margin-left: 130px;margin-top: 20px;color: red">¥&nbsp;${singleProduct.price}</div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</c:if>
<c:if test="${ordinaryUsers.ouid == null}" >
    <div class="beij_center">
        <div class="jiar_gouw_c_beij">
            <div class="msg"><i class="c_i_img"></i>您还未登录，请登录后投保购买！</div>
            <div class="shangp_jr">
                <div class="jr_you">
                    <a class="jr_fanh" onclick="history.go(-1)">返回</a>
                </div>
            </div>
        </div>
    </div>
</c:if>
<div class="jies_beij">
    <div class="beij_center over_dis">
        <div class="jies_ann_bei">
            <button onclick="insert()" class="order_btn" type="submit">支付订单</button>
        </div>
    </div>
</div>

<script type="text/javascript">
    function insert() {
        $("#insert").submit();
    }
</script>

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
