// Dominic Mazza
package hangman2;

//Abstract Guesser class
public abstract class Guesser {
 protected StringBuilder myLettersLeftToGuess;
 private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

 public Guesser() {
     myLettersLeftToGuess = new StringBuilder(ALPHABET);
 }

 // Abstract method to make a guess
 public abstract char makeGuess();

 // updates the letters left to guess
 public void updateLettersLeft(char guess) {
     int index = myLettersLeftToGuess.indexOf("" + guess);
     if (index >= 0) {
         myLettersLeftToGuess.deleteCharAt(index);  
     }
 }

 // returns letters left to guess
 public StringBuilder getLettersLeft() {
     return myLettersLeftToGuess;
 }
}
