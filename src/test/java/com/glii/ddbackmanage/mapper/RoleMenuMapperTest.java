package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.entity.RoleMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleMenuMapperTest extends DdBackManageApplicationTests {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Test
    void batchInsertRoleMenu() {
        List<RoleMenu> roleMenus = new ArrayList();
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(81L);
        roleMenu.setMenuId(3L);
        roleMenus.add(roleMenu);
        RoleMenu roleMenu2 = new RoleMenu();
        roleMenu2.setRoleId(81L);
        roleMenu2.setMenuId(4L);
        roleMenus.add(roleMenu2);
        System.out.println(roleMenus);
        roleMenuMapper.batchInsertRoleMenu(roleMenus);
    }

    @Test
    void deleteRoleMenuByRoleIds() {
        List<Long> list = new ArrayList();
        list.add(83L);
        Integer result = roleMenuMapper.deleteRoleMenuByRoleIds(list);
        System.out.println(result);
    }
}