package com.jsako.springcloud.dept.controller;

import com.jsako.springcloud.dept.mappers.DeptMapper;
import com.jsako.springcloud.dept.service.DeptService;
import com.jsako.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date 2018/12/13
 * @Author LLJ
 * @Description
 */
@RestController
@RequestMapping("/api/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept getDeptById(@PathVariable Long id){
        return deptService.findById(id);
    }

    @GetMapping("/list")
    public List<Dept> listDept(){
        return deptService.findAll();
    }


}
