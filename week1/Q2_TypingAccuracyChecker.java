public class Q2_TypingAccuracyChecker {

    // Compares original vs typed text character by character
    static void checkTypingAccuracy(String original, String typed) {
        int length = original.length();
        int matched = 0;
        int firstMismatchPosition = -1; // -1 means no mismatch found yet

        for (int i = 0; i < length; i++) {
            char originalChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (originalChar == typedChar) {
                matched++;
            } else if (firstMismatchPosition == -1) {
                // record only the very first mismatch (1-indexed position, as in the sample output)
                firstMismatchPosition = i + 1;
            }
        }

        double accuracy = (matched / (double) length) * 100;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, length, accuracy);

        if (firstMismatchPosition == -1) {
            System.out.println(" | No Mismatches");
        } else {
            char origMismatch = original.charAt(firstMismatchPosition - 1);
            char typedMismatch = typed.charAt(firstMismatchPosition - 1);
            System.out.println(" | First Mismatch at position " + firstMismatchPosition
                    + " ('" + origMismatch + "' vs '" + typedMismatch + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        // Expected: Matched: 10/11 | Accuracy: 90.91% | First Mismatch at position 11 ('d' vs 't')

        checkTypingAccuracy("coding", "coding");
        // Expected: Matched: 6/6 | Accuracy: 100.00% | No Mismatches
    }
}
