public class Q2_WordReversalEncoder {

    // Reverses each word individually while keeping word order the same
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();

            // build the reversed word manually with a loop
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversedWord.append(words[i].charAt(j));
            }

            result.append(reversedWord);

            if (i < words.length - 1) {
                result.append(" "); // keep single-space separation between words
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club")); // Expected: olleh bulc
    }
}
