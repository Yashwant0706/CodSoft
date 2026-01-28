
import java.util.*;

public class NumberGame {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalRounds = 0; //initially total rounds = 0, because not single match played
        int roundsWon = 0;  // Similarly "0" rounds Won 

        System.out.println("Welcome to the Number Game!");

        boolean playAgain = true; // playagian option is valid
        while (playAgain) {
            totalRounds++;
            int number = rand.nextInt(100); //1 to 100
            int attempts = 0; // counter for attempts starts from "0"
            int maxAttempts = 7; //maximum number of attempts given are "7"
            boolean isGuessed = false;

            System.out.println("I have selected a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts to guess it");

            while (attempts < maxAttempts) {
                System.out.println("Enter your guess :");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You have guessed the number in " + attempts + " attempts");
                    roundsWon++;
                    isGuessed = true;
                } else if (guess > number) {
                    System.out.println("Guessed too high! Try again.");
                } else {
                    System.out.println("Guessed too low ! Try again");
                }
            }
            if (isGuessed = false) {
                System.out.println("You have used all your attempts. The correct number is" + number);
            }

            // ----Score Display----
            System.out.println("Score");
            System.out.println("Rounds played :" + totalRounds);
            System.out.println("Rounds won:" + roundsWon);

            //  ----Option for PlayAgain----
            System.out.println("Do you want to play again? (yes/no) :");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("yes")) {
                playAgain = true;
            } else if (choice.equalsIgnoreCase("No")) {
                playAgain = false;
            }
        }
        System.out.println("Thanks for playing!");
        sc.close();
    }

}
