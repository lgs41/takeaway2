package com.lgs.query;

/**
 * @ClassName: UserQuery
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/7 8:49
 **/
public class UserQuery extends BaseQuery{

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserQuery{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
