package com.mars.union;

import org.junit.Test;

import java.util.Random;

public class UnionTest {
    @Test
    public void testUnionFind() {
        int size = 10000000;
        int m = 10000000;

//        UnionFind1 unionFind1 = new UnionFind1(size);
//        System.out.println("UnionFind1: " + testUF(unionFind1, m) + " s");
//        UnionFind2 unionFind2 = new UnionFind2(size);
//        System.out.println("UnionFind2: " + testUF(unionFind2, m) + " s");
        UnionFind3 unionFind3 = new UnionFind3(size);
        System.out.println("UnionFind3: " + testUF(unionFind3, m) + " s");
        UnionFind4 unionFind4 = new UnionFind4(size);
        System.out.println("UnionFind4: " + testUF(unionFind4, m) + " s");
        UnionFind5 unionFind5 = new UnionFind5(size);
        System.out.println("UnionFind5: " + testUF(unionFind5, m) + " s");
        UnionFind6 unionFind6 = new UnionFind6(size);
        System.out.println("UnionFind6: " + testUF(unionFind6, m) + " s");

    }

    private double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElement(a, b);
        }
        for (int i = 0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
