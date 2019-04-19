package com.mars.tree;

import org.junit.Assert;
import org.junit.Test;

public class SegmentTreeTest {

    @Test
    public void testSegmentTree() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        Assert.assertEquals(1, segTree.query(0, 2).intValue());
        Assert.assertEquals(-1, segTree.query(2, 5).intValue());
        Assert.assertEquals(-3, segTree.query(0, 5).intValue());

        segTree.set(2, -1);
        Assert.assertEquals(-3, segTree.query(0, 2).intValue());
        Assert.assertEquals(-5, segTree.query(2, 5).intValue());
        Assert.assertEquals(-7, segTree.query(0, 5).intValue());
    }
}
