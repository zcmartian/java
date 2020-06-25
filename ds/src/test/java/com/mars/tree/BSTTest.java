package com.mars.tree;

import com.mars.map.BSTMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;
import java.util.Random;

public class BSTTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    BST<Integer> tree;

    @Before
    public void init() {
        tree = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            tree.add(num);
        }
        /**
         *                  5
         *                /  \
         *               3    6
         *              / \  / \
         *             2  4     8
         */
        System.out.println(tree);
    }

    @Test
    public void testPreOrder() {
        tree.preOrder();
        Assert.assertEquals("5\n" +
                "--3\n" +
                "----2\n" +
                "------null\n" +
                "------null\n" +
                "----4\n" +
                "------null\n" +
                "------null\n" +
                "--6\n" +
                "----null\n" +
                "----8\n" +
                "------null\n" +
                "------null\n" +
                "\n" +
                "5\n" +
                "3\n" +
                "2\n" +
                "4\n" +
                "6\n" +
                "8\n", log.getLog());
    }

    @Test
    public void testInOrder() {
        tree.inOrder();
        Assert.assertEquals("5\n" +
                "--3\n" +
                "----2\n" +
                "------null\n" +
                "------null\n" +
                "----4\n" +
                "------null\n" +
                "------null\n" +
                "--6\n" +
                "----null\n" +
                "----8\n" +
                "------null\n" +
                "------null\n" +
                "\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "8\n", log.getLog());
    }

    @Test
    public void testPostOrder() {
        tree.postOrder();
        Assert.assertEquals("5\n" +
                "--3\n" +
                "----2\n" +
                "------null\n" +
                "------null\n" +
                "----4\n" +
                "------null\n" +
                "------null\n" +
                "--6\n" +
                "----null\n" +
                "----8\n" +
                "------null\n" +
                "------null\n" +
                "\n" +
                "2\n" +
                "4\n" +
                "3\n" +
                "8\n" +
                "6\n" +
                "5\n", log.getLog());
    }

    @Test
    public void testNonRecursion() {
        tree.preOrderNonRecursion();
        Assert.assertEquals("5\n" +
                "--3\n" +
                "----2\n" +
                "------null\n" +
                "------null\n" +
                "----4\n" +
                "------null\n" +
                "------null\n" +
                "--6\n" +
                "----null\n" +
                "----8\n" +
                "------null\n" +
                "------null\n" +
                "\n" +
                "5\n" +
                "3\n" +
                "2\n" +
                "4\n" +
                "6\n" +
                "8\n", log.getLog());
    }

    @Test
    public void testLevelOrder() {
        tree.levelOrder();
        Assert.assertEquals("5\n" +
                "--3\n" +
                "----2\n" +
                "------null\n" +
                "------null\n" +
                "----4\n" +
                "------null\n" +
                "------null\n" +
                "--6\n" +
                "----null\n" +
                "----8\n" +
                "------null\n" +
                "------null\n" +
                "\n" +
                "5\n" +
                "3\n" +
                "6\n" +
                "2\n" +
                "4\n" +
                "8\n", log.getLog());
    }

    @Test
    public void testRemove() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("removeMin test completed");

        nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("removeMax test completed");
    }

    @Test
    public void testRemoveAny() {
        tree.remove(5);
        System.out.print(tree);
        Assert.assertEquals("5\n" +
                "--3\n" +
                "----2\n" +
                "------null\n" +
                "------null\n" +
                "----4\n" +
                "------null\n" +
                "------null\n" +
                "--6\n" +
                "----null\n" +
                "----8\n" +
                "------null\n" +
                "------null\n" +
                "\n" +
                "6\n" +
                "--3\n" +
                "----2\n" +
                "------null\n" +
                "------null\n" +
                "----4\n" +
                "------null\n" +
                "------null\n" +
                "--8\n" +
                "----null\n" +
                "----null\n", log.getLog());
        tree.remove(3);
        System.out.print(tree);
        Assert.assertEquals("5\n" +
                "--3\n" +
                "----2\n" +
                "------null\n" +
                "------null\n" +
                "----4\n" +
                "------null\n" +
                "------null\n" +
                "--6\n" +
                "----null\n" +
                "----8\n" +
                "------null\n" +
                "------null\n" +
                "\n" +
                "6\n" +
                "--3\n" +
                "----2\n" +
                "------null\n" +
                "------null\n" +
                "----4\n" +
                "------null\n" +
                "------null\n" +
                "--8\n" +
                "----null\n" +
                "----null\n" +
                "6\n" +
                "--4\n" +
                "----2\n" +
                "------null\n" +
                "------null\n" +
                "----null\n" +
                "--8\n" +
                "----null\n" +
                "----null\n", log.getLog());
    }

    @Test
    public void testPerformance() {
        int n = 20000000;

        Random random = new Random();
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }
        long startTime = System.nanoTime();
        BSTMap<Integer, Integer> bst = new BSTMap<>();
        for (Integer x : testData) {
            bst.add(x, null);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST : " + time + " s");
        startTime = System.nanoTime();
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x : testData) {
            avl.add(x, null);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL : " + time + " s");
        startTime = System.nanoTime();
        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x : testData) {
            rbt.add(x, null);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree : " + time + " s");
    }

    @Test
    public void testPerformance2() {
        int n = 20000000;

        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(i);
        }

        long startTime = System.nanoTime();
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x : testData) {
            avl.add(x, null);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL : " + time + " s");
        startTime = System.nanoTime();
        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x : testData) {
            rbt.add(x, null);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree : " + time + " s");
    }
}
