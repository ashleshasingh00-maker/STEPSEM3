public class Q4_LibraryIsbnNormalizer {

    // Trims whitespace and uppercases only the first 3 characters (publisher code)
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed; // too short to normalize a publisher code; validation will catch it
        }

        String publisherPart = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);

        return publisherPart + remainder;
    }

    // Validates the normalized code and builds the formatted display line
    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7, 13);

        // publisher code must be 3 letters
        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // year + catalog number (remaining 10 characters) must all be digits
        String body = year + catalogNumber;
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining 10 characters must be digits";
            }
        }

        StringBuilder display = new StringBuilder();
        display.append("[").append(publisherCode).append("] ");
        display.append("YEAR: ").append(year).append(" | ");
        display.append("CATALOG: ").append(catalogNumber);

        return display.toString();
    }

    public static void main(String[] args) {
        String raw1 = " pen2026004251 ";
        String normalized1 = normalizeCode(raw1);
        System.out.println(validateAndFormat(normalized1));
        // Expected: [PEN] YEAR: 2026 | CATALOG: 004251

        String raw2 = "12N2026004251";
        String normalized2 = normalizeCode(raw2);
        System.out.println(validateAndFormat(normalized2));
        // Expected: Invalid: publisher code must be 3 letters
    }
}
