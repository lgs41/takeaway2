<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/7
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

  <frameset rows="8%,*">

      <frame src="${pageContext.request.contextPath}/user/toTop"/>

      <frameset cols="15%,*">
          <frame src="${pageContext.request.contextPath}/user/toLeft" />
          <frame src="${pageContext.request.contextPath}/user/toMain" name="main" />
      </frameset>

  </frameset>

</html>
