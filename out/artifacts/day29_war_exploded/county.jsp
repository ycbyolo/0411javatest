<%--
  Created by IntelliJ IDEA.
  User: 杨春波
  Date: 2022/7/21
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js"></script>
    <script>
        // 页面加载完成时
        $(function () {                           //   查询到的
            // 查询国家 展示到 id=countySelect  选择框中 <option value="1">中国</option>
            //           路径              回显函数
            $.getJSON("countryServlet", function (a) {
                var str = "";
                for (var i = 0; i < a.length; i++) {
                    // 取到每一个国家 // a[i].id  a[i].name
                    str += "<option value='" + a[i].id + "'>" + a[i].name + "</option>";
                }
                // 获取到国家的下拉选择框 拼接str  所有选项
                $("#countrySelect").html($("#countrySelect").html() + str);
            });
            $("#countrySelect").change(function () {
                var countryId = $("#countrySelect").val();
                alert(countryId);
                $.getJSON("cityServlet", {"countryId":countryId}, function (b) {
                    if (b.length > 0) {
                        var str = "";
                        for (var i = 0; i < b.length; i++) {
                            str += "<option value='" + b[i].id + "'>" + b[i].name +"</option>"
                        }
                        // 获取到城市的下拉选择框 拼接str  所有选项
                        $("#citySelect").html(str)
                    }else {
                        $("#citySelect").html();
                    }
                })
            })
        })
    </script>
</head>
<body>
    国家:
<select name="countrySelect" id="countrySelect" style="width: 100px;height: 25px">
    <option value="">--请选择...--</option>
</select>
    城市:
    <select name="citySelect" id="citySelect" style="width: 100px;height: 25px">
        <option value="">--请选择...--</option>
    </select>
</body>
</html>
