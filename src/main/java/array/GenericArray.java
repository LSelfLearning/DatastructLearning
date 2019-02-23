package array;

import common.Logger;

/**
 * 数组的插入、删除、按照下标随机访问操作
 */
public class GenericArray<T> {
    private T[] data;
    //数组容量
    private int capacity;
    //元素个数
    private int count;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        this.capacity = capacity;
        count = 0;
    }

    /**
     * 增
     */
    public boolean insert(int index, T value) {
        if (count == capacity) {
            T[] newArr = (T[]) new Object[capacity * 2];
            System.arraycopy(data, 0, newArr, 0, data.length);
            data = newArr;
            capacity = capacity * 2;
        }

        if (index < 0 || index > count) {
            System.out.println("索引越界");
            return false;
        }

        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        count++;
        return true;

    }

    /**
     * 删
     */
    public boolean delete(int index) {
        if (count == 0) {
            System.out.println("数组为空");
            return false;
        }

        if (index < 0 || index > count - 1) {
            System.out.println("索引越界");
            return false;
        }

        for (int i = index; i < count; i++) {
            data[i] = data[i + 1];
        }
        count--;
        if (count < capacity / 2) {
            T[] newArr = (T[]) new Object[capacity / 2];
            System.arraycopy(data, 0, newArr, 0, count);
            data = newArr;
            capacity /= 2;
        }
        return true;
    }

    /**
     * 改
     */
    public boolean update(int index, T value) {
        if (index >= 0 && index < count) {
            data[index] = value;
            return true;
        }
        return false;
    }

    /**
     * 查
     */
    public T search(int index) {
        if (index < 0 || index >= count)
            System.out.println("索引越界");
        return data[index];
    }

    public void printAll() {
        Logger.log("--------log start--------");
        for (int i = 0; i < count; i++) {
            Logger.log("data[" + i + "]=" + data[i]);
        }
        Logger.log("--------log end--------");
    }

    public static void main(String[] args) {
        GenericArray arr = new GenericArray(2);
        arr.insert(0, "Hello");
        arr.insert(1, 3);
        arr.insert(2, 5);
        arr.insert(3, 7);
        arr.insert(4, 9);
        arr.update(1, 8);
        arr.printAll();
        Logger.log(arr.capacity);
//        Logger.log(arr.find(2));
//        arr.delete(0);
//        arr.insert(0, 3);

//        arr.printAll();
    }
}
