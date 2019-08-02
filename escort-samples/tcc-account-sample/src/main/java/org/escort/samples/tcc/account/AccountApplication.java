package org.escort.samples.tcc.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 10:11
 */
@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AccountApplication.class).run(args);
    }

    @Override
    public void run(String... args) {
    }
}
