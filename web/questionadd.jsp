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
    <form action="questionadd">
        <table border="5px">
            <tr>
                <td>试题内容</td>
                <td><input type="text" name="question"></td>
            </tr>
            <tr>
                <td>选项A</td>
                <td><input type="text" name="a"></td>
            </tr>
            <tr>
                <td>选项B</td>
                <td><input type="text" name="b"></td>
            </tr>
            <tr>
                <td>选项C</td>
                <td><input type="text" name="c"></td>
            </tr>
            <tr>
                <td>选项D</td>
                <td><input type="text" name="d"></td>
            </tr>
            <tr>
                <td>答案</td>
                <td>
                    <input type="radio" name="answer" value="A">A
                    <input type="radio" name="answer" value="B">B
                    <input type="radio" name="answer" value="C">C
                    <input type="radio" name="answer" value="D">D
                </td>
            </tr>
            <tr>
                <td><input type="submit"></td>
                <td><input type="reset"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>