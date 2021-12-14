package airbnb;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Vector2D {
    Iterator<List<Integer>> rowItr;
    Iterator<Integer> colItr;

    public Vector2D(List<List<Integer>> vec2d) {
        rowItr = vec2d.iterator();
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


