package queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if (front == (tail + 1) % data.length)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (front == tail)
            throw new IllegalArgumentException("Empty Queue");
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        if (front == tail)
            throw new IllegalArgumentException("Empty Queue");
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < data.length; i++) {
            newArr[i] = data[(front + i) % data.length];
        }
        data = newArr;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(",");
            }
        }

        res.append("] tail");
        return res.toString();
    }
}
