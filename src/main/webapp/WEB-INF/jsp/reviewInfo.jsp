<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/10
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

</head>
<body>

<div style="margin-left: 300px;margin-top: 80px">
    请输入要查询的评论内容：
    <form action="${pageContext.request.contextPath}/review/toReviewInfo" method="post">
        <input name="review" value="${review}"> <input type="submit" value="搜索">
    </form>
</div>



<table border="1" cellspacing="0" width="1100px" style="margin-top: 20px;margin-left: 5px">
    <tr>
        <th>评论编号</th>
        <th>用户名</th>
        <th>商品名称</th>
        <th>订单编号</th>
        <th>评论内容</th>
        <th>评论时间</th>
    </tr>
    <c:forEach items="${requestScope.pageInfo.list}" var="temp">
        <tr>
<%--            <td style="text-align: center"><input type="checkbox" class="itemBox" value="${temp.reviewId}"/></td>--%>
            <td style="text-align: center">${temp.reviewId}</td>
            <td style="text-align: center">${temp.userName}</td>
            <td style="text-align: center">${temp.foodName}</td>
            <td style="text-align: center">${temp.orderId}</td>
            <td style="text-align: center">${temp.review}</td>
            <td style="text-align: center">${temp.reviewData}</td>
        </tr>
    </c:forEach>
</table>

<c:choose>
    <c:when test="${pageInfo.pages<=3}">
        <c:set var="begin" value="1"></c:set>
        <c:set var="end" value="${pageInfo.pages}"></c:set>
    </c:when>

    <c:otherwise>
        <c:set var="begin" value="${pageInfo.pageNum-1}"></c:set>
        <c:set var="end" value="${pageInfo.pageNum+1}"></c:set>
        <c:if test="${pageInfo.pageNum-1<1}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="3"></c:set>
        </c:if>
        <c:if test="${pageInfo.pageNum+1>pageInfo.pages}">
            <c:set var="begin" value="${pageInfo.pages-2}"></c:set>
            <c:set var="end" value="${pageInfo.pages}"></c:set>
        </c:if>

    </c:otherwise>
</c:choose>


<div style="margin-left: 450px">
    <c:if test="${pageInfo.hasPreviousPage}">
        <a href="${pageContext.request.contextPath}/review/toReviewInfo?foodName=${review}">首页</a>
        <a href="${pageContext.request.contextPath}/review/toReviewInfo?pageNum=${pageInfo.pageNum-1}&review=${review}">上一页</a>
    </c:if>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <a href="${pageContext.request.contextPath}/review/toReviewInfo?pageNum=${i}&review=${review}">${i}</a>
    </c:forEach>

    <c:if test="${pageInfo.hasNextPage}">
        <a href="${pageContext.request.contextPath}/review/toReviewInfo?pageNum=${pageInfo.pageNum+1}&review=${review}">下一页</a>
        <a href="${pageContext.request.contextPath}/review/toReviewInfo?pageNum=${pageInfo.pages}&review=${review}">尾页</a>
    </c:if>
</div>

<script>
    //给全选添加点击事件
    $("#allBtn").click(function (){
        var isChecked =  $("#allBtn").prop("checked");
        if(isChecked){
            //全选
            $(".itemBox").prop("checked",true);
        }else{

            //取消
            $(".itemBox").prop("checked",false);
        }
    })
    //给每一行添加事件
    $(".itemBox").click(function (){
        var all = $(".itemBox").length;
        var ck=$(".itemBox:checked").length;
        if (ck==all){
            $("#allBtn").prop("checked",true);
        }else{
            $("#allBtn").prop("checked",false);
        }
    })
</script>

</body>
</html>
