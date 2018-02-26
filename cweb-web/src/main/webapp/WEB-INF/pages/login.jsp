<%--
  Created by IntelliJ IDEA.
  User: Chirs
  Date: 2018/2/6
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,user-scalable=no,user-scalable=1.0,
                 initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录/Log in</title>
    <!-- 引入login样式 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
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
<div id="vueControl">
    <div id="login-container">
        <h2>拍手精灵</h2>
        <h3>更好的管理拍手xxxxx</h3>
        <form class="pure-form pure-form-aligned" id="login-input">
            <div id="login-phoneNum-input">
                <input type="text" placeholder="输入手机号" id="phoneNum" v-model="inputMobile"
                       @blur="blurInput" @focus="focusInput"
                       data-vali="phoneNum" data-isvali="1"
                       class="input-need-vali">
                <el-alert   class="inputAlert hide"
                            id="for-phoneNum"
                            title="您输入的手机号有误(11位数字)"
                            type="error">
                </el-alert>
            </div>
            <div id="login-password-input">
                <input type="password" placeholder="输入密码" id="password" v-model="inputPw" @keyup.enter="loginSubmit"
                       @blur="blurInput" @focus="focusInput"
                       data-vali="password" data-isvali="1"
                       class="input-need-vali">
                <el-alert   class="inputAlert hide"
                            id="for-password"
                            title="您输入的密码长度有误(8~20位)"
                            type="error">
                </el-alert>
            </div>
            <div id="login-submit">
                <button class="pure-button" type="button" id="login-submit-button" @click="loginSubmit">
                    登录
                </button>
            </div>
            <div id="goto-registerOrForget">
                <forget><a>忘记密码?</a></forget>
                <register>没有账号? <a>注册</a></register>
            </div>
        </form>
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
        el:'#vueControl',
        data:{
            title:'',
            inputMobile:'',
            inputPw:''
        },
        methods: {
            loginSubmit: function () {
                //此处未登录点击事件,ajax在此处

                var account = $("#phoneNum").val();
                var password = $("#password").val();
                $.ajax({
                    url: "tryLogin",
                    type: "get",
                    dataType: "json",
                    data: {
                        account: account,
                        password:password,
                    },
                    success: function(resp){
                        if(resp.status == 200){
                            console.log(resp.data);
                            // $(location).attr("href","../profile");
                        }
                    },
                    fail: function(resp){
                        if(resp.status == 404){
                            console.log(resp.data);
                        }
                    }
                })

                var valInputs = document.querySelectorAll(".input-need-vali"),
                    isPassed = 0;
                _.forEach(valInputs, function(itm){
                    itm.focus();
                    itm.blur();
                    isPassed += parseInt(itm.dataset.isvali);
                    console.log(isPassed)
                });
                if (isPassed === 0) {
                    //此处为前端验证通过后,调用ajax接口.
                    var loginPhoneNum = this.$data.inputMobile, //获取input框的手机号
                        loginPw = this.$data.inputPw;           //获取input框的密码

















                }
            },
            //此处为输入框失去焦点时,根据正则验证验证输入框内容,
            blurInput:function(e) {
                let reg = regLogin[e.target.dataset.vali];  //验证正则表达式
                console.log(e.target.dataset.vali); //要验证的类型,此处只有输入密码较为特殊.
                var v = e.target.value;  //获取输入值
                var eleWarning = document.getElementById("for-" + e.target.id);  //获取警告dom元素
                if(e.target.dataset.vali === 'passWordAgain') {    //若失去焦点为 第一次密码或第二次密码输入,则将第二次密码的值与第一次密码比较
                    if (this.$data.userPw === this.$data.userPwAgain){
                        eleWarning.classList.add("hide");
                        e.target.dataset.isvali = 0;
                    } else {
                        eleWarning.classList.remove("hide");
                        e.target.dataset.isvali = 1;
                    }
                } else {
                    if (reg.test(v)) {
                        eleWarning.classList.add("hide");
                        e.target.dataset.isvali = 0;
                    }
                    else {
                        eleWarning.classList.remove("hide");
                        e.target.dataset.isvali = 1;
                    }
                }
            },
            focusInput:function(e){
                var eleWarning = document.getElementById("for-" + e.target.id);  //input重新获得焦点后,alert警告框消失.
                eleWarning.classList.add("hide");
                e.target.dataset.isvali = 0;
            }
        }
    });
</script>
</html>
