<%@ page import="com.test.entity.Question" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <center>
        <form action="answer">
            <table border="2">
                <tr>
                    <td>试题编号</td>
                    <td>试题内容</td>
                    <td>选项A</td>
                    <td>选项B</td>
                    <td>选项C</td>
                    <td>选项D</td>
                    <td colspan="4">选项</td>
                </tr>
                <%
                   List<Question> list;
                    list = (List) session.getAttribute("key");
                    for (Question question : list) {
                %>
                    <tr>
                        <td><%=question.getNum()%></td>
                        <td><%=question.getQuestion()%></td>
                        <td><%=question.getA()%></td>
                        <td><%=question.getB()%></td>
                        <td><%=question.getC()%></td>
                        <td><%=question.getD()%></td>
                        <td><input type="radio" name="answer_<%=question.getNum()%>" value="A">A</td>
                        <td><input type="radio" name="answer_<%=question.getNum()%>" value="B">B</td>
                        <td><input type="radio" name="answer_<%=question.getNum()%>" value="C">C</td>
                        <td><input type="radio" name="answer_<%=question.getNum()%>" value="D">D</td>
                    </tr>
                <%
                    }
                %>
                <tr>
                    <td colspan="5"><input type="submit" value="交卷"></td>
                    <td colspan="5"><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
