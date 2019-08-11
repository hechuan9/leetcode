package f2019.problem896;

class Solution {
    public boolean isMonotonic(int[] a) {
        if (a.length == 0) return true;
        return isIncreasing(a) || isDecreasing(a);
    }

    private boolean isIncreasing(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) return false;
        }
        return true;
    }

    private boolean isDecreasing(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i+1]) return false;
        }
        return true;
    }
}