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
            <%@ include file="header.jsp"%>
            <bodyContainer class="el-container">
                <%@ include file="aside.jsp"%>
                <main class="el-main">
                    hello,world
                </main>
            </bodyContainer>
        </container>
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
