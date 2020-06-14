<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">功能菜单</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>个人信息管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/admin/users/info?auid=${adminUser.auid}"><i class="fa fa-circle-o"></i>个人信息</a></li>
                    <li><a href="/admin/users/pwd_update?auid=${adminUser.auid}"><i class="fa fa-circle-o"></i>修改密码</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>普通用户管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/ordinary/users/list"><i class="fa fa-circle-o"></i>普通用户列表</a></li>
                    <li><a href="/ordinary/users/form"><i class="fa fa-circle-o"></i>新增普通用户</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>保险管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/insurance/category/list"><i class="fa fa-circle-o"></i>保险分类列表</a></li>
                    <li><a href="/insurance/category/form"><i class="fa fa-circle-o"></i>新增保险分类</a></li>
                    <li><a href="/insurance/list"><i class="fa fa-circle-o"></i>保险列表</a></li>
                    <li><a href="/insurance/form"><i class="fa fa-circle-o"></i>新增保险</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>用户保单管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/insurance/orders/list"><i class="fa fa-circle-o"></i>用户保单列表</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>内容管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/content/category/list"><i class="fa fa-circle-o"></i>内容分类列表</a></li>
                    <li><a href="/content/category/form"><i class="fa fa-circle-o"></i>新增内容分类</a></li>
                    <li><a href="/content/list"><i class="fa fa-circle-o"></i>内容列表</a></li>
                    <li><a href="/content/form"><i class="fa fa-circle-o"></i>新增内容</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>
