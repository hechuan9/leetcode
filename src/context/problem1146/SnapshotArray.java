package context.problem1146;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class SnapshotArray {

    class Revision {
        int index;
        int value;
        Revision(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    List<List<Revision>> snapshots;
    int snapId = 0; // unsaved

    public SnapshotArray(int length) {
        snapshots = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            List<Revision> snapshot = new LinkedList<>();
            snapshot.add(new Revision(-1, 0));
            snapshots.add(snapshot);
        }
    }

    public void set(int index, int val) {
        List<Revision> snapshot = snapshots.get(index);
        snapshot.add(new Revision(snapId, val));
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<Revision> snapshot = snapshots.get(index);
        Iterator<Revision> itr = snapshot.iterator();
        int value = itr.next().value;
        while (itr.hasNext()) {
            Revision rev = itr.next();
            if (rev.index <= snap_id) {
                value = rev.value;
            } else {
                break;
            }
        }
        return value;
    }
}