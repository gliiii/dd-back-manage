package com.glii.ddbackmanage.service;

import com.glii.ddbackmanage.form.RoleForm;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.vo.RoleVO;

import java.util.List;

public interface RoleService {
    /**
     * 查询角色列表详情
     * @param roleForm
     * @param query
     * @return
     */
    List<RoleVO> findRoleDetailList(RoleForm roleForm, QueryRequst query);

    /**
     * 查询角色总数
     * @return
     */
    int findRsCount();

    /**
     * 新增角色
     * @param roleForm
     * @return
     */
    void addRole(RoleForm roleForm);

    /**
     * 根据角色id查询用户信息
     * @param roleId
     * @return
     */
    RoleVO findRoleById(Long roleId);

    /**
     * 更新角色
     * @param roleForm
     * @return
     */
    void updateRole(RoleForm roleForm);
}
