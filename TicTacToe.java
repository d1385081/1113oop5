
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    private char[][] board; // 井字遊戲盤面 (使用字符陣列儲存)
    private char player;    // 玩家 (O 或 X)
    private char currentPlayer; // 目前正在操作的玩家 (O 或 X)
    private boolean gameEnded; // 遊戲是否結束
    private int playerTurn; // 目前正在進行的玩家 (0 或 1)

    // 遊戲初始化
    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.'; // 初始化盤面為空
            }
        }
        player = 'O'; // 初始玩家為 O
        currentPlayer = 'O'; // 初始玩家為 O
        gameEnded = false;
        playerTurn = 0; // 玩家 0 (O) 先先
    }

    // 設定玩家
    public void setPlayer(char player) {
        this.player = player;
    }

    // 設定目前正在操作的玩家
    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    // 設定玩家輪流設定位置
    public void setPosition(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            board[row][col] = currentPlayer;
            if (currentPlayer == 'O') {
                playerTurn = 1; // 玩家 1 (X) 輪到操作
            } else {
                playerTurn = 0; // 玩家 0 (O) 輪到操作
            }
        } else {
            System.out.println("Invalid position. Row and column must be between 0 and 2.");
        }
    }

    // 判斷遊戲是否結束
    public boolean evaluate() {
        if (gameEnded) {
            return true; // 遊戲已結束，返回 true
        }

        // 檢查行
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '.') {
                gameEnded = true;
                return true;
            }
        }

        // 檢查列
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '.') {
                gameEnded = true;
                return true;
            }
        }

        // 檢查對角線
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '.') {
            gameEnded = true;
            return true;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '.') {
            gameEnded = true;
            return true;
        }

        // 檢查平手
        if (!isBoardFull()) {
            return false; // 遊戲未結束，繼續檢查
        }

        gameEnded = true;
        return true;
    }

    // 檢查盤面是否已滿
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    // 顯示盤面
    public void displayBoard() {
        System.out.println("------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("------------------");
        }
    }

    // 取得盤面
    public char[][] getBoard() {
        return board;
    }

    // 取得目前正在操作的玩家
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    // 取得遊戲是否結束
    public boolean isGameEnded() {
        return gameEnded;
    }

    // 取得目前玩家的輪數
    public int getPlayerTurn() {
        return playerTurn;
    }
}
