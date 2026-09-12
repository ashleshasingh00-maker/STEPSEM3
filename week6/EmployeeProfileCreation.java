class ProfileEmployee {
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    // Permanent employees
    public ProfileEmployee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Interns - chains to the three-argument constructor with salary 0
    public ProfileEmployee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeProfileCreation {
    public static void main(String[] args) {
        ProfileEmployee permanent = new ProfileEmployee("E-101", "Divya", 65000);
        ProfileEmployee intern = new ProfileEmployee("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
