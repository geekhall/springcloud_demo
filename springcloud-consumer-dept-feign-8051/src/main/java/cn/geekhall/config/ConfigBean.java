package cn.geekhall.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ConfigBean.java
 *
 * @author yiny
 */
@Configuration
public class ConfigBean {

    // IRule ： 配置负载均衡实现RestTemplate
    // AvailabilityFilteringRule ： 会先过滤掉跳闸，访问故障的服务，对剩下的进行轮询～。
    // RoundRobinRule ： 轮询
    // RandomRule     ： 随机
    // RetryRule      ： 会先按照轮训获取服务～如果服务获取失败，则会在指定的时间内进行重试。

    @Bean
    @LoadBalanced       // 配置负载均衡实现RestTemplate
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
