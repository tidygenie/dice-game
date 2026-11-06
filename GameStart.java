public class GameStart {

    public static void playRound(PlayerInput playerInput, Player player, int roundsPlayed, Die die, int numberOfRounds, int score) {

        while (roundsPlayed <= numberOfRounds) {
            System.out.println(
                    "\nRound: " + roundsPlayed + " av " + numberOfRounds + " " + player.getName() + " score: "
                            + player.getScore());
            int guess = playerInput.readIntInRange("Guess a number between 1 and " + die.getNumberOfSides() + ": ", 1,
                    die.getNumberOfSides());

            die.roll();

            int diceValue = die.getCurrentValue();
            System.out.println("\nThe dice landed on: " + diceValue);

            if (guess == diceValue) {
                System.out.println("You guessed correctly!");
                player.increaseScore();
            } else {
                System.out.println("You guessed incorrectly!");
            }
            roundsPlayed++;

            System.out.println(
                "\nGame over! Your final score is: " + score + " out of " + numberOfRounds + " rounds.");

            System.out.print("Do you want to play again? (yes/no): ");

            if (!playerInput.equals("yes") && !playerInput.equals("y")) {
            System.out.println("Thank you for playing! Goodbye!");
            }


        }
    }

}
