package problem134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int min = Integer.MAX_VALUE;
        int index = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                index = i;
                min = sum;
            }
        }
        if (sum < 0) return -1;
        return (index + 1) % n;
    }
}