package com.mars;

/**
 * Created by marszhou on 16/8/19.
 */
public class Client {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        new Thread(new ClientHandle("127.0.0.1", port), "client-001").start();

        // Socket socket = null;
        // BufferedReader in = null;
        // PrintWriter out = null;
        //
        // for (int i =0; i<50; ++i) {
        // try {
        // socket = new Socket("127.0.0.1", port);
        // in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // out = new PrintWriter(socket.getOutputStream(), true);
        // out.println("QUERY TIME ORDER");
        // System.out.println("Send order 2 server succeed.");
        // String resp = in.readLine();
        // System.out.println("Now is : " + resp);
        // } catch (Exception e) {
        //
        // } finally {
        // if (out != null) {
        // out.close();
        // out = null;
        // }
        // if (in != null) {
        // try {
        // in.close();
        // } catch (IOException e1) {
        // e1.printStackTrace();
        // }
        // }
        // if (socket != null) {
        // try {
        // socket.close();
        // } catch (IOException e1) {
        // e1.printStackTrace();
        // }
        // socket = null;
        // }
        // }
        // }
    }
}
