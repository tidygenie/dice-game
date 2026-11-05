import java.util.Scanner;

public class DiceGame {
    // private final Scanner scanner;
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DiceGame diceGame = new DiceGame();

        // // Die die = new Die();
        // Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, welcome to dice game!");
        // boolean playAgain = true;

        while (true) {

            int numberOfRounds = diceGame.readIntInRange("How many rounds do you want to play? ", 1, Integer.MAX_VALUE);
            int numberOfSides = diceGame.readIntInRange("How many sides should the die have? ", 1, Integer.MAX_VALUE);

            // Läser användarens namn
            var playerName = diceGame.readName();
            Player player = new Player(playerName);

            // Create dice
            player.addDie(numberOfSides);

            int roundsPlayed = 1;

            
            GameStart.playRound(diceGame.scanner, player, roundsPlayed, Die.die, numberOfRounds);
           
        }

        // int numberOfRounds = readIntInRange("How many rounds do you want to play?",
        // 1, Integer.MAX_VALUE);
        // int numberOfSides = readIntInRange("How many sides should the die have?", 1,
        // Integer.MAX_VALUE);

    }

    /**
     * Reads an integer within a range and asks again in the event of an error.
     * 
     * @param prompt  the text to be displayed before the input.
     * @param minimum the minimum allowed value.
     * @param maximum the maximum allowed value.
     * @return the player's valid integer.
     */
    private int readIntInRange(String prompt, int minimum, int maximum) {
        while (true) {

            System.out.print(prompt);

            String input = scanner.next();

            try {
                int value = Integer.parseInt(input);
                if (value >= minimum && value <= maximum) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Loopen frågar igen om inmatnignen inte är heltal/korekt
            }
            System.out.println("Ogiltiga inmatning. Ange ett heltal mellan " + minimum + " och " + maximum + ".");
        }
    }

    /**
     * Reads in a name and asks again if the name is empty.
     * 
     * @return the player'sname
     */
    private String readName() {
        while (true) {
            System.out.print("What is your name? ");
            String name = scanner.next();

            if (name.isEmpty()) {
                System.out.println("The name cannot be empty.");
            }

            return name;
        }
    }

    // public void placeYourGuess(String prompt) { // Osäker på hur jag får in de
    // bestämda antal sidorna i metoden. :-)
    // System.out.print(prompt);
    // int guess = scanner.nextInt();

    // if (guess == die.getValue()) {
    // System.out.println("Congratulations! You guessed the correct number!");
    // System.out.println("Your score is: " + player.getScore() + " and you have "
    // + (numberOfRounds - roundsPlayed) + " rounds left.");
    // } else {
    // System.out.println("Sorry, your guess was incorrect. The correct number was:
    // " + die.getValue());
    // }

    // }

    // En metod för att läsa användarens namn.

}
