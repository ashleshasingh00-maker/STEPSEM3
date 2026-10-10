import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input looks like: [11, 22, 33, 44]
        String line = sc.nextLine().trim();
        line = line.replace("[", "").replace("]", "");
        String[] parts = line.split(",");

        int[] tokens = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            tokens[i] = Integer.parseInt(parts[i].trim());
        }

        // Two pointers - swap and move towards the centre (no second array)
        int left = 0;
        int right = tokens.length - 1;

        while (left < right) {
            int temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(tokens));
        sc.close();
    }
}
