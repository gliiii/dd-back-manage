package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.dto.MenuTree;
import com.glii.ddbackmanage.entity.Menu;
import com.glii.ddbackmanage.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MenuServiceImplTest extends DdBackManageApplicationTests {
    @Autowired
    MenuService menuService;

    @Test
    void findEleMenus() {
        Menu menu = new Menu();
        MenuTree<Menu> eleMenus = menuService.findEleMenus(menu);
        System.out.println(eleMenus);
    }
}