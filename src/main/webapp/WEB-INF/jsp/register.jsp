<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/7
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <script>
        function change(){
            var img = document.getElementById("img");

            img.src="${pageContext.request.contextPath}/getVarifyCode?time="+new Date();
        }

        function out(){
            parent.location.href="${pageContext.request.contextPath}/user/out";
        }

    </script>
    <style>
        body{
            padding: 1px;
            width: 100%;
            height: 100%;
            background-size: 100% 100%;
            /*background-color: #0B61A4;*/
            background-image: url("/img/register.jpg");
            background-attachment: fixed;

        }
    </style>

</head>
<body>
<div>
       <span style="color: #1b1b1b;font-size: 30px;margin-right: 30px">
           <a href="javascript:out()">退出</a>
       </span>
</div>
<div style="margin-top: 200px;margin-left: 500px;" >
    <form action="${pageContext.request.contextPath}/user/register" method="post">
        <table border="1" cellspacing="0" style="width: 380px;height: 240px">
            <tr>
                <td colspan="2" style="text-align: center;font-size: 25px">
                    <font color="red">
                        ${requestScope.msg}
                    </font>
                </td>
            </tr>

            <tr>
                <td style="font-size: 20px">
                    性别：
                </td>
                <td style="font-size: 15px">
                    <input name="gender" height="20px">
                </td>
            </tr>

            <tr>
                <td style="font-size: 20px">
                    用户名：
                </td>
                <td style="font-size: 15px">
                    <input name="userName" height="20px">
                </td>
            </tr>

            <tr>
                <td style="font-size: 20px">
                    密&nbsp;&nbsp;码：
                </td>
                <td style="font-size: 15px">
                    <input type="password" name="userPwd1" height="20px">
                </td>
            </tr>

            <tr>
                <td style="font-size: 20px">
                    确定密码：
                </td>
                <td style="font-size: 15px">
                    <input type="password" name="userPwd2" height="20px">
                </td>
            </tr>

            <tr>
                <td style="font-size: 20px">
                    手机号：
                </td>
                <td style="font-size: 15px">
                    <input name="userPhone" height="20px">
                </td>
            </tr>

            <tr>
                <td style="font-size: 20px">
                    地址：
                </td>
                <td style="font-size: 15px">
                    <input name="userAdd" height="20px">
                </td>
            </tr>

            <tr>
                <td style="font-size: 20px">
                    验证码：
                </td>
                <td style="font-size: 15px">
                    <input name="varifyCode" style="height: 20px">
                    <a href="javascript:change()">
                        <img id="img" style="display:inline-block;position: absolute;margin-top: 1px;margin-left: 5px" src="${pageContext.request.contextPath}/getVarifyCode">
                    </a>
                </td>
            </tr>

            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" value="注册" style="height: 30px;font-size: 20px">
                </td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
