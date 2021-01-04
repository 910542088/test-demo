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
<body>
<center>
    <table border="5px">
        <form action="useradd" method="get">
            <tr>
                <td>用户名称</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>用户密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" name="sex" value="男">男
                    <input type="radio" name="sex" value="女">女
                </td>
            </tr>
            <tr>
                <td>用户邮箱</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td><input type="submit" ></td>
                <td><input type="reset" name="重新填写"></td>
            </tr>
        </form>
    </table>
</center>
</body>
</html>