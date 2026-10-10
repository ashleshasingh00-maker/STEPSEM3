import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input looks like: [3, 8, 12, 5, 7, 10]
        String line = sc.nextLine().trim();
        line = line.replace("[", "").replace("]", "");
        String[] parts = line.split(",");

        int even = 0;
        int odd = 0;

        for (int i = 0; i < parts.length; i++) {
            int num = Integer.parseInt(parts[i].trim());

            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
