<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/7
  Time: 8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function logout(){
            parent.location.href="${pageContext.request.contextPath}/user/logout";
        }
    </script>
</head>
<body>
   <div style="text-align: right">
       <span>
            ${sessionScope.userInfo.userName} | <a href="javascript:logout()">退出</a>
       </span>
   </div>
</body>
</html>
