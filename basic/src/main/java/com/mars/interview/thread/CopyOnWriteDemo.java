package com.mars.interview.thread;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.String.valueOf;
import static java.util.UUID.randomUUID;

public class CopyOnWriteDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, valueOf(i)).start();
        }
    }
}
