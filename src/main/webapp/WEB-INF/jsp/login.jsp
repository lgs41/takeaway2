<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/6
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>登录页面</title>
    <script>
        function change(){
            var img = document.getElementById("img");

            img.src="${pageContext.request.contextPath}/getVarifyCode?time="+new Date();
        }
    </script>

    <style>
        body{
            padding: 1px;
            width: 100%;
            height: 100%;
            background-size: 100% 100%;
            /*background-color: #0B61A4;*/
            background-image: url("/img/ln.jpg");
            background-attachment: fixed;

        }
    </style>
</head>
<body>
     <div style="margin-top: 200px;margin-left: 480px"  >
         <form action="${pageContext.request.contextPath}/user/login" method="post">
         <table border="1" cellspacing="0" style="width: 340px;height: 200px">
             <tr>
                 <td colspan="2" style="text-align: center;font-size: 25px">
                     <font color="red">
                         ${requestScope.msg}
                     </font>
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
                     <input type="password" name="userPwd" height="20px">
                 </td>
             </tr>

             <tr>
                 <td style="font-size: 20px">
                     验证码：
                 </td>
                 <td style="position: relative;font-size: 15px">
                     <input name="varifyCode" style="height: 20px">
                     <a href="javascript:change()" >
                         <img id="img" style="display:inline-block;position: absolute;margin-top: 1px;margin-left: 5px" src="${pageContext.request.contextPath}/getVarifyCode">
                     </a>
                 </td>
             </tr>

             <tr>
                 <td colspan="2" style="text-align: center;">
                     <input type="submit" value="登录" style="height: 30px;font-size: 20px">
                 </td>
             </tr>
             <tr style="font-size: 30px">
                 <td colspan="2" style="text-align: center;font-size: 15px"><a
                         href="http://localhost:8080/takeaway_war_exploded/user/register">还没有账号？点此注册</a></td>
             </tr>

         </table>
         </form>
     </div>
</body>
</html>
