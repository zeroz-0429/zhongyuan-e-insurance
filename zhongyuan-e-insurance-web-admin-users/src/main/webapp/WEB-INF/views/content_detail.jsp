<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 内容详情</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="box-body">
    <table id="dataTable" class="table ">
        <tbody>
        <tr>
            <td>所属分类:</td>
            <td>${content.contentCategory.name}</td>
        </tr>
        <tr>
            <td>标题:</td>
            <td>${content.title}</td>
        </tr>
        <tr>
            <td>标题描述:</td>
            <td>${content.titleDesc}</td>
        </tr>
        <tr>
            <td>图片路径:</td>
            <td>${content.pictrue}</td>
        </tr>
        <tr>
            <td>详情内容:</td>
            <td>${content.content}</td>
        </tr>
        <tr>
            <td>更新时间:</td>
            <td><fmt:formatDate value="${content.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>
