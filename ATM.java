import java.util.Scanner;

public class ATM {
    private UserAccount userAccount;

    public ATM(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Current Balance: " + userAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = getUserInput();
                userAccount.deposit(depositAmount);
                System.out.println("New Balance: " + userAccount.getBalance());
                break;
            case 3:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = getUserInput();
                boolean withdrawalSuccess = userAccount.withdraw(withdrawalAmount);
                if (withdrawalSuccess) {
                    System.out.println("Withdrawal successful. New Balance: " + userAccount.getBalance());
                }
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private double getUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            double amount = 0;
            try {
                amount = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
            return amount;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();

            UserAccount userAccount = DummyDatabase.getUserAccount(username, pin);

            if (userAccount == null) {
                System.out.println("Invalid username or PIN. Exiting.");
                System.exit(0);
            }

            ATM atm = new ATM(userAccount);

            while (true) {
                atm.displayOptions();
                System.out.print("Enter option: ");
                int option = (int) atm.getUserInput();
                atm.processOption(option);
                System.out.println(); // Add a newline for better readability
            }
        }
    }
}