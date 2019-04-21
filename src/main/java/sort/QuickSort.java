package sort;

public class QuickSort implements SortAlgorithm {
    @Override
    public void sort(Comparable[] arr, int n) {
        quickSort(arr, 0, n - 1);
    }

    /**
     * 对arr[l,r]部分进行快速排序
     */
    private void quickSort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    /**
     * 对arr[l,r]部分进行partition操作，返回p，使得arr[l,p-1] < arr[p];
     * arr[p+1,r] > arr[p]
     */
    private int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                Comparable temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        Comparable temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        return j;
    }
}
