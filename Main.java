import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

    public static int[] randomArray(int n, int seed) {
        Random rand = new Random(seed);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000000);
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        String csvFile = "results_insertion.csv";
        try (PrintWriter pw = new PrintWriter(new FileWriter(csvFile))) {
            pw.println("n,comparisons,swaps,time_ns");

            int[] sizes = {100, 500, 1000, 5000, 10000};

            for (int n : sizes) {
                Metrics m = new Metrics();
                int[] arr = randomArray(n, 42);
                InsertionSort.sort(arr, m);
                pw.printf("%d,%d,%d,%d%n", n, m.comparisons, m.swaps, m.timeNs);
                System.out.printf("n=%d done%n", n);
            }
        }
        System.out.println("Results saved to results_insertion.csv");
    }
}
