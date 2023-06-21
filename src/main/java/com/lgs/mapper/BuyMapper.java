package com.lgs.mapper;

import com.lgs.pojo.Buy;
import com.lgs.pojo.Food;
import com.lgs.query.FoodQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: BuyMapper
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/9 10:12
 **/
public interface BuyMapper {
//    购物车展示
    List<Buy> getBuyList(@Param("userId") Integer userId,@Param("test") FoodQuery foodQuery);

    //批量删除
    int toDelBatch(Integer[] id);

    //获取单价
    Food getPrice(@Param("buyId") Integer buyId);

    //插入到订单中
    int toAddBatch(@Param("userId") Integer userId, @Param("foodName") String foodName,@Param("number") Integer number, @Param("price") Integer price);

    //修改销量
    void updateSale(Food food);
}
