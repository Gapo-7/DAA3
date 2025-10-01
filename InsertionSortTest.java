import java.util.Arrays;
import java.util.Random;

public class InsertionSortTest {

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) if (a[i-1] > a[i]) return false;
        return true;
    }

    private static int[] copy(int[] a) { return Arrays.copyOf(a, a.length); }

    private static void testEmpty() {
        int[] a = {};
        Metrics m = new Metrics();
        InsertionSort.sort(a, m);
        assert isSorted(a);
    }

    private static void testSingle() {
        int[] a = {42};
        Metrics m = new Metrics();
        InsertionSort.sort(a, m);
        assert isSorted(a);
    }

    private static void testDuplicates() {
        int[] a = {5, 1, 5, 1, 5, 1};
        Metrics m = new Metrics();
        InsertionSort.sort(a, m);
        assert isSorted(a);
    }

    private static void testSorted() {
        int[] a = {1,2,3,4,5};
        Metrics m = new Metrics();
        InsertionSort.sort(a, m);
        assert isSorted(a);
    }

    private static void testReverse() {
        int[] a = {5,4,3,2,1};
        Metrics m = new Metrics();
        InsertionSort.sort(a, m);
        assert isSorted(a);
    }

    private static void testRandom() {
        Random rnd = new Random(7);
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) a[i] = rnd.nextInt(1_000_000);
        Metrics m = new Metrics();
        InsertionSort.sort(a, m);
        assert isSorted(a);
    }

    public static void main(String[] args) {
        testEmpty();
        testSingle();
        testDuplicates();
        testSorted();
        testReverse();
        testRandom();
        System.out.println("InsertionSort: ALL TESTS PASSED");
    }
}
