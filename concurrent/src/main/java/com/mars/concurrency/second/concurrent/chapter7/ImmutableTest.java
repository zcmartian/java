package com.mars.concurrency.second.concurrent.chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ImmutableTest {

    private final int age;
    private final String name;
    private final List<String> list;


    public ImmutableTest(int age, String name) {
        this.age = age;
        this.name = name;
        list = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {

        // 返回list 时不能保证 其他线程 不能修改 list 所以加unmodifiableList
//        return list;
        return Collections.unmodifiableList(list);
    }
}