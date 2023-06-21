package com.lgs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.pojo.Buy;
import com.lgs.pojo.Food;
import com.lgs.pojo.Result;
import com.lgs.pojo.User;
import com.lgs.query.FoodQuery;
import com.lgs.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: BuyController
 * @Auther: lgs
 * @Description: 购物车
 * @DateTime: 2023/6/9 10:08
 **/
@Controller
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    private BuyService buyService;
    //购物车展示及模糊查询
    @RequestMapping("/toBuyInfo")
    public String toBuyInfo(HttpSession session,FoodQuery foodQuery, Model model){
        User user = (User) session.getAttribute("userInfo");
        Integer userId = user.getId();
        //启动分页插件
        PageHelper.startPage(foodQuery.getPageNum(),foodQuery.getPageSize());
        List<Buy> buyList = buyService.getBuyList(userId,foodQuery);
        //首页 上一页 下一页 尾页，至少需要 当前页，总页数，总记录数，需要一个类进行封装，但是分页插件提供了这个类PageInfo
        PageInfo<Buy> pageInfo = new PageInfo<Buy>(buyList);
        model.addAttribute("foodName",foodQuery.getFoodName());
        model.addAttribute("pageInfo",pageInfo);
        return "buyInfo";
    }

    //购物车批量删除
    @RequestMapping("/toDelBatch")
    public String toDelBatch(HttpSession session,Integer[] id,Model model){
        Result result = buyService.toDelBatch(id);
        if(result.getCode()==200){
            FoodQuery foodQuery = new FoodQuery();
            return toBuyInfo(session,foodQuery,model);
        }
        return null;
    }
    //商品下单
    @RequestMapping("/toAddBatch")
    public String toAddBatch(HttpSession session,Integer userId,Integer[] id,Model model){
        Result result = buyService.toAddBatch(userId,id);
        if(result.getCode()==200){
            FoodQuery foodQuery = new FoodQuery();
            return toBuyInfo(session,foodQuery,model);
        }
        return null;
    }


}
