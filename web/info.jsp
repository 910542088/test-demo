<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/19
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/questionupdate">
    <table border="5px">
        <tr>
            <td>试题编号</td>
            <td><input type="text" name="num" value="${requestScope.key.num}" readonly></td>
        </tr>
        <tr>
            <td>试题内容</td>
            <td><input type="text" name="question" value="${requestScope.key.question}"></td>
        </tr>
        <tr>
            <td>选项A</td>
            <td><input type="text" name="a" value="${requestScope.key.a}"></td>
        </tr>
        <tr>
            <td>选项B</td>
            <td><input type="text" name="b" value="${requestScope.key.b}"></td>
        </tr>
        <tr>
            <td>选项C</td>
            <td><input type="text" name="c" value="${requestScope.key.c}"></td>
        </tr>
        <tr>
            <td>选项D</td>
            <td><input type="text" name="d" value="${requestScope.key.d}"></td>
        </tr>
        <tr>
            <td>答案</td>
            <td>
                <input type="radio" name="answer" value="A" ${"A".equals(requestScope.key.answer)?"checked":""}>A
                <input type="radio" name="answer" value="B" ${"B".equals(requestScope.key.answer)?"checked":""}>B
                <input type="radio" name="answer" value="C" ${"C".equals(requestScope.key.answer)?"checked":""}>C
                <input type="radio" name="answer" value="D" ${"D".equals(requestScope.key.answer)?"checked":""}>D
            </td>
        </tr>
        <tr>
            <td><input type="submit"></td>
            <td><input type="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
