package com.jikexueyuan.rpc.container;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jikexueyuan.rpc.invoke.ProviderConfig;

/**
 * Created by version_z on 2015/8/22.
 */
public class HttpContainer extends Container {
    private static final Logger logger = LoggerFactory.getLogger(HttpContainer.class);

    private AbstractHandler httpHandler;
    private ProviderConfig providerConfig;

    public HttpContainer(AbstractHandler httpHandler) {
        this(httpHandler, new ProviderConfig("/invoke", 8080));
    }

    public HttpContainer(AbstractHandler httpHandler, ProviderConfig providerConfig) {
        this.httpHandler = httpHandler;
        this.providerConfig = providerConfig;
        Container.container = this;
    }

    public void start() {
        Server server = new Server();
        try {
            SelectChannelConnector connector = new SelectChannelConnector();
            connector.setPort(providerConfig.getPort());
            server.setConnectors(new Connector[] { connector });
            server.setHandler(httpHandler);
            server.start();
        } catch (Throwable e) {
            logger.error("�����쳣", e);
        }
    }

}
