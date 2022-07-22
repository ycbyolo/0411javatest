<%--
  Created by IntelliJ IDEA.
  User: 杨春波
  Date: 2022/7/21
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js"></script>
    <script>
        // 页面加载完成时
        $(function () {
            // 键盘抬起事件
            $("#productname").keyup(function () {
                // 获取数据  获取input输入框中的值
                var productname = $("#productname").val();
                // 由于keyup事件响应时  凡是键盘松开时的数据都会被监控
                var reg = /^[\u4e00-\u9f5a]+$/;
                if (reg.test(productname)) {
                    // ajax 发送请求
                    $.getJSON("ProductServlet", {"productname": productname}, function (a) {
                        var str = "";
                        for (var i = 0; i < a.length; i++) {
                            // 所有内容展示到div
                            str += "<div>" + a[i].productname + "</div>";
                        }
                        // 获取div标签 str放置到div中
                        $("#div").html(str);
                    })
                }
            });
            // 鼠标点击事件
            $("#div").click(function (e) {
                // 获取到事件源对象
                var t = e.target;
                // 获取到div中 值 把点击div的内容显示在input输入框中
                $("#productname").val($(t).html())
                // 清除div中的内容
                $("#div").html("");
            })
            // 鼠标移入和鼠标移除 js对象转换成jquery对象  jquery 方法 背景颜色
            $("#div").mouseover(function (m) {
                var t = m.target;
                $(t).css({backgroundColor: "green"})
            })
            $("#div").mouseout(function (m) {
                var t = m.target;
                $(t).css({backgroundColor: "white"})
            });
        })
    </script>
</head>
<body>
<input type="text" style="width: 250px;" name="productname" id="productname" placeholder="请输入产品名称">
<div id="div" style="width: 250px;"></div>
</body>
</html>
