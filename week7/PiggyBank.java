public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= savings) {
            savings -= amount;
        }
        // if amount > savings, withdrawal is rejected - savings stays unchanged
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("After deposit(100): " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After withdraw(30): " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("After withdraw(500) - rejected: " + pb.getSavings());
    }
}
