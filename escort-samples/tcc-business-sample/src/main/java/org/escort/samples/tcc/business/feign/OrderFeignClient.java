package org.escort.samples.tcc.business.feign;

import org.escort.sample.tcc.common.OrderDTO;
import org.escort.spring.context.feign.EscortFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 11:13
 */
@FeignClient(name = "order-service", url = "127.0.0.1:18083", configuration = {EscortFeignConfiguration.class})
public interface OrderFeignClient {

    @PostMapping("/order")
    Boolean order(@RequestBody OrderDTO order);
}
