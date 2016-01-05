package org.smart4j.proxy;

/**
 * Created by marszhou on 15/12/21.
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
