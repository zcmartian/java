package com.mars.tree;

import com.mars.map.Map;

public class RBTree<K extends Comparable<K>, V> implements Map<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private int size;

    public RBTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;
    }

    /**
     *       node              x
     *      /  \              / \
     *     T1   x          node  T3
     *         / \        /  \
     *       T2   T3     T1  T2
     */

    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    @Override
    public V remove(K key) {
//        Node node = getNode(root, key);
//        if (node != null) {
//            root = remove(root, key);
//            return node.value;
//        }
        return null;
    }
//
//    //返回以node为根的树中删除了E的新树的根
//    private Node remove(Node node, K key) {
//        if (node == null) {
//            return null;
//        }
//
//        if (key.compareTo(node.key) < 0) {
//            node.left = remove(node.left, key);
//            return node;
//        } else if (key.compareTo(node.key) > 0) {
//            node.right = remove(node.right, key);
//            return node;
//        } else {
//            if (node.left == null) {
//                Node rightNode = node.right;
//                node.right = null;
//                size--;
//                return rightNode;
//            }
//            if (node.right == null) {
//                Node leftNode = node.left;
//                node.left = null;
//                size--;
//                return leftNode;
//            }
//            // 找到当前待删除节点的后继,即右子树中的最小值
//            // 让后继的左子树等于待删除节点的左子树,
//            // 让后继的右子树等于待删除节点的右子树删除这个最小值之后的根节点(即一颗新的树)
////            Node successor = minimum(node.right);
////            successor.right = removeMin(node.right);
////            successor.left = node.left;
//
//            // 找到当前待删除节点的后继,即左子树中的最大值
//            // 让后继的右子树等于待删除节点的右子树,
//            // 让后继的左子树等于待删除节点的左子树删除这个最大值之后的根节点(即一颗新的树)
//            Node successor = maximum(node.left);
//            successor.left = removeMax(node.left);
//            successor.right = node.right;
//            node.left = node.right = null;
//            return successor;
//        }
//    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

//    //删除以node为根的树中的最小值,返回新的树的根
//    private Node removeMin(Node node) {
//        if (node.left == null) {
//            Node rightNode = node.right;
//            node.right = null;
//            size--;
//            return rightNode;
//        }
//        node.left = removeMin(node.left);
//        return node;
//    }
//
//    //删除以node为根的树中的最大值,返回新的树的根
//    private Node removeMax(Node node) {
//        if (node.right == null) {
//            Node leftNode = node.left;
//            node.left = null;
//            size--;
//            return leftNode;
//        }
//        node.right = removeMax(node.right);
//        return node;
//    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exists!");
        }
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }
}
