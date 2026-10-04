import java.util.Scanner;

abstract class Customer {
    String type;
    double amount;

    Customer(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class Student extends Customer {
    Student(double amount) {
        super("STUDENT", amount);
    }

    double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super("STAFF", amount);
    }

    double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super("GUEST", amount);
    }

    double calculateFinalAmount() {
        return amount + 10; // full amount plus service charge
    }
}

public class CanteenBillingSystem {

    // Factory - the only place that knows about concrete types
    static Customer createCustomer(String type, double amount) {
        switch (type) {
            case "STUDENT":
                return new Student(amount);
            case "STAFF":
                return new Staff(amount);
            case "GUEST":
                return new Guest(amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            // Main loop never checks type - it just calls the common method
            Customer customer = createCustomer(type, amount);
            double finalAmount = customer.calculateFinalAmount();

            System.out.printf("%s: %.2f%n", customer.type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
