<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/6
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script>
        $(function (){
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/user/getRoleList",
                dataType:"json",
                success:function (data){
                    var option="";
                    var roleId=${user.roleId}
                        $.each(data,function(i,n){
                            if(roleId==n.id){
                                option+="<option value="+n.id+" selected>"+n.roleName+"</option>";
                            }else{
                                option+="<option value="+n.id+">"+n.roleName+"</option>";
                            }
                        })
                    $("#roleId").append(option);
                }
            })
        })
    </script>

</head>
<body>
<form action="${pageContext.request.contextPath}/user/editUser" method="post">
    <table style="margin-left: 200px;margin-top: 100px">

        <tr>
            <td colspan="2" style="text-align: center">
                <font color="red">
                    ${requestScope.msg}
                </font>
            </td>
        </tr>

        <tr>
            <td>用户名</td>
            <td>
                <input name="userName" value="${requestScope.user.userName}">
            </td>
        </tr>

        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="userPwd" value="${requestScope.user.userPwd}">
            </td>
        </tr>

        <tr>
            <td>手机号</td>
            <td>
                <input name="userPhone" value="${requestScope.user.userPhone}">
            </td>
        </tr>

        <tr>
            <td>地址</td>
            <td>
                <input name="userAdd" value="${requestScope.user.userAdd}">
            </td>
        </tr>

        <tr>
            <td>角色</td>
            <td>
                <select id="roleId" name="roleId">
                    <option value="0">--请选择角色--</option>
                </select>
            </td>
        </tr>

        <tr>
            <td></td>
            <td colspan="2">
                <input type="submit" value="修改">
            </td>
        </tr>

    </table>
    <input type="hidden" name="id" value="${requestScope.user.id}">
</form>
</body>
</html>
