import Helper.TerminalColors;

/**
 * Runs the rounds of a dice game and handles the replay prompt.
 * The brain of the game 🧠
 */
public class GameStart {

    /**
     * Plays the requested number of rounds, displays the final score, and asks
     * whether the player wants to play again.
     *
     * @param playerInput    helper used to read the player's responses
     * @param player         player whose score is updated during the game
     * @param die            die used to determine each round's result
     * @param numberOfRounds number of rounds to play
     * @return {@code true} if the player wants to play again; otherwise
     *         {@code false}
     */
    public static boolean playRound(PlayerInput playerInput, Player player, Die die, int numberOfRounds) {
        int roundsPlayed = 1;
        boolean winner = false;

        while (roundsPlayed <= numberOfRounds && !winner) {
            showRoundStatus(player, roundsPlayed, numberOfRounds);
            int guess = readGuess(playerInput, die);
            winner = aSingleRound(guess, die, player);
            roundsPlayed++;
        }

        if (!winner) {
            showFinalScore(player, numberOfRounds);
        }

        return askToPlayAgain(playerInput);
    }

    /**
     * Displays the player's score and the current round number.
     *
     * @param player         player whose score is displayed
     * @param roundsPlayed   current round number
     * @param numberOfRounds total number of rounds in the game
     */
    private static void showRoundStatus(Player player, int roundsPlayed, int numberOfRounds) {
        System.out.println(TerminalColors.BLUE + "\n"
                + player.getName() + "'s score: " + player.getScore()
                + " | Round: " + roundsPlayed + " of " + numberOfRounds
                + TerminalColors.RESET);
    }

    /**
     * Reads a guess within the range of values the die can roll.
     *
     * @param playerInput helper used to read and validate the guess
     * @param die         die whose number of sides determines the valid range
     * @return the player's valid guess
     */
    private static int readGuess(PlayerInput playerInput, Die die) {
        return playerInput.readIntInRange(
                "Guess a number between 1 and " + die.getNumberOfSides() + ": ",
                1, die.getNumberOfSides());
    }

    /**
     * Rolls the die, displays its value, and updates the player's score if the
     * guess is correct.
     *
     * @param guess  the player's guess
     * @param die    die to roll
     * @param player player whose score may be increased
     */
    private static boolean aSingleRound(int guess, Die die, Player player) {
        die.roll();

        int diceValue = die.getCurrentValue();
        System.out.println(TerminalColors.CYAN + "\nThe dice landed on: " + diceValue + TerminalColors.RESET);

        if (guess == diceValue) {
            System.out.println(TerminalColors.GREEN + "You guessed correctly!" + TerminalColors.RESET);
            player.increaseScore();
        } else {
            System.out.println(TerminalColors.RED + "You guessed incorrectly!" + TerminalColors.RESET);
        }

        return checkWinner(player);

    }

    /**
     * Displays the player's final score.
     *
     * @param player         player whose score is displayed
     * @param numberOfRounds total number of rounds played
     */
    private static void showFinalScore(Player player, int numberOfRounds) {
        System.out.println(
                "\nGame over! Your final score is: " + player.getScore() + " points out of " + numberOfRounds
                        + " rounds.");
    }

    /**
     * Asks whether the player wants to start another game.
     *
     * @param playerInput helper used to read the player's response
     * @return {@code true} for "yes" or "y"; otherwise {@code false}
     */
    private static boolean askToPlayAgain(PlayerInput playerInput) {
        while (true) {

            System.out.print("Do you want to play again? (yes/no): ");
            String roundAnswer = playerInput.readLine();

            if (roundAnswer.equals("yes") || roundAnswer.equals("y")) {
                return true;
            }

            if (roundAnswer.equals("no") || roundAnswer.equals("n")) {
                System.out.println("Thank you for playing! Goodbye!");
                return false;
            }

            System.out.println(TerminalColors.RED + "Invalid answer. Please enter yes (y) or no (n)." + TerminalColors.RESET);
        }
    }

    /**
    *  Added a method to check if the player has won the game by reaching a score of 10 or more.
    *  @param player the player whose score is checked
    *  @return true if the player has won, false otherwise
    */ 
    public static boolean checkWinner(Player player) {
        if (player.getScore() >= 10) {
            System.out.println(
        "  .      .       .       .       .       .       .       .       .\n" +
        "    \\  |  /        \\  |  /        \\  |  /        \\  |  /        \\  |  /\n" +
        "  --  ★ ★  --    --  ★ ★  --    --  ★ ★  --    --  ★ ★  --    --  ★ ★  --\n" +
        "    /  |  \\        /  |  \\        /  |  \\        /  |  \\        /  |  \\\n" +
        " .      .       .       .       .       .       .       .       .\n" +
        "\n" +
        "  ██╗       ██╗██╗ ██████╗████████╗ ██████╗ ██████╗ ██╗   ██╗██╗██╗██╗\n" +
        "  ╚██╗     ██╔╝██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝██║██║██║\n" +
        "   ╚██╗   ██╔╝ ██║██║        ██║   ██║   ██║██████╔╝ ╚████╔╝ ██║██║██║\n" +
        "    ╚██╗ ██╔╝  ██║██║        ██║   ██║   ██║██╔══██╗  ╚██╔╝  ╚═╝╚═╝╚═╝\n" +
        "     ╚████╔╝   ██║╚██████╗   ██║   ╚██████╔╝██║  ██║   ██║   ██╗██╗██╗\n" +
        "      ╚══╝     ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝╚═╝╚═╝\n" +
        "\n" +
        " .      .       .       .       .       .       .       .       .\n" +
        "    \\  |  /        \\  |  /        \\  |  /        \\  |  /        \\  |  /\n" +
        "  --  ★ ★  --    --  ★ ★  --    --  ★ ★  --    --  ★ ★  --    --  ★ ★  --\n" +
        "    /  |  \\        /  |  \\        /  |  \\        /  |  \\        /  |  \\\n" +
        "  .      .       .       .       .       .       .       .       ."
            );
            System.out.println(TerminalColors.GREEN + "Congratulations, " + player.getName() + "! You won the game with a score of " + player.getScore() + "!" + TerminalColors.RESET);
            return true;
        } 
        return false;
    }
}