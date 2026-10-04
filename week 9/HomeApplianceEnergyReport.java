import java.util.Scanner;

interface SaverModeCapable {
    double SAVER_REDUCTION = 0.25;
}

abstract class Appliance {
    protected double powerWatts;

    public Appliance(double powerWatts) {
        this.powerWatts = powerWatts;
    }

    abstract String getName();

    double getPowerWatts() {
        return powerWatts;
    }
}

class Fridge extends Appliance {
    public Fridge() {
        super(150);
    }

    String getName() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverModeCapable {
    public AC() {
        super(1500);
    }

    String getName() {
        return "AC";
    }
}

class TV extends Appliance {
    public TV() {
        super(100);
    }

    String getName() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverModeCapable {
    public Washer() {
        super(500);
    }

    String getName() {
        return "WASHER";
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean saverRequested = tokens.length > 2 && tokens[2].equals("SAVER");

            Appliance appliance;
            if (type.equals("FRIDGE")) {
                appliance = new Fridge();
            } else if (type.equals("AC")) {
                appliance = new AC();
            } else if (type.equals("TV")) {
                appliance = new TV();
            } else {
                appliance = new Washer();
            }

            if (saverRequested && !(appliance instanceof SaverModeCapable)) {
                System.out.println(appliance.getName() + ": saver mode not supported");
                continue;
            }

            double units = appliance.getPowerWatts() * hours / 1000;
            if (saverRequested) {
                units = units * (1 - SaverModeCapable.SAVER_REDUCTION);
            }
            double cost = units * 8;
            totalCost += cost;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
