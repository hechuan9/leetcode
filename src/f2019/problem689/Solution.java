package f2019.problem689;

class Solution {
    private int[] sums;
    private int k;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        this.k = k;
        int n = nums.length;
        sums = new int[n+1]; // Off by 1
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + nums[i];
        }

        int[] posLeft = new int[n];
        int[] posRight = new int[n];

        for (int i = 0, total = 0; i < n -k +1; i++) {
            if (getSum(i) > total) {
                posLeft[i+k-1] = i;
                total = getSum(i);
            } else {
                posLeft[i+k-1] = posLeft[i+k-2];
            }
        }

        for (int i = n-k, total = 0; i >= 0; i--) {
            if (getSum(i) >= total) {
                posRight[i] = i;
                total = getSum(i);
            } else {
                posRight[i] = posRight[i+1];
            }
        }

        int maxSum = 0;
        int[] res = new int[3];
        for (int i = k; i <= n - 2 * k; i++) {
            int leftStart = posLeft[i-1];
            int leftSum = getSum(leftStart);
            int rightStart = posRight[i+k];
            int rightSum = getSum(rightStart);
            int midSum = getSum(i);
            if (leftSum + midSum + rightSum > maxSum) {
                maxSum = leftSum + midSum + rightSum;
                res[0] = leftStart; res[1] = i; res[2] = rightStart;
            }
        }

        return res;
    }

    private int getSum(int start) {
        return sums[start+k] - sums[start];
    }
}