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
}
