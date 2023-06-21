package com.lgs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.pojo.Result;
import com.lgs.pojo.Role;
import com.lgs.pojo.User;
import com.lgs.query.UserQuery;
import com.lgs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: UserController
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/6 21:40
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //退出登录
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    //顶部
    @RequestMapping("/toTop")
    public String toTop(){
        return "top";
    }
    //左侧
    @RequestMapping("/toLeft")
    public String toLeft(){
        return "left";
    }
    //主页面
    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }

    //登录
    @RequestMapping("/login")
    public String login(String userName, String userPwd, String varifyCode, HttpSession session, Model model){
        Result result = userService.login(userName,userPwd,varifyCode,session);
        if(result.getCode()==200){
            //登陆成功
            User userInfo = (User)result.getData();
            session.setAttribute("userInfo",userInfo);
            return "index";
        }else {
            //登录失败
            model.addAttribute("msg",result.getMsg());
            return "login";
        }
    }
    //清除session
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    //注册
    @RequestMapping("/register")
    public String register(String gender,String userName, String userPwd1,String userPwd2,
                           String userPhone,String userAdd,String varifyCode, HttpSession session,Model model){
        Result result = userService.register(gender,userName,userPwd1,userPwd2,userPhone,userAdd,varifyCode,session);
        if(result.getCode()==200){
            return "login";
        }else {
            //登录失败
            model.addAttribute("msg",result.getMsg());
            return "register";
        }
    }

    //注册时候退出
    //清除session
    @RequestMapping("/out")
    public String out(HttpSession session){
        session.invalidate();
        return "login";
    }
    //用户添加
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "toAdd";
    }

    @RequestMapping("/addUser")
    public String addUser(String gender,String userName,String userPwd,String userPhone,String userAdd,Integer roleId,Model model){
//        System.out.println(gender+"****"+userName+"****"+userPwd+"****"+userPhone+"****"+userAdd+"****"+roleId);

        Result result = userService.addUser(gender,userName,userPwd,userPhone,userAdd,roleId);

        if(result.getCode()==200){
            //添加成功
            UserQuery userQuery =new UserQuery();
            return toUserInfo(userQuery,model);
        }else {
            model.addAttribute("msg",result.getMsg());
            return "toAdd";
        }
    }
    //用户列表展示及模糊查询
    @RequestMapping("/toUserInfo")
    public String toUserInfo(UserQuery userQuery, Model model){

        //启动分页插件
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());

        List<User> userList = userService.getUserList(userQuery);

        //首页 上一页 下一页 尾页，至少需要 当前页，总页数，总记录数，需要一个类进行封装，但是分页插件提供了这个类PageInfo
        PageInfo<User> pageInfo = new PageInfo<User>(userList);

        model.addAttribute("userName",userQuery.getUserName());

        model.addAttribute("pageInfo",pageInfo);

        return "userInfo";
    }


    //用户修改
    @RequestMapping("/toEdit")
    public String toEdit(Integer id,Model model){
        User user = userService.getById(id);
        model.addAttribute("user",user);
//        model.addAttribute("roleId",user.getRoleId());
        return "toEdit";
    }

    //修改用户
    @RequestMapping("/editUser")
    public String editUser(User user,Model model){

        Result result = userService.editUser(user);

        if(result.getCode()==200){
            UserQuery userQuery =new UserQuery();
            return toUserInfo(userQuery,model);
        }else {
            model.addAttribute("msg",result.getMsg());
            return "toEdit";
        }
    }
    //用户删除
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id,Model model){

        Result result = userService.deleteUser(id);

        if(result.getCode()==200){
            UserQuery userQuery =new UserQuery();
            return toUserInfo(userQuery,model);
        }

        return null;
    }
    //用户批量删除
    @RequestMapping("/delBatch")
    public String delBatch(Integer[] id,Model model){
        Result result = userService.delBatch(id);

        if(result.getCode()==200){
            UserQuery userQuery =new UserQuery();
            return toUserInfo(userQuery,model);
        }

        return null;
    }
    //获取角色名
    @RequestMapping("/getRoleList")
    @ResponseBody
    public List<Role> getRoleList(){
        return userService.getRoleList();
    }

}
