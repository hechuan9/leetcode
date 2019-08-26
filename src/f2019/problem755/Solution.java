package f2019.problem755;

class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        int cur = K;
        for (int i = 0; i < V; i++) {
            cur = K;
            while (cur >= 1 && heights[cur-1] <= heights[cur]) cur--;
            while (cur < heights.length - 1 && heights[cur+1] <= heights[cur]) cur++;
            while (cur > K && heights[cur-1] <= heights[cur]) cur--;
            heights[cur]++;
        }
        return heights;
    }
}