package com.mars.tree;

import java.util.TreeMap;

public class Trie {
    private Node root;
    private int size;
    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node(cur));
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public void addByRecursion(String word) {
        _add(root, 0, word);
    }

    private void _add(Node cur, int index, String word) {
        if (cur == null) {
            return;
        }

        char c = word.charAt(index);
        Node found = cur.next.get(c);
        if (found == null) {
            found = new Node(cur);
            cur.next.put(c, found);
        }
        if (index < word.length() - 1) {
            _add(found, index + 1, word);
        } else if (index == word.length() - 1) {
            if (!found.isWord) {
                found.isWord = true;
                size++;
            }
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public void delete(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return;
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            return;
        } else {
            if (cur.next.size() > 0) {
                cur.isWord = false;
            } else {
                for (int i = word.length() - 1; i >= 0; i--) {
                    char c = word.charAt(i);
                    if (cur.parent.next.size() == 1) {
                        cur.parent.next.put(c, null);
                    }
                    cur = cur.parent;
                }
            }
        }
    }

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;
        public Node parent;

        public Node(boolean isWord, Node parent) {
            this.isWord = isWord;
            this.parent = parent;
            next = new TreeMap<>();
        }

        public Node() {
            this(null);
        }

        public Node(Node parent) {
            this(false, parent);
        }
    }
}
