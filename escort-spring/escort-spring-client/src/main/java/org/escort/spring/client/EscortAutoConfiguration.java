package org.escort.spring.client;

import org.escort.client.pattern.tcc.BranchTccProcessor;
import org.escort.client.pattern.tcc.GlobalTccProcessor;
import org.escort.spring.client.annotation.EscortTransactionScanner;
import org.escort.spring.client.annotation.InterceptorFilter;
import org.escort.spring.client.annotation.interceptor.BranchTccActionInterceptor;
import org.escort.spring.client.annotation.interceptor.GlobalTccInterceptor;
import org.escort.spring.client.config.SpringConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/7 12:10
 */
@Configuration
public class EscortAutoConfiguration {

    @Bean
    public SpringConfiguration springConfiguration() {
        return new SpringConfiguration();
    }

    @Bean
    public InterceptorFilter interceptorFilter() {
        return new InterceptorFilter();
    }

    @Bean
    public BranchTccActionInterceptor branchTccActionInterceptor() {
        BranchTccProcessor branchTccProcessor = new BranchTccProcessor(null);
        return new BranchTccActionInterceptor(branchTccProcessor);
    }

    @Bean
    public GlobalTccInterceptor globalTccInterceptor() {
        GlobalTccProcessor globalTccProcessor = new GlobalTccProcessor(null);
        return new GlobalTccInterceptor(globalTccProcessor);
    }

    @Bean
    public EscortTransactionScanner transactionScanner() {
        return new EscortTransactionScanner();
    }

    @PostConstruct
    public void init() {
        interceptorFilter().addInterceptor(branchTccActionInterceptor());
        interceptorFilter().addInterceptor(globalTccInterceptor());
    }

}
