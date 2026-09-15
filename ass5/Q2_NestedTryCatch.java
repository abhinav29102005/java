package ass5;

public class Q2_NestedTryCatch {
    public static void main(String[] args) {
        System.out.println("Starting nested try-catch block execution...");

        try {
            // Outer try block
            System.out.println("Inside outer try block");
            
            try {
                // Inner try block 1
                System.out.println("Inside inner try block 1");
                int a = 10 / 0; // Throws ArithmeticException
            } catch (ArithmeticException e) {
                System.out.println("Inner Catch 1: Caught ArithmeticException -> " + e.getMessage());
            }

            try {
                // Inner try block 2
                System.out.println("Inside inner try block 2");
                String s = null;
                s.length(); // Throws NullPointerException
            } catch (ArrayIndexOutOfBoundsException e) {
                // This won't catch NullPointerException, so it propagates to the outer catch
                System.out.println("Inner Catch 2: Caught ArrayIndexOutOfBoundsException -> " + e.getMessage());
            }
            
            System.out.println("This statement won't execute if propagation happened.");

        } catch (NullPointerException e) {
            // Outer catch block catching the propagated exception
            System.out.println("Outer Catch: Caught Exception propagated from inner block -> " + e.getClass().getName());
        }

        System.out.println("Program continues normally after handling exceptions.");
    }
}
