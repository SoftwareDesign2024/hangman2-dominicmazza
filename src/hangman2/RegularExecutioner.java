// Dominic Mazza
package hangman2;

public class RegularExecutioner extends Executioner {

    public RegularExecutioner(String secretWord) {
        super(secretWord);
    }

    @Override
    public boolean checkGuessInSecret(char guess) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }
}
