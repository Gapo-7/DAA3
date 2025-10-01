public class Metrics {
    public long comparisons = 0;
    public long swaps = 0;
    public long timeNs = 0;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        timeNs = 0;
    }

    @Override
    public String toString() {
        return comparisons + "," + swaps + "," + timeNs;
    }
}
