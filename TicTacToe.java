
import java.util.Arrays;

public class TicTacToe {

    private char[][] board;
    private char player; // 'O' 或 'X'
    private int currentPlayer; // 玩家輪流 (0 或 1)
    private boolean gameEnded;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.'; // 初始化為空
            }
        }
        player = 'O';
        currentPlayer = 0; // 初始為 O 的玩家
        gameEnded = false;
    }

    public void setPosition(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid position.");
            return;
        }

        if (board[row][col] != '.') {
            System.out.println("Position is already occupied.");
            return;
        }

        board[row][col] = player;
        if (currentPlayer == 0) {
            player = 'X';
        } else {
            player = 'O';
        }
        currentPlayer = 1 - currentPlayer; // 輪到對面玩家
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public boolean checkWin(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '.') {
            return false;
        }

        // 檢查水平線
        if (board[row][col] == board[row][col + 1] && board[row][col] == board[row][col + 2]) {
            return true;
        }

        // 檢查垂直線
        if (board[row][col] == board[row + 1][col] && board[row][col] == board[row + 2][col]) {
            return true;
        }

        // 檢查對角線
        if (board[row][col] == board[row + 1][col + 1] && board[row][col] == board[row + 2][col + 2]) {
            return true;
        }

        // 檢查對角線
        if (board[row][col] == board[row + 1][col - 1] && board[row][col] == board[row + 2][col - 2]) {
            return true;
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void endGame(char winner) {
        gameEnded = true;
        if (winner == 'X') {
            System.out.println("X wins!");
        } else if (winner == 'O') {
            System.out.println("O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}

// JUnit 測試類別
