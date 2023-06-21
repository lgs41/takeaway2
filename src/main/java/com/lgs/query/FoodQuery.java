package com.lgs.query;

/**
 * @ClassName: FoodQuery
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/7 20:47
 **/
public class FoodQuery extends BaseQuery{
    private String foodName;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "FoodQuery{" +
                "foodName='" + foodName + '\'' +
                '}';
    }
}
