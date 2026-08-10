import java.util.Scanner;

public class q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base: ");
        double base = scanner.nextDouble();
        System.out.print("Enter exponent: ");
        int exponent = scanner.nextInt();

        double result = 1;
        int exp = Math.abs(exponent);

        for (int i = 0; i < exp; i++) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1.0 / result;
        }

        System.out.println(base + " ^ " + exponent + " = " + result);
        scanner.close();
    }
}
