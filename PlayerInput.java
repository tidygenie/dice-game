import java.util.Scanner;

public class PlayerInput {
    
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Collects a string input from the user.
     * 
    * @return the user's input.
     */
    public String readString() {
        return scanner.nextLine();
    }

    /**
     * Collects a integer input from the user.
     * @return the user's integer input.
     */
    public int readInt() {
        return Integer.parseInt(scanner.nextLine());
    }

}
