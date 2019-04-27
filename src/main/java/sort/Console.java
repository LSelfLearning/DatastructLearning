package sort;

import common.Logger;

import java.util.Arrays;
import java.util.Random;


public class Console {

    public static void main(String[] args) {
//        SortTestHelper sortTestHelper = new SortTestHelper();
//        sortTestHelper.test(100000);
        Random random = new Random();
        Integer[] arr = new Integer[20];
        for (int i = 0;i<20;i++){
            arr[i] = random.nextInt(300);
        }

//        Integer[] arr = new Integer[]{3,5,2,8,7};
        new QuickSort().sort(arr,arr.length);
        Logger.logln(Arrays.toString(arr));
    }
}
