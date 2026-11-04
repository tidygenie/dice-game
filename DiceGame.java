import java.util.Scanner;
import java.util.Random;

public class DiceGame {
    private final Scanner scanner;
    
    
    public static void main(String[] args){
        
        System.out.println("Hello, welcome to dice game!");
        boolean playAgain = true;

        while(playAgain){

            System.out.println("Enter your name:")
            String name = scanner.nextLine();
            Player player = new Player(name);

            System.out.println("How many rounds do you want to play?");
            int numberOfRounds =  readIntInRange("How many rounds do you want to play?", 1, Integer.MAX_VALUE);

            System.out.println("How many sides should the die have?");
            int numberOfSides =  readIntInRange("How many sides should the die have?", 1, Integer.MAX_VALUE);
        
            // Create dice
            player.addDie(numberOfSides);
            
            int roundsPlayed = 1;

            while (roundsPlayed <= numberOfRounds) {
                System.out.println("\nRound: " + roundsPlayed + "Player score: " + player.getScore());
                System.out.println("\nGuess a number between 1 and " + numberOfSides);
            }
            
        }

        player.rollDice();
        player.increaseScore();

       int numberOfRounds =  readIntInRange("How many rounds do you want to play?", 1, Integer.MAX_VALUE);
       int numberOfSides =  readIntInRange("How many sides should the die have?", 1, Integer.MAX_VALUE);
        
    

    }
    

    /**
     * Reads an integer within a range and asks again in the event of an error.
     * @param 
     */
    private int readIntInRange(String prompt, int minimum, int maximum){
      while (true) {
        
        System.out.print(prompt);
        String input = scanner.nextLine();
        
        try {
            int value = Integer.parseInt(input);
            if(value >= minimum && value <= maximum){
                return value;
            }
        }catch(NumberFormatException e){
            // Loopen frågar igen om inmatnignen inte är heltal/korekt 
        }
            
            System.out.println("Ogiltiga inmatning. Ange ett heltal mellan " + minimum + " och " + maximum + ".");
      
      }  
    }

    public void placeYourGuess(String prompt) { //Osäker på hur jag får in de bestämda antal sidorna i metoden. :-)
        System.out.print(prompt);
        int guess = scanner.nextInt();

            if(guess == die.getValue()){
                System.out.println("Congratulations! You guessed the correct number!");
                System.out.println("Your score is: " + player.getScore() + " and you have " + (numberOfRounds - roundsPlayed) + " rounds left.");
            } else {
                System.out.println("Sorry, your guess was incorrect. The correct number was: " + die.getValue());
            }
        
    }
    
    

    
    
}

