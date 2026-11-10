import Helper.TerminalColors;

/**
 * Sets up and runs the dice game by collecting player choices and starting each
 * round.
 */
public class DiceGame {

        /** Reads and validates input entered by the player. */
        private final PlayerInput scanner = new PlayerInput();

        /**
         * Returns the input helper used by this game.
         *
         * @return this game's player input helper
         */
        public PlayerInput getPlayerInput() {
                return scanner;
        }

        /**
         * Starts the game and repeats it while the player chooses to play again.
         */
        public static void main(String[] args) {
                DiceGame diceGame = new DiceGame();

                welcomeHeading();

                boolean playAgain = true;

                while (playAgain) {
                        int numberOfRounds = diceGame.scanner.readIntInRange("How many rounds do you want to play? ", 2,
                                        Integer.MAX_VALUE);
                        int numberOfSides = diceGame.scanner.readIntInRange("How many sides should the die have? ", 2,
                                        Integer.MAX_VALUE);
                        String playerName = diceGame.scanner.readName("What is your name? ");

                        // Create the player and die using the chosen settings.
                        Player player = new Player(playerName);
                        Die die = new Die(numberOfSides);

                        // Show the player a summary of the game.
                        System.out.println(
                                        TerminalColors.BLUE + "\nHi, " + player.getName() + "! You are playing "
                                                        + numberOfRounds
                                                        + " rounds with a " + numberOfSides + " sided die."
                                                        + TerminalColors.RESET);

                        playAgain = GameStart.playRound(diceGame.getPlayerInput(), player, die, numberOfRounds);

                }
        }

        private static void welcomeHeading() {
                System.out.println(TerminalColors.CYAN
                                + "\n================ welcome to dice game! ================"
                                + TerminalColors.RESET);
        }
}
