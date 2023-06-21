package com.lgs.service;

import com.lgs.mapper.EchartsMapper;
import com.lgs.pojo.EchartsData;
import com.lgs.pojo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: EchartsService
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/10 15:21
 **/
@Service
public class EchartsService {
    @Autowired
    private EchartsMapper echartsMapper;

    //销量
    public List<EchartsData> getSaleEcharts() {
        return echartsMapper.getSaleEcharts();
    }
    //获取名字
    public List<String> getNameEcharts() {
        return echartsMapper.getNameEcharts();
    }

    //专区展示
    public List<EchartsData> getClassEcharts() {
        return echartsMapper.getClassEcharts();
    }

    public List<EchartsData> getPriceEcharts() {
        List<Food> foodList= echartsMapper.getPriceEcharts();
        ArrayList echartsData= new ArrayList<Integer>();
        for(int i =0 ;i<foodList.size();i++){
            Integer value= Integer.valueOf(foodList.get(i).getFoodPrice());
            echartsData.add(value);
        }
        return echartsData;
    }
}
