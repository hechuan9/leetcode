package f2019.problem350;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (int num : nums1) {
            if (map.containsKey(num) && map.get(num) > 0) {
                res.add(num);
                map.put(num, map.get(num)-1);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}