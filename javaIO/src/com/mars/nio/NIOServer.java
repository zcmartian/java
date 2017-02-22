package com.mars.nio;

import java.net.Socket;

public class NIOServer {

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;

        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        MultiplexerSelector multiplexerSelector = new MultiplexerSelector(port);
        new Thread(multiplexerSelector, "NIO-com.mars.nio.MultiplexerSelector-001").start();

        try {
            Socket socket = null;
            while (true) {
                Thread.sleep(1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
