package sort;

public class MergeSort2 implements SortAlgorithm {
    @Override
    public void sort(Comparable[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }

    /**
     * 对arr[l,r]区间内的数据进行排序
     */
    private void mergeSort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (r + l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
        merge(arr, l, mid, r);

    }

    /**
     * 将排序好的arr[l,mid]、arr[mid+1,r] merge
     */
    private void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];
        for (int i = l; i <= r; i++)
            aux[i - l] = arr[i];

        int leftIndex = l;
        int rightIndex = mid + 1;

        for (int i = l; i <= r; i++) {
            if (leftIndex > mid) {
                arr[i] = aux[rightIndex - l];
                rightIndex++;
            } else if (rightIndex > r) {
                arr[i] = aux[leftIndex - l];
                leftIndex++;
            } else if (aux[leftIndex - l].compareTo(aux[rightIndex - l]) > 0) {
                arr[i] = aux[rightIndex - l];
                rightIndex++;
            } else {
                arr[i] = aux[leftIndex - l];
                leftIndex++;
            }
        }
    }
}
