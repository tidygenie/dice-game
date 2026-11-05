import java.util.Scanner;

public class DiceGame {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DiceGame diceGame = new DiceGame();

        System.out.println("Hello, welcome to dice game!");

        while (true) {

            int numberOfRounds = diceGame.readIntInRange("How many rounds do you want to play? ", 1, Integer.MAX_VALUE);
            int numberOfSides = diceGame.readIntInRange("How many sides should the die have? ", 1, Integer.MAX_VALUE);

            // Läser användarens namn
            var playerName = diceGame.readName();
            Player player = new Player(playerName);

            // Create dice
            player.addDie(numberOfSides);

            int roundsPlayed = 1;

            while (roundsPlayed <= numberOfRounds) {
                System.out.println("\nRound: " + roundsPlayed + "Player score: " + player.getScore());
                System.out.println("\nGuess a number between 1 and " + numberOfSides);

                int guess = diceGame.scanner.nextInt();

                Die die = new Die(numberOfSides);

                die.rollDie();

                int diceValue = die.getCurrentValue();
                System.out.println("The dice landed on: " + diceValue);

                if (guess == diceValue) {

                    System.out.println("Correct!");
                    player.increaseScore();

                } else {
                    System.out.println("Incorrect!");
                }
            }
        }
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
}
