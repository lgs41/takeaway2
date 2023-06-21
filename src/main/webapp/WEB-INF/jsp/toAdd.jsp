<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/6
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script>
        $(function (){
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/user/getRoleList",
                dataType:"json",
                success:function (data){
                    var option="";
                    $.each(data,function (i,n){
                        option+="<option value="+n.id+">"+n.roleName+"</option>";
                    })
                    $("#role").append(option);
                }
            })
        })
    </script>

</head>
<body>
 <form action="${pageContext.request.contextPath}/user/addUser" method="post">
    <table style="margin-left: 200px;margin-top: 100px">

        <tr>
            <td colspan="2" style="text-align: center">
                <font color="red">
                    ${requestScope.msg}
                </font>
            </td>
        </tr>

        <tr>
            <td>性别</td>
            <td>
                <input name="gender">
            </td>
        </tr>

        <tr>
            <td>用户名</td>
            <td>
                <input name="userName">
            </td>
        </tr>

        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="userPwd">
            </td>
        </tr>

        <tr>
            <td>手机号</td>
            <td>
                <input name="userPhone">
            </td>
        </tr>

        <tr>
            <td>地址</td>
            <td>
                <input name="userAdd">
            </td>
        </tr>

        <tr>
            <td>角色</td>
            <td>
                <select id="role" name="roleId">
                    <option value="0">--请选择角色--</option>
                </select>
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
