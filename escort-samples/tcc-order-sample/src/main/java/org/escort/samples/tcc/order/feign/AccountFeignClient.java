package org.escort.samples.tcc.order.feign;

import org.escort.sample.tcc.common.AccountBalanceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
@FeignClient(name = "account-service", url = "127.0.0.1:18084")
public interface AccountFeignClient {

    @PostMapping("/deduct")
    Boolean deduct(@RequestBody AccountBalanceDTO accountBalance);

}
