package com.mars;

public class Main {

    public static void main(String[] args) {
        int port = 8080;

        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        MultiplexerServer server = new MultiplexerServer(port);
        new Thread(server, "NIO-com.mars.MultiplexerServer-001").start();

        // ServerSocket serverSocket = null;
        //
        // try {
        // serverSocket = new ServerSocket(port);
        // System.out.println("The server is start in port : " + port);
        // Socket socket = null;
        // com.mars.TimeServerHandlerExecutePool singleExecutor = new com.mars.TimeServerHandlerExecutePool(50, 10000);
        // while (true) {
        // socket = serverSocket.accept();
        // // new Thread(new com.mars.ServerHandler(socket)).start();//同步处理,一个请求一个线程
        // singleExecutor.execute(new com.mars.ServerHandler(socket));
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // } finally {
        // if (serverSocket != null) {
        // System.out.println("The server close");
        // try {
        // serverSocket.close();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // serverSocket = null;
        // }
        // }
    }
}
