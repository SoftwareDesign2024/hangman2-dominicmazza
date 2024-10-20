// Dominic Mazza
package hangman2;

import util.HangmanDictionary;

public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;
    public static final boolean cheating = true;

    public static void main(String[] args) {
        HangmanDictionary dictionary = new HangmanDictionary(DICTIONARY);
        Guesser humanGuesser = new HumanGuesser();
        Guesser autoGuesser = new AutoGuesser();

        if (cheating) {
            // AutoGuesser vs Cheating Executioner
            Executioner cheatingExecutioner = new CheatingExecutioner(dictionary.getWords(NUM_LETTERS));
            new HangmanGame(humanGuesser, cheatingExecutioner, NUM_MISSES).play();
        }
        else {
            // Regular Human vs Regular Executioner
            Executioner regularExecutioner = new RegularExecutioner(dictionary.getRandomWord(NUM_LETTERS));
            new HangmanGame(humanGuesser, regularExecutioner, NUM_MISSES).play();
        }
    }
}

