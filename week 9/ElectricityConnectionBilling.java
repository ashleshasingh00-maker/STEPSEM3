import java.util.Scanner;

abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
    abstract String getType();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        } else {
            return 100 * 5 + (units - 100) * 7;
        }
    }

    String getType() {
        return "HOME";
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8 + 100;
    }

    String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super(units);
    }

    double calculateBill() {
        double bill = units * 6;
        return Math.max(bill, 1000);
    }

    String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Connection[] connections = new Connection[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            int units = Integer.parseInt(tokens[1]);

            if (type.equals("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else if (type.equals("FACTORY")) {
                connections[i] = new FactoryConnection(units);
            }
        }

        double total = 0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", c.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
