package context.problem1169;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        Transaction(String[] parts) {
            this.name = parts[0];
            this.time = Integer.parseInt(parts[1]);
            this.amount = Integer.parseInt(parts[2]);
            this.city = parts[3];
        }

        public String print() {
            return name+","+time+","+amount+","+city;
        }
    }

    public List<String> invalidTransactions(String[] _transactions) {
        Transaction[] transactions = new Transaction[_transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            String[] parts = _transactions[i].split(",");
            transactions[i] = new Transaction(parts);
        }

        Arrays.sort(transactions, Comparator.comparingInt(e -> e.time));
        Map<String, List<Transaction>> map = new HashMap<>();
        Set<Transaction> invalid = new HashSet<>();

        for (Transaction transaction : transactions) {
            if (transaction.amount > 1000) {
                invalid.add(transaction);
            }

            List<Transaction> hasBeen;
            if (map.containsKey(transaction.name)) {
                hasBeen = map.get(transaction.name).stream()
                        .filter(e -> transaction.time - e.time <= 60).collect(Collectors.toList());
                for (Transaction entry : hasBeen) {
                    if (!entry.city.equals(transaction.city)) {
                        invalid.add(entry);
                        invalid.add(transaction);
                    }
                }
            } else {
                hasBeen = new LinkedList<>();
            }
            hasBeen.add(transaction);
            map.put(transaction.name, hasBeen);

        }
        return invalid.stream().map(Transaction::print).collect(Collectors.toList());
    }
}
