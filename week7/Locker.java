public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (currentCode.equals(code)) {
            code = newCode;
            return true; // success
        }
        return false; // rejected - code stays the same
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        boolean result1 = l.changeCode("1234", "5678");
        System.out.println("changeCode(1234, 5678) success: " + result1);

        boolean result2 = l.changeCode("0000", "9999");
        System.out.println("changeCode(0000, 9999) success: " + result2);
    }
}
