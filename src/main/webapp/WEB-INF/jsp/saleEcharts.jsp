<%--
  Created by IntelliJ IDEA.
  User: Mr li
  Date: 2023/6/8
  Time: 9:03
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
                title: {
                    text: '商品销量统计',
                    subtext: '南丁格尔玫瑰图',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                },
                legend: {
                    left: 'center',
                    top: 'bottom',
                    data: data1
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: { show: true },
                        dataView: { show: true, readOnly: false },
                        restore: { show: true },
                        saveAsImage: { show: true }
                    }
                },
                series: [
                    {
                        name: '商品',
                        type: 'pie',
                        radius: [20, 140],
                        center: ['25%', '50%'],
                        roseType: 'radius',
                        itemStyle: {
                            borderRadius: 5
                        },
                        label: {
                            show: false
                        },
                        emphasis: {
                            label: {
                                show: true
                            }
                        },
                        data: data
                    },
                    {
                        name: '商品',
                        type: 'pie',
                        radius: [20, 140],
                        center: ['75%', '50%'],
                        roseType: 'area',
                        itemStyle: {
                            borderRadius: 5
                        },
                        data: data
                    }
                ]
            };

            option && myChart.setOption(option);

        })

        function getData(){
            var jsonData;
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/echarts/getSaleEcharts",
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
    <div id="main" style="width: 1100px;height:500px;"></div>
</body>
</html>
