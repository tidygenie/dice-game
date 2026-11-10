import Helper.TerminalColors;

public class GameStart {

    public static boolean playRound(PlayerInput playerInput, Player player, Die die, int numberOfRounds) {
        int roundsPlayed = 1;

        while (roundsPlayed <= numberOfRounds) {
            showRoundStatus(player, roundsPlayed, numberOfRounds);
            int guess = readGuess(playerInput, die);
            playSingleRound(guess, die, player);
            roundsPlayed++;
        }

        showFinalScore(player, numberOfRounds);
        return askToPlayAgain(playerInput);
    }

    private static void showRoundStatus(Player player, int roundsPlayed, int numberOfRounds) {
        System.out.println(TerminalColors.BLUE + "\n"
                + player.getName() + "'s score: " + player.getScore()
                + " | Round: " + roundsPlayed + " of " + numberOfRounds
                + TerminalColors.RESET);
    }

    private static int readGuess(PlayerInput playerInput, Die die) {
        return playerInput.readIntInRange(
                "Guess a number between 1 and " + die.getNumberOfSides() + ": ",
                1, die.getNumberOfSides());
    }

    private static void playSingleRound(int guess, Die die, Player player) {
        die.roll();

        int diceValue = die.getCurrentValue();
        System.out.println(TerminalColors.CYAN + "\nThe dice landed on: " + diceValue + TerminalColors.RESET);

        if (guess == diceValue) {
            System.out.println(TerminalColors.GREEN + "You guessed correctly!" + TerminalColors.RESET);
            player.increaseScore();
        } else {
            System.out.println(TerminalColors.RED + "You guessed incorrectly!" + TerminalColors.RESET);
        }
    }

    private static void showFinalScore(Player player, int numberOfRounds) {
        System.out.println(
                "\nGame over! Your final score is: " + player.getScore() + " points out of " + numberOfRounds
                        + " rounds.");
    }

    private static boolean askToPlayAgain(PlayerInput playerInput) {
        System.out.print("Do you want to play again? (yes/no): ");
        String roundAnswer = playerInput.readLine();

        if (roundAnswer.equals("yes") || roundAnswer.equals("y")) {
            return true;
        }

        System.out.println("Thank you for playing! Goodbye!");
        return false;
    }
}
