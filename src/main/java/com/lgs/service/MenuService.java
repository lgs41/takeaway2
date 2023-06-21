package com.lgs.service;

import com.lgs.mapper.MenuMapper;
import com.lgs.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MenuService
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/6 20:34
 **/
@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> getMenuList(Integer userId) {
        return menuMapper.getMenuList(userId);
    }
}
