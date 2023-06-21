<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/10
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script>
        function toReview(orderId,state){
            if(state=="已评价"){
                alert("该订单已经评价，请勿重新评价！");
                return;
            }
            if(state=="已下单"){
                alert("该订单还未送达，尚不能评价！");
                return;
            }
            window.location.href="${pageContext.request.contextPath}/order/review?orderId="+orderId
        }
        <%--function toDelBatch(){--%>
        <%--    //获取选中的记录--%>
        <%--    var ckIds=$(".itemBox:checked");--%>
        <%--    // alert(ckIds.length);--%>
        <%--    if(ckIds.length<=0){--%>
        <%--        alert("请至少选中一条记录");--%>
        <%--        return;--%>
        <%--    }--%>
        <%--    //批量删除，id=1&id=2&id=3--%>

        <%--    var idArray= new Array();--%>

        <%--    ckIds.each(function () {--%>
        <%--        var id = $(this).val();--%>
        <%--        idArray.push(id);--%>
        <%--    })--%>

        <%--    var ids ="";--%>
        <%--    for(var i=0;i<idArray.length;i++){--%>
        <%--        if(i<idArray.length-1){--%>
        <%--            ids+="id="+idArray[i]+"&";--%>
        <%--        }else {--%>
        <%--            ids+="id="+idArray[i];--%>
        <%--        }--%>
        <%--    }--%>
        <%--    // alert(ids);--%>

        <%--    window.location.href="${pageContext.request.contextPath}/order/toDelBatch?"+ids;--%>
        <%--}--%>
    </script>

</head>
<body>

<div style="margin-left: 300px;margin-top: 80px">
    请输入要查询的商品名称：
    <form action="${pageContext.request.contextPath}/order/userOrderInfo" method="post">
        <input name="foodName" value="${foodName}">
        <input type="submit" value="搜索">
    </form>
<%--    <a href="javascript:toDelBatch()" target="main">删除订单</a>--%>
</div>



<table border="1" cellspacing="0" width="1200px" style="margin-top: 20px;margin-left: 5px">
    <tr>
        <th><input type="checkbox" id="allBtn"/>全选</th>
        <th>订单号</th>
        <th>用户名</th>
        <th>手机号</th>
        <th>地址</th>
        <th>商品名称</th>
        <th>数量</th>
        <th>总价(元)</th>
        <th>下单时间</th>
        <th>订单状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.pageInfo.list}" var="temp">
        <tr>
            <td style="text-align: center"><input type="checkbox" class="itemBox" value="${temp.orderId}"/></td>
            <td style="text-align: center">${temp.orderId}</td>
            <td style="text-align: center">${temp.userName}</td>
            <td style="text-align: center">${temp.userPhone}</td>
            <td style="text-align: center">${temp.userAdd}</td>
            <td style="text-align: center">${temp.foodName}</td>
            <td style="text-align: center">${temp.number}</td>
            <td style="text-align: center">${temp.price}</td>
            <td style="text-align: center">${temp.orderData}</td>
            <td style="text-align: center">${temp.state}</td>
            <td style="text-align: center">
                <a href="javascript:toReview('${temp.orderId}','${temp.state}')">评价</a>
            </td>
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
        <a href="${pageContext.request.contextPath}/order/userOrderInfo?foodName=${foodName}">首页</a>
        <a href="${pageContext.request.contextPath}/order/userOrderInfo?pageNum=${pageInfo.pageNum-1}&foodName=${foodName}">上一页</a>
    </c:if>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <a href="${pageContext.request.contextPath}/order/userOrderInfo?pageNum=${i}&foodName=${foodName}">${i}</a>
    </c:forEach>

    <c:if test="${pageInfo.hasNextPage}">
        <a href="${pageContext.request.contextPath}/order/userOrderInfo?pageNum=${pageInfo.pageNum+1}&foodName=${foodName}">下一页</a>
        <a href="${pageContext.request.contextPath}/order/userOrderInfo?pageNum=${pageInfo.pages}&foodName=${foodName}">尾页</a>
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
