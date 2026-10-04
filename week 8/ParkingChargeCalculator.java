import java.util.Scanner;

abstract class Vehicle {
    String type;
    int hours;

    Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super("BIKE", hours);
    }

    double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super("CAR", hours);
    }

    double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super("TRUCK", hours);
    }

    double calculateCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0);
    }
}

public class ParkingChargeCalculator {

    static Vehicle createVehicle(String type, int hours) {
        switch (type) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            case "TRUCK":
                return new Truck(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            Vehicle vehicle = createVehicle(type, hours);
            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n", vehicle.type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
