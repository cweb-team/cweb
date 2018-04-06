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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/groupTable.css">
    <style>
        [v-cloak] {
            display: none;
        }
    </style>
</head>
<body>
    <div>
        <container class='el-container is-vertical'>
            <%@ include file="header.jsp"%>
            <bodyContainer class="el-container">
                <%@ include file="aside.jsp"%>
                <mian class="el-main">
                    <%@ include file="groupTable.jsp"%>
                </mian>
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

<!-- 引入header,aside栏的js部分 -->
<%@ include file="headerAndAside.jsp"%>

<script>
    var vueApp = new Vue({
        el:"#groupTeam-container",
        data:{
            allPage : 20,
            currentPage :1,     //当前页数
            recordsPerPage : 10,     //一页显示几条
        },
        watch: {
            currentPage: function(oldValue , newValue) {
                console.log(arguments);
                console.log('当前页'+this.currentPage);
            }
        },
        methods: {
            btnClick: function(data) {//页码点击事件
                if(data !== this.currentPage){
                    this.currentPage = data;
                    // getWines(this.currentPage,vueApp.$data.wineType);
                }
            },
            pageClick: function() {
                console.log('当前页'+this.currentPage);
                // getWines(this.currentPage,vueApp.$data.wineType);
            }
        },
        mounted: function() {

        },
        computed: {
            allPageComputed: function(){
                let left = 1;
                let right = this.allPage;
                let pageArr = [];    //次处变量pageArr返回一个当前应该显示的页数数组,如[4,5,6,7,8],即页面上显示的页数
                if(this.allPage>= 5){
                    if(this.currentPage > 3 && this.currentPage < this.allPage-2){
                        left = this.currentPage - 2;
                        right = this.currentPage + 2;
                    }else{
                        if(this.currentPage<=3){
                            left = 1;
                            right = 5;
                        }else{
                            right = this.allPage;
                            left = this.allPage -4;
                        }
                    }
                }
                while (left <= right){
                    pageArr.push(left);
                    left ++;
                }
                return pageArr;
            },
        }
    });
</script>
</html>
