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
     * 换句话说，将arr[l]放到正确的位置，返回该位置的index
     */
    private int partition(Comparable[] arr, int l, int r) {
        Comparable baseVal = arr[l];
        int rightBaseValIndex = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(baseVal) < 0) {
                rightBaseValIndex++;
                Comparable temp = arr[rightBaseValIndex];
                arr[rightBaseValIndex] = arr[i];
                arr[i] = temp;
            }
        }
        Comparable temp = arr[rightBaseValIndex];
        arr[rightBaseValIndex] = arr[l];
        arr[l] = temp;
        return rightBaseValIndex;
    }
}
