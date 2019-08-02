package org.escort.samples.tcc.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 10:11
 */
@EnableFeignClients
@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(OrderApplication.class).run(args);
    }

    @Override
    public void run(String... args) {
    }
}
