import Helper.TerminalColors;

import java.util.Scanner;

/**
 * Reads and validates text entered by the player in the console.
 */
public class PlayerInput {

    /** Scanner used to read input from standard input. */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Reads one whole line of text from the user.
     *
     * @return the text the user entered.
     */
    public String readLine() {
        return scanner.nextLine().trim().toLowerCase();
    }

    /**
     * Reads a line of text and converts it to an integer.
     *
     * @return the integer the user entered
     * @throws NumberFormatException if the entered text is not a valid integer
     */
    public int readInt() {
        var a = Integer.parseInt(readLine());

        return a;
    }

    /**
     * Keeps asking until the user enters an integer within the given range.
     *
     * @param prompt  the message to show before reading input.
     * @param minimum the smallest allowed value.
     * @param maximum the largest allowed value.
     * @return the integer entered by the user.
     */
    public int readIntInRange(String prompt, int minimum, int maximum) {
        while (true) {
            System.out.print(TerminalColors.YELLOW + prompt + TerminalColors.RESET);

            try {
                int value = readInt();
                if (value >= minimum && value <= maximum) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Ask again when the input is not an integer.
            }

            System.out.println(TerminalColors.RED + "\nInvalid input. Enter an integer between " + minimum + " and "
                    + maximum + "." + TerminalColors.RESET);
        }
    }

    /**
     * Keeps asking until the user enters a non empty name.
     *
     * @param prompt the message to show before reading the name.
     * @return the name entered by the user.
     */
    public String readName(String prompt) {
        while (true) {
            System.out.print(TerminalColors.YELLOW + prompt + TerminalColors.RESET);
            String name = readLine();

            if (name.matches("(?=.*\\p{L})[\\p{L} -]+")) {
                return name;
            } // AI fick hjälpa mig med denna...
              // (?=.*\\p{L})[\\p{L} -]+ är en regex som kollar om det finns minst en bokstav
              // i strängen och att den endast innehåller bokstäver, mellanslag och
              // bindestreck.

            System.out.println(
                    TerminalColors.RED + "Name must contain letters only. And/or cannot be empty. Please try again."
                            + TerminalColors.RESET);
        }
    }

    /**
     * Closes the scanner.
     * 
     * @return closes the scanner to free up resources. After calling this method,
     *         the scanner should not be used again.
     */
    public void scannerClose() {
        scanner.close();
    }
}