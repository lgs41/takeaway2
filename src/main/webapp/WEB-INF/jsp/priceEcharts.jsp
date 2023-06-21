<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/11
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script src="${pageContext.request.contextPath}/js/echarts.js"></script>

    <script>
        $(function (){

            //发送Ajax

            var data = getData();
            var data1 = getData1();
            var chartDom = document.getElementById('main');
            var myChart = echarts.init(chartDom);
            var option;

            option = {
                xAxis: {
                    type: 'category',
                    data: data1
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        data: data,
                        type: 'line'
                    }
                ]
            };

            option && myChart.setOption(option);


        })

        function getData(){
            var jsonData;
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/echarts/getPriceEcharts",
                dataType:"json",
                async:false,
                success:function (data){
                    jsonData = data;
                }
            })
            return jsonData;
        }
        function getData1(){
            var jsonData;
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/echarts/getNameEcharts",
                dataType:"json",
                async:false,
                success:function (data){
                    jsonData = data;
                }
            })
            return jsonData;
        }
    </script>

</head>

<body>
<div id="main" style="width: 3000px;height:600px;"></div>
</body>
</html>
