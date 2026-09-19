public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        presentStudents = new String[maxClassSize];
        count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return; // already marked, avoid duplicate
        }
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("isPresent(Ben): " + sheet.isPresent("Ben"));
        System.out.println("isPresent(Chen): " + sheet.isPresent("Chen"));
    }
}
