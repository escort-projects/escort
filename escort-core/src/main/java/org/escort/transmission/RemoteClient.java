package org.escort.transmission;

import org.escort.event.IEvent;
import org.escort.event.ResultMessage;

import java.util.concurrent.Future;

/**
 * 客户端发送接口（RM、TM、TC）
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/1 19:19
 */
public interface RemoteClient {

    /**
     * 同步调用接口
     *
     * @param event 消息
     * @return 结果
     */
    ResultMessage syncSendEvent(IEvent event);

    /**
     * 异步调用接口
     *
     * @param event 消息
     * @return 结果
     */
    Future<ResultMessage> asyncSendEvent(IEvent event);

    /**
     * 无返回结果调用，失败抛除运行时异常（网络原因等）
     *
     * @param event 消息
     */
    void notifyvent(IEvent event);

}
