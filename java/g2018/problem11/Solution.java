package g2018.problem11;

class Solution {
    public int maxArea(int[] height) {
        int ret = 0;
        int begin = 0;
        int end = height.length - 1;
        while (begin < end) {
            ret = Math.max(ret, Math.min(height[begin], height[end])*(end-begin));
            if (height[end] > height[begin]) begin++;
            else end--;
        }
        return ret;
    }
}