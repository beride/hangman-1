package cn.codingstyle;

import static java.util.stream.Collectors.joining;

public class Hangman {
    private static final String ALL_VOWELS = "aeiou";
    private static final int MAX_TRIES = 12;
    private static final String PLACEHOLDER = "_";
    private final String word;
    private final GameChecker gameChecker;
    private String used = ALL_VOWELS;
    private int tries = MAX_TRIES;

    public Hangman(String word) {
        this.word = word;
        gameChecker = new GameChecker(this, this.word);
    }

    public int length() {
        return word.length();
    }

    public String used() {
        return used;
    }

    public void type(char c, Runnable gameOver, Runnable gameWin) {
        decreaseTries(c);
        appendCharToUsed(c);
        gameChecker.checkGameOver(gameOver);
        gameChecker.checkGameWin(gameWin);
    }

    private void decreaseTries(char c) {
        if (isCharUsed(c) || !isCharContained(c))
            tries--;
    }

    private void appendCharToUsed(char c) {
        if (!isCharUsed(c))
            used += c;
    }

    private boolean isCharUsed(char c) {
        return used.indexOf(c) != -1;
    }

    private boolean isCharContained(char c) {
        return word.indexOf(c) != -1;
    }

    public String discovered() {
        return word.chars()
                .mapToObj(i -> discoveredChar((char)i))
                .collect(joining());
    }

    private String discoveredChar(char c) {
        if (isCharUsed(c))
            return String.valueOf(c);
        else
            return PLACEHOLDER;
    }

    public int tries() {
        return tries;
    }
}
