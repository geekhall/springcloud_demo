package cn.geekhall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ZuulApplication_9527.java
 *
 * @author yiny
 */
@SpringBootApplication
@EnableZuulProxy        // 开启Zuul
public class ZuulApplication_9527 {
    /**
     * 配置完路由之后即可通过：
     *      http://zuul9527.com:9527/springcloud-provider-dept/dept/get/2
     *      来访问
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class, args);
    }
}
