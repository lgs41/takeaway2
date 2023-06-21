package com.lgs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.pojo.*;
import com.lgs.query.FoodQuery;
import com.lgs.query.OrderQuery;
import com.lgs.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: OrderController
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/9 23:49
 **/
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    //订单管理展示
    @RequestMapping("/toOrderInfo")
    public String toOrderInfo(OrderQuery orderQuery, Model model){
        //启动分页插件
        PageHelper.startPage(orderQuery.getPageNum(),orderQuery.getPageSize());
        List<Order> orderList = orderService.getOrderList(orderQuery);
        //首页 上一页 下一页 尾页，至少需要 当前页，总页数，总记录数，需要一个类进行封装，但是分页插件提供了这个类PageInfo
        PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
        model.addAttribute("foodName",orderQuery.getFoodName());
        model.addAttribute("pageInfo",pageInfo);
        return "orderInfo";
    }
    //用户订单展示
    @RequestMapping("/userOrderInfo")
    public String userOrderInfo(HttpSession session,OrderQuery orderQuery, Model model){
        User user = (User) session.getAttribute("userInfo");
        Integer userId = user.getId();
        //启动分页插件
        PageHelper.startPage(orderQuery.getPageNum(),orderQuery.getPageSize());
        List<Order> orderList = orderService.getUserOrderList(userId,orderQuery);
        //首页 上一页 下一页 尾页，至少需要 当前页，总页数，总记录数，需要一个类进行封装，但是分页插件提供了这个类PageInfo
        PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
        model.addAttribute("foodName",orderQuery.getFoodName());
        model.addAttribute("pageInfo",pageInfo);
        return "userOrderInfo";
    }
    //修改发货状态
    @RequestMapping("/toFoodEdit")
    public String toFoodEdit(Integer orderId,Model model){
        Result result = orderService.toFoodEdit(orderId);
        if(result.getCode()==200){
            OrderQuery orderQuery = new OrderQuery();
            return toOrderInfo(orderQuery,model);
        }
        return null;
    }
    //批量删除订单信息
    @RequestMapping("/toDelBatch")
    public String toDelBatch(Integer[] id,Model model){
        Result result = orderService.toDelBatch(id);
        if(result.getCode()==200){
            OrderQuery orderQuery = new OrderQuery();
            return toOrderInfo(orderQuery,model);
        }
        return null;
    }
    //修改商品分类
    @RequestMapping("/review")
    public String review(Integer orderId,Model model){
        Review review = orderService.getList(orderId);
//        System.out.println("************");
//        System.out.println(review);
        model.addAttribute("review",review);
        return "toReview";
    }

    //订单评论
    @RequestMapping("/toReview")
    public String toReview(HttpSession session,Review review,Model model){
//        System.out.println("*********************");
//        System.out.println(review.getReview());
//        System.out.println("****************");
        Result result = orderService.toReview(review);
        if(result.getCode()==200){
            OrderQuery orderQuery = new OrderQuery();
            return userOrderInfo(session,orderQuery,model);
        } else{
            model.addAttribute("msg",result.getMsg());
            return "toReview";
        }
    }

}
