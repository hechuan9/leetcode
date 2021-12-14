package f2019.problem69;

class Solution {
    public int mySqrt(int x) {
        if (x==1) return 1;

        int low = 0;
        int high = x;

        while (low < high) {
            int mid = (low + high) / 2;
            if (mid <= (x/mid) && (mid+1) > x/(mid+1)) return mid;
            if (mid > x/mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}