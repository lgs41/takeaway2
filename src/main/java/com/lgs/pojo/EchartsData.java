package com.lgs.pojo;

/**
 * @ClassName: EchartsData
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/8 9:13
 **/
public class EchartsData {
    private Integer value;
    private String name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EchartsData{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
