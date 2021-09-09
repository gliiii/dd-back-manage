package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DeptMapper {
    /**
     * 根据部门id查询部门信息列表
     * @param depIds
     * @return
     */
    List<Dept> findDeptsByDeptIdIn(List<Long> depIds);

    /**
     * 查询所有部门信息
     * @return
     */
    List<Dept> findDeptList();

    /**
     * 根据id查询部门信息
     * @param deptId
     * @return
     */
    Dept findDeptById(Long deptId);

    /**
     * 新增部门
     * @param dept
     * @return
     */
    Integer insertDept(Dept dept);

    /**
     * 修改部门
     * @param dept
     * @return
     */
    Integer updateDept(Dept dept);

    /**
     * 根据deptId删除部门信息
     * @param deptId
     * @return
     */
    Integer deleteDeptById(Long deptId);
}
