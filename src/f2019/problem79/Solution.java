package f2019.problem79;

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, m, n, word, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int m, int n, String word, int index) {
        if (index == word.length()) return true;
        if (i >= m || i < 0 || j >= n || j < 0) return false;
        if (word.charAt(index) != board[i][j]) return false;

        board[i][j] = '*';
        if (dfs(board, i-1, j, m, n, word, index + 1) ||
                dfs(board, i+1, j, m, n, word, index + 1) ||
                dfs(board, i, j-1, m, n, word, index + 1) ||
                dfs(board, i, j+1, m, n, word, index + 1))
            return true;

        board[i][j] = word.charAt(index);
        return false;

    }
}