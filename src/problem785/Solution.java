package problem785;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for (int i=0; i<graph.length; i++) {
            colors[i] = -1;
        }

        for (int i=0; i<graph.length; i++) {
            if (colors[i] != -1) {
                continue;
            }
            if (!dfsAssign(graph, colors, i, 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfsAssign(int[][] graph, int[] colors, int index, int color) {
        if (colors[index] != color) {
            // Already assigned
            if (colors[index] != -1) {
                return false;
            }
            // Assign the color
            colors[index] = color;
            // Assign child
            for (int next : graph[index]) {
                if (!dfsAssign(graph, colors, next, 1 - color)) {
                    return false;
                }
            }
        }
        return true;
    }
}