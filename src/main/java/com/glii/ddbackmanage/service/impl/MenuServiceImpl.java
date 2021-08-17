package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.dto.MenuTree;
import com.glii.ddbackmanage.entity.Menu;
import com.glii.ddbackmanage.mapper.MenuMapper;
import com.glii.ddbackmanage.service.MenuService;
import com.glii.ddbackmanage.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findMenuList(Menu menu) {
        return menuMapper.findMenuList(menu);
    }

    @Override
    public MenuTree<Menu> findEleMenus(Menu menu) {
        List<Menu> menuList = menuMapper.findMenuList(menu);
        List<MenuTree<Menu>> trees = convertMenus(menuList);
        return TreeUtil.buildMenuTree(trees);
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

    private List<MenuTree<Menu>> convertMenus(List<Menu> menus) {
        List<MenuTree<Menu>> trees = new ArrayList<>();
        menus.forEach(menu -> {
            MenuTree<Menu> tree = new MenuTree<>();
            tree.setId(String.valueOf(menu.getMenuId()));
            tree.setParentId(String.valueOf(menu.getParentId()));
            tree.setTitle(menu.getMenuName());
            tree.setIcon(menu.getIcon());
            tree.setHref(menu.getUrl());
            tree.setData(menu);
            trees.add(tree);
        });
        return trees;
    }
}
