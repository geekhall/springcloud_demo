package cn.geekhall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * DeptConsumer_8051.java
 *
 * @author yiny
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({"cn.geekhall"})
//@ComponentScan("cn.geekhall")     // @SpringBootApplication 中已经包含该注解
public class DeptConsumer_8051 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_8051.class, args);
    }
}
