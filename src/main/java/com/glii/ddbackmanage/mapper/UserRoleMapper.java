package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {


    /**
     * 批量新增用户角色
     * @param userRoles
     * @return
     */
    Integer batchInsertUserRole(List<UserRole> userRoles);

    /**
     * 批量删除用户角色
     * @param userIds
     * @return
     */
    Integer deleteUserRoleByRoleIds(Long[] userIds);
}
