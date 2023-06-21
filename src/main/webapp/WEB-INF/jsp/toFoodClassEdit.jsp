<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/8
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品分类修改</title>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

</head>
<body>
<div style="margin-left: 200px;margin-top: 100px;color: #2ba2ea" >
    请输入要添加的商品分类名称：
</div>
<form action="${pageContext.request.contextPath}/foodClass/editFoodClass" method="post">
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
                <input name="className" value="${requestScope.foodClass.className}">
            </td>
        </tr>

        <tr>
            <td></td>
            <td colspan="2">
                <input type="submit" value="修改">
            </td>
        </tr>

    </table>
    <input type="hidden" name="id" value="${requestScope.foodClass.id}">
</form>
</body>
</html>

