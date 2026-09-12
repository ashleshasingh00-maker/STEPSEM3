class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyInfoManagement {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ravi", 45000);
        Employee e2 = new Employee("Anitha", 52000);
        Employee e3 = new Employee("Karthik", 48000);

        Employee.printCompanyInfo(); // called through the class name, not any object
    }
}
