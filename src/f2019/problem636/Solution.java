package f2019.problem636;

import java.util.List;
import java.util.Stack;

class Solution {
    class Entry {
        int id;
        int time;
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        int prev = 0;
        Stack<Entry> entries = new Stack<>();
        for (String log : logs) {
            String[] logSplit = log.split(":");
            int id = Integer.parseInt(logSplit[0]);
            int time = Integer.parseInt(logSplit[2]);
            if (logSplit[1].equals("end")) {
                entries.pop();
                res[id] += time - prev;
            } else {
                if (!entries.isEmpty()) {
                    res[entries.peek().id] += time - prev;
                }

                Entry entry = new Entry();
                entry.id = id;
                entry.time = time;

                entries.push(entry);
            }
            prev = time;
        }

        return res;
    }
}