import java.util.Scanner;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowingDays();

    LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowingDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 3;
    }
}

public class LibraryDueDateCalculator {

    // Fixed "current date" as stated in the problem
    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new DVD(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Pattern titlePattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            // First token is the item type
            String type = line.substring(0, line.indexOf(' ')).trim();

            // Title is whatever is inside the quotes
            Matcher matcher = titlePattern.matcher(line);
            String title = "";
            if (matcher.find()) {
                title = matcher.group(1);
            }

            LibraryItem item = createItem(type, title);
            LocalDate dueDate = item.getDueDate(CURRENT_DATE);

            System.out.println(item.title + ": " + dueDate);
        }

        sc.close();
    }
}
