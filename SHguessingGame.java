// Programmer: Shelby Hahn
// Class: CS &145
// Date: 4/7/2022
// Assignment: Guessing Game
// What will this program do?: Play a guessing game with the user!

import java.util.*;

public class SHguessingGame {

   // begin main method
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      // Define variables
      int n = 1;
      int numTries;
      int sum = 0;
      int gameCount = 0;
      int bestGuess = 1000000;

      // call methods
      intro();
      playGame();

      numTries = playGame();
         if (numTries < bestGuess) {
            bestGuess = numTries;
         }
         sum += numTries;
         gameCount++;

      
     System.out.println("Would you like to play again? Answer 1 for yes, 2 for no:  ");
      int playAgain = input.nextInt();
      if(playAgain == 1) {
         while (playAgain == 1) {
            playGame();
            System.out.println("Would you like to play again? Answer 1 for yes, 2 for no:  ");
            playAgain = input.nextInt();
         }
      } else if (playAgain == 2) {
            results(sum,gameCount,bestGuess);
      } // end of if/else
      
      results(sum,gameCount,bestGuess);

   } // end main


   // begin intro method
   public static void intro() { // Intro to the user about the game and how it works. 
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
   } // end of intro method


   // begin playGame method
   public static int playGame() { // Plays the game with the user 

     Scanner input = new Scanner(System.in);

     // Variables
     int range = 100;
     int numTries = 1;
     int guess;

     // Computer thinks of random number
     Random rand = new Random();
     int randomNumber = rand.nextInt(range) + 1; // 1-100
     System.out.println("Random = " + randomNumber);
     System.out.println("I'm thinking of a random number between 1 and " + range);
     System.out.println("Your guess?: ");
     guess = input.nextInt();

     // begin while loop
     while(guess != randomNumber) {
         if (guess > randomNumber) {
            System.out.println("It's lower.");
            numTries++;
         } else { 
            System.out.println("It's higher.");
            numTries++;
         } 
         System.out.println("Your guess?: ");
         guess = input.nextInt();
     } // end while loop

     System.out.println("Congratulations! You got it right in " + numTries + " guesses!");         
     return numTries;
   } // end of playGame method

   
   // begin results method
   public static void results(int sum, int gameCount, int bestGuess) {
     double averageTries = (double) sum/gameCount;
     System.out.println("Overall results: ");
     System.out.println("Total games = " + gameCount);
     System.out.println("Total guesses = " + sum);
     System.out.println("Best Guess = " + bestGuess);
     System.out.printf("Average Tries = %.1f%n ", averageTries);
   } // end results method


} // end class