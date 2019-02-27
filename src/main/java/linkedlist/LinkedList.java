package linkedlist;

public class LinkedList<E> {
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
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

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        checkIndexValid(index);
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

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
        return delNode.data;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E get(int index) {
        checkIndexValid(index);
        Node cur = dummyHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public E getFisrt() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    public void set(int index, E e) {
        checkIndexValid(index);
        Node cur = dummyHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        cur.data = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.data == e)
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList2 :    ");
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            sb.append(cur.data);
            sb.append("-->");
        }
        sb.append("NULL");
        return sb.toString();
    }

    private class Node {
        private Node next;
        private E data;

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node next) {
            this.next = next;
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }
    }

    private void checkIndexValid(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("error index");
    }
}
