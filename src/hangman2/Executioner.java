// Dominic Mazza
package hangman2;

import util.DisplayWord;

//Abstract Executioner class
public abstract class Executioner {
protected String mySecretWord;
protected DisplayWord myDisplayWord;

public Executioner(String secretWord) {
   this.mySecretWord = secretWord;
   this.myDisplayWord = new DisplayWord(secretWord);
}

// Abstract method to check guess
public abstract boolean checkGuessInSecret(char guess);

public boolean isGameWon() {
   return myDisplayWord.equals(mySecretWord);
}

public DisplayWord getDisplayWord() {
   return myDisplayWord;
}

public String getSecretWord() {
   return mySecretWord;
}
}
