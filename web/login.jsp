<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(":button").on("click", function () {
                $.post(
                    "/login", {"userName": $("#name").val(), "password": $("#password").val()},
                    function (resp) {
                        if (resp === "1") {
                            window.location.href = "index.html"
                        } else {
                            alert("fail!")
                            $("span").html("错误错误~");
                        }
                    }
                )
            })
        })
        // setInterval(
        //     function countTime() {
        //         $("span").html(new Date().toLocaleString());
        //     }
        //     , 1000)


    </script>
</head>
<body>
<center>
    <table border="5px">
        <tr>
            <td>用户名</td>
            <td><input type="text" id="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" id="password"></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="button" value="登录"></td>
        </tr>
        <br/><span style="font-size: 50px;color: darkcyan"></span>
    </table>
</center>
</body>
</html>
