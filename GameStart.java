import Helper.TerminalColors;

public class GameStart {

    public static boolean playRound(PlayerInput playerInput, Player player, int roundsPlayed, Die die, int numberOfRounds, int score) {

        while (roundsPlayed <= numberOfRounds) {
            System.out.println(
                    "\nRound: " + roundsPlayed + " of " + numberOfRounds + " " + player.getName() + " score: "
                            + player.getScore());
            int guess = playerInput.readIntInRange("Guess a number between 1 and " + die.getNumberOfSides() + ": ", 1,
                    die.getNumberOfSides());
            System.out.println(TerminalColors.BLUE + "\nRound: " + roundsPlayed + " of " + numberOfRounds + " | "
                    + player.getName() + "'s score: " + player.getScore() + TerminalColors.RESET);
            int guess = input.readIntInRange(
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
                "\nGame over! Your final score is: " + player.getScore() + " points out of " + numberOfRounds + " rounds.");

            System.out.print("Do you want to play again? (yes/no): ");
            String roundAnswer = playerInput.readLine();

            if (roundAnswer.equals("yes") || roundAnswer.equals("y")) {
                return true;
            } else {
                System.out.println("Thank you for playing! Goodbye!");
                return false;
            }
    // TODO: Do you want to play again? (yes/no): dyker inte upp efter alla omgågnar
    public static void endRound(int score, int numberOfRounds, PlayerInput playerInput) {

        System.out.println(TerminalColors.BLUE + "\nGame over! Your final score is: " + score + " out of "
                + numberOfRounds + " rounds." + TerminalColors.RESET);

        System.out.print("Do you want to play again? (yes/no): ");
        String answer = playerInput.readLine();
        if (!answer.equals("yes") && !answer.equals("y")) {
            System.out.println(TerminalColors.GREEN + "Thank you for playing! Goodbye!" + TerminalColors.RESET);
            playerInput.scannerClose();
            System.out.print(TerminalColors.YELLOW + "Do you want to play again? (yes/no): " + TerminalColors.RESET);
        }
    }

}
