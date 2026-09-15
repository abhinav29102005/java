package library.util;

public class InputValidator {

    public static boolean validateResourceId(String resourceId) {
        if (resourceId == null || resourceId.trim().isEmpty()) {
            return false;
        }
        
        // Ensure the ID parses to an integer greater than 0, assuming resource IDs are numeric strings
        try {
            int id = Integer.parseInt(resourceId);
            return id > 0;
        } catch (NumberFormatException e) {
            // For this assignment, we will consider any non-empty string as valid if it's alphanumeric,
            // but the requirement explicitly says Resource ID (>0). So we enforce numeric check here.
            return false;
        }
    }

    public static boolean validateFineDays(int overdueDays) {
        return overdueDays >= 0;
    }
}
