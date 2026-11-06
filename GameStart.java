import Helper.TerminalColors;

public class GameStart {

    public static boolean playRound(PlayerInput playerInput, Player player, int roundsPlayed, Die die,
            int numberOfRounds, int score) {

        while (roundsPlayed <= numberOfRounds) {
            System.out.println(
                    "\nRound: " + roundsPlayed + " of " + numberOfRounds + " " + player.getName() + " score: "
                            + player.getScore());

            System.out.println(TerminalColors.BLUE + "\nRound: " + roundsPlayed + " of " + numberOfRounds + " | "
                    + player.getName() + "'s score: " + player.getScore() + TerminalColors.RESET);
            int guess = playerInput.readIntInRange(
                    TerminalColors.YELLOW + "Guess a number between 1 and " + die.getNumberOfSides() + ": "
                            + TerminalColors.RESET,
                    1, die.getNumberOfSides());

            die.roll();

            int diceValue = die.getCurrentValue();
            System.out.println(TerminalColors.CYAN + "\nThe dice landed on: " + diceValue + TerminalColors.RESET);

            if (guess == diceValue) {
                System.out.println(TerminalColors.GREEN + "You guessed correctly!" + TerminalColors.RESET);
                player.increaseScore();
            } else {
                System.out.println(TerminalColors.RED + "You guessed incorrectly!" + TerminalColors.RESET);
            }
            roundsPlayed++;

        }

        System.out.println(
                "\nGame over! Your final score is: " + player.getScore() + " points out of " + numberOfRounds
                        + " rounds.");

        System.out.print("Do you want to play again? (yes/no): ");
        String roundAnswer = playerInput.readLine();

        if (roundAnswer.equals("yes") || roundAnswer.equals("y")) {
            return true;
        } else {
            System.out.println("Thank you for playing! Goodbye!");
            return false;
        }
    }
}
