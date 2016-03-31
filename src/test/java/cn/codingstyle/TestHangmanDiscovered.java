package cn.codingstyle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHangmanDiscovered {

    private static final String PLACEHOLDER = "_";
    private static final String ONE_CONSONANT_WORD = "b";
    private static final String TWO_CONSONANTS_WORD = "bt";

    @Test
    public void one_consonant_word_when_game_start() {
        Hangman hangman = new Hangman(ONE_CONSONANT_WORD);

        assertEquals(PLACEHOLDER, hangman.discovered());
    }

    @Test
    public void two_consonants_word_when_game_start() {
        Hangman hangman = new Hangman(TWO_CONSONANTS_WORD);

        assertEquals(PLACEHOLDER + PLACEHOLDER, hangman.discovered());
    }
}
