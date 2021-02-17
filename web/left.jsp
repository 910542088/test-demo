<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
    <ul>
        <li>用户信息管理</li>
            <ol>
                <li><a href="useradd.jsp" target="right">用户信息注册</a></li>
                <li><a href="userfind" target="right">用户信息查询</a></li>
            </ol>
        <li>试题信息查询</li>
            <ol>
                <li><a href="questionadd.jsp" target="right">试题信息注册</a></li>
                <li><a href="questionfind" target="right">试题信息查询</a></li>
            </ol>
        <li>考试管理</li>
        <ol>
            <li><a href="questionSelect" target="right">参加考试</a></li>
        </ol>
    </ul>
</body>
</html>