package com.lgs.pojo;

/**
 * @ClassName: FoodClass
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/8 10:25
 **/
public class FoodClass {
    private Integer id;
    private String className;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "FoodClass{" +
                "id=" + id +
                ", className='" + className + '\'' +
                '}';
    }
}
