package com.lgs.mapper;

import com.lgs.pojo.Order;
import com.lgs.pojo.Review;
import com.lgs.query.OrderQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: OrderMapper
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/9 23:51
 **/
public interface OrderMapper {
    //订单展示
    List<Order> getOrderList(OrderQuery orderQuery);
    //修改订单状态
    int toFoodEdit(Integer orderId);
    //批量删除订单
    int toDelBatch(Integer[] id);
    //订单评论
    int toReview(Review review);
    //订单
    Order getOrderIdList(Integer orderId);
    //获取订单信息
    Review getList(Integer orderId);
    //获取用户信息
    Order getIdList(Integer orderId);
    //修改为已经送达
    void toEdit(Integer orderId);
    //用户订单展示
    List<Order> getUserOrderList(@Param("userId") Integer userId, @Param("test") OrderQuery orderQuery);
}
