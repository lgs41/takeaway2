package com.lgs.query;

/**
 * @ClassName: OrderQuery
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/9 23:56
 **/
public class OrderQuery extends BaseQuery{
    private Integer pageSize=10;//每页显示的记录数
    private String foodName;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "OrderQuery{" +
                "pageSize=" + pageSize +
                ", foodName='" + foodName  +
                '}';
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
