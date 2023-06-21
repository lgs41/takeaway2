package com.lgs.query;

/**
 * @ClassName: FoodClassQuery
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/8 22:07
 **/
public class FoodClassQuery extends BaseQuery {
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "FoodClassQuery{" +
                "className='" + className + '\'' +
                '}';
    }
}
