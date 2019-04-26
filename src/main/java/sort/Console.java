package sort;

import common.Logger;

import java.util.Arrays;
import java.util.Random;


public class Console {

    public static void main(String[] args) {
//        SortTestHelper sortTestHelper = new SortTestHelper();
//        sortTestHelper.test(100000);
        Random random = new Random();
        int[] arr = new int[20];
        for (int i = 0;i<20;i++){
            arr[i] = random.nextInt(300);
        }
        QuickSort2.quickSort(arr,0,arr.length-1);
        Logger.logln(Arrays.toString(arr));
    }
}
