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
     * 将排好序的arr[l...mid]和arr[mid+1...r]两部分进行归并
     */
    private void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];
        //将要merge的数据放到临时数组里
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int leftPartIndex = l;
        int rightPartIndex = mid + 1;

        for (int cur = l; cur <= r; cur++) {

            if (leftPartIndex > mid) {
                //左半边部分遍历结束时，将右半边部分依次放入数组相应位置
                arr[cur] = aux[rightPartIndex - l];
                rightPartIndex++;

            } else if (rightPartIndex > r) {
                //右半边部分遍历结束时，将左半边部分依次放入数组相应位置
                arr[cur] = aux[leftPartIndex - l];
                leftPartIndex++;

            } else if (aux[leftPartIndex - l].compareTo(aux[rightPartIndex - l]) < 0) {
                //左半边元素比右半边元素小，将左半边元素放入数组相应位置
                arr[cur] = aux[leftPartIndex - l];
                leftPartIndex++;
            } else {
                //右半边元素比左半边元素小，将右半边元素放入数组相应位置
                arr[cur] = aux[rightPartIndex - l];
                rightPartIndex++;
            }
        }

    }

}
