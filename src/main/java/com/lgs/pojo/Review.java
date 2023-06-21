package com.lgs.pojo;

/**
 * @ClassName: Review
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/10 11:46
 **/
public class Review{
    private String reviewId;
    private Integer userId;
    private String userName;
    private String foodName;
    private Integer orderId;
    private String review;
    private String reviewData;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReviewData() {
        return reviewData;
    }

    public void setReviewData(String reviewData) {
        this.reviewData = reviewData;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", foodName='" + foodName + '\'' +
                ", orderId=" + orderId +
                ", review='" + review + '\'' +
                ", reviewData='" + reviewData + '\'' +
                '}';
    }
}
