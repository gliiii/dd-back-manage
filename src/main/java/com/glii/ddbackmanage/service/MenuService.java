package com.glii.ddbackmanage.service;

import com.glii.ddbackmanage.entity.Menu;

import java.util.List;

public interface MenuService {

    /**
     *查询所有菜单
     * @param menu
     * @return
     */
    List<Menu> findMenuList(Menu menu);
}
