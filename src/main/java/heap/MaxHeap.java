package heap;

import array.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> array;

    public MaxHeap() {
        this(null);
    }

    public MaxHeap(E[] arr) {
        if (arr == null || arr.length == 0) {
            array = new Array<>();
        } else {
            array = new Array<>(arr);
            for (int i = parent(size() - 1); i >= 0; i--) {
                shiftDown(i);
            }
        }
    }

    public int size() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index = 0 doesn't have parent index!");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // 看堆中的最大元素
    public E findMax() {
        if (array.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return array.get(0);
    }

    public E extractMax() {
        E max = findMax();
        array.swap(0, size() - 1);
        array.removeLast();
        shiftDown(0);
        return max;
    }


    private void shiftDown(int index) {
        while (leftChild(index) < size()) {
            int leftChildIndex = leftChild(index);
            int rightChildIndex = leftChildIndex + 1;
            int maxValIndex = leftChildIndex;
            if (rightChildIndex < size() && array.get(rightChildIndex).compareTo(array.get(leftChildIndex)) > 0) {
                maxValIndex = rightChildIndex;
            }
            if (array.get(index).compareTo(array.get(maxValIndex)) >= 0)
                break;
            array.swap(index, maxValIndex);
            index = maxValIndex;
        }
    }

    public void add(E e) {
        array.addLast(e);
        shiftUp(size() - 1);
    }

    private void shiftUp(int index) {
        while (index > 0 && array.get(parent(index)).compareTo(array.get(index)) < 0) {
            array.swap(index, parent(index));
            index = parent(index);
        }
    }

    public E replace(E e) {
        E max = findMax();
        array.set(0, e);
        shiftDown(0);
        return max;
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
