package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.entity.Role;
import com.glii.ddbackmanage.form.RoleForm;
import com.glii.ddbackmanage.mapper.RoleMapper;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.service.RoleService;
import com.glii.ddbackmanage.utils.PageCalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoleDetailList(RoleForm role, QueryRequst query) {
        int pageIndex = query.getPage();
        int pageSize = query.getLimit();
        List<Role> roleList = roleMapper.findRoleList(role, PageCalculatorUtil.calculateRowIndex(pageIndex, pageSize), pageSize);
        return roleList;
    }

    @Override
    public int findRsCount() {
        return roleMapper.findRoleCount();
    }
}
