package stack;

import linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList = new LinkedList<E>();

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedStack  ");
        for (int i = 0; i < linkedList.getSize(); i++) {
            if (i == 0)
                sb.append("Top\t");

            sb.append(linkedList.get(i) + "\t");
            if (i == linkedList.getSize() - 1)
                sb.append("Bottom");
        }
        return sb.toString();
    }
}
