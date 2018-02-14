<%--
  Created by IntelliJ IDEA.
  User: HYL
  Date: 18/2/14
  Time: 上午9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
<shiro:user>

    <p>欢迎[<shiro:principal/>]登录</p>
    <p>success login</p>
    <shiro:hasRole name="admin">
        用户[<shiro:principal/>]拥有角色admin<br/>
    </shiro:hasRole>
</shiro:user>
</body>
</html>
