package com.mars.concurrency.second.classloader.chapter4;

import java.io.UnsupportedEncodingException;


public class SimpleEncrypt {

    private static final String plain = "Hello ClassLoader";

    private static final byte ENCRYPT_FACTOR = (byte) 0xff;


    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = plain.getBytes();
        byte[] encrypt = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            encrypt[i] = (byte) (bytes[i] ^ ENCRYPT_FACTOR);
        }
        System.out.println(new String(encrypt, "utf-8"));

        byte[] decrypt = new byte[encrypt.length];
        for (int i = 0; i < encrypt.length; i++) {
            decrypt[i] = (byte) (encrypt[i] ^ ENCRYPT_FACTOR);
        }
        System.out.println(new String(decrypt));
    }
}