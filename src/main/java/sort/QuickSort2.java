package sort;

public class QuickSort2 implements SortAlgorithm {
    @Override
    public void sort(Comparable[] arr, int n) {

    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int partition = partition(arr, l, r);
        //递归调用左半数组
        quickSort(arr, l, partition - 1);
        //递归调用右半数组
        quickSort(arr, partition + 1, r);
    }

    /**
     * 某网友的写法
     */
    private static int partition(int[] arr, int l, int r) {
        int leftIndex, rightIndex, baseVal;
        leftIndex = l;
        rightIndex = r;
        baseVal = arr[leftIndex];
        while (leftIndex < rightIndex) {
            while (baseVal <= arr[rightIndex] && leftIndex < rightIndex) {
                rightIndex--;
            }
            while (baseVal >= arr[leftIndex] && leftIndex < rightIndex) {
                leftIndex++;
            }
            //如果满足条件则交换
            if (leftIndex < rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[l] = arr[leftIndex];
        arr[leftIndex] = baseVal;
        return leftIndex;
    }
}
