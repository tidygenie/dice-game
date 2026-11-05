import java.util.Scanner;

public class GameStart {

    public static void playRound(Scanner scanner, Player player, int roundsPlayed, Die die, int numberOfRounds) {

        while (roundsPlayed <= numberOfRounds) {
            System.out.println("\nRound: " + roundsPlayed + "  Player score: " + player.getScore());
            System.out.println("\nGuess a number between 1 and " + die.getNumberOfSides());

            int guess = scanner.nextInt();
            die.rollDie();
            int diceValue = die.getCurrentValue();
            System.out.println("The dice landed on: " + diceValue);

            if (guess == diceValue) {
                System.out.println("You guessed correctly!The number was: " + diceValue);
                player.increaseScore();
            } else {
                System.out.println("You guessed incorrectly! The number was: " + diceValue);
            }
            System.out.println("Your current score is: " + player.getScore());
            roundsPlayed++;
        }

    }

 public static void endRound(){
    System.out.println("\nGame over! Your final score is: " + player.getScore() + " out of " + numberOfRounds + " rounds.");
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = diceGame.scanner.next().trim().toLowerCase();   
            if (!playAgainInput.equals("yes")) {
                System.out.println("Thank you for playing! Goodbye!");
                break;
            }
 }




}
