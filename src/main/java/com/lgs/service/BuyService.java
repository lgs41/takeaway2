package com.lgs.service;

import com.lgs.mapper.BuyMapper;
import com.lgs.pojo.Buy;
import com.lgs.pojo.Food;
import com.lgs.pojo.Result;
import com.lgs.query.FoodQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: BuyMapper
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/9 10:11
 **/
@Service
public class BuyService {
    @Autowired
    private BuyMapper buyMapper;

    //购物车展示
    public List<Buy> getBuyList(Integer userId,FoodQuery foodQuery) {
        return buyMapper.getBuyList(userId,foodQuery);
    }

    //购物车批量删除
    public Result toDelBatch(Integer[] id) {
        if(id==null || id.length==0){
            return new Result(100,"至少选择一条记录");
        }
        int row = buyMapper.toDelBatch(id);
        if(row!=id.length){
            return new Result(100,"异常情况");
        }
        return new Result(200,"删除成功");
    }

    //商品下单添加到订单表中
    public Result toAddBatch(Integer userId,Integer[] id) {
        Integer number=id.length;
        Integer price = 0;
        //订单中的商品名称
        String foodName="";
        //修改商品的销量
        Integer foodSale=0;
        for(Integer i:id){
            Food food = buyMapper.getPrice(i);
            foodName +=food.getFoodName()+" ";
            //获得原来销量
            foodSale = Integer.valueOf(food.getFoodSale())+1;
            price += Integer.valueOf(food.getFoodPrice());

            food.setFoodSale(String.valueOf(foodSale));
            buyMapper.updateSale(food);
        }
        //插入到订单中
        int row = buyMapper.toAddBatch(userId,foodName,number,price);
        //删除购物车中的订单
        int row1 = buyMapper.toDelBatch(id);
        return new Result(200,"删除成功");
    }
}
