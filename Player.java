public class Player {

    private final String name;
    private int score;
    private Die die;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    /**
     * Get the player name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the score for the player.
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the score for the player.
     */
    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore() {
        score++;
    }

    public void addDie(int numberOfSides) {
        die = new Die(numberOfSides);
    }

    public void roll() {
        die.rollDie();
    }

}