package f2019.problem286;

import javax.swing.text.Position;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.add(new Position(i, j));
            }
        }

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;


            if (x > 0 && rooms[x-1][y] == Integer.MAX_VALUE) {
                rooms[x-1][y] = rooms[x][y] + 1;
                queue.add(new Position(x-1,y));
            }

            if (x < m - 1 && rooms[x+1][y] == Integer.MAX_VALUE) {
                rooms[x+1][y] = rooms[x][y] + 1;
                queue.add(new Position(x+1,y));
            }

            if (y > 0 && rooms[x][y-1] == Integer.MAX_VALUE) {
                rooms[x][y-1] = rooms[x][y] + 1;
                queue.add(new Position(x,y-1));
            }

            if (y < n - 1 && rooms[x][y+1] == Integer.MAX_VALUE) {
                rooms[x][y+1] = rooms[x][y] + 1;
                queue.add(new Position(x,y+1));
            }
        }
    }
}
