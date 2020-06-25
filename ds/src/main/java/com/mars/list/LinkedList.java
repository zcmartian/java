package com.mars.list;

public class LinkedList<E> {

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void add(E e) {
        dummyHead = addByRecursion(dummyHead, e);
    }

    //往当前节点之后插入节点,返回当前节点
    private Node addByRecursion(Node node, E e) {
        if (node.next == null) {
            size++;
            node.next = new Node(e);
            return node;
        }
        node.next = addByRecursion(node.next, e);
        return node;
    }

    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get fail. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(E e, int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set fail. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
        }
        return false;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node del = prev.next;
        prev.next = del.next;
        del.next = null;
        size--;
        return del.e;
    }

    public E removeElement(E value) {

        Node prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.e.equals(value)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.e;
        }
        return null;
    }

    public void removeAll(E value) {
        Node prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.e.equals(value)) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
    }

    // 删除以head为头结点的链表中值为value的节点,返回新的头结点
    private Node removeRecursion(Node head, E value) {
        if (head == null) {
            return null;
        }
        // 递归直接到底
        Node res = removeRecursion(head.next, value);
        if (head.e.equals(value)) {
            return res;//到底之后一个一个反向跳出递归然后判断,如果当前节点等于被删除节点,将待删除节点的后继弹出递归返回,等于删除了这个节点
        } else {
            // 接住上一次递归返回的节点,res就是删除了value之后的链表的头部,把上一次递归返回的头结点挂在当前头结点后面返回当前头结点
            head.next = res;
            return head;
        }
    }

    public void removeAllByRecursion(E value) {
        dummyHead.next = removeRecursion(dummyHead.next, value);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
