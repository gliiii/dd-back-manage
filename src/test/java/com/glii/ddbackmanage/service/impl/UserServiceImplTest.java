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
}