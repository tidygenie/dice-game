import Helper.TerminalColors;

public class GameStart {

    public static void playRound(PlayerInput input, Player player, int roundsPlayed, Die die, int numberOfRounds) {

        while (roundsPlayed <= numberOfRounds) {
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
    }

    // TODO: Do you want to play again? (yes/no): dyker inte upp efter alla omgågnar
    public static void endRound(int score, int numberOfRounds, PlayerInput playerInput) {

        System.out.println(TerminalColors.BLUE + "\nGame over! Your final score is: " + score + " out of "
                + numberOfRounds + " rounds." + TerminalColors.RESET);

        System.out.print("Do you want to play again? (yes/no): ");
            String answer = playerInput.readLine();
        if (!answer.equals("yes") && !answer.equals("y")) {
            System.out.println("Thank you for playing! Goodbye!");
            playerInput.scannerClose();
        System.out.print(TerminalColors.YELLOW + "Do you want to play again? (yes/no): " + TerminalColors.RESET);

        if (!playerInput.equals("yes") && !playerInput.equals("y")) {
            System.out.println(TerminalColors.GREEN + "Thank you for playing! Goodbye!" + TerminalColors.RESET);
        }
    }
}
