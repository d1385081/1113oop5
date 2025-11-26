
import java.util.Arrays;

public class TicTacToe {

    private char[][] board = new char[3][3];
    private char player = 'X'; // X 先手
    private boolean gameOver = false;
    private char winner = ' ';

    // 初始化棋盤
    public TicTacToe() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
    }

    // 下棋
    public boolean set(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false; // 超出範圍
        }

        if (board[row][col] != ' ') {
            return false; // 位置已被占用
        }

        board[row][col] = player;

        // 檢查勝負
        if (checkWin()) {
            gameOver = true;
            winner = player;
            return true;
        }

        // 輪到下一次玩家
        player = (player == 'X') ? 'O' : 'X';
        return true;
    }

    // 勝負判斷
    private boolean checkWin() {
        // 檢查三條橫列
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0] == winner ? true : false;
            }
        }

        // 檢查三條直行
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                return board[0][j] == winner ? true : false;
            }
        }

        // 檢查主對角線
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0] == winner ? true : false;
        }

        // 檢查副對角線
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return board[0][2] == winner ? true : false;
        }

        return false;
    }

    // 檢查遊戲是否結束
    public boolean isGameOver() {
        return gameOver;
    }

    // 獲取勝者
    public char getWinner() {
        return winner;
    }

    // 顯示棋盤 (可選，用於 debug)
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
