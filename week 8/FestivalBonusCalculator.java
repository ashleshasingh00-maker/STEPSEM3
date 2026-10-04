import java.util.Scanner;

abstract class Employee {
    String name;
    double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {

    static Employee createEmployee(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            case "INTERN":
                return new Intern(name, salary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            Employee employee = createEmployee(type, name, salary);
            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", employee.name, bonus);
            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        sc.close();
    }
}
