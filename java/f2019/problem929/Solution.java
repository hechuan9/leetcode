package f2019.problem929;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] splitAt = email.split( "@");
            String[] splitPlus = splitAt[0].split("\\+");
            uniqueEmails.add(splitPlus[0].replace(".", "")+"@"+splitAt[1]);
        }
        return uniqueEmails.size();
    }
}