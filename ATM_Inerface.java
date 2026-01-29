
import java.util.*;

//----Class that manages the user's account details----//
class UserAccount {

    private double currentBalance;

    //----Constructor to set the initial balance----//
    UserAccount(double initialBalance) {
        this.currentBalance = initialBalance;
    }

    //----deposit money to the account----//
    public void depositMoney(double amount) {
        if (amount > 0) {
            currentBalance += amount;
            System.out.println("Deposit completed sucessfully.");
        } else {
            System.out.println("Enter a valid amount to deposit.");
        }
        //----Withdrawal money from the account----//
    public void withdrawalMoney(double amount){
        if (amount > currentBalance) {
            System.out.println("Transaction failed : Insufficient funds.");
        } else if {
            System.out.println()
        }
    }

}
}
