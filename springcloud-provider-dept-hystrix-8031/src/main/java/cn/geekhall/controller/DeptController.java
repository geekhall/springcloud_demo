package cn.geekhall.controller;

import cn.geekhall.bean.Dept;
import cn.geekhall.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept == null){
            throw new RuntimeException("id=>" + id + ", 不存在该用户，或者信息无法找到～");
        }

        return dept;
    }


    // 异常备选方案
    // 当访问一个不存在的资源时，比如：http://localhost:8051/consumer/dept/get/6
    // 会返回：{"deptno":6,"dname":"id => 6, 没有对应的信息，null--@Hystrix～","db_source":"there is no database source configuration."}
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id => " + id + ", 没有对应的信息，null--@Hystrix～")
                .setDb_source("there is no database source configuration.");
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
