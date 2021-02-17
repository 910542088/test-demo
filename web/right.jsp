<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/17
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
    <h1>欢迎来到考试系统demo</h1><br>
    <h2><p>JavaWeb版本实现功能有:</p>
    <ul>
        <li>基本的curd</li>
        <li>考试题目的出题与评分</li>
        <li>过滤器的拦截登录</li>
        <li>登录页面ajax的应用</li>
    </ul><h2>
</body>
</html>
