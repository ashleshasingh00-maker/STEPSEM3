import java.util.Scanner;

abstract class PaymentTransaction {
    String type;
    double amount;

    PaymentTransaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract double calculateAdjustedAmount();
}

class CardTransaction extends PaymentTransaction {
    CardTransaction(double amount) {
        super("CARD", amount);
    }

    double calculateAdjustedAmount() {
        return amount * 1.02; // 2% processing fee
    }
}

class WalletTransaction extends PaymentTransaction {
    WalletTransaction(double amount) {
        super("WALLET", amount);
    }

    double calculateAdjustedAmount() {
        return amount * 1.01; // 1% processing fee
    }
}

class BankTransferTransaction extends PaymentTransaction {
    BankTransferTransaction(double amount) {
        super("BANKTRANSFER", amount);
    }

    double calculateAdjustedAmount() {
        return amount; // no processing fee
    }
}

public class PaymentFeeCalculator {

    static PaymentTransaction createTransaction(String type, double amount) {
        switch (type) {
            case "CARD":
                return new CardTransaction(amount);
            case "WALLET":
                return new WalletTransaction(amount);
            case "BANKTRANSFER":
                return new BankTransferTransaction(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
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

            PaymentTransaction txn = createTransaction(type, amount);
            double adjusted = txn.calculateAdjustedAmount();

            System.out.printf("%s: %.2f%n", txn.type, adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
