<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>保险商城 | 用户保单详情</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="box-body">
    <table id="dataTable" class="table ">
        <tbody>

        <tr>
            <td>普通用户账号:</td>
            <td>${insuranceOrders.ioid}</td>
        </tr>
        <tr>
            <td>被保人用户名:</td>
            <td>${insuranceOrders.name}</td>
        </tr>

        <tr>
            <td>被保人身份证:</td>
            <td>${insuranceOrders.identityCard}</td>
        </tr>

        <tr>
            <td>被保人手机号:</td>
            <td>${insuranceOrders.phone}</td>
        </tr>
        <tr>
            <td>所属保单:</td>
            <td>${insuranceOrders.insurance.name}</td>
        </tr>
        <tr>
            <td>创建时间:</td>
            <td><fmt:formatDate value="${insuranceOrders.created}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr>
            <td>更新时间:</td>
            <td><fmt:formatDate value="${insuranceOrders.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>
