package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

class MenuMapperTest extends DdBackManageApplicationTests {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    void findMenuList() {
        Menu menu = new Menu();
        menu.setParentId(0L);
        List<Menu> menuList = menuMapper.findMenuList(menu);
        System.out.println(menuList);
    }

    @Test
    void insertMenu() {
        Menu menu = new Menu();
        menu.setParentId(1L);
        menu.setMenuName("新增菜单");
        menu.setCreateTime(new Date());
        menu.setType("1");
        Integer result = menuMapper.insertMenu(menu);
        System.out.println(result);
    }

    @Test
    void findMenuById() {
        Menu menu = menuMapper.findMenuById(1L);
        System.out.println(menu);

    }

    @Test
    void updateMenu() {
        Menu menu = new Menu();
        menu.setMenuId(178L);
        menu.setModifyTime(new Date());
        Integer result = menuMapper.updateMenu(menu);
        System.out.println(result);
    }

    @Test
    void deleteMenuById() {
        Integer result = menuMapper.deleteMenuById(185L);
        System.out.println(result);
    }
}