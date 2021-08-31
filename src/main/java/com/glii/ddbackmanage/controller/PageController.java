package com.glii.ddbackmanage.controller;

import com.glii.ddbackmanage.service.DeptService;
import com.glii.ddbackmanage.service.MenuService;
import com.glii.ddbackmanage.service.RoleService;
import com.glii.ddbackmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

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

    @GetMapping("/menu")
    public String menu() {
        return "pages/menu/table-menu";
    }

    @GetMapping("/menu_add")
    public String menu_add() {
        return "pages/menu/menu-add";
    }

    @GetMapping("/menu_edit")
    public String menu_edit(Model model, Long menuId){
        model.addAttribute("menu", menuService.findMenuById(menuId));
        return "pages/menu/menu-edit";
    }

    @GetMapping("/role")
    public String role() {
        return "pages/role/table-role";
    }

    @GetMapping("/role_add")
    public String role_add() {
        return "pages/role/role-add";
    }

    @GetMapping("/role/{id}")
    public ModelAndView role_edit(@PathVariable("id") Long roleId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/role/role-edit");
        mv.addObject("role", roleService.findRoleById(roleId));

        System.out.println(roleService.findRoleById(roleId));

        return mv;
    }
}
