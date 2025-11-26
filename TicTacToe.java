
import java.util.HashMap;
import java.util.Map;

public class TicTacToe {

    private char[][] board;
    private char playerTurn; // 'X' or 'O'
    private int playerNumber; // 1 for X, 2 for O

    public TicTacToe() {
        board = new char[3][3];
        playerTurn = 'X';
        playerNumber = 1;
    }

    public void set(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException("Invalid row or column index.");
        }

        if (board[row][col] != '\0') {
            throw new IllegalArgumentException("This position is already occupied.");
        }

        board[row][col] = playerTurn;
        playerTurn = (playerTurn == 'X') ? 'O' : 'X';
    }

    public char getWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\0' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return String.valueOf(board[i][0]);
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '\0' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return String.valueOf(board[0][j]);
            }
        }

        // Check diagonals
        if (board[0][0] != '\0' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return String.valueOf(board[0][0]);
        }
        if (board[0][2] != '\0' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return String.valueOf(board[0][2]);
        }

        return '\0'; // No winner
    }

    public boolean isGameOver() {
        // Check for a winner
        if (getWinner() != '\0') {
            return true;
        }

        // Check for a draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }

        return true;
    }

    public char getBoard() {
        char[][] boardCopy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardCopy[i][j] = board[i][j];
            }
        }
        return boardCopy;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        // Test cases
        System.out.println("Test case 1: X wins");
        game.set(0, 0);
        game.set(1, 0);
        game.set(0, 1);
        game.set(1, 1);
        game.set(0, 2);
        System.out.println("Winner: " + game.getWinner());
        System.out.println("Game over: " + game.isGameOver());

        System.out.println("\nTest case 2: O wins");
        game.set(0, 1);
        game.set(0, 0);
        game.set(1, 0);
        game.set(1, 1);
        game.set(2, 1);
        game.set(2, 2);
        System.out.println("Winner: " + game.getWinner());
        System.out.println("Game over: " + game.isGameOver());

        System.out.println("\nTest case 3: Draw");
        game.set(0, 0);
        game.set(0, 1);
        game.set(0, 2);
        game.set(1, 1);
        game.set(1, 0);
        game.set(1, 2);
        game.set(2, 1);
        game.set(2, 0);
        game.set(2, 2);
        System.out.println("Winner: " + game.getWinner());
        System.out.println("Game over: " + game.isGameOver());

        System.out.println("\nTest case 4: Invalid set (same position)");
        try {
            game.set(0, 0);
            game.set(0, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("\nTest case 5: Invalid set (out of bounds)");
        try {
            game.set(3, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
