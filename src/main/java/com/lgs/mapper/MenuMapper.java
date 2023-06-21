package com.lgs.mapper;

import com.lgs.pojo.Menu;

import java.util.List;

/**
 * @ClassName: MenuMapper
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/6 20:35
 **/
public interface MenuMapper {

    List<Menu> getMenuList(Integer userId);

}
