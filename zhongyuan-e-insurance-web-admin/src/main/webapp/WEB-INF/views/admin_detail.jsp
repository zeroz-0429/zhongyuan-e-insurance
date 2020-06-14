<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>保险商城 | 管理员用户详情</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="box-body">
    <table id="dataTable" class="table ">
        <tbody>

        <tr>
            <td>手机:</td>
            <td>${adminUsers.phone}</td>
        </tr>

        <tr>
            <td>邮箱:</td>
            <td>${adminUsers.email}</td>
        </tr>

        <tr>
            <td>管理员状态:</td>
            <td>${adminUsers.state==0 ? "未激活" : "已激活"} </td>
        </tr>
        <tr>
            <td>创建时间:</td>
            <td><fmt:formatDate value="${adminUsers.created}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr>
            <td>更新时间:</td>
            <td><fmt:formatDate value="${adminUsers.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>
