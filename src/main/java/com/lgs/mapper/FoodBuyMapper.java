package com.lgs.mapper;

import com.lgs.pojo.Food;
import com.lgs.query.FoodQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FoodBuyMapper
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/9 8:27
 **/
public interface FoodBuyMapper {
    //商品展示
    List<Food> getFoodList(FoodQuery foodQuery);

    //商品添加至购物车insert
    int toFoodBuy(@Param("userId") Integer userId, @Param("id") Integer id);


}
