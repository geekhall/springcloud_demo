package cn.geekhall;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * DeptProvider_8031.java
 *
 * @author yiny
 */
@SpringBootApplication
@EnableEurekaClient     // 在服务启动后自动注册到Eureka中！
@EnableDiscoveryClient  // 服务发现
@EnableCircuitBreaker   // 添加对熔断的支持
public class DeptProviderHystrix_8031 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_8031.class, args);
    }

    // 增加一个Servlet
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
