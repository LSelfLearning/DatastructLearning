package sort;

import common.Logger;

import java.util.Random;

public class SortTestHelper {
    public enum Algorithm {
        BUBBLE, INSERTION, SELECTION
    }

    public void test(Algorithm algorithm, int dataSize) {
        Integer[] arr = generateArr(dataSize);
        SortAlgorithm sortAlgorithm;
        switch (algorithm) {
            case BUBBLE:
                sortAlgorithm = new BubbleSort();
                break;
            case INSERTION:
                sortAlgorithm = new InsertionSort();
                break;
            case SELECTION:
                sortAlgorithm = new SelectionSort();
                break;
            default:
                sortAlgorithm = new BubbleSort();
        }
        long start = System.currentTimeMillis();
        sortAlgorithm.sort(arr, arr.length);
        long end = System.currentTimeMillis();
        Logger.logln(algorithm.toString() + "     耗时:" + (end - start) / 1000f + "s");
    }

    public void test(int datasize){
        test(Algorithm.BUBBLE,datasize);
        test(Algorithm.INSERTION,datasize);
        test(Algorithm.SELECTION,datasize);
    }

    private static Integer[] generateArr(int size) {
        Integer[] arr = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }
}
