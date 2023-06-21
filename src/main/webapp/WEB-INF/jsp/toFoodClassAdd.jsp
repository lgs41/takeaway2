<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/8
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品分类</title>
</head>
<body>
<div style="margin-left: 200px;margin-top: 100px;color: #316AC5" >
    请输入要添加的商品分类名称：
</div>
<form action="${pageContext.request.contextPath}/foodClass/addFoodClass" method="post">
    <table style="margin-left: 200px;margin-top: 10px">

        <tr>
            <td colspan="2" style="margin-left: 200px">
                <font color="red">
                    ${requestScope.msg}
                </font>
            </td>
        </tr>

        <tr>
            <td>商品分类名称</td>
            <td>
                <input name="className">
            </td>
        </tr>

        <tr>
            <td></td>
            <td style="text-align: center">
                <input type="submit" value="添加">
            </td>
        </tr>

    </table>
</form>
</body>
</html>

