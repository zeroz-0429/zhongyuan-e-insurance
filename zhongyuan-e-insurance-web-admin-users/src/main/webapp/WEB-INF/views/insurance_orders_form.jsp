<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 编辑用户保单</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户保单管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">用户保单管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult!=null}">
                        <div class="alert alert-${baseResult.status==200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">编辑用户保单</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form  id="inputForm" cssClass="form-horizontal" action="/insurance/orders/save" method="post" modelAttribute="insuranceOrders">
                            <form:hidden path="ioid"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="ordinaryUsers.username" class="col-sm-2 control-label">所属用户</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="ordinaryUsers.username" placeholder="请输入保单所属用户"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="name" class="col-sm-2 control-label">被保人姓名</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="name" placeholder="请输入被保人姓名号"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="identityCard" class="col-sm-2 control-label">被保人身份证</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="identityCard" placeholder="请输入被保人身份证"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="phone" class="col-sm-2 control-label">被保人手机</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required mobile" path="phone" placeholder="请输入被保人手机"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="insurance.name" class="col-sm-2 control-label">所属保单</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="insurance.name" placeholder="所属保单"/>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>


<jsp:include page="../includes/footer.jsp"/>

<script>
    $(function () {
        Validate.init();
    });
</script>
</body>
</html>
