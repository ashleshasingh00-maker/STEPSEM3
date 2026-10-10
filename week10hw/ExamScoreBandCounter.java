public class ExamScoreBandCounter {

    // First index whose score is >= target (n if none)
    static int firstAtLeast(int[] scores, int target) {
        int lo = 0;
        int hi = scores.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) {
                hi = mid;        // mid could be the answer, keep looking left
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // First index whose score is > target (n if none)
    static int firstGreaterThan(int[] scores, int target) {
        int lo = 0;
        int hi = scores.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return firstGreaterThan(scores, high) - firstAtLeast(scores, low);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }

    /*
     * Complexity:
     *   Linear scan : O(n) time, O(1) space - checks every score for every query.
     *   Final answer: O(log n) time, O(1) space - two binary searches.
     *
     * Effect of duplicates at the edges:
     *   A normal binary search stops at ANY matching element, which could be the
     *   middle copy of 42 or 58. Counting would then be wrong. So the search must
     *   keep going after a match: for the low edge it moves left to find the FIRST
     *   score >= low, and for the high edge it finds the first score > high (just
     *   past the LAST copy of high). The difference counts every duplicate in the band.
     */
}
