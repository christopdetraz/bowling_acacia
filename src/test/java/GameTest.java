import org.example.Game;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    @DisplayName("20 rolls at 0")
    public void score_Given20RollsAt0() {
        Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    @DisplayName("20 rolls at 1")
    public void score_Given20RollsAt1() {
        Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    @DisplayName("1 spare + 1 roll at 3")
    public void score_Given1SparePlus1RollAt3() {
        Game game = new Game();
        game.roll(5);
        game.roll(5);
        game.roll(3);
        for (int i = 0; i < 17; i++) {
            game.roll(0);
        }
        assertEquals(16, game.score());
    }

    @Test
    @DisplayName("1 strike + 1 roll at 3 + 1 roll at 4")
    public void score_Given1StrikePlus1RollAt3Plus1RollAt4() {
        Game game = new Game();
        game.roll(10);
        game.roll(3);
        game.roll(4);
        for (int i = 0; i < 16; i++) {
            game.roll(0);
        }
        assertEquals(24, game.score());
    }

    @Test
    @DisplayName("Perfect game")
    public void score_PerfectGame() {
        Game game = new Game();
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assertEquals(300, game.score());
    }
}
