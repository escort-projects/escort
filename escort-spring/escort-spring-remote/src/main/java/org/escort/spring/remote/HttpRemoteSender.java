package org.escort.spring.remote;

import org.escort.config.ConfigurationDefine;
import org.escort.config.ConfigurationFactory;
import org.escort.protocol.BaseEvent;
import org.escort.remote.RemoteSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * provide for framework client
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/13 18:46
 */
public class HttpRemoteSender implements RemoteSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRemoteSender.class);

    private static final String REMOTE_TC_URL = "tc.url";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public <T extends BaseEvent> T send(BaseEvent event) {
//        ParameterizedTypeReference<T> typeRef = new ParameterizedTypeReference<T>() {
//        };
//        ResponseEntity<T> responseEntity = restTemplate.exchange(getTcUrl(), HttpMethod.POST, new HttpEntity<>(event), typeRef);
//        return responseEntity.getBody();
        LOGGER.warn("send message :{}", event);
        return null;
    }

    @Override
    public void asyncSend(BaseEvent event) {
        LOGGER.warn("send message :{}", event);
    }

    private String getTcUrl() {
        return ConfigurationFactory.getConfiguration().getProperty(ConfigurationDefine.getEscortPath(REMOTE_TC_URL));
    }

}
