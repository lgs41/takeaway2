package com.lgs.query;

/**
 * @ClassName: BaseQuery
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/7 8:13
 **/
public class BaseQuery {
    private Integer pageNum=1;//当前页
    private Integer pageSize=5;//每页显示的记录数

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BaseQuery{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
