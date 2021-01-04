<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() +
            "://" + request.getServerName() +
            ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        if (top.location !== self.location) {
            top.location = self.location
        }
        $(function () {
            $(":button").on("click", function () {
                submit();
            })
            $(document).keydown((event) => {
                if (event.keyCode === 13) {
                    submit();
                }
            })
        })
        submit = function () {
            if (!$("#name").val().trim() || !$("#password").val().trim()) {
                alert("请输入用户名及密码");
            } else {
                //添加上诉的base标签以后,发生请求的时候就不需要再加上 "/" 了,加上以后会报错
                $.post("login", {"userName": $("#name").val(), "password": $("#password").val()},
                    function (resp) {
                        //注意参数判断!==和===的区别
                        //==之判断字面值,而===同时还判断其数据类型
                        if (resp == "1") {
                            alert("登录成功~")
                            window.location.href = "index.jsp"
                        } else {
                            alert("fail!")
                            $("p").html("错误错误~");
                        }
                    }
                )
            }
        }

    </script>
</head>
<body>
<center>
    <%=basePath%>
    <div>
        <table border="5px">
            <tr>
                <td>用户名</td>
                <td><input type="text" id="name" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" id="password" name="password"></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="button" value="登录"></td>
            </tr>
            <br/>
        </table>
    </div>
    <p style="font-size: 50px;color: darkcyan"></p>
</center>
</body>
</html>