package cn.geekhall.controller;

import cn.geekhall.bean.Dept;
import cn.geekhall.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DeptController.java
 *
 * @author yiny
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }


    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }


    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }


    // 注册进来的微服务，获得一些消息

    public Object discovery(){
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery => services: " + services );

        // 得到一个具体的服务信息
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getInstanceId());
            System.out.println(instance.getUri());
        }
        return this.client;
    }

}
