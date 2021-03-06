package com.glii.ddbackmanage.service;

import com.glii.ddbackmanage.dto.MenuTree;
import com.glii.ddbackmanage.entity.Menu;

import java.util.List;

public interface MenuService {

    /**
     *查询所有菜单
     * @param menu
     * @return
     */
    List<Menu> findMenuList(Menu menu);

    /**
     * 查找所有的菜单/按钮 （树形结构）
     * @param menu
     * @return
     */
    MenuTree<Menu> findEleMenus(Menu menu);

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    Integer addMenu(Menu menu);

    /**
     * 根据菜单id查询菜单
     * @param menuId
     * @return
     */
    Menu findMenuById(Long menuId);

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    Integer updateMenu(Menu menu);

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    Integer deleteMenu(Long menuId);
}
