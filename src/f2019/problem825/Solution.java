package f2019.problem825;

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];

        for (int i = 0; i < ages.length; i++) {
            count[ages[i]]++;
        }

        int[] countSum = new int[121];
        for (int i = 1; i < count.length; i++) {
            countSum[i] = countSum[i-1] + count[i];
        }

        int sum = 0;
        // Solve x > 0.5x + 7 => x > 14
        for (int i = 15; i <= 120; i++) {
            if (count[i] == 0) continue;

            int minAge = (int)(0.5 * i + 7);
            int friendsOutAge = countSum[i - 1] - countSum[minAge];
            int friendsInAge = count[i] - 1;
            sum += (friendsOutAge + friendsInAge) * count[i];
        }

        return sum;
    }
}