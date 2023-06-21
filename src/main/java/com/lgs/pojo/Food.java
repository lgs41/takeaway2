package com.lgs.pojo;

/**
 * @ClassName: Food
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/7 20:44
 **/
public class Food {
    private Integer id;
    private String foodPri;
    private String foodName;
    private String foodPrice;
    private String foodSale;
    private String foodDescribe;
    private Integer foodClassId;
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPri() {
        return foodPri;
    }

    public void setFoodPri(String foodPri) {
        this.foodPri = foodPri;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodSale() {
        return foodSale;
    }

    public void setFoodSale(String foodSale) {
        this.foodSale = foodSale;
    }

    public String getFoodDescribe() {
        return foodDescribe;
    }

    public void setFoodDescribe(String foodDescribe) {
        this.foodDescribe = foodDescribe;
    }

    public Integer getFoodClassId() {
        return foodClassId;
    }

    public void setFoodClassId(Integer foodClassId) {
        this.foodClassId = foodClassId;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodPri='" + foodPri + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodPrice='" + foodPrice + '\'' +
                ", foodSale='" + foodSale + '\'' +
                ", foodDescribe='" + foodDescribe + '\'' +
                ", foodClassId=" + foodClassId +
                ", className='" + className + '\'' +
                '}';
    }
}
