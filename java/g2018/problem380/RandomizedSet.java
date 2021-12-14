package g2018.problem380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RandomizedSet {
    java.util.Random rand = new java.util.Random();
    private List<Integer> nums;
    private Map<Integer, Integer> locs;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) return false;
        int index = locs.get(val);
        if (index != nums.size() - 1) {// last number
            int lastNumber = nums.get(nums.size()-1);
            locs.put(lastNumber, index);
            nums.set(index, lastNumber);
        }

        locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}