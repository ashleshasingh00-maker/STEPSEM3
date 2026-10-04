import java.util.Scanner;

interface UsesTransport {
    double TRANSPORT_FEE = 12000; // interface fields are implicitly public static final
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    public String getName() {
        return name;
    }

    // Report asks "does this student use the bus?" via instanceof - no type-name checks
    final double getTotalFee() {
        double fee = calculateTuition();
        if (this instanceof UsesTransport) {
            fee += UsesTransport.TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholarStudent extends Student implements UsesTransport {
    public DayScholarStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000 + 60000;
    }
}

class ScholarStudent extends Student implements UsesTransport {
    public ScholarStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholarStudent(name);
            } else if (type.equals("HOSTELLER")) {
                students[i] = new HostellerStudent(name);
            } else if (type.equals("SCHOLAR")) {
                students[i] = new ScholarStudent(name);
            }
        }

        double totalCollected = 0;
        for (Student s : students) {
            double fee = s.getTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", s.getName(), fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
