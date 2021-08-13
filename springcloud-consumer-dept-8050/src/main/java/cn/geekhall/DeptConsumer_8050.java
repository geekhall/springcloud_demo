package cn.geekhall;

import cn.geekhall.config.GeekRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * DeptConsumer_8050.java
 *
 * @author yiny
 */
@SpringBootApplication
@EnableEurekaClient
// 在服务启动的时候就能自动加载我们自定义的Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = GeekRule.class)
public class DeptConsumer_8050 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_8050.class, args);
    }
}
