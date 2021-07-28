package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.entity.Menu;
import com.glii.ddbackmanage.mapper.MenuMapper;
import com.glii.ddbackmanage.service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findMenuList(@Param("menu") Menu menu) {
        return menuMapper.findMenuList(menu);
    }

    @Override
    public Integer addMenu(Menu menu) {
        return menuMapper.insertMenu(menu);
    }

    @Override
    public Menu findMenuById(Long menuId) {
        return menuMapper.findMenuById(menuId);
    }

    @Override
    public Integer updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public Integer deleteMenu(Long menuId) {
        return menuMapper.deleteMenuById(menuId);
    }
}
