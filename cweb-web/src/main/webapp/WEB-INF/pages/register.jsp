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
                        <input type="text" placeholder="用户名" v-model="inputUserName" id="userName"
                               @blur="blurInput" @focus="focusInput"
                               data-vali="userName" data-isvali="1"
                               class="input-need-vali">
                        <el-alert   class="inputAlert hide"
                                    id="for-userName"
                                    title=" "
                                    type="error">
                        </el-alert>
                    </div>
                    <div id="register-inputPhone">
                        <input type="text" placeholder="手机号" v-model="inputPhoneNumber" id="phoneNum"
                               @blur="blurInput" @focus="focusInput"
                               data-vali="phoneNum" data-isvali="1"
                               class="input-need-vali">
                        <el-alert   class="inputAlert hide"
                                    id="for-phoneNum"
                                    title="请输入正确的手机号(11位)"
                                    type="error">
                        </el-alert>
                    </div>
                    <div id="register-inputEmail">
                        <input type="text" placeholder="邮箱" v-model="inputEmail" id="email"
                               @blur="blurInput" @focus="focusInput"
                               data-vali="email" data-isvali="1"
                               class="input-need-vali">
                        <el-alert   class="inputAlert hide"
                                    id="for-email"
                                    title="请输入正确的邮箱"
                                    type="error">
                        </el-alert>
                    </div>
                    <div id="register-inputPassword">
                        <input type='text' placeholder="输入密码" v-model="inputPassWord" id="password"
                               @blur="blurInput" @focus="focusInput"
                               data-vali="password" data-isvali="1"
                               class="input-need-vali">
                        <el-alert   class="inputAlert hide"
                                    id="for-password"
                                    title="密码格式有误或为空(长度为8~20)"
                                    type="error">
                        </el-alert>
                    </div>
                    <div id="register-submitData">
                        <button type='button' class="pure-button" @click="registerSubmit">
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
            registerSubmit :function () {
                var valInputs = document.querySelectorAll(".input-need-vali"),
                    isPassed = 0;
                _.forEach(valInputs, function(itm){
                    itm.focus();
                    itm.blur();
                    isPassed += parseInt(itm.dataset.isvali);
                    console.log(isPassed)
                });
                if (isPassed === 0) {
                    var registerUserName = this.$data.inputUserName, //获取input框的用户名
                        registerPhoneNum = this.$data.inputMobile, //获取input框的手机号
                        registerEmail = this.$data.inputEmil,       //获取input框的邮箱地址
                        registerPassword = this.$data.inputPassWord;           //获取input框的密码
                        console.log(registerUserName + registerPhoneNum +registerEmail +registerPassword)
                    // axios.get('tryLogin.do',{
                    //     params:{
                    //         account:loginPhoneNum,
                    //         password:loginPw,
                    //     }
                    // }).then(function (response) {
                    //     let data = response.data;
                    //     let code = data.status;
                    //     if (code == 20000) {
                    //         swal({
                    //             text:"提交成功!",
                    //             button: true,
                    //             icon: "success",
                    //             timer: 2000
                    //         }).then(function () {
                    //             location.href = "../../register/";
                    //         });
                    //     }
                    //     else {
                    //         swal({
                    //             text:data.msg,
                    //             button: false,
                    //             icon: "error",
                    //             timer: 2000
                    //         }).then(function () {
                    //             document.querySelector('#login-input').reset();
                    //         });
                    //     }
                    // }).catch(function (err) {
                    //     console.log(err);
                    // });
                }
            },
            blurInput:function(e) {
                let reg = regRegister[e.target.dataset.vali];  //验证正则表达式
                console.log(e.target.dataset.vali); //要验证的类型,此处只有输入密码较为特殊.
                var v = e.target.value;  //获取输入值
                console.log(v)
                console.log(e.target.id)
                var eleWarning = document.getElementById("for-" + e.target.id);  //获取警告dom元素
                console.log(eleWarning)
                if (reg.test(v)) {
                    eleWarning.classList.add("hide");
                    e.target.dataset.isvali = 0;
                }
                else {
                    eleWarning.classList.remove("hide");
                    e.target.dataset.isvali = 1;
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
