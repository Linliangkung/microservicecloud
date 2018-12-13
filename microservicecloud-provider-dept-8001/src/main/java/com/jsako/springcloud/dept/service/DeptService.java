package com.jsako.springcloud.dept.service;

import com.jsako.springcloud.entities.Dept;

import java.util.List;

/**
 * @Date 2018/12/13
 * @Author LLJ
 * @Description
 */
public interface DeptService {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
