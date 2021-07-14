package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.entity.User;
import com.glii.ddbackmanage.form.UserForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class UserMapperTest extends DdBackManageApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void findUserList() {
        UserForm user = new UserForm();
        user.setCreateTimeFrom("2021-07-07");
        user.setCreateTimeTo("2021-07-08");
        List<User> userList = userMapper.findUserList(user, 0, 2);
        System.out.println(userList);
    }

    @Test
    void findUsersCount() {
        Integer count = userMapper.findUsersCount();
        System.out.println(count);
    }

    @Test
    void updateUserStatusById() {
        Integer result = userMapper.updateUserStatusById(2, "1");
        System.out.println(result);
    }
}