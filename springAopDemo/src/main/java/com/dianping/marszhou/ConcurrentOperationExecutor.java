package com.dianping.marszhou;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;
import org.springframework.dao.PessimisticLockingFailureException;

import javax.annotation.Resource;

/**
 * Created by marszhou on 16/3/8.
 */
@Resource
public class ConcurrentOperationExecutor implements Ordered {
    private static final int DEFAULT_MAX_RETRIES = 3;

    private int maxRetries = DEFAULT_MAX_RETRIES;

    private int order = 1;

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        int numAttempts = 0;
        PessimisticLockingFailureException pessimisticLockingFailureException;
        do {
            numAttempts++;
            System.out.println("Try times: " + numAttempts);
            try {
                return pjp.proceed();
            } catch (PessimisticLockingFailureException ex) {
                pessimisticLockingFailureException = ex;
            }
        } while (numAttempts <= this.maxRetries);
        System.out.println("Try error : " + numAttempts);
        throw pessimisticLockingFailureException;
    }
}
