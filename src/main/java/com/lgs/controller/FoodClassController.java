package com.lgs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.pojo.Food;
import com.lgs.pojo.FoodClass;
import com.lgs.pojo.Result;
import com.lgs.query.FoodClassQuery;
import com.lgs.query.UserQuery;
import com.lgs.service.FoodClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName: FoodClassController
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/8 22:07
 **/
@Controller
@RequestMapping("/foodClass")
public class FoodClassController {
    @Autowired
    private FoodClassService foodClassService;

    //商品信息展示
    @RequestMapping("/toFoodClassInfo")
    public String toFoodClassInfo(FoodClassQuery foodClassQuery, Model model){
        //启动分页插件
        PageHelper.startPage(foodClassQuery.getPageNum(),foodClassQuery.getPageSize());

        List<FoodClass> foodClassList = foodClassService.getFoodClassList(foodClassQuery);

        //首页 上一页 下一页 尾页，至少需要 当前页，总页数，总记录数，需要一个类进行封装，但是分页插件提供了这个类PageInfo
        PageInfo<FoodClass> pageInfo = new PageInfo<FoodClass>(foodClassList);

        model.addAttribute("foodClassName",foodClassQuery.getClassName());

        model.addAttribute("pageInfo",pageInfo);

        return "foodClassInfo";
    }

    //商品分类添加
    @RequestMapping("/toFoodClassAdd")
    public String toCourseAdd(){
        return "toFoodClassAdd";
    }

    @RequestMapping("/addFoodClass")
    public String addFoodClass(String className,Model model){

        Result result = foodClassService.addFoodClass(className);

        if(result.getCode()==200){
            //添加成功
            FoodClassQuery foodClassQuery = new FoodClassQuery();
            return toFoodClassInfo(foodClassQuery,model);
        }else {
            model.addAttribute("msg",result.getMsg());
            return "toFoodClassAdd";
        }

    }

    //删除商品分类
    @RequestMapping("/deleteFoodClass")
    public String deleteFoodClass(Integer id,Model model){
        Result result = foodClassService.deleteFoodClass(id);
        if(result.getCode()==200){
            FoodClassQuery foodClassQuery = new FoodClassQuery();
            return toFoodClassInfo(foodClassQuery,model);
        }
        return null;
    }

    //商品分类批量删除
    @RequestMapping("/delBatch")
    public String delBatch(Integer[] id,Model model){
        Result result = foodClassService.delBatch(id);

        if(result.getCode()==200){
            FoodClassQuery foodClassQuery = new FoodClassQuery();
            return toFoodClassInfo(foodClassQuery,model);
        }
        return null;
    }

    //修改商品分类
    @RequestMapping("/toFoodClassEdit")
    public String toFoodClassEdit(Integer id,Model model){
        //回显商品分类名称
        FoodClass foodClass = foodClassService.getById(id);
        model.addAttribute("foodClass",foodClass);
        return "toFoodClassEdit";
    }


    @RequestMapping("/editFoodClass")
    public String editFoodClass(FoodClass foodClass,Model model){

        Result result = foodClassService.editFoodClass(foodClass);

        if(result.getCode()==200){
            FoodClassQuery foodClassQuery = new FoodClassQuery();
            return toFoodClassInfo(foodClassQuery,model);
        }else {
            model.addAttribute("msg",result.getMsg());
            return "toFoodClassEdit";
        }
    }

}
