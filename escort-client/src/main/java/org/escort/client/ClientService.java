package org.escort.client;

import org.escort.client.context.ContextManager;
import org.escort.client.registry.RegisterInfo;
import org.escort.client.registry.Registry;
import org.escort.client.registry.RegistryService;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/15 19:32
 */
public class ClientService {

    private Registry registry;

    private void init() {
        registry = new RegistryService();
        // TODO GET FORM CONFIG
        registry.register(new RegisterInfo("demo", "localhost", 8080));
        ContextManager.getInstance().setCurrent(registry.getCurrentNodeInfo());
    }

}
