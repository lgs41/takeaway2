package com.lgs.pojo;

/**
 * @ClassName: Menu
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/5 17:39
 **/
public class Menu {
    private Integer id;
    private String name;
    private String url;
    private String target;
    private Integer pId;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", target='" + target + '\'' +
                ", pId=" + pId +
                ", icon='" + icon + '\'' +
                '}';
    }
}
