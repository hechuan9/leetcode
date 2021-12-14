package f2019.problem136;

class Solution {
    public int singleNumber(int[] nums) {
        int theNum = 0;
        for (int num : nums) {
            theNum = num ^ theNum;
        }
        return theNum;
    }
}