package sort;

public class InsertionSort implements SortAlgorithm {
    @Override
    public void sort(Comparable[] arr, int n) {
        /**
         * 最初
         */
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j > 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    Comparable temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                } else {
//                    break;
//                }
//            }
//        }
        /**
         * 优化代码结构
         */
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j > 0 && (arr[j].compareTo(arr[j - 1]) < 0); j--) {
//                Comparable temp = arr[j];
//                arr[j] = arr[j - 1];
//                arr[j - 1] = temp;
//            }
//        }
        /**
         * 继续改进
         */
        for (int i = 1; i < n; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (arr[j - 1].compareTo(e) > 0) {
                    arr[j] = arr[j - 1];
                } else
                    break;
            }
            arr[j] = e;
        }

    }
}
