package org.escort.samples.tcc.business;

import org.escort.samples.tcc.business.bo.BuildOrderBO;
import org.escort.samples.tcc.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.math.BigDecimal;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 10:11
 */
@EnableFeignClients
@SpringBootApplication
public class BusinessApplication implements CommandLineRunner {

    @Autowired
    private BusinessService businessService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(BusinessApplication.class).run(args);
    }

    @Override
    public void run(String... args) {
        // businessService.execute(new BuildOrderBO(1, 2, 3, new BigDecimal(4)));
    }
}
