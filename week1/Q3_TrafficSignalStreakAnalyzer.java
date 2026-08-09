public class Q3_TrafficSignalStreakAnalyzer {

    // Finds the longest streak of consecutive identical characters in the log
    static void findLongestStreak(String signalLog) {
        int currentStreakLength = 1;
        char currentStreakColor = signalLog.charAt(0);

        int longestStreakLength = 1;
        char longestStreakColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {
            char currentChar = signalLog.charAt(i);

            if (currentChar == currentStreakColor) {
                currentStreakLength++;
            } else {
                // streak broken, reset tracker to the new color
                currentStreakColor = currentChar;
                currentStreakLength = 1;
            }

            if (currentStreakLength > longestStreakLength) {
                longestStreakLength = currentStreakLength;
                longestStreakColor = currentStreakColor;
            }
        }

        System.out.println("Longest Streak: '" + longestStreakColor + "' repeated "
                + longestStreakLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR"); // Expected: Longest Streak: 'G' repeated 3 times
        findLongestStreak("RRRRYYGG"); // Expected: Longest Streak: 'R' repeated 4 times
    }
}
