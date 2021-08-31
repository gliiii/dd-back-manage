package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.entity.UserRole;
import com.glii.ddbackmanage.mapper.UserRoleMapper;
import com.glii.ddbackmanage.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Integer batchInsertUserRole(List<UserRole> userRoles) {
        return userRoleMapper.batchInsertUserRole(userRoles);
    }

    @Override
    public Integer deleteUserRoleByRoleIds(Long[] roleIds) {
        return userRoleMapper.deleteUserRoleByRoleIds(roleIds);
    }
}
