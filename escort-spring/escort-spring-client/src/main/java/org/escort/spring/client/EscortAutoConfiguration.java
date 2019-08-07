package org.escort.spring.client;

import org.escort.spring.client.annotation.EscortTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/7 12:10
 */
@Configuration
public class EscortAutoConfiguration {

    @Bean
    public EscortTransactionScanner transactionScanner() {
        return new EscortTransactionScanner();
    }
}
