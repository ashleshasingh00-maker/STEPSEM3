import java.util.Scanner;

interface NightServiceCapable {
    double NIGHT_SURCHARGE_PERCENT = 0.20;
}

abstract class Cab {
    abstract double getRatePerKm();
    abstract String getType();

    // Minimum fare rule shared by every cab
    final double calculateFare(double km) {
        double fare = km * getRatePerKm();
        return Math.max(fare, 100);
    }
}

class MiniCab extends Cab {
    double getRatePerKm() {
        return 10;
    }

    String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightServiceCapable {
    double getRatePerKm() {
        return 14;
    }

    String getType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightServiceCapable {
    double getRatePerKm() {
        return 18;
    }

    String getType() {
        return "SUV";
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            double km = Double.parseDouble(tokens[1]);
            String time = tokens[2];

            Cab cab;
            if (type.equals("MINI")) {
                cab = new MiniCab();
            } else if (type.equals("SEDAN")) {
                cab = new SedanCab();
            } else {
                cab = new SUVCab();
            }

            double baseFare = cab.calculateFare(km);

            if (time.equals("NIGHT")) {
                if (cab instanceof NightServiceCapable) {
                    double fare = baseFare * (1 + NightServiceCapable.NIGHT_SURCHARGE_PERCENT);
                    total += fare;
                    System.out.printf("%s: %.2f%n", cab.getType(), fare);
                } else {
                    System.out.println(cab.getType() + ": night service not available");
                }
            } else {
                total += baseFare;
                System.out.printf("%s: %.2f%n", cab.getType(), baseFare);
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
