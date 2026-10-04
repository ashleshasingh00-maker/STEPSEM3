import java.util.Scanner;

abstract class Delivery {
    String type;
    double weight;
    double distance;

    Delivery(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliveryFeeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            Delivery delivery;
            if (type.equals("STANDARD")) {
                delivery = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                delivery = new ExpressDelivery(weight, distance);
            } else if (type.equals("INTERNATIONAL")) {
                double customsFee = Double.parseDouble(parts[3]);
                delivery = new InternationalDelivery(weight, distance, customsFee);
            } else {
                throw new IllegalArgumentException("Unknown delivery type: " + type);
            }

            double fee = delivery.calculateFee();
            System.out.printf("%s: %.2f%n", delivery.type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
