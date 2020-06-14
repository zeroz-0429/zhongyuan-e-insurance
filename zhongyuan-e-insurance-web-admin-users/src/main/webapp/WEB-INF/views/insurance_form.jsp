<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 新增保险</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css">
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/dropzone.css">
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/basic.min.css">
    <link rel="stylesheet" href="/static/assets/plugins/wangEditor/wangEditor.min.css">
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
                    <c:if test="${categoryName!=null}">
                        <div class="alert alert-${categoryName.status==200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${categoryName.message}
                        </div>
                    </c:if>
                    <c:if test="${baseResult!=null}">
                        <div class="alert alert-${baseResult.status==200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${insurance.iid == null ? "新增" : "编辑"}保险</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form  id="inputForm" cssClass="form-horizontal" action="/insurance/save" method="post" modelAttribute="insurance">
                            <form:hidden path="iid"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">所属分类</label>
                                    <div class="col-sm-10">
                                        <form:select cssClass="form-control required"  path="insuranceCategory.name">
                                            <c:if test="${insurance.iid!=null}">
                                                <form:option  value="${insurance.insuranceCategory.name}"/>
                                            </c:if>
                                            <c:if test="${insurance.iid==null}" >
                                                <form:option  value="" label="请选择"/>
                                            </c:if>
                                            <form:options  items="${insuranceCategoryName}"/>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="name" class="col-sm-2 control-label">保险名称</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="name" placeholder="请输入保险名称"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="price" class="col-sm-2 control-label">保险价格</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="price" placeholder="请输入保险价格"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">是否上架</label>

                                    <div class="col-sm-10">
                                        <form:radiobutton  cssStyle="margin-top: 10px" path="state" value="0" label="否" />
                                        <form:radiobutton  cssStyle="margin-top: 10px" path="state" value="1" label="是" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">是否参与活动</label>

                                    <div class="col-sm-10">
                                        <form:radiobutton  cssStyle="margin-top: 10px" path="isActivity" value="0" label="否" />
                                        <form:radiobutton  cssStyle="margin-top: 10px" path="isActivity" value="1" label="是" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="bargainPrice" class="col-sm-2 control-label">活动价格</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="bargainPrice"  placeholder="请输入活动价格"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="pictrue" class="col-sm-2 control-label">相关图片</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required " path="pictrue" placeholder="请上传相关图片"/>
                                        <div id="dropz" class="dropzone"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">保险详情</label>

                                    <div class="col-sm-10">
                                        <form:hidden path="content"/>
                                        <div id="editor">${insurance.content}</div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                <button id="btnSubmit" type="submit" class="btn btn-info pull-right">提交</button>
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
<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script src="/static/assets/plugins/dropzone/min/dropzone.min.js"></script>
<script src="/static/assets/plugins/wangEditor/wangEditor.min.js"></script>


<script>
    $(function () {

    });
    $(function () {
        initWangEditor();
    });

    /**
     * 初始化富文本编辑器
     */
    function initWangEditor(){
        var E=window.wangEditor;
        var editor=new E('#editor');
        // 配置服务器端地址
        editor.customConfig.uploadImgServer = '/upload';
        editor.customConfig.uploadFileName = 'editorFiles';
        editor.create();
        $("#btnSubmit").bind("click",function () {
            var contentHtml=editor.txt.html();
            $("#content").val(contentHtml);
        })
    }
    App.initDropzone({
        id:"#dropz",
        url:"/upload",
        init: function () {
            this.on("success", function (file,data) {
                $("#pictrue").val(data.fileName);
            });
        }
    });
</script>
</body>
</html>

