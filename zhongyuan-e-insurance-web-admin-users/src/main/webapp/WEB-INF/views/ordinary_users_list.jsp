<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>保险商城 | 普通用户列表</title>
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
                普通用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">普通用户管理</li>

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
                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <div class="box-body">
                            <div class="row form-horizontal">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="username" class="col-sm-4 control-label">用户名</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" id="username" placeholder="用户名"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-4 control-label">邮箱</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" id="email" placeholder="邮箱"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="phone" class="col-sm-4 control-label">手机</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" id="phone" placeholder="手机"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <button type="button" class="btn btn-info pull-right" onclick="search();">搜索</button>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">普通用户列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="/ordinary/users/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i>新增</a>
                            <button  type="button" class="btn btn-sm btn-danger" onclick="App.deleteMul('/ordinary/users/deleteMul')"><i class="fa fa-trash-o"></i>批量删除</button>
                            <button  type="button" class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display')=='none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')"><i class="fa fa-search"></i>搜索</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive ">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master" /></th>
                                    <th>序列号</th>
                                    <th>用户名</th>
                                    <th>手机</th>
                                    <th>邮箱</th>
                                    <th>账号状态</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>

<jsp:include page="../includes/footer.jsp"/>
<sys:modal />

<script>
    var _dataTable;
    $(function () {
        var _columns=[
            {"data":function (row,type,val,meta) {
                    return '<input id="'+row.ouid+'" type="checkbox" class="minimal" />';
                }},
            {"data":"ouid"},
            {"data":"username"},
            {"data":"phone"},
            {"data":"email"},
            {"data":function (row,type,val,meta) {
                    var updateUrl = "/ordinary/users/update?ouid="+row.ouid;
                    var stateMsg0 = "确定要唤醒该用户吗？";
                    var stateMsg1 = "确定要注销该用户吗？";
                    if (row.state==0){
                        return '<Button  type="button" class="btn btn-sm btn-warning" onclick="App.updateState(\'' + updateUrl + '\',\'' + row.ouid + '\',\'' + stateMsg0 + '\')">已注销</Button>';
                    }
                    else{
                        return '<Button  type="button" class="btn btn-sm btn-success" onclick="App.updateState(\'' + updateUrl + '\',\'' + row.ouid + '\',\'' + stateMsg1 + '\')">活跃中</Button>';
                    }
                }},
            {"data":function (row,type,val,meta) {
                    return DateTime.format(row.updated,"yyyy-MM-dd HH:mm:ss");
                }},
            {"data":function (row,type,val,meta) {
                    var detailUrl="/ordinary/users/detail?ouid="+row.ouid;
                    var deleteUrl = "/ordinary/users/delete?ouid="+row.ouid;
                    var deleteMsg = "确定要删除该用户吗？";
                    return '<button type="button" class="btn btn-sm btn-default" onclick="App.showDetail(\''+detailUrl+'\')"><i class="fa fa-search"></i>查看</button>'+
                        '<a href="/ordinary/users/form?ouid='+row.ouid+'" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i>编辑</a>'+
                        '<Button  type="button" class="btn btn-sm btn-danger" onclick="App.updateState(\'' + deleteUrl + '\',\'' + row.ouid + '\',\'' + deleteMsg + '\')"><i class="fa fa-trash-o"></i>删除</Button>';
                }}
        ];
        _dataTable=App.initDataTables("/ordinary/users/page",_columns);
    });

    function search() {
        var username=$("#username").val();
        var phone=$("#phone").val();
        var email=$("#email").val();
        var param = {
            "username":username,
            "phone":phone,
            "email":email
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
</script>
</body>
</html>
