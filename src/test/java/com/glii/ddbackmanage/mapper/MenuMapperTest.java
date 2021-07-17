package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}