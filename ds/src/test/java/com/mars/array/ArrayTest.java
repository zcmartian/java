package com.mars.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {

    Array<Integer> array;

    @Before
    public void initArray() {
        array = new Array<>();
        for(int i = 0;i < 10;i++) {
            array.addLast(i);
        }
        Assert.assertEquals("Array: size=10, capacity=10\n" +
                "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", array.toString());
    }

    @Test
    public void testGet() {
        Assert.assertEquals(0, (int) array.getFirst());
    }

    @Test
    public void testRemoveElement() {
        array.removeElement(0);
        Assert.assertEquals("Array: size=9, capacity=10\n" +
                "[1, 2, 3, 4, 5, 6, 7, 8, 9]", array.toString());
    }

    @Test
    public void testAdd() {
        array.add(1, 100);
        Assert.assertEquals("Array: size=11, capacity=20\n" +
                "[0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]", array.toString());

        array.addFirst(-1);
        Assert.assertEquals("Array: size=12, capacity=20\n" +
                "[-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]", array.toString());
    }

    @Test
    public void testRemove() {
        array.add(1, 100);
        array.addFirst(-1);
        Assert.assertEquals("Array: size=12, capacity=20\n" +
                "[-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]", array.toString());

        array.remove(2);
        Assert.assertEquals("Array: size=11, capacity=20\n" +
                "[-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", array.toString());

        array.removeLast();
        Assert.assertEquals("Array: size=10, capacity=20\n" +
                "[-1, 0, 1, 2, 3, 4, 5, 6, 7, 8]", array.toString());
        array.removeLast();
        Assert.assertEquals("Array: size=9, capacity=20\n" +
                "[-1, 0, 1, 2, 3, 4, 5, 6, 7]", array.toString());
        array.removeFirst();
        Assert.assertEquals("Array: size=8, capacity=20\n" +
                "[0, 1, 2, 3, 4, 5, 6, 7]", array.toString());
        array.remove(3);
        Assert.assertEquals("Array: size=7, capacity=20\n" +
                "[0, 1, 2, 4, 5, 6, 7]", array.toString());
        array.removeFirst();
        Assert.assertEquals("Array: size=6, capacity=20\n" +
                "[1, 2, 4, 5, 6, 7]", array.toString());
        array.removeLast();
        Assert.assertEquals("Array: size=5, capacity=10\n" +
                "[1, 2, 4, 5, 6]", array.toString());
        array.removeLast();
        Assert.assertEquals("Array: size=4, capacity=10\n" +
                "[1, 2, 4, 5]", array.toString());
        array.removeLast();
        Assert.assertEquals("Array: size=3, capacity=10\n" +
                "[1, 2, 4]", array.toString());
        array.removeLast();
        Assert.assertEquals("Array: size=2, capacity=5\n" +
                "[1, 2]", array.toString());
        array.removeLast();
        Assert.assertEquals("Array: size=1, capacity=2\n" +
                "[1]", array.toString());
        array.removeLast();
        Assert.assertEquals("Array: size=0, capacity=1\n" +
                "[]", array.toString());
        array.addFirst(1);
        Assert.assertEquals("Array: size=1, capacity=1\n" +
                "[1]", array.toString());
        array.removeLast();
        Assert.assertEquals("Array: size=0, capacity=1\n" +
                "[]", array.toString());
    }
}
