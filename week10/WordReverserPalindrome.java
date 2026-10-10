import java.util.Scanner;

public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reads every word given (one per line) until input ends
        while (sc.hasNext()) {
            String word = sc.next();

            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            String reversed = sb.toString();

            if (word.equals(reversed)) {
                System.out.println(reversed + " - palindrome");
            } else {
                System.out.println(reversed + " - not a palindrome");
            }
        }

        sc.close();
    }
}
