package org.escort.client.handler;

import org.escort.protocol.BaseEvent;
import org.escort.remote.RemoteHandler;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 18:38
 */
public class ClientHandler  implements RemoteHandler {

    @Override
    public <T extends BaseEvent> T receiveEventSyncReply(BaseEvent event) {
        return null;
    }

    @Override
    public void receiveEventNoReply(BaseEvent event) {

    }
}
