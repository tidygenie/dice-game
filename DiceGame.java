public class DiceGame {
    private final PlayerInput scanner = new PlayerInput();

    public static void main(String[] args) {
        DiceGame diceGame = new DiceGame();

        System.out.println("Hello, welcome to dice game!");

        while (true) {
            int numberOfRounds = diceGame.scanner.readIntInRange("How many rounds do you want to play? ", 1,
                    Integer.MAX_VALUE);
            int numberOfSides = diceGame.scanner.readIntInRange("How many sides should the die have? ", 1,
                    Integer.MAX_VALUE);
            String playerName = diceGame.scanner.readName("What is your name? ");

            Player player = new Player(playerName);
            Die die = new Die(numberOfSides);

            // Info message to user
            System.out
                    .println("\nHi, " + player.getName() + " You are playing " + numberOfRounds + " rounds" + " with a "
                            + numberOfSides + " sided die.");

            int roundsPlayed = 1;
            GameStart.playRound(diceGame.scanner, player, roundsPlayed, die.getDie(), numberOfRounds);

            GameStart.endRound(player.getScore(), numberOfRounds, diceGame.scanner);

        } 
    
    }

}
