package com.dianping.marszhou.service;

import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;

/**
 * Created by marszhou on 16/3/8.
 */
@Service
public class InvokeService {
    public void invoke() {
        System.out.println("InvokeService......");
    }

    public void invokeException() {
        throw new PessimisticLockingFailureException("");
    }
}
