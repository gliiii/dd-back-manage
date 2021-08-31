package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRoleMapperTest extends DdBackManageApplicationTests {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Test
    void deleteUserRoleByRoleIds() {
        Long[] roleIds ={8L};
        Integer result = userRoleMapper.deleteUserRoleByRoleIds(roleIds);
        System.out.println(result);
    }

    @Test
    void batchInsertUserRole() {
        List<UserRole> list = new ArrayList();
        UserRole userRole = new UserRole();
        userRole.setUserId(8L);
        userRole.setRoleId(78L);
        list.add(userRole);
        UserRole userRole2 = new UserRole();
        userRole2.setUserId(8L);
        userRole2.setRoleId(79L);
        list.add(userRole2);
        Integer result = userRoleMapper.batchInsertUserRole(list);
        System.out.println(result);
    }
}