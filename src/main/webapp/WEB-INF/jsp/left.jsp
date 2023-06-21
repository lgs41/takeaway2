<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/7
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/zTree_v3-master/css/demo.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/zTree_v3-master/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3-master/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3-master/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3-master/js/jquery.ztree.excheck.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3-master/js/jquery.ztree.exedit.js"></script>
    <SCRIPT type="text/javascript">

        //异步请求（没有阻塞的）
        //文档加载完成时触发
        $(function (){
            var data = getData();

            var setting = {
                data: {
                    simpleData: {
                        enable: true
                    }
                }
            };

            //渲染
            var zNodes =data;

            $(document).ready(function(){
                $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            });

        })

        function getData(){
            var jsonData;
            //发送Ajax请求
            $.ajax({
                //请求方式
                type:"post",
                //请求路径
                url:"${pageContext.request.contextPath}/menu/getMenuList?userId=${sessionScope.userInfo.id}",
                //数据类型
                dataType:"json",
                //同步请求（有阻塞）
                async:false,
                //回调函数
                success:function (data){
                    jsonData=data;
                }
            })
            return jsonData;
        }

    </SCRIPT>
</head>
<body>


<div class="zTreeDemoBackground left">
    <ul id="treeDemo" class="ztree"></ul>
</div>

</body>
</html>
