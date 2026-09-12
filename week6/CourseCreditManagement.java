class Course {
    private String code;
    private String title;
    private int credits;
    private int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Theory-only courses - chains to the four-argument constructor
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }

    String getCode() {
        return code;
    }
}

public class CourseCreditManagement {
    public static void main(String[] args) {
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryCourse.getCode() + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.getCode() + " total credits: " + labCourse.totalCredits());
    }
}
