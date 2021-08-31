package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.entity.Role;
import com.glii.ddbackmanage.form.RoleForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
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

    @Test
    void insertRole() {
        Role role = new Role();
        role.setRoleName("测试人员");
        role.setCreateTime(new Date());
        role.setRemark("测试任务");
        Integer result = roleMapper.insertRole(role);
        System.out.println(result);
    }

    @Test
    void findRoleById() {
        Role role = roleMapper.findRoleById(81L);
        System.out.println(role);
    }

    @Test
    void updateRole() {
        Role role = new Role();
        role.setRoleId(83L);
        role.setModifyTime(new Date());
        Integer result = roleMapper.updateRole(role);
        System.out.println(result);
    }

    @Test
    void deleteRoleByIds() {
        List<Long> list = new ArrayList();
        list.add(84L);
        Integer result = roleMapper.deleteRoleByIds(list);
        System.out.println(result);
    }

    @Test
    void findRoles() {
        List<Role> roles = roleMapper.findRoles();
        System.out.println(roles);
    }
}