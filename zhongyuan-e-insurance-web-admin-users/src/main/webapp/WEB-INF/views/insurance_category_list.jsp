<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>保险商城 | 保险分类列表</title>
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
                保险管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">保险管理</li>

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
                                        <label for="icid" class="col-sm-4 control-label">序列号</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" id="icid" placeholder="序列号"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="name" class="col-sm-4 control-label">分类名称</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" id="name" placeholder="分类名称"/>
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
                            <h3 class="box-title">保险分类列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="/insurance/category/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i>新增</a>
                            <button  type="button" class="btn btn-sm btn-danger" onclick="App.deleteMul('/insurance/category/deleteMul')"><i class="fa fa-trash-o"></i>批量删除</button>
                            <button  type="button" class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display')=='none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')"><i class="fa fa-search"></i>搜索</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive ">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master" /></th>
                                    <th>序列号</th>
                                    <th>分类名称</th>
                                    <th>类别描述</th>
                                    <th>创建时间</th>
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
                    return '<input id="'+row.icid+'" type="checkbox" class="minimal" />';
                }},
            {"data":"icid"},
            {"data":"name"},
            {"data":"description"},
            {"data":function (row,type,val,meta) {
                    return DateTime.format(row.created,"yyyy-MM-dd HH:mm:ss");
                }},
            {"data":function (row,type,val,meta) {
                    return DateTime.format(row.updated,"yyyy-MM-dd HH:mm:ss");
                }},
            {"data":function (row,type,val,meta) {
                    var detailUrl="/insurance/category/detail?icid="+row.icid;
                    var deleteUrl = "/insurance/category/delete?icid="+row.icid;
                    var deleteMsg = "确定要删除该分类吗？";
                    return '<button type="button" class="btn btn-sm btn-default" onclick="App.showDetail(\''+detailUrl+'\')"><i class="fa fa-search"></i>查看</button>'+
                        '<a href="/insurance/category/form?icid='+row.icid+'" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i>编辑</a>'+
                        '<Button  type="button" class="btn btn-sm btn-danger" onclick="App.updateState(\'' + deleteUrl + '\',\'' + row.icid + '\',\'' + deleteMsg + '\')"><i class="fa fa-trash-o"></i>删除</Button>';
                }}
        ];
        _dataTable=App.initDataTables("/insurance/category/page",_columns);
    });

    function search() {
        var icid=$("#icid").val();
        var name=$("#name").val();
        var param = {
            "icid":icid,
            "name":name
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
</script>
</body>
</html>
