<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 管理员个人信息</title>
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
                管理员个人信息
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">管理员个人信息</li>
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
                            <h3 class="box-title">个人密码修改</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
<%--                        <form class="form-horizontal" id="inputForm" action="/admin/users/edit" method="post">--%>
<%--                            <div class="box-body">--%>
<%--                                <div class="form-group">--%>
<%--                                    <label for="password" class="col-sm-2 control-label">旧密码</label>--%>

<%--                                    <div class="col-sm-10">--%>
<%--                                        <input type="password" class="form-control " id="password" name="password" placeholder="请输入旧密码">--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div class="form-group">--%>
<%--                                    <label for="newPassword" class="col-sm-2 control-label">新密码</label>--%>

<%--                                    <div class="col-sm-10">--%>
<%--                                        <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="请输入新密码">--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div class="form-group">--%>
<%--                                    <label for="newPassword2" class="col-sm-2 control-label">确认密码</label>--%>

<%--                                    <div class="col-sm-10">--%>
<%--                                        <input type="password" class="form-control" id="newPassword2" name="newPassword2" placeholder="请再次输入新密码">--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <!-- /.box-body -->--%>
<%--                            <div class="box-footer">--%>
<%--                                <a type="button" href="/main" class="btn btn-default" >回到首页</a>--%>
<%--                                <button type="submit" class="btn btn-info pull-right">提交修改</button>--%>
<%--                            </div>--%>
<%--                            <!-- /.box-footer -->--%>
<%--                        </form>--%>
                        <form:form  id="inputForm" cssClass="form-horizontal" action="/admin/users/edit" method="post" modelAttribute="adminUsers">
                            <form:hidden path="auid"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="password" class="col-sm-2 control-label">旧密码</label>

                                    <div class="col-sm-10">
                                        <form:password cssClass="form-control required " path="password" placeholder="请输入旧密码"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-sm-2 control-label">新密码</label>

                                    <div class="col-sm-10">
                                        <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="请输入新密码" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-sm-2 control-label">确认密码</label>

                                    <div class="col-sm-10">
                                        <input type="password" class="form-control" id="newPassword2" name="newPassword2" placeholder="请再次输入新密码" >
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <a type="button" href="/main" class="btn btn-default" >回到首页</a>
                                <button type="submit" class="btn btn-info pull-right">提交修改</button>
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

