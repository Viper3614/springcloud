package com.provider.controller;

import com.provider.service.DeptService;
import com.viper.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Viper
 * @description
 * @date 2021/4/18
 */

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/dept")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/{id}")
    public Dept findOne(@PathVariable("id") int id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> findAll() {
        return deptService.queryAll();
    }

    @RequestMapping("/dept/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println("services:" + services);
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                            instance.getUri() + "\t" +
                            instance.getPort() + "\t" +
                            instance.getScheme() + "\t" +
                            instance.getServiceId() + "\t" +
                            instance.getMetadata()
            );
        }
        return discoveryClient;
    }
}