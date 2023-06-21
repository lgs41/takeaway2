package com.lgs.mapper;

import com.lgs.pojo.Result;
import com.lgs.query.ReviewQuery;

import java.util.List;

/**
 * @ClassName: ReviewMapper
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/10 14:30
 **/
public interface ReviewMapper {
    //展示评论
    List<Result> getReviewList(ReviewQuery reviewQuery);
}
