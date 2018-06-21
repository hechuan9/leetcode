package problem289;

class Solution {
    private int m;
    private int n;

    // 0 dead
    // 1 live
    // 2 was dead now live
    // 3 was live now dead

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = isLive(board, i, j);
                int neighbors = 0;
                neighbors += isLive(board, i-1, j-1);
                neighbors += isLive(board, i-1, j);
                neighbors += isLive(board, i-1, j+1);
                neighbors += isLive(board, i, j-1);
                neighbors += isLive(board, i, j+1);
                neighbors += isLive(board, i+1, j-1);
                neighbors += isLive(board, i+1, j);
                neighbors += isLive(board, i+1, j+1);

                if (live == 1) {
                    if (neighbors < 2) board[i][j] = 3;
                    else if (neighbors > 3) board[i][j] = 3;
                } else {
                    if (neighbors == 3) board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 3) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }

    private int isLive(int[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        return (board[i][j] == 1 || board[i][j] == 3) ? 1 : 0;
    }
}