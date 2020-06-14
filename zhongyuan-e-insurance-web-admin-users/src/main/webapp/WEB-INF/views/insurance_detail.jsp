<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>保险商城 | 保险详情</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="box-body">
    <table id="dataTable" class="table ">
        <tbody>

        <tr>
            <td>保险名称:</td>
            <td>${insurance.name}</td>
        </tr>

        <tr>
            <td>保险价格:</td>
            <td>${insurance.price}</td>
        </tr>

        <tr>
            <td>是否参与活动:</td>
            <td>${insurance.isActivity==0 ? "否" : "是"}</td>
        </tr>

        <tr>
            <td>保险状态:</td>
            <td>${insurance.state==0 ? "已下架" : "热卖中"}</td>
        </tr>

        <tr>
            <td>所属分类:</td>
            <td>${insurance.insuranceCategory.name}</td>
        </tr>
        <tr>
            <td>创建时间:</td>
            <td><fmt:formatDate value="${insurance.created}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr>
            <td>更新时间:</td>
            <td><fmt:formatDate value="${insurance.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>
