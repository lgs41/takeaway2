<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/1
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

</head>
<body>
<form action="${pageContext.request.contextPath}/food/editFood" method="post" enctype="multipart/form-data">
    <table style="margin-left: 200px;margin-top: 20px">

        <tr>
            <td colspan="2" style="text-align: center">
                <font color="red">
                    ${requestScope.msg}
                </font>
            </td>
        </tr>

        <tr>
            <td>商品名称</td>
            <td>
                <input name="foodName" value="${requestScope.food.foodName}">
            </td>
        </tr>

        <tr>
            <td>商品单价</td>
            <td>
                <input name="foodPrice" value="${requestScope.food.foodPrice}">(元)
            </td>
        </tr>

        <tr>
            <td>商品描述</td>
            <td>
                <input name="foodDescribe" value="${requestScope.food.foodDescribe}" style="width: 400px;">
            </td>
        </tr>

        <tr>
            <td>商品分类</td>
            <td>
                <input name="className" value="${requestScope.food.className}">
            </td>
        </tr>

        <img style="width: 100px;margin-top: 80px;margin-left: 200px" height="100px" id="img" src="http://localhost:8080/${requestScope.food.foodPri}">
        <div style="margin-left: 200px;margin-top: 10px" >
            商品图片：<input type="file" name="upload"><br/>
        </div>

        <tr>
            <td></td>
            <td colspan="2">
                <input type="submit" value="修改">
            </td>
        </tr>

    </table>
    <input type="hidden" name="id" value="${requestScope.food.id}">
</form>
</body>
</html>
