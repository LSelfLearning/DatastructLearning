package sort;

import common.Logger;

import java.util.Arrays;
import java.util.Random;

public class SortTestHelper {
    public enum Algorithm {
        BUBBLE, INSERTION, SELECTION, MERGE
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
            case MERGE:
                sortAlgorithm = new MergeSort();
                break;
            default:
                sortAlgorithm = new BubbleSort();
        }
        long start = System.currentTimeMillis();
        sortAlgorithm.sort(arr, arr.length);
        long end = System.currentTimeMillis();
        Logger.logln(algorithm.toString() + "     耗时:" + (end - start) / 1000f + "s");
    }

    public void test(Algorithm algorithm, Integer[] arr) {
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
            case MERGE:
                sortAlgorithm = new MergeSort();
                break;
            default:
                sortAlgorithm = new BubbleSort();
        }
        long start = System.currentTimeMillis();
        sortAlgorithm.sort(arr, arr.length);
        long end = System.currentTimeMillis();
        Logger.logln(algorithm.toString() + "     耗时:" + (end - start) / 1000f + "s");
    }

    public void test(int datasize) {
        Integer[] arr = generateArr(datasize);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        test(Algorithm.BUBBLE, arr);
        test(Algorithm.INSERTION, arr2);
        test(Algorithm.SELECTION, arr3);
        test(Algorithm.MERGE, arr4);
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
