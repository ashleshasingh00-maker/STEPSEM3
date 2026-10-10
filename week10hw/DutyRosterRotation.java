import java.util.Arrays;

public class DutyRosterRotation {

    // Rotates the roster to the right by k places
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);   // remove full turns

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[(i + shift) % n] = names[i];   // name at i moves to (i + k) % n
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};

        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }

    /*
     * Complexity:
     *   Time  : O(n) - each name is placed once. k % n makes the size of k irrelevant.
     *   Space : O(n) - a new array holds the rotated roster.
     *
     * Why rotating one place at a time, k times, is slow:
     *   One single-place rotation touches all n names, so doing it k times costs
     *   O(n * k). With k up to 10^9 that is billions of steps, even though after
     *   every n rotations the roster is back to where it started - k % n skips
     *   all that wasted work.
     */
}
