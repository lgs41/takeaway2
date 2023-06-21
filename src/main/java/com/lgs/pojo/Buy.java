package com.lgs.pojo;

/**
 * @ClassName: Buy
 * @Auther: lgs
 * @Description: 购物车
 * @DateTime: 2023/6/9 10:08
 **/
public class Buy extends Food{
    private Integer buyId;
    private String addData;

    public String getAddData() {
        return addData;
    }

    public void setAddData(String addData) {
        this.addData = addData;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "buyId=" + buyId +
                ", addData='" + addData + '\'' +
                '}';
    }
}
