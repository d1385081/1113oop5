import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void testXWinsRow() {
        TicTacToe game = new TicTacToe();
        game.set(0,0); // X
        game.set(1,0); // O
        game.set(0,1); // X
        game.set(1,1); // O
        game.set(0,2); // X wins
        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals('X', game.getWinner());
    }

    @Test
    public void testOWinsDiagonal() {
        TicTacToe game = new TicTacToe();
        game.set(0,1); // X
        game.set(0,0); // O
        game.set(1,0); // X
        game.set(1,1); // O
        game.set(2,1); // X
        game.set(2,2); // O wins
        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals('O', game.getWinner());
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();
        // 模擬平手局面
        game.set(0,0); // X
        game.set(0,1); // O
        game.set(0,2); // X
        game.set(1,1); // O
        game.set(1,0); // X
        game.set(1,2); // O
        game.set(2,1); // X
        game.set(2,0); // O
        game.set(2,2); // X
        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals(' ', game.getWinner());
    }

    @Test
    public void testSetInvalidPosition() {
        TicTacToe game = new TicTacToe();
        Assert.assertTrue(game.set(0,0));
        Assert.assertFalse(game.set(0,0)); // 同一格不能重放
    }
}
