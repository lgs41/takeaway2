<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/7
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script>
        function toFoodAdd(){
            window.location.href="${pageContext.request.contextPath}/food/toFoodAdd"
        }
        function toFoodEdit(id){
            window.location.href="${pageContext.request.contextPath}/food/toFoodEdit?id="+id
        }

        function toFoodDelBatch(){
            //获取选中的记录
            var ckIds=$(".itemBox:checked");
            // alert(ckIds.length);
            if(ckIds.length<=0){
                alert("请至少选中一条记录");
                return;
            }
            //批量删除，id=1&id=2&id=3

            var idArray= new Array();

            ckIds.each(function () {
                var id = $(this).val();
                idArray.push(id);
            })

            var ids ="";
            for(var i=0;i<idArray.length;i++){
                if(i<idArray.length-1){
                    ids+="id="+idArray[i]+"&";
                }else {
                    ids+="id="+idArray[i];
                }
            }
            // alert(ids);

            window.location.href="${pageContext.request.contextPath}/food/toFoodDelBatch?"+ids;
        }

    </script>
</head>
<body>

<div style="margin-left: 300px;margin-top: 80px">
    请输入要查询的商品名称：
    <form action="${pageContext.request.contextPath}/food/toFoodInfo" method="post">
        <input name="foodName" value="${foodName}"> <input type="submit" value="搜索">
    </form>
    <a href="javascript:toFoodAdd()" target="main">添加</a>
    <a href="javascript:toFoodDelBatch()" target="main">下架</a>
</div>



<table border="1" cellspacing="0" width="1000px" style="margin-top: 20px;margin-left: 5px">
    <tr>
        <th><input type="checkbox" id="allBtn"/>全选</th>
        <th>序号</th>
        <th>商品图片</th>
        <th>商品名称</th>
        <th>商品单价(元)</th>
        <th>商品销量</th>
        <th>商品描述</th>
        <th>商品分类</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.pageInfo.list}" var="temp">
        <tr>
            <td style="text-align: center"><input type="checkbox" class="itemBox" value="${temp.id}"/></td>
            <td style="text-align: center">${temp.id}</td>
            <td style="text-align: center">
                <img src="${temp.foodPri}" height="70px" width="70px">
            </td>
            <td style="text-align: center">${temp.foodName}</td>
            <td style="text-align: center">${temp.foodPrice}</td>
            <td style="text-align: center">${temp.foodSale}</td>
            <td style="text-align: center">${temp.foodDescribe}</td>
            <td style="text-align: center">${temp.className}</td>
            <td style="text-align: center">
                <a href="javascript:toFoodEdit(${temp.id})">修改</a>
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
        <a href="${pageContext.request.contextPath}/food/toFoodInfo?foodName=${foodName}">首页</a>
        <a href="${pageContext.request.contextPath}/food/toFoodInfo?pageNum=${pageInfo.pageNum-1}&foodName=${foodName}">上一页</a>
    </c:if>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <a href="${pageContext.request.contextPath}/food/toFoodInfo?pageNum=${i}&foodName=${foodName}">${i}</a>
    </c:forEach>

    <c:if test="${pageInfo.hasNextPage}">
        <a href="${pageContext.request.contextPath}/food/toFoodInfo?pageNum=${pageInfo.pageNum+1}&foodName=${foodName}">下一页</a>
        <a href="${pageContext.request.contextPath}/food/toFoodInfo?pageNum=${pageInfo.pages}&foodName=${foodName}">尾页</a>
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
