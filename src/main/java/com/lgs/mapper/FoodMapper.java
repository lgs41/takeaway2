package com.lgs.mapper;

import com.lgs.pojo.Food;
import com.lgs.pojo.FoodClass;
import com.lgs.query.FoodQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: FoodMapper
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/7 20:49
 **/
public interface FoodMapper {

    //商品展示
    List<Food> getFoodList(FoodQuery foodQuery);

    //通过商品的分类名称在数据库中插入id
    FoodClass getFoodClassId(String className);

    //判断商品是否存在
    Food getByName(String foodName);

    //获得图片路径
    Food getById(@Param("id") Integer id);

    //添加商品
    int insert(Food food);

    //商品批量删除
    int toFoodDelBatch(Integer[] id);

    //未修改照片时修改商品信息
    int update(Food food);

    //修改图片时
    int update1(Food food);
}
