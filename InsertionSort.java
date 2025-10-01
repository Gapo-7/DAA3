public class InsertionSort {

    public static void sort(int[] arr, Metrics m) {
        long start = System.nanoTime();
        if (arr.length < 2) { m.timeNs = 0; return; }

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                m.comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    m.swaps++;
                    j--;
                } else break;
            }
            arr[j + 1] = key;
        }
        m.timeNs = System.nanoTime() - start;
    }

    //optimized >>

    public static void sortWithSentinel(int[] arr, Metrics m) {
        if (arr.length < 2) return;

        int minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            m.comparisons++;
            if (arr[i] < arr[minIdx]) minIdx = i;
        }
        if (minIdx != 0) {
            int tmp = arr[0]; arr[0] = arr[minIdx]; arr[minIdx] = tmp;
            m.swaps++;
        }

        for (int i = 2; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (arr[j] > key) { // no bound check thanks to sentinel
                m.comparisons++;
                arr[j + 1] = arr[j];
                m.swaps++;
                j--;
            }
            m.comparisons++; // last failed comparison
            arr[j + 1] = key;
        }
    }
}
