package com.lgs.mapper;

import com.lgs.pojo.Role;
import com.lgs.pojo.User;
import com.lgs.query.UserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/6 21:41
 **/
public interface UserMapper {
    //登录
    User login(@Param("userName") String userName, @Param("userPwd")String userPwd);
    //判断该用户名是否已经注册
    User getByName(String userName);
    //注册插入用户数据
    int insert1(@Param("gender")Integer gender, @Param("userName")String userName,
                @Param("userPwd")String userPwd1,@Param("userPhone")String userPhone,@Param("userAdd")String userAdd);
    //展示数据
    List<User> getUserList(UserQuery userQuery);
    //添加数据
    int insert(@Param("gender") String gender,@Param("userName") String userName,
               @Param("userPwd") String userPwd,@Param("userPhone")String userPhone,@Param("userAdd") String userAdd,@Param("roleId") Integer roleId);
    //修改的时候回显数据
    User getById(Integer id);
    //修改用户
    int update(User user);
    //删除用户
    int deleteUser(Integer id);
    //批量删除
    int delBatch(Integer[] id);
    //获取角色名
    List<Role> getRoleList();
}
