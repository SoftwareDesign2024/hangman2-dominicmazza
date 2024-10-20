// Dominic Mazza
package hangman2;

public class AutoGuesser extends Guesser {
    private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
    private int index;

    public AutoGuesser() {
        super();
        this.index = 0;
    }

    @Override
    public char makeGuess() {
        return LETTERS_ORDERED_BY_FREQUENCY.charAt(index++);
    }
}
