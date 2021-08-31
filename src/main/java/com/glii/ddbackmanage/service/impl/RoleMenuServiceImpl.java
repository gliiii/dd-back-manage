package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.entity.RoleMenu;
import com.glii.ddbackmanage.mapper.RoleMenuMapper;
import com.glii.ddbackmanage.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public Integer batchAddRoleMenu(List<RoleMenu> roleMenus) {
        return roleMenuMapper.batchInsertRoleMenu(roleMenus);
    }

    @Override
    public Integer deleteRoleMenuByRoleIds(List<Long> roleIds) {
        return roleMenuMapper.deleteRoleMenuByRoleIds(roleIds);
    }
}
