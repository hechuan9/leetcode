package f2019.problem348;

class TicTacToe {

    /** Initialize your data structure here. */
    int n;
    int[][] board;

    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        return winH(col, player) ||
               winV(row, player) ||
               winD1(row, col, player) ||
               winD2(row, col, player) ? player : 0;
    }

    private boolean winV(int row, int player) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] != player) return false;
        }
        return true;
    }

    private boolean winH(int col, int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] != player) return false;
        }
        return true;
    }

    private boolean winD1(int row, int col, int player) {
        if (row == col) {
            for (int i = 0; i < n; i++) {
                if (board[i][i] != player) return false;
            }
            return true;
        }
        return false;
    }

    private boolean winD2(int row, int col, int player) {
        if (row == n - col - 1) {
            for (int i = 0; i < n; i++) {
                if (board[i][n-i-1] != player) return false;
            }
            return true;
        }
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */