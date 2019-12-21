package Games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TexasHoldEmTest {

    @Test
    void playGame() {
        TexasHoldEm texas = new TexasHoldEm(3);
        texas.playGame();
    }
}