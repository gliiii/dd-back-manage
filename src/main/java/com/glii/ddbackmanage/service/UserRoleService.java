package com.glii.ddbackmanage.service;

import com.glii.ddbackmanage.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    /**
     * 新增角色菜单
     * @param userRoles
     * @return
     */
    Integer batchInsertUserRole(List<UserRole> userRoles);

    /**
     * 批量删除角色菜单
     * @param userIds
     * @return
     */
    Integer deleteUserRoleByRoleIds(Long[] userIds);
}
