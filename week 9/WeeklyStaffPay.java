import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours, rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Staff[] staffList = new Staff[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];

            if (type.equals("FULLTIME")) {
                double salary = Double.parseDouble(tokens[2]);
                staffList[i] = new FullTimeStaff(name, salary);
            } else if (type.equals("HOURLY")) {
                double hours = Double.parseDouble(tokens[2]);
                double rate = Double.parseDouble(tokens[3]);
                staffList[i] = new HourlyStaff(name, hours, rate);
            } else if (type.equals("INTERN")) {
                double stipend = Double.parseDouble(tokens[2]);
                staffList[i] = new InternStaff(name, stipend);
            }
        }

        double totalPayroll = 0;
        for (Staff s : staffList) {
            double pay = s.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", s.getName(), pay);
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}
