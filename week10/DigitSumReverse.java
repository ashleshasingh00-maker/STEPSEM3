import java.util.Scanner;

public class DigitSumReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int sum = 0;
        int reverse = 0;

        while (number > 0) {
            int digit = number % 10;  
            sum = sum + digit;
            reverse = reverse * 10 + digit;
            number = number / 10;    
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
        sc.close();
    }
}
