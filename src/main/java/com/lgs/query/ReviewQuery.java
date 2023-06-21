package com.lgs.query;

/**
 * @ClassName: ReviewQuery
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/10 14:32
 **/
public class ReviewQuery extends BaseQuery{
    private Integer pageSize=8;//每页显示的记录数
    private String review;

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "ReviewQuery{" +
                "pageSize=" + pageSize +
                ", review='" + review + '\'' +
                '}';
    }
}
