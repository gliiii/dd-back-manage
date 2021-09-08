package com.glii.ddbackmanage.controller.system;

import com.glii.ddbackmanage.dto.DeptTree;
import com.glii.ddbackmanage.entity.Dept;
import com.glii.ddbackmanage.service.DeptService;
import com.glii.ddbackmanage.utils.ResultVOUtil;
import com.glii.ddbackmanage.vo.DeptVO;
import com.glii.ddbackmanage.vo.ResultTreeVO;
import com.glii.ddbackmanage.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/select/tree")
    public ResultVO getDeptTree() {
        List<DeptTree<Dept>> deptTree = deptService.findDeptTree();
        return ResultVOUtil.success(deptTree);
    }

    @GetMapping("/tree")
    public ResultVO getDeptList() {
        List<DeptVO> deptList = deptService.findDeptList();
        return ResultVOUtil.success(deptList);
    }

    @PostMapping
    public ResultVO addDept(Dept dept) {
        deptService.addDept(dept);
        return ResultVOUtil.success();
    }

    @GetMapping("/selectParent")
    public ResultTreeVO selectParent() {
        List<DeptVO> deptList = deptService.findDeptList();
        ResultTreeVO resultTreeVO = new ResultTreeVO();
        resultTreeVO.setData(deptList);
        return resultTreeVO;
    }

}
