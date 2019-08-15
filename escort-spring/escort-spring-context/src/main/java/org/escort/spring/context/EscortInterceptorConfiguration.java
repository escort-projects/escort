package org.escort.spring.context;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 20:00
 */
public class EscortInterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new EscortHandlerInterceptor())
                .addPathPatterns("/**");
    }
}
