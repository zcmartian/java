package com.mars.nio;

/**
 * Created by marszhou on 16/8/19.
 */
public class NIOClient {
    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        new Thread(new ClientHandle("127.0.0.1", port), "client-001").start();
    }
}
