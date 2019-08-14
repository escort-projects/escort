package org.escort.spring.client.annotation;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 18:28
 */
public class InterceptorFilter {

    private Set<BaseTransactionInterceptor> interceptors = new HashSet<>(16);

    public Set<BaseTransactionInterceptor> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(Set<BaseTransactionInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    public void addInterceptor(BaseTransactionInterceptor baseTransactionInterceptor) {
        this.interceptors.add(baseTransactionInterceptor);
    }
}