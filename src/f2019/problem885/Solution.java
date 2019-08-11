package f2019.problem885;

class Solution {
    public int[][] spiralMatrixIII(int r, int c, int r0, int c0) {
        int index = 0;
        int travel = 1;
        int dir = 0; // 0 -> right, down; 1 -> left, up
        int[][] res = new int[r*c][2];
        res[index++] = new int[] {r0, c0};

        while (index != r*c) {
            if (dir == 0) { // go right
                for (int i = 0; i < travel; i++) {
                    c0++;
                    index = insert(res, r, c, r0, c0, index);
                }

                for (int i = 0; i < travel; i++) {
                    r0++;
                    index = insert(res, r, c, r0, c0, index);
                }
                dir = 1;
            } else { // 1
                for (int i = 0; i < travel; i++) {
                    c0--;
                    index = insert(res, r, c, r0, c0, index);
                }

                for (int i = 0; i < travel; i++) {
                    r0--;
                    index = insert(res, r, c, r0, c0, index);
                }
                dir = 0;
            }
            travel++;
        }
        return res;
    }

    private int insert(int[][] res, int r, int c, int r0, int c0, int index) {
        if (r0 < 0 || c0 < 0 || c0 >= c || r0 >= r) return index;
        res[index] = new int[] {r0, c0};
        return index + 1;
    }
}