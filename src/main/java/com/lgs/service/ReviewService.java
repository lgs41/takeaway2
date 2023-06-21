package com.lgs.service;

import com.lgs.mapper.ReviewMapper;
import com.lgs.pojo.Result;
import com.lgs.query.ReviewQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ReviewService
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/10 14:30
 **/
@Service
public class ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    //展示评论
    public List<Result> getReviewList(ReviewQuery reviewQuery) {
        return reviewMapper.getReviewList(reviewQuery);
    }
}
