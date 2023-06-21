package com.lgs.pojo;

/**
 * @ClassName: Order
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/9 16:20
 **/
public class Order extends User{
    private Integer orderId;
    private Integer userId;
    private String foodName;
    private Integer number;
    private Integer price;
    private String orderData;
    private String state;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", foodName='" + foodName + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", orderData='" + orderData + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
