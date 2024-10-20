// Dominic Mazza
package hangman2;

public class HangmanGame {
    private Guesser myGuesser;
    private Executioner myExecutioner;
    private int myNumGuessesLeft;

    public HangmanGame(Guesser guesser, Executioner executioner, int numGuesses) {
        this.myGuesser = guesser;
        this.myExecutioner = executioner;
        this.myNumGuessesLeft = numGuesses;
    }

    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();

            char guess = myGuesser.makeGuess();
            myGuesser.updateLettersLeft(guess);

            if (!myExecutioner.checkGuessInSecret(guess)) {
                myNumGuessesLeft -= 1;
            }

            if (isGameLost()) {
                System.out.println("YOU ARE HUNG!!!");
                gameOver = true;
            } else if (isGameWon()) {
                System.out.println("YOU WIN!!!");
                gameOver = true;
            }
        }
        System.out.println("The secret word was " + myExecutioner.getSecretWord());
    }

    private boolean isGameWon() {
        return myExecutioner.isGameWon();
    }

    private boolean isGameLost() {
        return myNumGuessesLeft == 0;
    }

    private void printStatus() {
        System.out.println(myExecutioner.getDisplayWord());
        System.out.println("# misses left = " + myNumGuessesLeft);
        System.out.println("letters not yet guessed = " + myGuesser.getLettersLeft());
        System.out.println();
    }
}

