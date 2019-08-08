package org.escort.spring.client.rm;

import org.escort.spring.client.context.SpringBeanManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 15:08
 */
@RestController
public class RmMessageController {

    @Autowired
    private SpringBeanManager beanManager;



}
