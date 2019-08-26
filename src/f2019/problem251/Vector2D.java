package f2019.problem251;

import java.util.*;

class Vector2D {
    List<List<Integer>> v;
    Iterator<List<Integer>> rowItr;
    Iterator<Integer> colItr;

    public Vector2D(int[][] _v) {
        v = new LinkedList<>();
        for (int[] _row : _v) {
            List<Integer> row = new LinkedList<>();
            for (int _col : _row) {
                row.add(_col);
            }
            v.add(row);
        }
        rowItr = v.iterator();
        colItr = Collections.emptyIterator();
    }

    public int next() {
        if (hasNext()) {
            return colItr.next();
        } else {
            return -1;
        }
    }

    public boolean hasNext() {
        while (!colItr.hasNext()) {
            if (!rowItr.hasNext()) return false;
            List<Integer> row = rowItr.next();
            colItr = row.iterator();
        }
        return true;
    }

    public void remove() {
        if (hasNext()) {
            colItr.next();
            colItr.remove();
        }
    }
}
