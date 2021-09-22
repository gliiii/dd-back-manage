package com.glii.ddbackmanage.controller.system;

import com.glii.ddbackmanage.form.UserForm;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.service.UserService;
import com.glii.ddbackmanage.utils.ResultVOUtil;
import com.glii.ddbackmanage.utils.VerifyCodeUtils;
import com.glii.ddbackmanage.vo.ResultVO;
import com.glii.ddbackmanage.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/sys/users")
    public ResultVO userList(UserForm user, QueryRequst query) {
        List<UserVO> userVOList = userService.findUserDetailList(user, query);
        int count = userService.findUsersCount();
        return ResultVOUtil.success(userVOList,count);
    }

    @PutMapping("/user/{id}")
    public ResultVO updateUserStatus(@PathVariable("id") Integer userId, Boolean status) {
        String statusStr = null;
        userService.updateUserStatus(userId, statusStr=status?"1":"0");
        return ResultVOUtil.success();
    }

    @PostMapping("/user")
    public ResultVO addUser(UserForm userForm) {
        //TODO 考虑处理失败情况
        userService.addUser(userForm);
        return ResultVOUtil.success();
    }

    @PutMapping("/user")
    public ResultVO updateUser(@RequestBody UserForm userForm) {
        //TODO 考虑失败情况处理
        userService.updateUser(userForm);
        return ResultVOUtil.success();
    }

    @DeleteMapping("/user/{id}")
    public ResultVO deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        return ResultVOUtil.success();
    }

    @DeleteMapping("/users/{ids}")
    public ResultVO deleteUsers(@PathVariable("ids") Long[] userIds) {
        userService.deleteUserByIds(userIds);
        return ResultVOUtil.success();
    }

    /**
     * 验证码方法
     */
    @RequestMapping("/user/getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //验证码放入session
        session.setAttribute("code",code);
        //验证码存入图片
        ServletOutputStream os = response.getOutputStream();
        response.setContentType("image/png");
        VerifyCodeUtils.outputImage(220,60,os,code);
    }
}
