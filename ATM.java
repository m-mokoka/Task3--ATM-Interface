import java.util.Scanner;

public class ATM {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM");
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        // Validate user credentials
        if (!DummyDatabase.isValidUser(username, pin)) {
            System.out.println("Invalid credentials");
            return;
        }

        BankAccount userAccount = new BankAccount(1000); // Initial balance
        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: $" + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit was successful!");
                    System.out.println("New balance: $" + userAccount.getBalance());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= userAccount.getBalance() && withdrawAmount > 0) {
                        userAccount.withdraw(withdrawAmount);
                        System.out.println("Withdrawal was successful");
                    } else {
                        System.out.println("Insufficient funds or invalid amount, please enter valid amount");
                    }
                    System.out.println("New balance: $" + userAccount.getBalance());
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}