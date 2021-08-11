package com.glii.ddbackmanage.service;

import com.glii.ddbackmanage.entity.Role;
import com.glii.ddbackmanage.form.RoleForm;
import com.glii.ddbackmanage.pojo.QueryRequst;

import java.util.List;

public interface RoleService {
    /**
     * 查询角色列表详情
     * @param roleForm
     * @param query
     * @return
     */
    List<Role> findRoleDetailList(RoleForm roleForm, QueryRequst query);

    /**
     * 查询角色总数
     * @return
     */
    int findRsCount();
}
