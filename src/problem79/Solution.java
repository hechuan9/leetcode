package problem79;

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int start) {
        if (start >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(start)) return false;
        if (board[i][j] == '#') return false;
        char c = board[i][j];
        board[i][j] = '#';
        if (exist(board, i-1, j, word, start+1)
                || exist(board, i+1, j, word, start+1)
                || exist(board, i, j-1, word, start+1)
                || exist(board, i, j+1, word, start+1))
            return true;
        board[i][j] = c;
        return false;
    }
}