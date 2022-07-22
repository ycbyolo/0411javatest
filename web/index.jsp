<%--
  Created by IntelliJ IDEA.
  User: 杨春波
  Date: 2022/7/21
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="js/jquery.js"></script>
    <script>
        // 页面加载完成时
        $(function () {
            // 在用户名录入完成后  失去焦点后执行函数
            $("#username").blur(function () {
                $.ajax({
                    url:"checkUsername",    // 请求路径
                    data:{"username":$(this).val()},   // 参数
                    type:"post",   // 请求方式
                    success:function (a) {  // 成功执行的回调函数
                        alert(a);
                        if (a == "yes") {  // 用户名可用
                            $("#userNameSpan").html("用户名可用");
                            $("#userNameSpan").css({color:"green"});
                        }else {            // 用户名不可用
                            $("#userNameSpan").html("用户名不可用");
                            $("#userNameSpan").css({color: "red"});
                        }
                    },
                    error:function () {     // 失败执行的回调函数
                        alert("error");
                    }
                })
            })
        })
    </script>
</head>
<body>
<td>
    用户名:
    <input type="text" name="username" placeholder="请输入用户名" id="username"/>
    <span id="userNameSpan"></span>
</td>
</body>

</html>
