<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2018/4/1
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class='el-header'>
    <el-menu :default-active="activeIndex" class="el-menu-demo" id='header-control'
             mode="horizontal" @select="handleSelect">
        <div id='header-logo' class='f-left' >logo</div>
        <el-menu-item index="1" class='f-right'>个人中心</el-menu-item>

        <el-submenu index="2" class='f-left'>
            <template slot="title">菜单</template>
            <el-menu-item index="2-1">1</el-menu-item>
            <el-menu-item index="2-2">2</el-menu-item>
            <el-menu-item index="2-3">3</el-menu-item>
            <el-submenu index="2-4">
                <template slot="title">4</template>
                <el-menu-item index="2-4-1">1</el-menu-item>
                <el-menu-item index="2-4-2">2</el-menu-item>
                <el-menu-item index="2-4-3">3</el-menu-item>
            </el-submenu>
        </el-submenu>
        <el-menu-item index="3" disabled class='f-left'>消息中心</el-menu-item>
        <el-menu-item index="4" class='f-left'>
            <a href="" target="_blank">访问拍牌主页</a>
        </el-menu-item>
    </el-menu>
</header>