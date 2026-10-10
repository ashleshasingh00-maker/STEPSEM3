import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            long factorial = 1; 

            for (int i = 1; i <= n; i++) {
                factorial = factorial * i;
            }

            System.out.println(factorial);
        }

        sc.close();
    }
}
