public class ClassAttendanceTracker {

    // Returns {presentDays, longestStreak} in a single pass
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int current = 0;
        int longest = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                present++;
                current++;               // streak grows on every 1
                if (current > longest) {
                    longest = current;   // remember the largest value reached
                }
            } else {
                current = 0;             // streak resets on every 0
            }
        }

        return new int[] { present, longest };
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] r1 = attendanceSummary(days1);
        System.out.println("Present: " + r1[0] + ", Longest streak: " + r1[1]);

        int[] days2 = {0, 0, 0};
        int[] r2 = attendanceSummary(days2);
        System.out.println("Present: " + r2[0] + ", Longest streak: " + r2[1]);
    }

    /*
     * Complexity:
     *   Time  : O(n) - one pass over the days array.
     *   Space : O(1) - three counters only.
     *   Both answers are found in a single pass: 'present' and 'current' are
     *   updated together inside the same loop.
     */
}
