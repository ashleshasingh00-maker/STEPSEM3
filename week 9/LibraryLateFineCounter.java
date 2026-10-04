import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return 2 * daysLate;
    }
}

class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        double fine = 5 * daysLate;
        return Math.min(fine, 50);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return 1 * daysLate;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            String title = tokens[1];
            int daysLate = Integer.parseInt(tokens[2]);

            if (type.equals("BOOK")) {
                items[i] = new Book(title, daysLate);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title, daysLate);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new Magazine(title, daysLate);
            }
        }

        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);
        sc.close();
    }
}
