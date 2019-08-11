package f2019.problem721;

import java.util.*;

class Solution {
    private Map<String, String> parents;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parents = new HashMap<>();
        Map<String, String> owners = new HashMap<>();

        for (List<String> account : accounts) {
            String owner = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                parents.put(account.get(i), account.get(i));
                owners.put(account.get(i), owner);
            }
        }

        for (List<String> account : accounts) {
            String firstEmail = parent(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                union(account.get(i), firstEmail);
            }
        }

        Map<String, Set<String>> unions = new HashMap<>();

        for (Map.Entry<String, String> entry : parents.entrySet()) {
            String parent = entry.getValue();
            String email = entry.getKey();
            if (!unions.containsKey(parent)) unions.put(parent, new TreeSet<>());
            Set<String> emails = unions.get(parent);
            emails.add(email);
        }

        List<List<String>> ret = new LinkedList<>();
        for (Map.Entry<String, Set<String>> entry : unions.entrySet()) {
            List<String> account = new LinkedList<>();
            account.add(owners.get(entry.getKey()));
            for (String email : entry.getValue()) {
                account.add(email);
            }
            ret.add(account);
        }
        return ret;
    }

    private String parent(String email) {
        while (!parents.get(email).equals(email)) {
            email = parents.get(email);
        }
        return email;
    }

    private void union(String email, String parent) {
        parents.put(parent(email), parent);
    }
}