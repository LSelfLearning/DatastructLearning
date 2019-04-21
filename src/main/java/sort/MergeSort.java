package sort;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(Comparable[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }

    /**
     * 递归使用归并排序,对arr[l...r]的范围进行排序
     */
    private void mergeSort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     */
    private void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];
        //将要merge的数据放到临时数组里
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int leftPartIndex = l;
        int rightPartIndex = mid + 1;
        for (int k = l; k <= r; k++) {
            if (leftPartIndex > mid) {
                arr[k] = aux[rightPartIndex - l];
                rightPartIndex++;
            } else if (rightPartIndex > r) {
                arr[k] = aux[leftPartIndex - l];
                leftPartIndex++;
            } else if (aux[leftPartIndex - l].compareTo(aux[rightPartIndex - l]) < 0) {
                arr[k] = aux[leftPartIndex - l];
                leftPartIndex++;
            } else {
                arr[k] = aux[rightPartIndex - l];
                rightPartIndex++;
            }
        }

    }
}
