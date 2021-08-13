package cn.geekhall.service;

import cn.geekhall.bean.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DeptClientServiceFallbackFactory.java
 *
 * @author yiny
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {


    // 将服务端关掉之后再访问http://localhost:8051/consumer/dept/get/1，就会提示如下内容：
    // {"deptno":1,"dname":"id => 1没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭","db_source":"no available data"}

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("id => " + id + "没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setDb_source("no available data");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
