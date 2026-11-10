/**
 * Stores a players name, score, and associated die.
 */
public class Player {

    /** The players name. */
    private final String name;

    /** The number of correct guesses made by the player. */
    private int score;

    /** The die associated with this player, when one has been added. */
    private Die die;

    /**
     * Creates a player with the given name and an initial score of zero.
     *
     * @param name the players name
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    /**
     * Returns the players name.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the players current score.
     *
     * @return the players current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Get the current value of die.
     * 
     * @return current value of the die.
     */
    public int getDieValue() {
        return die.getCurrentValue();
    }

    /**
     * Sets the players score.
     *
     * @param score the new score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Increases the players score by one point.
     */
    public void increaseScore() {
        score++;
    }

    /**
     * Creates and associates a die with the given number of sides.
     *
     * @param numberOfSides the number of sides on the die
     */
    public void addDie(int numberOfSides) {
        die = new Die(numberOfSides);
    }

    /**
     * Rolls the die associated with this player.
     */
    public void rollDie() {
        die.roll();
    }

}