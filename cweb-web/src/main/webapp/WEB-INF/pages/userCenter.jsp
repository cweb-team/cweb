<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,user-scalable=no,user-scalable=1.0,
                 initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,minimal-ui">
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <title>个人操作中心</title>
    <!-- 引入userCenter样式 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/userCenter.css">
    <!-- 引入pure样式 -->
    <link href="https://cdn.bootcss.com/pure/1.0.0/buttons-min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/pure/1.0.0/forms-min.css" rel="stylesheet">
    <!-- 引入element组件样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 此处样式为vue.js 缓冲数据渲染-->
    <style>
        [v-cloak] {
            display: none;
        }
    </style>
</head>
<body>
    <div id="vueController">
            <container class='el-container is-vertical'>
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
                <bodyContainer class="el-container">
                    <el-aside>
                        <el-row class="tac">
                            <el-col >
                                <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
                                 background-color="#545c64" text-color="#fff" active-text-color="#ffd04b"
                                    active-text-color="#ffd04b">
                                    <el-submenu index="1">
                                        <template slot="title">
                                            <span> 任务专栏 </span>
                                        </template>
                                        <el-menu-item-group>
                                            <template slot="title">分组一</template>
                                            <el-menu-item index="1-1">选项1</el-menu-item>
                                            <el-menu-item index="1-2">选项2</el-menu-item>
                                        </el-menu-item-group>
                                        <el-menu-item-group title="分组2">
                                            <el-menu-item index="1-3">选项3</el-menu-item>
                                        </el-menu-item-group>
                                        <el-submenu index="1-4">
                                            <template slot="title">选项4</template>
                                            <el-menu-item index="1-4-1">选项1</el-menu-item>
                                        </el-submenu>
                                    </el-submenu>
                                    <el-menu-item index="2">
                                        <span slot="title">导航二</span>
                                    </el-menu-item>
                                    <el-menu-item index="3" disabled>
                                        <span slot="title">导航三</span>
                                    </el-menu-item>
                                    <el-menu-item index="4">
                                        <span slot="title">导航四</span>
                                    </el-menu-item>
                                </el-menu>
                            </el-col>
                        </el-row>
                    </el-aside>
                    





                    <main class='el-main'>Main</main>
                </bodyContainer>
            <container>
    </div>
</body>
<!-- 引入sweetalert2.0组件 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert@2.0.8/dist/sweetalert.min.js"></script>
<!-- 引入jQuery组件库 -->
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<!-- 引入vue.js -->
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.9/dist/vue.min.js"></script>
<!-- 引入loadsh.js -->
<script src="https://cdn.jsdelivr.net/npm/lodash/lodash.min.js"></script>
<!-- 引入axios.js -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<!-- 引入element组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<script>
    var vueAppUserCenter = new Vue({
        el:"#vueController",
        data:{
            activeIndex: '1'
            // activeIndex2: '1'
        },
        methods: {
            handleSelect(value, keyPath) {
                console.log(value, 'hhh'+keyPath);
            },
            handleOpen(key, keyPath) {
                console.log(key, 'qqq'+keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, 'qqq'+keyPath);
            }
        }
    });
</script>
</html>
