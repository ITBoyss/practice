package data_structure.linkedlist;

/**
 * @ProjectName: algorithm
 * @Description: 双向链表实现
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/20 15:30
 * @Version: 1.0.0
 */
public class DLinkedList<E> {

    private class Node {

        public E e;

        public Node prev;

        public Node next;

        public Node(E e, Node prev, Node next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }
    }


    private Node dummyHead;

    private int size;

    public DLinkedList() {
        dummyHead = new Node(null, null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index invalid");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node after = prev.next;
        Node node = new Node(e, prev, after);
        prev.next = node;
        if (after != null) {
            after.prev = node;
        }
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }


    public E remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("remove failed, DLinkedList is empty");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index invalid");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = prev.next;
        Node after = prev.next.next;
        prev.next = after;
        if (after != null) {
            after.prev = prev;
        }
        node.prev = null;
        node.next = null;
        size--;
        return node.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("remove failed, DLinkedList is empty");
        }
        return dummyHead.next.e;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new RuntimeException("remove failed, DLinkedList is empty");
        }
        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DLinkedList:[");
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.e + "<->");
            cur = cur.next;
        }
        sb.append("NULL]");

        return sb.toString();
    }
}
