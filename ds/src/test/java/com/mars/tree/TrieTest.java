package com.mars.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrieTest {

    private Trie trie1;
    private Trie trie2;

    @Before
    public void init() {
        String str1 = "Hello World";
        String str2 = "Hello";
        String str3 = "HelloWorld";
        String str4 = "World";
        String str5 = "WorldWar2";
        trie1 = new Trie();
        trie1.add(str1);
        trie1.add(str2);
        trie1.add(str3);
        trie1.add(str4);
        trie1.add(str5);
        trie2 = new Trie();
        trie2.addByRecursion(str1);
        trie2.addByRecursion(str2);
        trie2.addByRecursion(str3);
        trie2.addByRecursion(str4);
        trie2.addByRecursion(str5);
    }

    @Test
    public void testTrie1() {
        Assert.assertTrue(trie1.isPrefix("Hello"));
        Assert.assertTrue(trie1.contains("Hello"));
        Assert.assertTrue(trie1.contains("World"));
        Assert.assertTrue(trie1.isPrefix("Wor"));
        Assert.assertFalse(trie1.contains("WorldWar"));
        Assert.assertTrue(trie1.contains("WorldWar2"));
        Assert.assertFalse(trie1.contains("HelloW"));
        Assert.assertTrue(trie1.isPrefix("HelloW"));
    }

    @Test
    public void testTrie2() {
        Assert.assertTrue(trie2.isPrefix("Hello"));
        Assert.assertTrue(trie2.contains("Hello"));
        Assert.assertTrue(trie2.contains("World"));
        Assert.assertTrue(trie2.isPrefix("Wor"));
        Assert.assertFalse(trie2.contains("WorldWar"));
        Assert.assertTrue(trie2.contains("WorldWar2"));
        Assert.assertFalse(trie2.contains("HelloW"));
        Assert.assertTrue(trie2.isPrefix("HelloW"));
    }

    @Test
    public void testTrie3() {
        trie1.delete("Hello");
        Assert.assertTrue(trie1.isPrefix("Hello"));
        Assert.assertFalse(trie1.contains("Hello"));
    }
}
