package cn.codingstyle.hangman;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHangmanTries {

    private static final int MAX_TRIES = 12;
    private static final char VOWEL = 'a';
    private static final char CONTAINED_CONSONANT = 'w';
    Hangman hangman = new Hangman("word");

    @Test
    public void tries_is_12_when_game_start() {
        assertEquals(MAX_TRIES, hangman.tries());
    }

    @Test
    public void tries_decrease_one_when_type_a_vowel() {
        hangman.type(VOWEL);

        assertEquals(MAX_TRIES - 1, hangman.tries());
    }

    @Test
    public void tries_remain_unchanged_when_type_a_contained_consonant() {
        hangman.type(CONTAINED_CONSONANT);

        assertEquals(MAX_TRIES, hangman.tries());
    }
}
