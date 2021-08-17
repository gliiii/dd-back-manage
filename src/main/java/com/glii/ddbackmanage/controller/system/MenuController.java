package com.glii.ddbackmanage.controller.system;

import com.glii.ddbackmanage.dto.MenuTree;
import com.glii.ddbackmanage.entity.Menu;
import com.glii.ddbackmanage.service.MenuService;
import com.glii.ddbackmanage.utils.ResultVOUtil;
import com.glii.ddbackmanage.vo.ResultTreeVO;
import com.glii.ddbackmanage.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/eletree")
    public ResultVO getMenuEleTree(Menu menu) {
        MenuTree<Menu> eleMenus = menuService.findEleMenus(menu);
        List<MenuTree<Menu>> childs = eleMenus.getChilds();
        return ResultVOUtil.success(childs);
    }

    @GetMapping("selectParent")
    public ResultTreeVO selectParent(Menu menu){
        List<Menu> list = menuService.findMenuList(menu);
//        Menu baseMenu = new Menu();
//        baseMenu.setMenuName("顶级权限");
//        baseMenu.setMenuId(0L);
//        baseMenu.setParentId(-1L);
//        list.add(baseMenu);
        ResultTreeVO resultTreeVO = new ResultTreeVO();
        resultTreeVO.setData(list);
        return resultTreeVO;
    }

    @PostMapping
    public ResultVO addMenu(Menu menu) {
        menu.setCreateTime(new Date());
        menuService.addMenu(menu);
        return ResultVOUtil.success();
    }

    @PutMapping
    public ResultVO updateMenu(Menu menu) {
        menu.setModifyTime(new Date());
        menuService.updateMenu(menu);
        return ResultVOUtil.success();
    }

    @DeleteMapping("/{id}")
    public ResultVO deleteMenu(@PathVariable("id") Long menuId) {
        menuService.deleteMenu(menuId);
        return ResultVOUtil.success();
    }

}
