package f2019.problem489;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    class Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move() { return true; }

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft() {}
        void turnRight() {}

        // Clean the current cell.
        void clean() {}
    }

    public void cleanRoom(Robot robot) {
        int dir = 0; // 0 -> up, 90 -> right, 180 -> down, 270 -> left
        Set<String> visited = new HashSet<>();
        dfs(visited, robot, 0,0, dir);
    }

    private void dfs(Set<String> visited, Robot robot, int x, int y, int dir) {
        String hash = x + "," + y;
        if (visited.contains(hash)) return;
        robot.clean();
        visited.add(hash);

        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                switch (dir) {
                    case 0:
                        dfs(visited, robot, x, y+1, dir);
                        break;
                    case 90:
                        dfs(visited, robot, x+1, y, dir);
                        break;
                    case 180:
                        dfs(visited, robot, x, y-1, dir);
                        break;
                    case 270:
                        dfs(visited, robot, x-1, y, dir);
                        break;
                }

                // go back
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            dir = (dir + 90) % 360;
        }
    }
}
