package org.escort.client.registry;

import org.escort.client.Node;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/15 18:46
 */
public interface Registry {

    void register(RegisterInfo info);

    Node getCurrentNodeInfo();

}
