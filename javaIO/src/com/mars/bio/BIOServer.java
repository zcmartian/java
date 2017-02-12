package com.mars.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;

        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The server is start in port : " + port);
            Socket socket = null;
            com.mars.bio.TimeServerHandlerExecutePool singleExecutor = new com.mars.bio.TimeServerHandlerExecutePool(50,
                    10000);
            while (true) {
                Thread.sleep(1000L);
                socket = serverSocket.accept();

                // 最简单 新起一个线程处理请求
                // 同步处理,一个请求一个线程
                // new Thread(new com.mars.bio.ServerHandler(socket)).start();

                singleExecutor.execute(new com.mars.bio.ServerHandler(socket));
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
