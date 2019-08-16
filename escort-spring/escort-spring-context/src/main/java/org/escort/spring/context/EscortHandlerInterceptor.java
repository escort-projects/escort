package org.escort.spring.context;

import com.alibaba.fastjson.JSONObject;
import org.escort.client.TransactionContext;
import org.escort.client.context.ContextManager;
import org.escort.client.context.TransactionManager;
import org.escort.core.EscortConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 19:58
 */
public class EscortHandlerInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(EscortHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.debug("HandlerInterceptor preHandle()");
       String message= request.getHeader(EscortConstants.TRANSACTION_CONTEXT_MARK);
        if (StringUtils.isEmpty(message)){
            return true;
        }
        TransactionContext transactionContext = JSONObject.parseObject(message,TransactionContext.class);
        LOGGER.debug("HandlerInterceptor decode transactionContext: {}",transactionContext);
        TransactionManager transactionManager = ContextManager.getInstance();
        transactionManager.attachTransaction(transactionContext);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.debug("HandlerInterceptor postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.debug("HandlerInterceptor afterCompletion()");
    }
}
