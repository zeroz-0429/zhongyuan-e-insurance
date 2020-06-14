<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>中原E保商城 | 个人信息</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <link rel="stylesheet" type="text/css" href="/static/css/ziy.css">
    <script type="text/javascript" src="/static/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/static/js/select.js"></script>
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
            <c:if test="${ordinaryUser != null}">
                <li class="denglu"><a href="/personal/info?ouid=${ordinaryUsers.ouid}" style="font-size: 15px;font-weight: bold">我的信息</a></li>
                <li class="denglu"><a href="/personal/info?ouid=${ordinaryUsers.ouid}" style="color: orangered">Hi~ ${ordinaryUser.username}</a> 欢迎回来 <a class="red" href="/logout">[注销]</a></li>
            </c:if>
            <c:if test="${ordinaryUser == null}">
                <li class="denglu">Hi~<a class="red" href="/login">请登录!</a> <a href="/register">[免费注册]</a></li>
            </c:if>
            <li class="shu"></li>
            <li class="denglu"><a class="ing_ps" href="/insurance/order?ouid=${ordinaryUsers.ouid}">我的保单</a></li>
        </ul>
    </div>
</div>

<div class="hongs_beij">
    <div class="beij_center">
        <div class="wode_tongc_logo">
            <a class="tongc_logo" href="#"></a>
            <a class="fanh_shouy" href="/index" target="_blank">返回首页</a>
        </div>
    </div>
</div>
<!---->
<div class="wod_tongc_zhongx">
    <div class="beij_center">
        <div class="myGomeWeb">
            <!--侧边导航-->
            <div class="tod_tongc_zuoc">
                <div class="zuoc_toux">
                    <div class="toux_kuang">
                        <div class="userImage">
                            <div class="myGome_userPhoto">
                                <img src="/static/images/toux.png">
                            </div>
                        </div>
                        <div class="user_name_Level">
                            <p class="user_name" title="山的那边是海">${ordinaryUser.username}</p>
                            <p class="userLevel" style="font-size: 13px">用户状态：<span style="color: #005ea7;font-size: 15px">在线</span></p>
                        </div>
                    </div>
                    <div class="userInfo_bar">
                        <span style="font-size: 15px">手机号：</span>
                        <div style="font-size: 15px">${ordinaryUser.phone}</div>
                    </div>
                    <div class="userInfo_bar">
                        <span style="font-size: 15px">邮箱号：</span>
                        <div style="font-size: 15px">${ordinaryUser.email}</div>
                    </div>

                </div>
                <div class="wod_tongc_daoh_lieb">
                    <div class="diy_top">
                        <ul>
                            <h3>订单中心</h3>
                            <li><a href="/insurance/order?ouid=${ordinaryUsers.ouid}" style="font-size: 13px">我的订单</a></li>
                        </ul>
                        <ul>
                            <h3>管理中心</h3>
                            <li><a href="/insurance/favorite?ouid=${ordinaryUsers.ouid}" style="font-size: 13px">我的收藏</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--左边内容-->
            <div class="mod_main">
                <div class="jib_xinx_kuang">
                    <div class="wt">
                        <ul>
                            <li class="dangq_hongx" style="font-size: 18px;font-weight: bold">修改个人信息</li>
                        </ul>
                    </div>
                    <div class="wd">
                        <form action="/personal/update" method="post">
                            <div class="user_set">
                                <input type="hidden" id="ouid" name="ouid" value="${ordinaryUsers.ouid}">
                                <div class="item_meic">
                                    <div class="fl_e">
                                        <label class="label_meic" style="font-size: 15px;margin-left: 30px" for="username"><em>*</em> 用户名：</label>
                                        <input style="height: 28px;width: 250px" type="text" id="username" name="username" disabled="disabled" value="${ordinaryUser.username}">
                                    </div>
                                </div>
                                <div class="item_meic">
                                    <div class="fl_e">
                                        <label class="label_meic" style="font-size: 15px;margin-left: 30px" for="old_password"><em>*</em> 旧密码：</label>
                                        <input style="height: 28px;width: 250px" type="password" id="old_password" name="old_password" >
                                    </div>
                                </div>
                                <div class="item_meic">
                                     ${msg.message}
                                </div>
                                <div class="item_meic">
                                    <div class="fl_e">
                                        <label for="password" class="label_meic" style="font-size: 15px;margin-left: 30px"><em>*</em> 新密码：</label>
                                        <input style="height: 28px;width: 250px" type="password" id="password" name="password" >
                                    </div>
                                </div>
                                <div class="item_meic">
                                    <div class="fl_e">
                                        <label class="label_meic" style="font-size: 15px;margin-left: 30px" for="phone"><em>*</em> 手机号：</label>
                                        <input style="height: 28px;width: 250px" type="text" id="phone" name="phone" value="${user.phone}">
                                    </div>
                                </div>
                                <div class="item_meic">
                                    <div class="fl_e">
                                        <label for="email" class="label_meic" style="font-size: 15px;margin-left: 30px"><em>*</em> 邮箱号：</label>
                                        <input style="height: 28px;width: 250px" type="text" id="email" name="email" value="${user.email}">
                                    </div>
                                </div>
                                <div class="item_meic">
                                    <c:if test="${baseResult != null}">
                                        <div class="${baseResult.message =="修改个人信息成功" ? "green" : "red"}">${baseResult.message}</div>
                                    </c:if>
                                </div>
                                <div class="item_meic">
                                    <div class="fl_e">
                                        <input type="submit" value="保存" class="savebtn">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--底部-->
<div class="dib_beij dib_beij_ger_zhongx">
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