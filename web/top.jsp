<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body style="background-color: aquamarine">
    <center>
        <font style="color: black;font-size: 50px">在线考试管理系统demo</font>
    </center>
    <div style="text-align: right">欢迎你:${sessionScope.name}</div>
    <div style="text-align: right"><a href="logout">退出</a></div>

</body>
</html>