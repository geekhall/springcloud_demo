package cn.geekhall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer_7001.java
 *
 * @author yiny
 */
@SpringBootApplication
@EnableEurekaServer         // 表示是一个Eureka服务端的启动类。
public class EurekaServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001.class, args);
    }
}
