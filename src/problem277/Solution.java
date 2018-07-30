package problem277;


import javax.management.relation.Relation;
import java.util.LinkedList;
import java.util.List;

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) celebrity = i;
        }
        for (int i = 0; i < n; i++) {
            if (i == celebrity) continue;
            if (!knows(i, celebrity) || knows(celebrity, i)) return -1;
        }
        return celebrity;
    }
}