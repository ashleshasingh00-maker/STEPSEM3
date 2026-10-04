import java.util.Scanner;

abstract class Ticket {
    protected static final double CONVENIENCE_FEE = 20;
    protected int count;

    public Ticket(int count) {
        this.count = count;
    }

    abstract double pricePerTicket();
    abstract String getSeatType();

    // Convenience fee written in exactly one place
    final double getAmount() {
        return count * (pricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    double pricePerTicket() {
        return 150;
    }

    String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    double pricePerTicket() {
        return 250;
    }

    String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    double pricePerTicket() {
        return 400;
    }

    String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String seat = tokens[0];
            int count = Integer.parseInt(tokens[1]);

            if (seat.equals("REGULAR")) {
                tickets[i] = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                tickets[i] = new PremiumTicket(count);
            } else if (seat.equals("RECLINER")) {
                tickets[i] = new ReclinerTicket(count);
            }
        }

        double total = 0;
        for (Ticket t : tickets) {
            double amount = t.getAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", t.getSeatType(), amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
