import java.util.Random;

public class Die {
    private int currentValue;
    private final int numberOfSides;
    private final Random random;

    Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        this.random = new Random();
    }

    public Die getDie() {
        return this;
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
     * Sets a new value for currentValue between 1 and the number of sides via
     * rolling the die.
     */
    public void roll() {
        currentValue = random.nextInt(numberOfSides) + 1;
    }

}