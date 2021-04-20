package com.consumer.springcloud.controller;

import com.viper.pojo.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Viper
 * @description
 * @date 2021/4/20
 */
@Slf4j
@RestController
public class DeptController {

    // 使用RestFul风格请求provider服务---RestTemplate模板

    private static final String REST_URL_PREFIX = "http://localhost:8001";


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    /*
     * 提供多种访问远程HTTP服务的方法，简单的restful风格的服务模板，
     * 方法的参数：url,实体：map,Class<T> responseType
     */
    @RequestMapping("/consumer/dept/{id}")
    public Dept get(@PathVariable("id") int id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }


    @RequestMapping("/consumer/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        log.info("services:", services);
        List<ServiceInstance> instances = discoveryClient.getInstances("CONSUMER-DEPT-80");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                            instance.getUri() + "\t" +
                            instance.getPort() + "\t" +
                            instance.getServiceId() + "\t" +
                            instance.getInstanceId() + "\t" +
                            instance.getScheme() + "\t" +
                            instance.getMetadata()
            );
        }
        return discoveryClient;
    }
}