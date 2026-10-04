import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
    abstract String getType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8;
    }

    String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6.0) / occupants;
    }

    String getType() {
        return "SHARED";
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 10 + 200;
    }

    String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            int units = Integer.parseInt(tokens[1]);

            if (type.equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = Integer.parseInt(tokens[2]);
                rooms[i] = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                rooms[i] = new ACRoom(units);
            }
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", r.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
