import java.util.HashMap;
import java.util.Map;

public class DummyDatabase {
    private static Map<String, UserAccount> userAccounts = new HashMap<>();

    static {
        // Dummy data
        userAccounts.put("user123", new UserAccount("user123", "1234", 1500.0));
        userAccounts.put("user456", new UserAccount("user456", "5678", 2000.0));
    }

    public static UserAccount getUserAccount(String username, String pin) {
        UserAccount userAccount = userAccounts.get(username);
        if (userAccount != null && userAccount.verifyPin(pin)) {
            return userAccount;
        }
        return null;
    }
}

class UserAccount {
    private String username;
    private String pin;
    private double balance;

    public UserAccount(String username, String pin, double initialBalance) {
        this.username = username;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
        return false;
    }
}