package com.glii.ddbackmanage.controller.system;

import com.glii.ddbackmanage.entity.Menu;
import com.glii.ddbackmanage.service.MenuService;
import com.glii.ddbackmanage.utils.ResultVOUtil;
import com.glii.ddbackmanage.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/tree")
    public ResultVO getMenuTree(Menu menu) {
        List<Menu> menuList = menuService.findMenuList(menu);
        return ResultVOUtil.success(menuList);
    }

}
