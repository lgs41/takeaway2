package com.lgs.mapper;

import com.lgs.pojo.EchartsData;
import com.lgs.pojo.Food;

import java.util.List;

/**
 * @ClassName: EchartsMapper
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/10 15:21
 **/
public interface EchartsMapper {
    //销量
    List<EchartsData> getSaleEcharts();

    //获取名字
    List<String> getNameEcharts();

    //专区展示
    List<EchartsData> getClassEcharts();

    //获取价格
    List<Food> getPriceEcharts();
}
