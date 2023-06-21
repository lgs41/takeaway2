<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/10
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单评论</title>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

</head>
<body>
<div style="margin-left: 200px;margin-top: 100px;color: #2ba2ea" >
    请输入评论的内容：
</div>
<form action="${pageContext.request.contextPath}/order/toReview" method="post">
    <table style="margin-left: 200px;margin-top: 10px">

        <tr>
            <td colspan="2" style="margin-left: 200px">
                <font color="red">
                    ${requestScope.msg}
                </font>
            </td>
        </tr>

        <tr>
            <td>评论内容</td>
            <td>
                <input name="review">
            </td>
        </tr>

        <tr>
            <td></td>
            <td colspan="2">
                <input type="submit" value="评论">
            </td>
        </tr>

    </table>
    <input type="hidden" name="orderId" value="${requestScope.review.orderId}">
</form>
</body>
</html>
