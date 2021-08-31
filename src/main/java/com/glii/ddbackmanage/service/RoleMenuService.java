package com.glii.ddbackmanage.service;

import com.glii.ddbackmanage.entity.RoleMenu;

import java.util.List;

public interface RoleMenuService {
    /**
     * 新增角色菜单
     * @param roleMenus
     * @return
     */
    Integer batchAddRoleMenu(List<RoleMenu> roleMenus);

    /**
     * 批量删除角色菜单
     * @param roleIds
     * @return
     */
    Integer deleteRoleMenuByRoleIds(List<Long> roleIds);
}
