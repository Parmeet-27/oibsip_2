import java.util.Scanner;

public class NumberGuessingGame {

    private static int generateRandomNumber(){
        return (int)(Math.random()*100) + 1;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 5; // Maximum number of attempts per round
        int score = 0; //Initial Score

        System.out.println("Welcome to Number Guessing Game!");
   
        while(true){
            int targetNo = generateRandomNumber();
            int attempts=0;
            boolean guessedcorrectly = false;

            System.out.println("Round starts! Guess a number between 1 and 100.");

            while(attempts<maxAttempts){
                System.out.println("Attempt " + (attempts + 1) + ":");
                int guess = scanner.nextInt();
                attempts++;

                if(guess == targetNo){
                    System.out.println("You guessed the correct number.");
                    guessedcorrectly = true;
                    break; 
                }
                else if(guess < targetNo){
                    System.out.println("Too Low,Try Again");
                }
                else{
                    System.out.println("Too High,Try Again");
                }
            }
            if(!guessedcorrectly){
                System.out.println("You ran out of attempts.");
                System.out.println("correct number was: " + targetNo);
            }
            else{
                //calculate and display scores based on number of attempts
                int roundScore = maxAttempts - attempts + 1;
                score += roundScore;
                System.out.println("Score for this round: " + roundScore);
                System.out.println("Total Score: " + score);
            }
            System.out.println("Do you want to play again?(Y/N)");
            String playagain = scanner.next();

            if(!playagain.equalsIgnoreCase("Y")){
                System.out.println("Thank you for playing!Your Final Score is: " + score);
                break;
            }
        }
        
        scanner.close();

    }
       
}


