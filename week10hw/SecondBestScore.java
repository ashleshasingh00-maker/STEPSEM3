public class SecondBestScore {

    // Returns the second-highest distinct score, or -1 if it does not exist
    static int secondHighest(int[] scores) {
        int highest = -1;   // safe sentinel because scores are 0..100
        int second = -1;

        for (int i = 0; i < scores.length; i++) {
            int s = scores[i];

            if (s == highest) {
                continue;               // skip a score equal to the current highest
            }

            if (s > highest) {
                second = highest;       // old highest becomes second
                highest = s;
            } else if (s > second) {
                second = s;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println(secondHighest(scores1));

        int[] scores2 = {50, 50, 50};
        System.out.println(secondHighest(scores2));
    }

    /*
     * Complexity:
     *   Time  : O(n) - each score is visited once.
     *   Space : O(1) - two variables.
     *   Compared with sorting first: sorting costs O(n log n) time (and may need
     *   extra space), plus you still have to walk past duplicates to find the
     *   next distinct value. The single pass is faster and needs no sorting.
     */
}
