package com.jsako.springcloud.dept.controller;

import com.jsako.springcloud.entities.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Date 2018/12/13
 * @Author LLJ
 * @Description
 */
@RestController
@RequestMapping("/api/dpet/consumer")
public class DeptConsumerController {
    private final static String DEPT_SERVICE_PREFIX="http://MICROSERVICECLOUD-DEPT/";


    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/add")
    public boolean addDept(@RequestBody Dept dept){
        return restTemplate.postForObject(DEPT_SERVICE_PREFIX + "api/dept/add", dept, Boolean.class);
    }

    @GetMapping("/get/{id}")
    @HystrixCommand(groupKey = "MICROSERVICECLOUD-DEPT",commandKey = "getDept",fallbackMethod = "fallback1")
    public Dept get(@PathVariable Integer id){
        return restTemplate.getForObject(DEPT_SERVICE_PREFIX+"api/dept/get/"+id,Dept.class);
    }


    public Dept fallback1(Integer id,Throwable e){
        System.out.println(id);
        System.out.println(e.getMessage());
        Dept dept=new Dept(0l,"无法查询鸭" ,"error" );
        return dept;
    }

    @GetMapping("/list")
    public List<Dept> list(){
        return restTemplate.getForObject(DEPT_SERVICE_PREFIX+"api/dept/list",List.class);
    }

    @GetMapping("/discovery")
    public String discovery(){
        return restTemplate.getForObject(DEPT_SERVICE_PREFIX+"api/discovery/get", String.class);
    }


}
