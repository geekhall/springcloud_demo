package cn.geekhall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * DeptConsumerDashboard_9001.java
 *
 * @author yiny
 */
@SpringBootApplication
@EnableHystrixDashboard         // 开启Hystrix监控
public class DeptConsumerDashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard_9001.class, args);
    }
}
