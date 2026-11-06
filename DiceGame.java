import Helper.TerminalColors;

/**
 * Sets up and runs the dice game by collecting player choices and starting each
 * round.
 */
public class DiceGame {
    
    private final PlayerInput scanner = new PlayerInput();  

    public PlayerInput getPlayerInput() {
        return scanner;
    }
        /** Reads and validates input entered by the player. */
        private final PlayerInput scanner = new PlayerInput();

        public static void main(String[] args) {
                DiceGame diceGame = new DiceGame();

        System.out.println("Hello, welcome to dice game!");
        boolean playAgain = true;

        while (playAgain) {
            int numberOfRounds = diceGame.scanner.readIntInRange("How many rounds do you want to play? ", 1,
                    Integer.MAX_VALUE);
            int numberOfSides = diceGame.scanner.readIntInRange("How many sides should the die have? ", 1,
                    Integer.MAX_VALUE);
            String playerName = diceGame.scanner.readName("What is your name? ");
                System.out.println(TerminalColors.CYAN + "\n================ welcome to dice game! ================"
                                + TerminalColors.RESET);

                while (true) {
                        // Get the game settings and the player's name.
                        int numberOfRounds = diceGame.scanner.readIntInRange("How many rounds do you want to play? ", 1,
                                        Integer.MAX_VALUE);
                        int numberOfSides = diceGame.scanner.readIntInRange("How many sides should the die have? ", 1,
                                        Integer.MAX_VALUE);
                        String playerName = diceGame.scanner.readName("What is your name? ");

                        // Create the player and die using the chosen settings.
                        Player player = new Player(playerName);
                        Die die = new Die(numberOfSides);

                        // Show the player a summary of the game.
                        System.out.println(TerminalColors.BLUE + "\nHi, " + player.getName() + "! You are playing "
                                        + numberOfRounds
                                        + " rounds with a " + numberOfSides + " sided die." + TerminalColors.RESET);

            int roundsPlayed = 1;

            playAgain = GameStart.playRound(diceGame.getPlayerInput(), player, roundsPlayed, die, numberOfRounds, player.getScore());

            
                        int roundsPlayed = 1;
                        GameStart.playRound(diceGame.scanner, player, roundsPlayed, die, numberOfRounds);

                        GameStart.endRound(player.getScore(), numberOfRounds, diceGame.scanner);

                }
        }
}