package g2018.problem136;

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = num ^ result;
        }
        return result;
    }
}