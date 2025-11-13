public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private char winner; // 'X', 'O', or ' ' (no winner yet)

    public TicTacToe() {
        board = new char[3][3];
        reset();
    }

    // 重設遊戲
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
        gameOver = false;
        winner = ' ';
    }

    // 設定某格（例如 set(0, 2)）
    public boolean set(int row, int col) {
        if (gameOver) return false;
        if (row < 0 || row >= 3 || col < 0 || col >= 3) return false;
        if (board[row][col] != ' ') return false;

        board[row][col] = currentPlayer;
        evaluate(); // 檢查是否勝利或平手

        // 若遊戲還沒結束則換人
        if (!gameOver) {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        return true;
    }

    // 檢查勝負或平手
    public void evaluate() {
        // 檢查列、行、對角線
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                gameOver = true;
                winner = board[i][0];
                return;
            }
            if (board[0][i] != ' ' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                gameOver = true;
                winner = board[0][i];
                return;
            }
        }
        // 檢查兩條對角線
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            gameOver = true;
            winner = board[0][0];
            return;
        }
        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            gameOver = true;
            winner = board[0][2];
            return;
        }

        // 檢查是否平手
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    full = false;
                    break;
                }
            }
        }
        if (full) {
            gameOver = true;
            winner = ' '; // 平手
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public char getWinner() {
        return winner;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public void printBoard() {
        System.out.println("-------");
        for (int i = 0; i < 3; i++) {
            System.out.println("|" + board[i][0] + "|" + board[i][1] + "|" + board[i][2] + "|");
        }
        System.out.println("-------");
    }
}
