package com.mars;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;

        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        /**
         * 3.多路复用选择器
         */
        MultiplexerServer multiplexerServer = new MultiplexerServer(port);
        new Thread(multiplexerServer, "NIO-com.mars.MultiplexerServer-001").start();
        /**
         * 3.多路复用选择器
         */

        ServerSocket serverSocket = null;

        try {
//            serverSocket = new ServerSocket(port);
//            System.out.println("The server is start in port : " + port);
            Socket socket = null;
            /**
             * 2.线程池处理请求
             */
            // com.mars.TimeServerHandlerExecutePool singleExecutor = new com.mars.TimeServerHandlerExecutePool(50,
            // 10000);
            /**
             * 2.线程池处理请求
             */
            while (true) {
                Thread.sleep(1000L);
//                socket = serverSocket.accept();

                /**
                 * 1.最简单 新起一个线程处理请求
                 */
                // new Thread(new com.mars.ServerHandler(socket)).start();//同步处理,一个请求一个线程
                /**
                 * 1.最简单 新起一个线程处理请求
                 */

                /**
                 * 2.线程池处理请求
                 */
                // singleExecutor.execute(new com.mars.ServerHandler(socket));
                /**
                 * 2.线程池处理请求
                 */
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                System.out.println("The server close");
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                serverSocket = null;
            }
        }
    }
}
