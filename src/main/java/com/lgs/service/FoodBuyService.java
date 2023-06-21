package com.lgs.service;

import com.lgs.mapper.FoodBuyMapper;
import com.lgs.pojo.Food;
import com.lgs.pojo.Result;
import com.lgs.query.FoodQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: FoodBuyService
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/9 8:27
 **/
@Service
public class FoodBuyService {
    @Autowired
    private FoodBuyMapper foodBuyMapper;
    //商品展示
    public List<Food> getFoodList(FoodQuery foodQuery) {
        return foodBuyMapper.getFoodList(foodQuery);
    }

    //商品添加至购物车
    public Result toFoodBuy(Integer userId,Integer id) {
        int row = foodBuyMapper.toFoodBuy(userId,id);
        if(row!=1){
            return new Result(100,"异常情况");
        }
        return new Result(200,"删除成功");
    }

    //商品批量添加至购物车
    public Result toFoodAddBatch(Integer userId,Integer[] id) {
        if(id==null || id.length==0){
            return new Result(100,"至少选择一条记录");
        }
        for(Integer i:id){
            int row = foodBuyMapper.toFoodBuy(userId,i);
        }
        return new Result(200,"删除成功");
    }
}
