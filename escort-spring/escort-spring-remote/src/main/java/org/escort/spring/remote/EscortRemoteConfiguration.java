package org.escort.spring.remote;

import org.escort.client.handler.ClientHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 18:24
 */
@Configuration
public class EscortRemoteConfiguration {

    @Bean
    public HttpRemoteReceiver httpRemoteReceiver() {
        HttpRemoteReceiver receiver = new HttpRemoteReceiver();
        receiver.addHandler(new ClientHandler());
        return receiver;
    }

}
