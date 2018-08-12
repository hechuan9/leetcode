package problem130;

import java.util.Stack;

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int m = board.length;
        int n = board[0].length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O'){
                stack.add(i);
            }
            if (board[m-1][i] == 'O') {
                stack.add((m-1)*n + i);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O'){
                stack.add(i*n);
            }
            if (board[i][n-1] == 'O') {
                stack.add(i*n + n-1);
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int x = index / n;
            int y = index % n;
            board[x][y] = 'L';
            if ((x-1 >= 0) && board[x-1][y] == 'O') stack.add((x-1)*n + y);
            if ((x+1 < m) && board[x+1][y] == 'O') stack.add((x+1)*n + y);
            if ((y-1 >= 0) && board[x][y-1] == 'O') stack.add(x*n + y - 1);
            if ((y+1 < n) && board[x][y+1] == 'O') stack.add(x*n + y + 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'L') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

    }

}