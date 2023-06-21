package com.lgs.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import com.lgs.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginIntercepter
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/6 17:14
 **/
public class LoginIntercepter implements HandlerInterceptor {
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();

        if(uri.indexOf("toLogin")!=-1 ||uri.indexOf("register")!=-1 || uri.indexOf("toIndex")!=-1
                || uri.indexOf("register.jsp")!=-1 || uri.indexOf("login")!=-1 ||uri.indexOf("login.jsp")!=-1
                ||uri.indexOf("getVarifyCode")!=-1 ){
            return true;
        }

        User userInfo = (User)request.getSession().getAttribute("userInfo");

        if(userInfo==null){
            //请求转发
            request.getRequestDispatcher("/user/toLogin").forward(request,response);
            return false;
        }

        return true;

    }
}
