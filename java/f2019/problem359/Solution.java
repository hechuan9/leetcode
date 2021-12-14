package f2019.problem359;

import java.util.HashMap;
import java.util.Map;

class Logger {

    /** Initialize your data structure here. */
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        } else {
            int lastTimeStamp = map.get(message);
            if (timestamp - lastTimeStamp >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}