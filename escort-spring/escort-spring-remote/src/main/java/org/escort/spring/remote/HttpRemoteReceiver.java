package org.escort.spring.remote;

import org.escort.protocol.BaseEvent;
import org.escort.remote.RemoteHandler;
import org.escort.remote.RemoteReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * provide for framework client
 * 注入到 spring 容器中，调用 RemoteHandler 实现类
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/13 19:12
 */
public class HttpRemoteReceiver implements RemoteReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRemoteReceiver.class);

    private RemoteHandler remoteHandler;

    @RequestMapping(path = "/escort/client/handle", method = RequestMethod.POST)
    public <T extends BaseEvent> T handler(@RequestBody BaseEvent baseEvent) {
        // TODO baseEvent can't use
        return remoteHandler.receiveEventSyncReply(baseEvent);
    }

    @Override
    public void addHandler(RemoteHandler remoteHandler) {
        this.remoteHandler = remoteHandler;
    }
}
