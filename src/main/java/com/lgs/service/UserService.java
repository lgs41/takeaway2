package com.lgs.service;

import com.github.pagehelper.StringUtil;
import com.lgs.mapper.UserMapper;
import com.lgs.pojo.Result;
import com.lgs.pojo.Role;
import com.lgs.pojo.User;
import com.lgs.query.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: UserService
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/6 21:40
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    //登录
    public Result login(String userName, String userPwd, String varifyCode, HttpSession session) {
        //非空校验
        if(StringUtil.isEmpty(userName)){
            return new Result(100,"用户名不能为空");
        }
        if(StringUtil.isEmpty(userPwd)){
            return new Result(100,"密码不能为空");
        }
        if(StringUtil.isEmpty(varifyCode)){
            return new Result(100,"验证码不能为空");
        }
        //判断验证码是否正确
        String realVarifyCode =(String) session.getAttribute("varifyCode");
        if(!varifyCode.equalsIgnoreCase(realVarifyCode)){
            return new Result(100,"验证码不正确");
        }
        //登录；通过用户名和密码进行登录，通过用户名密码查询
        User user = userMapper.login(userName,userPwd);
        if(user==null){
            return new Result(100,"用户名或密码错误");
        }
        return new Result(200,"登录成功",user);
    }

    //注册
    public Result register(String gender,String userName, String userPwd1,String userPwd2,
                           String userPhone,String userAdd, String varifyCode, HttpSession session) {
        //非空校验
        if (StringUtil.isEmpty(gender)) {
            return new Result(100, "性别不能为空");
        }
        if (StringUtil.isEmpty(userName)) {
            return new Result(100, "用户名不能为空");
        }
        if (StringUtil.isEmpty(userPwd1)) {
            return new Result(100, "密码不能为空");
        }
        if (StringUtil.isEmpty(userPwd2)) {
            return new Result(100, "确认密码不能为空");
        }
        if (StringUtil.isEmpty(userPhone)) {
            return new Result(100, "手机号不能为空");
        }
        if (StringUtil.isEmpty(userAdd)) {
            return new Result(100, "地址不能为空");
        }
        if (!userPwd1.equals(userPwd2)) {
            return new Result(100, "两次密码输入不一致");
        }

        if (userPhone.length()!=11) {
            return new Result(100, "手机号格式不正确");
        }

        if (StringUtil.isEmpty(varifyCode)) {
            return new Result(100, "验证码不能为空");
        }
        Integer genderNew = 0;
        if (gender.equals("男")) {
            genderNew=1;
        } else {
            genderNew=2;
        }
        //判断验证码是否正确
        String realVarifyCode = (String) session.getAttribute("varifyCode");
//        System.out.println(gender+"****"+userName+"****"+userPwd1+"****"+userPwd2+"****"+varifyCode);
        if (!varifyCode.equalsIgnoreCase(realVarifyCode)) {
            return new Result(100, "验证码不正确");
        }
        //密码；通过用户名和密码进行登录，通过用户名密码查询
        User user = userMapper.getByName(userName);
        if (user != null) {
            return new Result(100, "该用户名已经存在");
        }
        int rows = userMapper.insert1(genderNew, userName, userPwd1,userPhone,userAdd);
        if (rows!= 1) {
            return new Result(100, "添加失败");
        }
        return new Result(200, "添加成功");
    }


    //添加用户
    public Result addUser(String gender,String userName,String userPwd,String userPhone,String userAdd,Integer roleId) {
        //非空校验
        if (StringUtil.isEmpty(gender)) {
            return new Result(100, "性别不能为空");
        }
        if (StringUtil.isEmpty(userName)) {
            return new Result(100, "用户名不能为空");
        }
        if (StringUtil.isEmpty(userPwd)) {
            return new Result(100, "密码不能为空");
        }
        if (StringUtil.isEmpty(userPhone)) {
            return new Result(100, "手机号不能为空");
        }
        if (StringUtil.isEmpty(userAdd)) {
            return new Result(100, "地址不能为空");
        }
        if (userPhone.length()!=11) {
            return new Result(100, "手机号格式不正确");
        }
        if(roleId==0){
            return new Result(100,"未选择角色");
        }

        if(gender.equals("男")){
            gender="1";
        }else {
            gender="2";
        }
        System.out.println(gender+"****"+userName+"****"+userPwd+"****"+userPhone+"****"+userAdd+"****"+roleId);
        User user = userMapper.getByName(userName);
        if(user!=null){
            return new Result(100,"用户名已存在");
        }
        int rows = userMapper.insert(gender,userName,userPwd,userPhone,userAdd,roleId);
        if(rows!=1){
            return new Result(100,"添加失败");
        }
        return new Result(200,"添加成功");
    }

    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    //修改用户
    public Result editUser(User user) {
        //非空校验
        if (StringUtil.isEmpty(user.getUserName())) {
            return new Result(100, "用户名不能为空");
        }
        if (StringUtil.isEmpty(user.getUserPwd())) {
            return new Result(100, "密码不能为空");
        }
        if (user.getUserPhone().length()!=11) {
            return new Result(100, "手机号格式不正确");
        }
        if (StringUtil.isEmpty(user.getUserAdd())) {
            return new Result(100, "地址不能为空");
        }
        int rows = userMapper.update(user);
        if(rows!=1){
            return new Result(100,"添加失败");
        }
        return new Result(200,"添加成功");
    }

    //删除用户
    public Result deleteUser(Integer id) {
        int row = userMapper.deleteUser(id);
        if(row!=1){
            return new Result(100,"异常情况");
        }
        return new Result(200,"删除成功");
    }

    //批量删除
    public Result delBatch(Integer[] id) {
        if(id==null || id.length==0){
            return new Result(100,"至少选择一条记录");
        }
        int row = userMapper.delBatch(id);
        if(row!=id.length){
            return new Result(100,"异常情况");
        }
        return new Result(200,"删除成功");
    }

    //展示用户及模糊查询
    public List<User> getUserList(UserQuery userQuery) {
        return userMapper.getUserList(userQuery);
    }

    //显示角色名
    public List<Role> getRoleList() {
        return userMapper.getRoleList();
    }
}
