import java.util.Scanner;

abstract class Booking {
    protected static final double BOOKING_FEE = 50;
    protected double distanceKm;

    public Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateFare();
    abstract String getMode();

    // Common booking fee written in exactly one place
    final double getTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return 2 * distanceKm;
    }

    String getMode() {
        return "BUS";
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return 1.5 * distanceKm;
    }

    String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return 2500 + 4 * distanceKm;
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String mode = tokens[0];
            double distanceKm = Double.parseDouble(tokens[1]);

            if (mode.equals("BUS")) {
                bookings[i] = new BusBooking(distanceKm);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new TrainBooking(distanceKm);
            } else if (mode.equals("FLIGHT")) {
                bookings[i] = new FlightBooking(distanceKm);
            }
        }

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f%n", b.getMode(), b.getTotal());
        }

        sc.close();
    }
}
