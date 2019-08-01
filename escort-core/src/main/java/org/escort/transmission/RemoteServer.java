package org.escort.transmission;

import org.escort.event.IEvent;
import org.escort.event.ResultMessage;

/**
 * 服务端接收接口（RM、TM、TC）
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/1 19:20
 */
public interface RemoteServer {

    /**
     * 等待数据返回
     *
     * @param event 消息
     * @return 结果
     */
    ResultMessage receiveEventSyncReply(IEvent event);

    /**
     * 异步数据返回，当前请求不需要返回结果
     *
     * @param event 消息
     */
    void receiveEventNoReply(IEvent event);
}
