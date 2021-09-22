package com.glii.ddbackmanage.controller;

import com.glii.ddbackmanage.service.DeptService;
import com.glii.ddbackmanage.service.MenuService;
import com.glii.ddbackmanage.service.RoleService;
import com.glii.ddbackmanage.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
        return "pages/other/welcome";
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
    public String menu_edit(Model model, Long menuId) {
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
        return mv;
    }

    @GetMapping("/dept")
    public String dept() {
        return "pages/dept/table-dept";
    }

    @GetMapping("/dept_add")
    public String dept_add() {
        return "pages/dept/dept-add";
    }

    @GetMapping("/dept_edit")
    public String dept_edit(Model model, Long deptId) {
        model.addAttribute("dept", deptService.findDeptById(deptId));
        return "pages/dept/dept-edit";
    }

    @GetMapping("/loginview")
    public String login() {
        System.out.println("登陆页面");
        return "login";
    }

    @PostMapping("/user/login")
    public String login(String username, String password, String code, HttpSession session) {
        //比较验证码
        String codes = (String) session.getAttribute("code");
        try {
            if (codes.equalsIgnoreCase(code)){
                //获取主体对象
                Subject subject = SecurityUtils.getSubject();
                subject.login(new UsernamePasswordToken(username, password));
                return "redirect:/index";
            }else{
                throw new RuntimeException("验证码错误!");
            }
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误!");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误!");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "redirect:/user/loginview";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }


}
