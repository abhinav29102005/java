package ass5;

import java.util.Scanner;

public class Q6_LoginSystem {
    private static final String CORRECT_USER = "admin";
    private static final String CORRECT_PASS = "password123";
    private static final int MAX_ATTEMPTS = 3;
    
    private static int failedAttempts = 0;
    private static boolean isLocked = false;

    public static void login(String username, String password) throws InvalidUsernameException, InvalidPasswordException, AccountLockedException {
        if (isLocked) {
            throw new AccountLockedException("Account is locked due to too many failed attempts. Please contact support.");
        }

        if (!username.equals(CORRECT_USER)) {
            failedAttempts++;
            checkLockStatus();
            throw new InvalidUsernameException("Username '" + username + "' is incorrect. Attempts left: " + (MAX_ATTEMPTS - failedAttempts));
        }

        if (!password.equals(CORRECT_PASS)) {
            failedAttempts++;
            checkLockStatus();
            throw new InvalidPasswordException("Password is incorrect. Attempts left: " + (MAX_ATTEMPTS - failedAttempts));
        }

        // If we reach here, login is successful
        System.out.println("Login successful! Welcome, " + username + ".");
        failedAttempts = 0; // Reset attempts on successful login
    }

    private static void checkLockStatus() {
        if (failedAttempts >= MAX_ATTEMPTS) {
            isLocked = true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Login System ---");

        try {
            while (!isLocked) {
                System.out.print("Enter Username: ");
                String user = scanner.nextLine();
                
                System.out.print("Enter Password: ");
                String pass = scanner.nextLine();
                
                try {
                    login(user, pass);
                    break; // Exit loop on successful login
                } catch (InvalidUsernameException | InvalidPasswordException e) {
                    System.out.println("Login Failed: " + e.getMessage());
                } catch (AccountLockedException e) {
                    System.out.println("FATAL: " + e.getMessage());
                }
            }
        } finally {
            scanner.close();
            System.out.println("Scanner closed. Login session ended.");
        }
    }
}
