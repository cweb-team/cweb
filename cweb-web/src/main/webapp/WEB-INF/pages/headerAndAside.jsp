<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2018/4/6
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var vueAppHeader = new Vue({
        el:"#vueController-header",
        data:{
            activeIndex: '1',
            activeIndex2:'1'
        },
        methods: {
            handleSelect(value, keyPath) {
                console.log(value, 'hhh'+keyPath);
            }
        }
    });
    var vueAppAside = new Vue({
        el:'#vueController-aside',
        data:{

        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    });
</script>