package com.lgs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.pojo.Food;
import com.lgs.pojo.Result;
import com.lgs.pojo.User;
import com.lgs.query.FoodQuery;
import com.lgs.query.UserQuery;
import com.lgs.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: FoodController
 * @Auther: lgs
 * @Description: 商品/食物
 * @DateTime: 2023/6/7 20:48
 **/
@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;
    //商品展示及模糊查询
    @RequestMapping("/toFoodInfo")
    public String toFoodInfo(FoodQuery foodQuery, Model model){
        //启动分页插件
        PageHelper.startPage(foodQuery.getPageNum(),foodQuery.getPageSize());
        List<Food> foodList = foodService.getFoodList(foodQuery);
        //首页 上一页 下一页 尾页，至少需要 当前页，总页数，总记录数，需要一个类进行封装，但是分页插件提供了这个类PageInfo
        PageInfo<Food> pageInfo = new PageInfo<Food>(foodList);
        model.addAttribute("foodName",foodQuery.getFoodName());
        model.addAttribute("pageInfo",pageInfo);
        return "foodInfo";
    }
    //商品添加
    @RequestMapping("/toFoodAdd")
    public String toAdd(){
        return "toFoodAdd";
    }

    @RequestMapping("/addFood")
    public String addFood(Food food, MultipartFile upload, Model model) throws IOException {
        String filename = upload.getOriginalFilename();
        food.setFoodPri("/takeaway_war_exploded/img/" + filename);
        String path = "D:\\java开源框架2023\\takeaway\\src\\main\\webapp\\img";
        Result result = foodService.addFood(food);
        if (result.getCode() == 200) {
            /**
             *文件上传
             */
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (upload != null && !upload.isEmpty()) {
                upload.transferTo(new File(path, filename));
            } else {
                return "failed";
            }
            //添加成功
            FoodQuery foodQuery = new FoodQuery();
            return toFoodInfo(foodQuery, model);
        } else {
            model.addAttribute("msg", result.getMsg());
            return "toFoodAdd";
        }

    }

    //商品批量删除
    @RequestMapping("/toFoodDelBatch")
    public String toFoodDelBatch(Integer[] id,Model model){
        Result result = foodService.toFoodDelBatch(id);

        if(result.getCode()==200){
            FoodQuery foodQuery =new FoodQuery();
            return toFoodInfo(foodQuery,model);
        }

        return null;
    }

    //商品修改
    @RequestMapping("/toFoodEdit")
    public String toEdit(Integer id,Model model){
        Food food = foodService.getById(id);
        model.addAttribute("food",food);
        return "toFoodEdit";
    }

    //修改商品
    @RequestMapping("/editFood")
    public String editFood(Food food, MultipartFile upload, Model model) throws IOException {

        Result result = new Result();
        //获取文件名
        String filename = upload.getOriginalFilename();
        if (filename == null || filename == "") {
            result = foodService.editFood(food);
        }else {
            food.setFoodPri("/takeaway_war_exploded/img/"+filename);
            String path = "D:\\java开源框架2023\\takeaway\\src\\main\\webapp\\img";
            /**
             *文件上传
             */
            File file = new File(path);
            if (!file.exists()){
                file.mkdirs();
            }
            if (upload != null && !upload.isEmpty()) {
                upload.transferTo(new File(path,filename));
            } else {
                return "failed";
            }
            //修改图片时
            result = foodService.editFood1(food);
        }
//        Result result = foodService.editFood(food);
        if(result.getCode()==200){
            FoodQuery foodQuery =new FoodQuery();
            return toFoodInfo(foodQuery,model);
        }else {
            model.addAttribute("msg",result.getMsg());
            return "toFoodEdit";
        }
    }

}
