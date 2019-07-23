package f2019.problem269;

import java.util.*;

class Solution {
    private enum State { White, Grey, Black }

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, State> visited = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.put(c, new LinkedList<>());
                visited.put(c, State.White);
            }
        }

        // Create Topological Structure

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i+1].length()); j++) {
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    List<Character> children = map.get(words[i].charAt(j));
                    children.add(words[i+1].charAt(j));
                    map.put(words[i].charAt(j), children);
                    break;
                }
            }
        }

        // Topological Sort
        Stack<Character> stack = new Stack<>();
        for (char c : map.keySet()) {
            if (visited.get(c) == State.Black) continue;
            if (!dfs(stack, visited, map, c)) return "";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private boolean dfs(Stack<Character> stack, Map<Character, State> visited, Map<Character, List<Character>> map, char c) {
        if (visited.get(c) == State.Black) return true;
        if (visited.get(c) == State.Grey) return false;

        visited.put(c, State.Grey);
        for (char child : map.get(c)) {
            if (!dfs(stack, visited, map, child)) return false;
        }
        visited.put(c, State.Black);
        stack.push(c);
        return true;
    }
}