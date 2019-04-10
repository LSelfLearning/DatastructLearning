package queue;


import java.util.Stack;

public class StackQueue<E> implements Queue<E> {

    private Stack<E> dataStack;
    private Stack<E> helpStack;

    public StackQueue() {
        dataStack = new Stack<E>();
        helpStack = new Stack<E>();
    }

    @Override
    public int getSize() {
        return dataStack.size() + helpStack.size();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public void enqueue(E e) {
        dataStack.push(e);
    }

    @Override
    public E dequeue() {
        while (!dataStack.isEmpty()) {
            helpStack.push(dataStack.pop());
        }
        E e = helpStack.pop();
        while (!helpStack.isEmpty()) {
            dataStack.push(helpStack.pop());
        }
        return e;
    }

    @Override
    public E getFront() {
        while (!dataStack.isEmpty()) {
            helpStack.push(dataStack.pop());
        }
        E e = helpStack.peek();
        while (!helpStack.isEmpty()) {
            dataStack.push(helpStack.pop());
        }
        return e;
    }
}

