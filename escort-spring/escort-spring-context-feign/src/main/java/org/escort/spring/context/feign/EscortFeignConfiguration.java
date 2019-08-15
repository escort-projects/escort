package org.escort.spring.context.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 19:54
 */
@Configuration
public class EscortFeignConfiguration {

    @Bean
    public EscortRequestInterceptor escortRequestInterceptor() {

        return new EscortRequestInterceptor();
    }

}
