package problem350;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        List<Integer> ret = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int count = Math.min(entry.getValue(), map2.getOrDefault(entry.getKey(), 0));
            for (int i = 0; i < count; i++) ret.add(entry.getKey());
        }
        return ret.stream().mapToInt(i->i).toArray();
    }
}