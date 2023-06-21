package com.lgs.mapper;

import com.lgs.pojo.FoodClass;
import com.lgs.query.FoodClassQuery;

import java.util.List;

/**
 * @ClassName: FoodClassMapper
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/8 22:09
 **/
public interface FoodClassMapper {
    //商品分类展示
    List<FoodClass> getFoodClassList(FoodClassQuery foodClassQuery);

    //判断商品分类是否存在
    FoodClass getByClassName(String className);

    //插入商品名称
    int insert(String className);

    //删除商品分类
    int deleteFoodClass(Integer id);

    //商品分类批量删除
    int delBatch(Integer[] id);

    //回显商品分类名称
    FoodClass getById(Integer id);

    //修改商品分类名称
    int update(FoodClass foodClass);
}
