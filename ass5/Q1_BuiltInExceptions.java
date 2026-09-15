package ass5;

public class Q1_BuiltInExceptions {
    public static void main(String[] args) {
        System.out.println("Demonstrating Built-in Exceptions:");

        // 1. ArithmeticException
        try {
            int a = 10, b = 0;
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        // 2. NullPointerException
        try {
            String str = null;
            System.out.println("Length: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }

        // 3. ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[5];
            arr[10] = 50; // Accessing invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // 4. NumberFormatException
        try {
            String notANumber = "XYZ";
            int num = Integer.parseInt(notANumber);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }
        
        System.out.println("All exceptions handled successfully.");
    }
}
