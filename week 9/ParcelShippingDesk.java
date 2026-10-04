import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
    abstract String getType();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return 40 + 10 * weightKg;
    }

    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return 80 + 15 * weightKg;
    }

    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        double standardCharge = 40 + 10 * weightKg;
        return standardCharge + 50;
    }

    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            double weight = Double.parseDouble(tokens[1]);
            double declaredValue = Double.parseDouble(tokens[2]);

            if (type.equals("STANDARD")) {
                parcels[i] = new StandardParcel(weight, declaredValue);
            } else if (type.equals("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, declaredValue);
            } else if (type.equals("FRAGILE")) {
                parcels[i] = new FragileParcel(weight, declaredValue);
            }
        }

        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = (p instanceof Insurable) ? ((Insurable) p).calculateInsurance() : 0;
            double total = charge + insurance;
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.getType(), charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
