public class Q1_AtmPinLengthValidator {

    // Checks that a PIN string is exactly 4 characters long
    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        checkPinLength("482");   // Expected: Invalid PIN — must be exactly 4 digits.
        checkPinLength("4820");  // Expected: PIN length OK.
    }
}
