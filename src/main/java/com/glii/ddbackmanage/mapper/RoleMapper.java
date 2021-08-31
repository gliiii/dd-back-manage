package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.entity.Role;
import com.glii.ddbackmanage.form.RoleForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * 查询用户列表
     * @return
     */
    List<Role> findRoleList(@Param("role") RoleForm role, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize );

    /**
     * 查询用户总数
     * @return
     */
    Integer findRoleCount();

    /**
     * 新增角色
     * @param role
     * @return
     */
    Integer insertRole(Role role);

    /**
     * 根据用户id查询角色信息
     * @param roleId
     * @return
     */
    Role findRoleById(@Param("roleId") Long roleId);

    /**
     * 更新角色
     * @param role
     * @return
     */
    Integer updateRole(@Param("role") Role role);

    /**
     * 根据用户id删除角色
     * @param roleId
     * @return
     */
    Integer deleteRoleById(Long roleId);

    /**
     * 批量删除角色
     * @param roleIds
     * @return
     */
    Integer deleteRoleByIds(List<Long> roleIds);
}
