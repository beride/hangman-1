package cn.codingstyle.hangman;

public class Hangman {
    private static final String ALL_VOWEL = "aeiou";
    private final String word;
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

    public void type(char c) {
        if (isCharNotUsed(c))
            used += c;
    }

    private boolean isCharNotUsed(char c) {
        return used.indexOf(c) == -1;
    }
}
