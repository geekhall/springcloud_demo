package cn.geekhall.controller;

import cn.geekhall.bean.Dept;
import cn.geekhall.service.DeptClientService;
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

    @Autowired
    private DeptClientService service = null;
//    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return service.queryAll();
    }


}
