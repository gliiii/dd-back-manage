package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    /**
     * 根据不同menu条件查询菜单列表
     * @param menu
     * @return
     */
    List<Menu> findMenuList(Menu menu);

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    Integer insertMenu(Menu menu);

    /**
     * 根据id查找菜单
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
    Integer deleteMenuById(Long menuId);

}
