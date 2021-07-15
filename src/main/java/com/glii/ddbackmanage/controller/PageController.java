package com.glii.ddbackmanage.controller;

import com.glii.ddbackmanage.service.DeptService;
import com.glii.ddbackmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String welcome() {
        return "pages/other/welcome" ;
    }

    @GetMapping("/table_user")
    public ModelAndView table_user() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user/table-user");
        mv.addObject("depts", deptService.findDeptList());
        return mv;
    }

    @GetMapping("/user_add")
    public ModelAndView user_add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user/user-add");
        mv.addObject("depts", deptService.findDeptList());
        return mv;
    }

    @GetMapping("/user/{id}")
    public ModelAndView user_edit(@PathVariable("id") Long userId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user/user-edit");
        mv.addObject("depts", deptService.findDeptList());
        mv.addObject("user", userService.findUserById(userId));
        return mv;
    }


}
