package f2019.problem46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permute(numbers, new LinkedList<>());
        return res;
    }

    private void permute(List<Integer> numbers, List<Integer> done) {
        if (numbers.isEmpty()) {
            res.add(new ArrayList<>(done));
            return;
        }

        for (Integer number : numbers) {
            done.add(number);
            List<Integer> newNumbers = new LinkedList<>(numbers);
            newNumbers.remove(number);
            permute(newNumbers, done);
            newNumbers.add(number);
            done.remove(number);
        }
    }
}