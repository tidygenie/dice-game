import java.util.Random;

/**
 * Represents a die that can be rolled to get a random value.
 */
public class Die {
    /**
     * The value from the most recent roll.
     */
    private int currentValue;

    /**
     * The number of sides on the die.
     */
    private final int numberOfSides;

    /**
     * Generates random values when the die is rolled.
     */
    private final Random random;

    /**
     * Creates a die with the specified number of sides.
     *
     * @param numberOfSides the number of sides on the die
     */
    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        this.random = new Random();
    }

    /**
     * Collects the current value of the die.
     * 
     * @return the current value of the die.
     */
    public int getCurrentValue() {
        return currentValue;
    }

    /**
     * Collects the number of sides of the die.
     * 
     * @return the number of sides of the die.
     */
    public int getNumberOfSides() {
        return numberOfSides;
    }

    /**
     * Rolls the die and stores a random value between 1 and the number of sides.
     */
    public void roll() {
        currentValue = random.nextInt(numberOfSides) + 1;
    }
}