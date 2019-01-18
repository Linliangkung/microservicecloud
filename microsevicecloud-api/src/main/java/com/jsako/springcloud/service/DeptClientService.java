package com.jsako.springcloud.service;

import com.jsako.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rx.Observable;

import java.util.List;

/**
 * @Date 2019/1/5
 * @Author LLJ
 * @Description
 */
@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory =DeptFallBackFactory.class,configuration =DeptConfiguration.class )
public interface DeptClientService {

    @RequestMapping(value = "/api/dept/get/{id}", method = RequestMethod.GET)
    Observable<Dept> get(@PathVariable("id") long id);

    @RequestMapping(value = "/api/dept/list", method = RequestMethod.GET)
    List<Dept> list();

    @RequestMapping(value = "/api/dept/add", method = RequestMethod.POST)
    boolean add(Dept dept);

    @RequestMapping(value="/api/discovery/get",method = RequestMethod.GET)
    Object discovery();

}
