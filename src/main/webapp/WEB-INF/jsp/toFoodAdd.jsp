<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/7
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/food/addFood" method="post" enctype="multipart/form-data">
    <table>

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
                <input name="foodName">
            </td>
        </tr>

        <tr>
            <td>商品单价</td>
            <td>
                <input name="foodPrice">(元)
            </td>
        </tr>

        <tr>
            <td>商品描述</td>
            <td>
                <input name="foodDescribe">
            </td>
        </tr>

        <tr>
            <td>商品分类</td>
            <td>
                <input name="className">
            </td>
        </tr>

        <div style="margin: 50px auto">
            商品图片：<input type="file" name="upload"><br/>
        </div>

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
