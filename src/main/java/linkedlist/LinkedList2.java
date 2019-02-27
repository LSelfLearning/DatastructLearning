package linkedlist;

public class LinkedList2<E> {
    private Node head;
    private int size;

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return head == null;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        head = new Node(e, head);
        size++;
    }

    // 在链表尾部添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Error index");

        if (index == 0)
            addFirst(e);
        else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
//        Node node = new Node(e);
//        node.next = pre.next;
//        pre.next = node;

            pre.next = new Node(e, pre.next);
            size++;
        }

    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("LinkedList:[");
        Node cur = head;
        while (cur != null) {
            str.append(cur.data);
            cur = cur.next;
            if (cur != null)
                str.append(",");
        }
        str.append("]");
        return str.toString();
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
}
