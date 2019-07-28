package g2018.problem88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        while (index >= 0) {
            if (nums2Index < 0) {
                break;
            } else if (nums1Index < 0) {
                nums1[index] = nums2[nums2Index];
                nums2Index--;
            } else if (nums2[nums2Index] >= nums1[nums1Index]) {
                nums1[index] = nums2[nums2Index];
                nums2Index--;
            } else {
                nums1[index] = nums1[nums1Index];
                nums1Index--;
            }
            index--;
        }
    }
}