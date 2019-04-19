package com.mars.aio;

/**
 * Created by mars on 2017/2/12.
 */
public class AIOClient {
    public static void main(String... args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {

            }
        }

        AsyncClientHandler timeClientHandler = new AsyncClientHandler("localhost", port);
        new Thread(timeClientHandler, "AIO-AsyncClientHandler-001").start();
    }
}
