package cn.geekhall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer_7002.java
 *
 * @author yiny
 */
@SpringBootApplication
@EnableEurekaServer         // 表示是一个Eureka服务端的启动类。
public class EurekaServer_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002.class, args);
    }
}
