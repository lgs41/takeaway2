<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/8
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script>
        function toFoodClassAdd(){
            window.location.href="${pageContext.request.contextPath}/foodClass/toFoodClassAdd"
        }

        function toFoodClassEdit(id){
                window.location.href="${pageContext.request.contextPath}/foodClass/toFoodClassEdit?id="+id
        }

        function deleteFoodClass(id){
            window.location.href="${pageContext.request.contextPath}/foodClass/deleteFoodClass?id="+id
        }

        function delBatch(){
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

            window.location.href="${pageContext.request.contextPath}/foodClass/delBatch?"+ids;
        }
    </script>
</head>
<body>

<div style="margin-left: 300px;margin-top: 100px">
    请输入要查询的分类名称：
    <form action="${pageContext.request.contextPath}/foodClass/toFoodClassInfo" method="post">
        <input name="className" value="${className}"> <input type="submit" value="搜索">
    </form>
    <a href="javascript:toFoodClassAdd()" target="main">添加</a>
    <a href="javascript:delBatch()" target="main">删除</a>
</div>



<table border="1" cellspacing="0" width="800px" style="margin-top: 50px;margin-left: 150px">
    <tr>
        <th><input type="checkbox" id="allBtn"/>全选</th>
        <th>ID</th>
        <th>分类名称</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.pageInfo.list}" var="temp">
        <tr>
            <td style="text-align: center"><input type="checkbox" class="itemBox" value="${temp.id}"/></td>
            <td style="text-align: center">${temp.id}</td>
            <td style="text-align: center">${temp.className}</td>
            <td style="text-align: center">
                <a href="javascript:toFoodClassEdit(${temp.id})">修改</a>|<a href="javascript:deleteFoodClass(${temp.id})">删除</a>
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
        <a href="${pageContext.request.contextPath}/foodClass/toFoodClassInfo?className=${className}">首页</a>
        <a href="${pageContext.request.contextPath}/foodClass/toFoodClassInfo?pageNum=${pageInfo.pageNum-1}&className=${className}">上一页</a>
    </c:if>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <a href="${pageContext.request.contextPath}/foodClass/toFoodClassInfo?pageNum=${i}&className=${className}">${i}</a>
    </c:forEach>

    <c:if test="${pageInfo.hasNextPage}">
        <a href="${pageContext.request.contextPath}/foodClass/toFoodClassInfo?pageNum=${pageInfo.pageNum+1}&className=${className}">下一页</a>
        <a href="${pageContext.request.contextPath}/foodClass/toFoodClassInfo?pageNum=${pageInfo.pages}&className=${className}">尾页</a>
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