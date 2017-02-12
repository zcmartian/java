package com.mars;

/**
 * Created by mars on 2017/2/12.
 */
public class AIOTimeClient {
    public static void main(String ... args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {

            }
        }

        AsyncTimeClientHandler timeClientHandler = new AsyncTimeClientHandler("localhost", port);
        new Thread(timeClientHandler, "AIO-AsyncTimeClientHandler-001").start();
    }
}
