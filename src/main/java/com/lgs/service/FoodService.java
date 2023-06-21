package com.lgs.service;

import com.github.pagehelper.StringUtil;
import com.lgs.mapper.FoodMapper;
import com.lgs.pojo.Food;
import com.lgs.pojo.FoodClass;
import com.lgs.pojo.Result;
import com.lgs.pojo.User;
import com.lgs.query.FoodQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @ClassName: FoodService
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/7 20:49
 **/
@Service
public class FoodService {
    @Autowired
    private FoodMapper foodMapper;

    //商品展示
    public List<Food> getFoodList(FoodQuery foodQuery) {
        return foodMapper.getFoodList(foodQuery);
    }

    public Result addFood(Food food) {
        if (StringUtil.isEmpty(food.getFoodName())) {
            return new Result(100, "商品名不能为空");
        }
        if (StringUtil.isEmpty(food.getFoodPrice())) {
            return new Result(100, "商品单价不能为空");
        }

        if (StringUtil.isEmpty(food.getFoodDescribe())) {
            return new Result(100, "商品描述不能为空");
        }

        FoodClass foodClass = foodMapper.getFoodClassId(food.getClassName());
        if(foodClass==null){
            return new Result(100,"商品分类不存在");
        }
        //通过商品的分类名称在数据库中插入id
        food.setFoodClassId(foodClass.getId());

//        System.out.println("**************************");
//        System.out.println(food.getFoodClassId());

        Food food1 = foodMapper.getByName(food.getFoodName());
        if(food1!=null){
            return new Result(100,"商品已存在");
        }
        int rows = foodMapper.insert(food);
        if(rows!=1){
            return new Result(100,"添加失败");
        }
        return new Result(200,"添加成功");
    }

    /**
     * 从图片的文件路径中获取图片名字
     * @param path
     * @return
     */
    public static String getImageNameByPath(String path){
        String fName = path.trim();       //删除路径两侧多余空格
        String ImageName = fName.substring(fName.lastIndexOf("/")+1,
                fName.lastIndexOf("."));
        //截取最右侧斜杠之右的字段，到点为止

        return ImageName ;
    }
    //批量删除
    public Result toFoodDelBatch(Integer[] id) {
        for(Integer i:id){
            Food food = foodMapper.getById(i);
            System.out.println(food);
            String pri=getImageNameByPath(food.getFoodPri());
            String file = "D:\\java开源框架2023\\takeaway\\src\\main\\webapp\\img\\";
//            System.out.println(file+pri+"jpg");
            boolean success = (new File(file+pri+".jpg").delete());
//            System.out.println(success+"*****************************");
        }
        int row = foodMapper.toFoodDelBatch(id);
        if(row!=id.length){
            return new Result(100,"异常情况");
        }
        return new Result(200,"删除成功");
    }

    //修改商品信息 回显数据
    public Food getById(Integer id) {
        return foodMapper.getById(id);
    }

    //未修改照片时修改商品信息
    public Result editFood(Food food) {
        if (StringUtil.isEmpty(food.getFoodName())) {
            return new Result(100, "商品名不能为空");
        }
        if (StringUtil.isEmpty(food.getFoodPrice())) {
            return new Result(100, "商品单价不能为空");
        }

        if (StringUtil.isEmpty(food.getFoodDescribe())) {
            return new Result(100, "商品描述不能为空");
        }

        FoodClass foodClass = foodMapper.getFoodClassId(food.getClassName());
        if(foodClass==null){
            return new Result(100,"商品分类不存在");
        }
        //通过商品的分类名称在数据库中插入id
        food.setFoodClassId(foodClass.getId());

        int rows = foodMapper.update(food);
        if(rows!=1){
            return new Result(100,"添加失败");
        }
        return new Result(200,"添加成功");
    }

    //修改图片时
    public Result editFood1(Food food) {
        if (StringUtil.isEmpty(food.getFoodName())) {
            return new Result(100, "商品名不能为空");
        }
        if (StringUtil.isEmpty(food.getFoodPrice())) {
            return new Result(100, "商品单价不能为空");
        }

        if (StringUtil.isEmpty(food.getFoodDescribe())) {
            return new Result(100, "商品描述不能为空");
        }

        FoodClass foodClass = foodMapper.getFoodClassId(food.getClassName());
        if(foodClass==null){
            return new Result(100,"商品分类不存在");
        }
        Food food1 = foodMapper.getById(food.getId());
        String pri=getImageNameByPath(food1.getFoodPri());
        String file = "D:\\java开源框架2023\\takeaway\\src\\main\\webapp\\img\\";
        boolean success = (new File(file+pri+".jpg").delete());
        //通过商品的分类名称在数据库中插入id
        food.setFoodClassId(foodClass.getId());

        int rows = foodMapper.update1(food);
        if(rows!=1){
            return new Result(100,"添加失败");
        }
        return new Result(200,"添加成功");
    }
}
