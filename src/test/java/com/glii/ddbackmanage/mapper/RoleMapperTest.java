package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.entity.Role;
import com.glii.ddbackmanage.form.RoleForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class RoleMapperTest extends DdBackManageApplicationTests {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void findRoleList() {
        RoleForm role= new RoleForm();
        List<Role> roleList = roleMapper.findRoleList(role, 0, 10);
        System.out.println(roleList);
    }
}