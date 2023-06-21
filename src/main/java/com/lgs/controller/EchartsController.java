package com.lgs.controller;

import com.lgs.pojo.EchartsData;
import com.lgs.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: EchartsController
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/10 15:20
 **/
@Controller
@RequestMapping("/echarts")
public class EchartsController {
    @Autowired
    private EchartsService echartsService;
    //销量展示
    @RequestMapping("/toSaleEcharts")
    public String toEcharts(){
        return "saleEcharts";

    }
    //销量展示
    @RequestMapping("/getSaleEcharts")
    @ResponseBody
    public List<EchartsData> getSaleEcharts(){
        return echartsService.getSaleEcharts();
    }

    @RequestMapping("/getNameEcharts")
    @ResponseBody
    public List<String> getNameEcharts(){
        return echartsService.getNameEcharts();
    }

    //专区展示

    @RequestMapping("/toClassEcharts")
    public String toClassEcharts(){
        return "classEcharts";

    }

    @RequestMapping("/toPriceEcharts")
    public String toPriceEcharts(){
        return "priceEcharts";

    }
    //获取价格getPriceEcharts
    @RequestMapping("/getPriceEcharts")
    @ResponseBody
    public List<EchartsData> getPriceEcharts(){
        return echartsService.getPriceEcharts();
    }

    @RequestMapping("/getClassEcharts")
    @ResponseBody
    public List<EchartsData> getClassEcharts(){
        return echartsService.getClassEcharts();
    }

}
