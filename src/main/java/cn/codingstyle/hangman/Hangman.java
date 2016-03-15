package cn.codingstyle.hangman;

public class Hangman {
    private static final String ALL_VOWEL = "aeiou";
    private static final int MAX_TRIES = 12;
    private static final String PLACEHOLDER = "_";
    private final String word;
    private int tries = MAX_TRIES;
    private String used = ALL_VOWEL;

    public Hangman(String word) {
        this.word = word;
    }

    public int length() {
        return word.length();
    }

    public String used() {
        return used;
    }

    public void type(char c, Runnable gameLost) {
        decreaseTries(c);
        appendCharToUsed(c);
        checkGameLost(gameLost);
    }

    private void checkGameLost(Runnable gameLost) {
        if (tries == 0)
            gameLost.run();
    }

    private void decreaseTries(char c) {
        if (isCharNotContained(c) || isCharUsed(c))
            tries--;
    }

    private boolean isCharNotContained(char c) {
        return word.indexOf(c) == -1;
    }

    private void appendCharToUsed(char c) {
        if (!isCharUsed(c))
            used += c;
    }

    private boolean isCharUsed(char c) {
        return used.indexOf(c) > -1;
    }

    public int tries() {
        return tries;
    }

    public String discovered() {
        if (!ALL_VOWEL.contains(word))
            return PLACEHOLDER;

        return word;
    }
}
