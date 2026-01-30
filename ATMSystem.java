
import java.util.Scanner;

// Class that manages the user's account details
class UserAccount {

    private double currentBalance;

    // Constructor
    UserAccount(double initialBalance) {
        this.currentBalance = initialBalance;
    }

    // Deposit money
    public void depositMoney(double amount) {
        if (amount > 0) {
            currentBalance += amount;
            System.out.println("Deposit completed successfully.");
        } else {
            System.out.println("Enter a valid amount to deposit.");
        }
    }

    // Withdraw money
    public void withdrawMoney(double amount) {
        if (amount > currentBalance) {
            System.out.println("Transaction failed: Insufficient funds.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount entered.");
        } else {
            currentBalance -= amount;
            System.out.println("Please collect your cash.");
        }
    }

    // View balance
    public double viewBalance() {
        return currentBalance;
    }
}

// Main ATM class
public class ATMSystem {

    static void askToShowBalance(Scanner input, UserAccount account) {
        System.out.print("Do you want to see your balance? (yes/no): ");
        String choice = input.next();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Available Balance: Rs " + account.viewBalance());
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        UserAccount myAccount = new UserAccount(10000);

        int option = 0;

        do {
            System.out.println("\n====== WELCOME TO ATM SERVICE ======");
            System.out.println("1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. View Account Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // ✅ Safe menu input
            if (!input.hasNextInt()) {
                System.out.println("Please enter a valid number (1–4).");
                input.next(); // clear invalid input
                continue;
            }

            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = input.nextDouble();
                    myAccount.withdrawMoney(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = input.nextDouble();
                    myAccount.depositMoney(depositAmount);
                    break;

                case 3:
                    System.out.println("Available Balance: Rs " + myAccount.viewBalance());
                    break;

                case 4:
                    System.out.println("Session ended. Have a great day!");
                    break;

                default:
                    System.out.println("Invalid selection. Please choose again.");
            }

        } while (option != 4);

        input.close();
    }
}
