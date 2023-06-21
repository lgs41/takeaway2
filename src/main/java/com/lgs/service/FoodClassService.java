package com.lgs.service;

import com.github.pagehelper.StringUtil;
import com.lgs.mapper.FoodClassMapper;
import com.lgs.pojo.Food;
import com.lgs.pojo.FoodClass;
import com.lgs.pojo.Result;
import com.lgs.query.FoodClassQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: FoodClassService
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/8 22:07
 **/
@Service
public class FoodClassService {
    @Autowired
    private FoodClassMapper foodClassMapper;

    //商品分类展示
    public List<FoodClass> getFoodClassList(FoodClassQuery foodClassQuery) {
        return foodClassMapper.getFoodClassList(foodClassQuery);
    }

    //添加商品分类
    public Result addFoodClass(String className) {
        if (StringUtil.isEmpty(className)) {
            return new Result(100, "商品分类名称不能为空");
        }
        FoodClass foodClass =foodClassMapper.getByClassName(className);
        if(foodClass!=null){
            return new Result(100,"商品分类名称已经存在，添加失败");
        }
        int rows = foodClassMapper.insert(className);
        if(rows!=1){
            return new Result(100,"添加失败");
        }
        return new Result(200,"添加成功");
    }

    //删除商品分类
    public Result deleteFoodClass(Integer id) {
        int row = foodClassMapper.deleteFoodClass(id);
        if(row!=1){
            return new Result(100,"异常情况");
        }
        return new Result(200,"删除成功");
    }

    //商品分类批量删除
    public Result delBatch(Integer[] id) {
        if(id==null || id.length==0){
            return new Result(100,"至少选择一条记录");
        }
        int row = foodClassMapper.delBatch(id);
        if(row!=id.length){
            return new Result(100,"异常情况");
        }
        return new Result(200,"删除成功");
    }

    //修改
    //回显商品分类名称
    public FoodClass getById(Integer id) {
        return foodClassMapper.getById(id);
    }

    public Result editFoodClass(FoodClass foodClass) {
        //非空校验
        if (StringUtil.isEmpty(foodClass.getClassName())) {
            return new Result(100, "商品分类名称不能为空");
        }

        FoodClass foodClass1= foodClassMapper.getByClassName(foodClass.getClassName());
        if(foodClass1!=null){
            return new Result(100,"该商品分类名称已存在，修改失败");
        }
        int rows = foodClassMapper.update(foodClass);
        if(rows!=1){
            return new Result(100,"添加失败");
        }
        return new Result(200,"添加成功");
    }

//    public Result deleteCourse(Integer id) {
//        int row = courseMapper.deleteCourse(id);
//        if(row!=1){
//            return new Result(100,"异常情况");
//        }
//        return new Result(200,"删除成功");
//    }
//
//    public Course getById(Integer id) {
//        return courseMapper.getById(id);
//    }
//
//    public Result editCourse(Course course) {
//
////        String str="";
//        //非空校验
//        if (StringUtil.isEmpty(course.getCourseName())) {
//            return new Result(100, "课程名不能为空");
//        }
//
//        if (StringUtil.isEmpty(course.getCredit())) {
//            return new Result(100, "学分不能为空");
//        }
//
//        Course course1= courseMapper.getByCourseName(course.getCourseName());
//        if(course1!=null){
//            return new Result(100,"该课程号已存在,修改失败");
//        }
//        int rows = courseMapper.update(course);
//        if(rows!=1){
//            return new Result(100,"添加失败");
//        }
//        return new Result(200,"添加成功");
//    }
//

}
