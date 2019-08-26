package f2019.problem1066;

class Solution {
    private int min = Integer.MAX_VALUE;
    private int[][] workers;
    private int[][] bikes;
    private int numWorkers;
    private int numBikers;

    public int assignBikes(int[][] workers, int[][] bikes) {
        this.workers = workers;
        this.bikes = bikes;
        this.numWorkers = workers.length;
        this.numBikers = bikes.length;
        assignBikes(0, new boolean[numBikers], 0);
        return this.min;
    }

    private void assignBikes(int worker, boolean[] used, int sum) {
        if (worker == numWorkers) {
            min = Math.min(min, sum);
            return;
        }

        if (sum > min) return;

        for (int bike = 0; bike < numBikers; bike++) {
            if (used[bike]) continue;
            int distance = Math.abs(workers[worker][0] - bikes[bike][0]) + Math.abs(workers[worker][1] - bikes[bike][1]);
            used[bike] = true;
            assignBikes(worker+1, used, sum + distance);
            used[bike] = false;
        }
    }
}