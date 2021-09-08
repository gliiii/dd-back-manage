package com.glii.ddbackmanage.service;

import com.glii.ddbackmanage.dto.DeptTree;
import com.glii.ddbackmanage.entity.Dept;
import com.glii.ddbackmanage.vo.DeptVO;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门信息
     * @return
     */
    List<DeptVO> findDeptList();

    /**
     * 按树型结构查询部门信息
     * @return
     */
    List<DeptTree<Dept>> findDeptTree();

    /**
     * 根据deptid查询部门
     * @param deptId
     * @return
     */
    Dept findDeptById(Long deptId);

    /**
     *新增部门
     * @param dept
     * @return
     */
    Integer addDept(Dept dept);

    /**
     * 更新部门
     * @param dept
     * @return
     */
    Integer updateDept(Dept dept);
}
