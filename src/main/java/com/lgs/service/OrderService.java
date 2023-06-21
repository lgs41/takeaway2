package com.lgs.service;

import com.github.pagehelper.StringUtil;
import com.lgs.mapper.OrderMapper;
import com.lgs.pojo.Order;
import com.lgs.pojo.Result;
import com.lgs.pojo.Review;
import com.lgs.query.OrderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: OrderService
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/9 23:50
 **/
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    //订单展示
    public List<Order> getOrderList(OrderQuery orderQuery) {
        return orderMapper.getOrderList(orderQuery);
    }

    //修改发货状态为已经发货
    public Result toFoodEdit(Integer orderId) {
        int row = orderMapper.toFoodEdit(orderId);
        if(row!=1){
            return new Result(100,"修改失败");
        }
        return new Result(200,"修改成功");
    }

    //批量删除订单信息
    public Result toDelBatch(Integer[] id) {
        int row = orderMapper.toDelBatch(id);
        if(row!=id.length){
            return new Result(100,"异常情况");
        }
        return new Result(200,"删除成功");
    }

    //查看订单
    public Result toReview(Review review) {
        if(StringUtil.isEmpty(review.getReview())){
            return new Result(100,"评价不能为空");
        }
        Order order = orderMapper.getIdList(review.getOrderId());
        review.setUserId(order.getUserId());
        int row = orderMapper.toReview(review);
        //修改为已评价
        orderMapper.toEdit(review.getOrderId());
        if(row!=1){
            return new Result(100,"评论失败");
        }
        return new Result(200,"评论成功");
    }

    //获取订单信息
    public Review getList(Integer orderId) {
        return orderMapper.getList(orderId);
    }

    //用户订单展示
    public List<Order> getUserOrderList(Integer userId,OrderQuery orderQuery) {
        return orderMapper.getUserOrderList(userId,orderQuery);
    }
}
