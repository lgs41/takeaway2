package com.lgs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.pojo.Order;
import com.lgs.pojo.Result;
import com.lgs.query.OrderQuery;
import com.lgs.query.ReviewQuery;
import com.lgs.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName: ReviewController
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/10 14:30
 **/
@Controller
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    //评论展示
    @RequestMapping("/toReviewInfo")
    public String toReviewInfo(ReviewQuery reviewQuery, Model model){
        //启动分页插件
        PageHelper.startPage(reviewQuery.getPageNum(),reviewQuery.getPageSize());
        List<Result> resultList = reviewService.getReviewList(reviewQuery);
        //首页 上一页 下一页 尾页，至少需要 当前页，总页数，总记录数，需要一个类进行封装，但是分页插件提供了这个类PageInfo
        PageInfo<Result> pageInfo = new PageInfo<Result>(resultList);
        model.addAttribute("review",reviewQuery.getReview());
        model.addAttribute("pageInfo",pageInfo);
        return "reviewInfo";
    }
}
