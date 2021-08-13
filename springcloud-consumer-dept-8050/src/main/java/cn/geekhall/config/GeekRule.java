package cn.geekhall.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GeekRule.java
 *
 * @author yiny
 */
@Configuration
public class GeekRule {

    @Bean
    public IRule myRule(){
        return new GeekRandomRule();
    }
}
