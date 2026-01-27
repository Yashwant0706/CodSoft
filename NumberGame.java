
import java.util.*;

public class NumberGame {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalRounds = 0; //initially tottal rounds = 0, because not single match played
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
            sc.close();
        }
    }

}
