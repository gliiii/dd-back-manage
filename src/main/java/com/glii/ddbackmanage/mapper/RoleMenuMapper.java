package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMenuMapper {

    /**
     * 新增角色菜单
     * @param roleMenus
     * @return
     */
    Integer batchInsertRoleMenu(List<RoleMenu> roleMenus);

    /**
     * 批量删除角色菜单
     * @param roleIds
     * @return
     */
    Integer deleteRoleMenuByRoleIds(List<Long> roleIds);
}
