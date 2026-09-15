package ass5;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Propagating exceptions to the caller using 'throws'
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero.");
        }
        balance += amount;
        System.out.println("Successfully deposited Rs. " + amount);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Current balance: Rs. " + balance);
        }
        balance -= amount;
        System.out.println("Successfully withdrew Rs. " + amount);
    }
}

public class Q5_BankingApp {
    private static BankAccount[] accounts = {
        new BankAccount("ACC100", 5000.0),
        new BankAccount("ACC101", 1500.0)
    };

    // Method to find an account, propagates AccountNotFoundException
    public static BankAccount findAccount(String accNumber) throws AccountNotFoundException {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException("Account number '" + accNumber + "' does not exist.");
    }

    public static void processTransaction(String accNum, String type, double amount) {
        try {
            System.out.println("\nProcessing " + type + " for account: " + accNum);
            BankAccount account = findAccount(accNum); // May throw AccountNotFoundException

            if (type.equalsIgnoreCase("deposit")) {
                account.deposit(amount); // May throw InvalidAmountException
            } else if (type.equalsIgnoreCase("withdraw")) {
                account.withdraw(amount); // May throw InvalidAmountException or InsufficientBalanceException
            }
            
            System.out.println("Current Account Balance: Rs. " + account.getBalance());

        } catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Banking Application ---");

        // 1. Successful Deposit
        processTransaction("ACC100", "deposit", 2000);

        // 2. Successful Withdrawal
        processTransaction("ACC100", "withdraw", 1000);

        // 3. Failed Withdrawal (Insufficient Balance)
        processTransaction("ACC101", "withdraw", 2000);

        // 4. Failed Deposit (Negative Amount)
        processTransaction("ACC101", "deposit", -500);

        // 5. Failed Transaction (Account Not Found)
        processTransaction("ACC999", "deposit", 1000);
    }
}
