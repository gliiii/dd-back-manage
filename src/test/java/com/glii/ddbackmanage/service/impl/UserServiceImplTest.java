package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.form.UserForm;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.service.UserService;
import com.glii.ddbackmanage.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class UserServiceImplTest extends DdBackManageApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void testfindUserDetailList() {
        UserForm user = new UserForm();
        user.setUsername("GEN");
        QueryRequst queryRequst = new QueryRequst();
        queryRequst.setPage(1);
        queryRequst.setLimit(10);
        List<UserVO> result = userService.findUserDetailList(user,queryRequst);
        System.out.println(result);
    }

    @Test
    void updateUserStatus() {
        Integer result = userService.updateUserStatus(3, "0");
        System.out.println(result);
    }

    @Test
    void addUser() {
        UserForm user = new UserForm();
        user.setUsername("ligen");
        user.setDeptId(2L);
        user.setSsex("1");
        user.setStatus("1");
        user.setMobile("13177050000");
        user.setEmail("123@123.com");
        Integer result = userService.addUser(user);
        System.out.println(result);
    }

    @Test
    void findUserById() {
        UserVO user = userService.findUserById(24L);
        System.out.println(user);
    }

    @Test
    void updateUser() {
        UserForm userForm = new UserForm();
        userForm.setUserId(24L);
        userForm.setEmail("789@789.com");
        userService.updateUser(userForm);
    }

    @Test
    void deleteUserById() {
        Integer result = userService.deleteUserById(3L);
        System.out.println(result);
    }

    @Test
    void deleteUserByIds() {
        Integer result = userService.deleteUserByIds(new Long[]{1L, 2L});
        System.out.println(result);
    }
}