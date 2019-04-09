package collection.set;

import linkedlist.ILinkedList;
import linkedlist.LinkedList;

public class LinkedSet<E> implements Set<E> {
    private ILinkedList<E> linkedList = new LinkedList<>();

    @Override
    public void add(E e) {
        if (!linkedList.contains(e))
            linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.getSize();
    }
}
