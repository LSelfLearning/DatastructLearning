package linkedlist;

public class LinkedList<E> implements ILinkedList<E> {

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    private class Node {
        public E data;
        public Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
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
    public void removeElement(E e) {
        Node pre = this.dummyHead;
        while (pre.next != null) {
            if (pre.next.data.equals(e)){
                Node delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
                size--;
            }else {
                pre = pre.next;
            }
        }
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
        return delNode.data;
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
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = e;
    }

    @Override
    public E get(int index) {
        checkIndexValid(index);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.data;
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
            if (cur.data.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    private void checkIndexValid(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("error index");
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("dummpHead->");
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.data);
            res.append("->");
            cur = cur.next;
        }
        return res.substring(0, res.lastIndexOf("->"));
    }
}
