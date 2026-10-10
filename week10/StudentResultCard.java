import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }
        return (double) sum / marks.length;
    }

    String getGrade() {
        double avg = calculateAverage();

        if (avg >= 75) {
            return "B";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Each line looks like: Asha [80, 90, 70]
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            int bracketStart = line.indexOf('[');
            int bracketEnd = line.indexOf(']');

            String name = line.substring(0, bracketStart).trim();
            String[] parts = line.substring(bracketStart + 1, bracketEnd).split(",");

            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                marks[i] = Integer.parseInt(parts[i].trim());
            }

            Student s = new Student(name, marks);

            System.out.printf("%s: Average %.1f, Grade %s%n",
                    s.name.toUpperCase(), s.calculateAverage(), s.getGrade());
        }

        sc.close();
    }
}
