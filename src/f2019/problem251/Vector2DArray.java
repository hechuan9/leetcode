package f2019.problem251;

class Vector2DArray {
    private int rowPtr;
    private int colPtr;
    private int[][] v;

    public Vector2DArray(int[][] v) {
        rowPtr = 0;
        colPtr = -1;
        this.v = v;
        advanceToNext();
    }

    public int next() {
        int value = v[rowPtr][colPtr];
        advanceToNext();
        return value;
    }

    public boolean hasNext() {
        return rowPtr != v.length || colPtr != 0;
    }

    private void advanceToNext() {
        colPtr++;
        while (rowPtr != v.length && colPtr == v[rowPtr].length) {
            rowPtr++; colPtr = 0;
        }
    }
}

