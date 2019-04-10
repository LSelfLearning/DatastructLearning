package linkedlist;


import common.Logger;

public class SinglyLinkedList {

    private Node dummyHead = null;
    private int size = 0;

    public SinglyLinkedList() {
        dummyHead = new Node(-1, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node findByVal(int value) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.data == value)
                break;
            cur = cur.next;
        }
        return cur;
    }

    public Node findByIndex(int index) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void insertHead(int value) {
        insertHead(new Node(value, null));
    }

    public void insertHead(Node node) {
        node.next = dummyHead.next;
        dummyHead.next = node;
    }

    public void insertTail(int value) {
        insertTail(new Node(value, null));
    }

    public void insertTail(Node node) {
        Node pre = dummyHead;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = node;
    }

    public void insertAfter(Node node, int value) {
        insertAfter(node, new Node(value, null));
    }

    public void insertAfter(Node node, Node newValue) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next == node)
                break;
            pre = pre.next;
        }
        newValue.next = pre.next;
        pre.next = newValue;
    }

    public void insertBefore(Node node, int value) {
        insertBefore(node, new Node(value, null));
    }

    public void insertBefore(Node node, Node newValue) {
        Node pre = dummyHead;
        //找到pos节点前一个节点
        while (pre.next != null) {
            if (pre.next == node)
                break;
            pre = pre.next;
        }
        if (pre.next != null) {
            newValue.next = pre.next;
            pre.next = newValue;
        }
    }

    public void deleteByValue(int value) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.data == value)
                break;
            pre = pre.next;
        }
        if (pre.next != null) {
            pre.next = pre.next.next;
        }
    }

    public void deleteByNode(Node node) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next == node)
                break;
            pre = pre.next;
        }
        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
        }
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }


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

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);

        list.insertHead(0);
        list.insertBefore(list.findByVal(0), 9);
        Logger.logln(list);

        list.deleteByNode(list.findByVal(9));
        Logger.logln(list);

        list.deleteByValue(2);
        Logger.logln(list);
    }
}
