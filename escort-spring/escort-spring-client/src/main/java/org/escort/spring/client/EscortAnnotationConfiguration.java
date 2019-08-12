package org.escort.spring.client;

import org.escort.client.context.DefaultMethodHandlerManager;
import org.escort.client.pattern.tcc.BranchTccProcessor;
import org.escort.client.pattern.tcc.GlobalTccProcessor;
import org.escort.spring.client.annotation.BaseTransactionInterceptor;
import org.escort.spring.client.annotation.EscortTransactionScanner;
import org.escort.spring.client.annotation.interceptor.BranchTccActionInterceptor;
import org.escort.spring.client.annotation.interceptor.GlobalTccInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/12 16:08
 */
@Configuration
public class EscortAnnotationConfiguration {

    private DefaultMethodHandlerManager defaultMethodHandlerManager = new DefaultMethodHandlerManager();

    public class InterceptorFilter {

        private Set<BaseTransactionInterceptor> interceptors = new HashSet<>(16);

        public Set<BaseTransactionInterceptor> getInterceptors() {
            return interceptors;
        }

        public void setInterceptors(Set<BaseTransactionInterceptor> interceptors) {
            this.interceptors = interceptors;
        }

        public void addInterceptor(BaseTransactionInterceptor baseTransactionInterceptor) {
            this.interceptors.add(baseTransactionInterceptor);
        }
    }

    @Bean
    public InterceptorFilter interceptorFilter() {
        return new InterceptorFilter();
    }

    @Bean
    public BranchTccActionInterceptor branchTccActionInterceptor() {
        BranchTccProcessor branchTccProcessor = new BranchTccProcessor(null, defaultMethodHandlerManager);
        return new BranchTccActionInterceptor(branchTccProcessor);
    }

    @Bean
    public GlobalTccInterceptor globalTccInterceptor() {
        GlobalTccProcessor globalTccProcessor = new GlobalTccProcessor(null, defaultMethodHandlerManager);
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
