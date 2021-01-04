<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="<%=basePath%>">
    <script>
    </script>
</head>
    <frameset rows="20%,80%">
        <frame name="top" src="top.jsp"/>
        <frameset cols="20%,80%">
            <frame name="left" src="left.jsp">
            <frame name="right">
        </frameset>
    </frameset>
</html>