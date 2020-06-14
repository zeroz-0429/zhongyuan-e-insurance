<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>MyShop | 个人注册</title>
    <link rel="stylesheet" href="/static/css/index.css"/>
    <link rel="stylesheet" href="/static/css/ziy.css"/>
</head>
<body>
<!--dengl-->
<div class="yiny">
    <div class="beij_center">
        <div class="dengl_logo">
            <h1 style="margin-left: 160px">欢迎注册中原E保商城</h1>
        </div>
    </div>
</div>
<div class="beij_center">
    <div class="ger_zhuc_beij">
        <div class="ger_zhuc_biaot">
            <ul>
                <li class="ger_border_color"><a href="/register">个人注册</a></li>
                <p>我已经注册，现在就<a style="font-size: 20px" class="ftx-05 ml10" href="/login">登录</a></p>
            </ul>
        </div>
        <div class="zhuc_biaod">
            <c:if test="${baseResult != null}">
                <div  style=" margin-left: 150px;font-size: 16px" class="${baseResult.status==200 ? "green" : "red"}">${baseResult.message}</div>
            </c:if>
            <form action="/register" method="post">
                <div class="reg-items">
              	<span class="reg-label">
                	<label>用户名：</label>
              	</span>
                    <input class="i-text" id="username" name="username" type="text" value="${user.username}">
                </div>
                <c:if test="${resultName != null}">
                    <div  style=" margin-left: 150px;font-size: 16px" class="red">${resultName.message}</div>
                </c:if>
                <div class="reg-items">
              	<span class="reg-label">
                	<label>设置密码：</label>
              	</span>
                    <input class="i-text" id="password" name="password" type="password" >
                </div>
                <c:if test="${resultPassword != null}">
                    <div  style=" margin-left: 150px;font-size: 16px" class="red">${resultPassword.message}</div>
                </c:if>
                <div class="reg-items">
              	<span class="reg-label">
                	<label>确认密码：</label>
              	</span>
                    <input class="i-text" id="repassword" name="repassword" type="password" >
                </div>
                <div class="red" style="margin-left: 150px">${msg.message}</div>
                <div class="reg-items">
              	<span class="reg-label">
                	<label>手机号码：</label>
              	</span>
                    <input class="i-text" id="phone" name="phone" type="text" value="${user.phone}">
                </div>
                <c:if test="${resultPhone != null}">
                    <div  style=" margin-left: 150px;font-size: 16px" class="red">${resultPhone.message}</div>
                </c:if>
                <div class="reg-items">
              	<span class="reg-label">
                	<label>邮箱：</label>
              	</span>
                    <input class="i-text " id="email" name="email" type="text" value="${user.email}">
                </div>
                <c:if test="${resultEmail != null}">
                    <div  style=" margin-left: 150px;font-size: 16px" class="red">${resultEmail.message}</div>
                </c:if>
                <div class="reg-items">
              	<span class="reg-label">
                	<label> </label>
              	</span>
                    <div class="dag_biaod">
                        <input name="isRemember" type="checkbox"  ${isRemember==true ? "checked" : ""}>
                        阅读并同意
                        <a href="#" class="ftx-05 ml10">《中原E保注册协议》</a>
                        <a href="#" class="ftx-05 ml10">《隐私协议》</a><br>
                        <div class="red">${message.message}</div>
                    </div>
                </div>
                <div class="reg-items">
              	<span class="reg-label">
                    <label> </label>
                </span>
                    <input class="reg-btn" value="立即注册" type="submit">
                </div>
            </form>

        </div>
        <div class="xiaogg">
            <img src="/static/images/cdsgfd.jpg">
        </div>
    </div>
</div>


<div class="jianj_dib jianj_dib_1">
    <div class="beia_hao">
        <p>京ICP备：123456789号 </p>
        <p class="gonga_bei">京公网安备：123456789号</p>
    </div>
</div>

</body>
</html>
