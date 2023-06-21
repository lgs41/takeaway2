package com.lgs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.pojo.Food;
import com.lgs.pojo.Result;
import com.lgs.pojo.User;
import com.lgs.query.FoodClassQuery;
import com.lgs.query.FoodQuery;
import com.lgs.service.FoodBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: FoodBuyController
 * @Auther: lgs
 * @Description: 商品下单
 * @DateTime: 2023/6/9 8:27
 **/
@Controller
@RequestMapping("/foodBuy")
public class FoodBuyController {
    @Autowired
    private FoodBuyService foodBuyService;
    //商品展示及模糊查询
    @RequestMapping("/toFoodBuyInfo")
    public String toFoodBuyInfo(FoodQuery foodQuery, Model model){
        //启动分页插件
        PageHelper.startPage(foodQuery.getPageNum(),foodQuery.getPageSize());
        List<Food> foodList = foodBuyService.getFoodList(foodQuery);
        //首页 上一页 下一页 尾页，至少需要 当前页，总页数，总记录数，需要一个类进行封装，但是分页插件提供了这个类PageInfo
        PageInfo<Food> pageInfo = new PageInfo<Food>(foodList);
        model.addAttribute("foodName",foodQuery.getFoodName());
        model.addAttribute("pageInfo",pageInfo);
        return "foodBuyInfo";
    }
    //商品添加至购物车
    @RequestMapping("/toFoodBuy")
    public String toFoodBuy(HttpSession session,Integer id, Model model){
        //获取登陆的用户信息
        User user = (User) session.getAttribute("userInfo");
        Integer userId = user.getId();
        Result result = foodBuyService.toFoodBuy(userId,id);
        if(result.getCode()==200){
            FoodQuery foodQuery = new FoodQuery();
            return toFoodBuyInfo(foodQuery,model);
        }
        return null;
    }
    //商品批量添加至购物车
    @RequestMapping("/toFoodAddBatch")
    public String toFoodAddBatch(HttpSession session,Integer[] id,Model model){
        //获取登陆的用户信息
        User user = (User) session.getAttribute("userInfo");
        Integer userId = user.getId();
        Result result = foodBuyService.toFoodAddBatch(userId,id);
        if(result.getCode()==200){
            FoodQuery foodQuery = new FoodQuery();
            return toFoodBuyInfo(foodQuery,model);
        }
        return null;
    }
}
