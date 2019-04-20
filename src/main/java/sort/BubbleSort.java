package sort;

public class BubbleSort implements SortAlgorithm {
    @Override
    public void sort(Comparable[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Comparable e = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = e;
                }
            }
        }
    }
}
