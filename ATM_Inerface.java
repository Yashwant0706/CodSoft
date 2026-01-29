import java.util.*;

//----Class that manages the user's account details----//
class UserAccount{
   private double currentBalance;

   //----Constructor to set the initial balance----//
   UserAccount(double initialBalance){
      this.currentBalance = initialBalance;
   }

   //----deposit money to the account----//
   public void depositMoney(double amount){
      if(amount>0){
         currentBalance += amount;
         System.out.println("Deposit completed sucessfully.");
         }
      else{
            System.out.println("Enter a valid amount to deposit.");
         }

      //----Withdraws money from the account----//
         public void witdraMoney(double amount){
            if(amount > currentBlance){
               System.out.println("Transaction failed : Insufficient funds.");
            }
            else
         }

   }
}

