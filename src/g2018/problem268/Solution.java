package problem268;

class Solution {
    public int missingNumber(int[] nums) {
        Boolean[] met = new Boolean[nums.length+1];
        for (int i = 0; i < met.length; i++) {
            met[i] = false;
        }
        for (int i = 0; i < nums.length; i++) {
            met[nums[i]] = true;
        }
        for (int i = 0; i < met.length; i++) {
            if (!met[i]) return i;
        }
        return -1;
    }
}