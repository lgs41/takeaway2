package com.lgs.controller;

import com.lgs.pojo.Menu;
import com.lgs.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: MenuController
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/6 20:32
 **/
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    //
    @RequestMapping("/getMenuList")
    @ResponseBody
    public List<Menu> getMenuList(Integer userId){
        return menuService.getMenuList(userId);
    }

}
