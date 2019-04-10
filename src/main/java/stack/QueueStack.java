package stack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack<E> implements Stack<E> {

    private Queue<E> queue;

    public QueueStack() {
        queue = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void push(E e) {
        int n = queue.size();
        queue.offer(e);
        for (int i = 0; i < n; i++)
            queue.offer(queue.poll());
    }

    @Override
    public E pop() {
        return queue.poll();
    }

    @Override
    public E peek() {
        return queue.peek();
    }
}
