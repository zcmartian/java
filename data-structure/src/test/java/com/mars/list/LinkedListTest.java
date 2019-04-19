package com.mars.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class LinkedListTest {
    LinkedList<Integer> linkedList;
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Before
    public void init() {
        linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        Assert.assertEquals("4->3->2->1->0->NULL", linkedList.toString());
    }

    @Test
    public void testAdd() {
        linkedList.add(2, 666);
        Assert.assertEquals("4->3->666->2->1->0->NULL", linkedList.toString());
    }

    @Test
    public void testRemove() {
        linkedList.add(2, 666);
        linkedList.remove(2);
        Assert.assertEquals("4->3->2->1->0->NULL", linkedList.toString());
        linkedList.removeFirst();
        Assert.assertEquals("3->2->1->0->NULL", linkedList.toString());
        linkedList.removeLast();
        Assert.assertEquals("3->2->1->NULL", linkedList.toString());
    }

    @Test
    public void testRemoveAll() {
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(6);
        linkedList.addFirst(6);
        linkedList.removeAll(3);
        Assert.assertEquals("6->6->1->2->4->2->1->0->NULL", linkedList.toString());
        linkedList.removeAll(2);
        Assert.assertEquals("6->6->1->4->1->0->NULL", linkedList.toString());
        linkedList.removeAll(1);
        Assert.assertEquals("6->6->4->0->NULL", linkedList.toString());
        linkedList.removeAll(6);
        Assert.assertEquals("4->0->NULL", linkedList.toString());
        linkedList.removeAll(0);
        Assert.assertEquals("4->NULL", linkedList.toString());
    }

    @Test
    public void testRemoveAllByRecursion() {
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(6);
        linkedList.addFirst(6);
        linkedList.removeAllByRecursion(3);
        Assert.assertEquals("6->6->1->2->4->2->1->0->NULL", linkedList.toString());
        linkedList.removeAllByRecursion(2);
        Assert.assertEquals("6->6->1->4->1->0->NULL", linkedList.toString());
        linkedList.removeAllByRecursion(1);
        Assert.assertEquals("6->6->4->0->NULL", linkedList.toString());
        linkedList.removeAllByRecursion(6);
        Assert.assertEquals("4->0->NULL", linkedList.toString());
        linkedList.removeAllByRecursion(0);
        Assert.assertEquals("4->NULL", linkedList.toString());
    }
}
