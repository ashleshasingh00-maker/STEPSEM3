public class Q5_WordLengthProfiler {

    // Classifies each word in a review as Short, Medium, or Long based on letter count
    static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+"); // split on any whitespace

        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();

            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else { // 9+ letters
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
        // Expected: Short: 3 | Medium: 1 | Long: 3
    }
}
