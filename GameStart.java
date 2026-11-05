import java.util.Scanner;
public class GameStart {


    public static void playRound(Scanner scanner, Player player, int roundsPlayed, Die die, int numberOfRounds) {

        while (roundsPlayed <= numberOfRounds) {
            System.out.println("\nRound: " + roundsPlayed + " Player score: " + player.getScore());
            System.out.println("\nGuess a number between 1 and " + die.getNumberOfSides());

            int guess = scanner.nextInt();
            die.rollDie();
            int diceValue = die.getCurrentValue();
            System.out.println("The dice landed on: " + diceValue);

            if (guess == diceValue) {
                System.out.println("Correct!");
                player.increaseScore();
            } else {
                System.out.println("Incorrect!");
            }
            roundsPlayed++;
        }

        
    }

}
