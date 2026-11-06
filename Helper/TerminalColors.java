package Helper;

/**
 * TerminalColors class is a helper class for terminal colors.
 */
public class TerminalColors {
    public static final String BLUE = "\u001B[34m"; // Information and status, such as rounds and points.
    public static final String RED = "\u001B[31m"; // Errors, such as an incorrect guess or input.
    public static final String GREEN = "\u001B[32m"; // Something positive, such as a correct guess.
    public static final String YELLOW = "\u001B[33m"; // Questions and instructions for the player.
    public static final String CYAN = "\u001B[36m"; // Headings and the results of a die roll.
    public static final String RESET = "\u001B[0m"; // Restores the terminal's text color to the default.
}
