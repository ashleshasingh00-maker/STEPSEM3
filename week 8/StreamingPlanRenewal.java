import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewal {

    static Plan createPlan(String type, String name, LocalDate startDate) {
        switch (type) {
            case "BASIC":
                return new BasicPlan(name, startDate);
            case "STANDARD":
                return new StandardPlan(name, startDate);
            case "PREMIUM":
                return new PremiumPlan(name, startDate);
            default:
                throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            Plan plan = createPlan(type, name, startDate);
            LocalDate renewalDate = plan.getRenewalDate();

            System.out.println(plan.name + ": " + renewalDate);
        }

        sc.close();
    }
}
