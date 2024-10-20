// Dominic Mazza
package hangman2;

import java.util.Scanner;

public class HumanGuesser extends Guesser {
    private Scanner inputScanner;

    public HumanGuesser() {
        inputScanner = new Scanner(System.in);
    }

    @Override
    public char makeGuess() {
        System.out.print("Make a guess: ");
        String guess = inputScanner.nextLine();
        if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
            return guess.toLowerCase().charAt(0);
        } else {
            System.out.println("Please enter a single letter...");
            return makeGuess();
        }
    }
}
