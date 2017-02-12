package com.mars.aio;

/**
 * Created by mars on 2017/2/12.
 */
public class AIOServer {
    public static void main(String ... args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {

            }
        }

        AsyncServerHandler timeServerHandler = new AsyncServerHandler(port);
        new Thread(timeServerHandler, "AIO-AsyncServerHandler-001").start();
    }
}
