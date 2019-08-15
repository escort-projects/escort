package org.escort.client.registry;

import org.escort.client.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/15 18:54
 */
public class RegistryService implements Registry {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistryService.class);

    private Node current;

    @Override
    public void register(RegisterInfo info) {
        LOGGER.info("escort register info: {}", info);
        try {
            Class clazz = Class.forName("org.escort.samples.tcc.define.RegistryInfo");
            Method method = clazz.getMethod("getNode", Node.class);
            current = (Node) method.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Node getCurrentNodeInfo() {
        return current;
    }
}
