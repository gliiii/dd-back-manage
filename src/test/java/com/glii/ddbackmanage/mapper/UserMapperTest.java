package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.entity.User;
import com.glii.ddbackmanage.form.UserForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Random;

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

    @Test
    void insertUser() {
        User user = new User();
        user.setUsername("ligen");
        user.setPassword("123456");
        user.setStatus("1");
        user.setCreateTime(new Date());
        Integer result = userMapper.insertUser(user);
        System.out.println(result);
        System.out.println(user);
    }

    @Test
    void findUserById() {
        User user = userMapper.findUserById(24L);
        System.out.println(user);
    }

    @Test
    void updateUser() {
        User user = new User();
        Date date = new Date();
        user.setUserId(24L);
        user.setLastLoginTime(date);
        user.setModifyTime(date);
        user.setDescription(String.valueOf(new Random().nextInt(10)+1));
        Integer result = userMapper.updateUser(user);
        System.out.println(result);
    }

    @Test
    void deleteUserById() {
        Integer result = userMapper.deleteUserById(2L);
        System.out.println(result);
    }

    @Test
    void deleteUserByIds() {
        Long[] ids = {5L, 6L};
        Integer result = userMapper.deleteUserByIds(ids);
        System.out.println(result);
    }
}