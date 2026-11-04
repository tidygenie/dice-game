import java.util.Random;

public class Die {
    private int currentValue;
    private final int numberOfSides;
    private final Random random;

    Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        this.random = new Random();
    }

    /**
     * Hämtar tärnignens nuvarandra värde.
     * 
     * @return tärnignens nuvarandra värde.
     */
    public int getCurrentValue() {
        return currentValue;
    }

    /**
     * Hämtar tärningens antal sidor.
     * 
     * @return tärningens antal sidor.
     */
    public int getNumberOfSlides() {
        return numberOfSides;
    }

    /**
     * Rullar tärningen och väljer ett nytt värde mellan 1 och antal sidor.
     */
    public void rollDie() {
        currentValue = random.nextInt(numberOfSides) + 1;
    }
}