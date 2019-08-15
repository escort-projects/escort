package org.escort.spring.context.feign;

import com.alibaba.fastjson.JSONObject;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.escort.client.TransactionContext;
import org.escort.client.context.ContextManager;
import org.escort.core.EscortConstants;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 19:33
 */
public class EscortRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ContextManager contextManager = ContextManager.getInstance();
        TransactionContext transactionContext = contextManager.buildSpanTransactionContext();
        String message = JSONObject.toJSONString(transactionContext);
        requestTemplate.header(EscortConstants.TRANSACTION_CONTEXT_MARK, message);
        System.out.println("requestTemplate.headers(): " + requestTemplate.headers().entrySet());
    }
}
