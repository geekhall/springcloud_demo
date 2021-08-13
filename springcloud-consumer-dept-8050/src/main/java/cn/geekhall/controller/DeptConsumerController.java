package cn.geekhall.controller;

import cn.geekhall.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * DeptConsummerController.java
 * http://localhost:8050/consumer/dept/get/2
 * http://localhost:8050/consumer/dept/list
 *
 * @author yiny
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX="http://127.0.0.1:8031";
    // Ribbon version
    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+ "/dept/get/" + id, Dept.class );
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.getForObject(REST_URL_PREFIX+ "/dept/add/", Boolean.class );
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+ "/dept/list/", List.class );
    }


}
