import java.util.Scanner;

abstract class Transport {
    String type;
    double distance;

    Transport(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {
    Bus(double distance) {
        super("BUS", distance);
    }

    double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0); // max fare $10
    }
}

class Train extends Transport {
    Train(double distance) {
        super("TRAIN", distance);
    }

    double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class Metro extends Transport {
    double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            Transport transport;
            if (type.equals("BUS")) {
                transport = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                transport = new Train(distance);
            } else if (type.equals("METRO")) {
                double peakHourFactor = Double.parseDouble(parts[2]);
                transport = new Metro(distance, peakHourFactor);
            } else {
                throw new IllegalArgumentException("Unknown transport type: " + type);
            }

            double fare = transport.calculateFare();
            System.out.printf("%s: %.2f%n", transport.type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
