<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,user-scalable=no,user-scalable=1.0,
                 initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,minimal-ui">
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <title>注册/Register</title>
    <!-- 引入register样式 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/register.css">
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
    <div id="vueController-register">
        <div id="register-container">
            <div id="register-childContainer">
                <form id="register-form" class="pure-form">
                    <h4>
                        注册账号
                    </h4>
                    <div id="register-inputUserName">
                        <input placeholder="用户名" v-model="inputUserName">
                        <el-alert   class="inputAlert hide"
                                    id="for-userName"
                                    title="这个昵称已经被占用"
                                    type="error">
                        </el-alert>
                    </div>
                    <div id="register-inputPhone">
                        <input placeholder="手机号" v-model="inputPhoneNumber">
                        <el-alert   class="inputAlert hide"
                                    id="for-phoneNum"
                                    title="请输入正确的手机号(11位)"
                                    type="error">
                        </el-alert>
                    </div>
                    <div id="register-inputEmail">
                        <input placeholder="邮箱" v-model="inputEmail">
                        <el-alert   class="inputAlert hide"
                                    id="for-email"
                                    title="请输入正确的邮箱"
                                    type="error">
                        </el-alert>
                    </div>
                    <div id="register-inputPassword" v-model="inputPassWord">
                        <input placeholder="输入密码">
                        <el-alert   class="inputAlert hide"
                                    id="for-password"
                                    title="这个昵称已经被占用"
                                    type="error">
                        </el-alert>
                    </div>
                    <div id="register-submitData">
                        <button class="pure-button" @click="test">
                            注册
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<!-- 引入正则验证json文件 -->
<script src="<%=request.getContextPath()%>/js/json/regAlert.js"></script>
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
    var vueApp = new Vue({
        el:'#vueController-register',
        data:{
            inputUserName:'',
            inputPhoneNumber:'',
            inputEmail:'',
            inputPassWord:'',
        },
        methods:{
            test :function () {
                alert(123);
            }
        }
    });
</script>
</html>
