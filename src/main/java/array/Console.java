package array;

import common.Logger;

public class Console {

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    //计算arr[left..n]这个区间内所有数字的和
    public static int sum(int[] arr,int left){
        if (left == arr.length)
            return 0;
        return arr[left]+sum(arr,left+1);
    }

    public static void main(String[] args){
        int[] arr2 = {1,2,3,4,5,6,7,8,9};
        Logger.logln(sum(arr2));
    }
}
