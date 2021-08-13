package cn.geekhall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * DeptProvider_8032.java
 *
 * @author yiny
 */
@SpringBootApplication
@EnableEurekaClient     // 在服务启动后自动注册到Eureka中！
@EnableDiscoveryClient  // 服务发现
public class DeptProvider_8032 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8032.class, args);
    }
}
