package linkedlist;

public class LinkedList<E> implements ILinkedList<E> {

    private int size;
    private Node dummyHead;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, E e) {
        checkIndexValid(index);
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public E remove(int index) {
        checkIndexValid(index);
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.val;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public void set(int index, E e) {
        checkIndexValid(index);
        Node cur = dummyHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        cur.val = e;
    }

    @Override
    public E get(int index) {
        checkIndexValid(index);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.val == e) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    private void checkIndexValid(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("error index");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList :    ");
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            sb.append(cur.val);
            sb.append("-->");
        }
        sb.append("NULL");
        return sb.toString();
    }
    
    private class Node {
        public E val;
        public Node next;

        public Node(E val) {
            this.val = val;
        }

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
