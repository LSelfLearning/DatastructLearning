package heap;

import array.Array;
import common.Logger;

import java.util.Random;

public class Console {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 15; i > 0; i--) {
            maxHeap.add(random.nextInt(1000));
        }
        Logger.logln(maxHeap.toString());

        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 15; i++) {
            arr.add(i, maxHeap.extractMax());
        }
        Logger.logln(arr);
    }
}
