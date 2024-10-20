// Dominic Mazza
package hangman2;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map.Entry;

import util.DisplayWord;

import java.util.Collections;

public class CheatingExecutioner extends Executioner {
    private List<String> myRemainingWords;

    public CheatingExecutioner(List<String> words) {
        super(words.get(0));
        this.myRemainingWords = words;
    }

    @Override
    public boolean checkGuessInSecret(char guess) {
        cheat(guess);
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }

    private void cheat(char guess) {
        HashMap<DisplayWord, List<String>> templatedWords = new HashMap<>();
        for (String word : myRemainingWords) {
            DisplayWord template = new DisplayWord(myDisplayWord);
            template.update(guess, word);
            templatedWords.computeIfAbsent(template, k -> new ArrayList<>()).add(word);
        }

        Entry<DisplayWord, List<String>> maxEntry = templatedWords.entrySet().stream()
            .max((entry1, entry2) -> entry1.getValue().size() - entry2.getValue().size())
            .orElseThrow();

        myDisplayWord = maxEntry.getKey();
        myRemainingWords = maxEntry.getValue();
        Collections.shuffle(myRemainingWords);
        mySecretWord = myRemainingWords.get(0);
    }
}

