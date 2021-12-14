package f2019.problem299;

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
        }
        int[] secretCounts = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            secretCounts[secret.charAt(i)-'0']++;
        }
        int[] guessCounts = new int[10];
        for (int i = 0; i < guess.length(); i++) {
            guessCounts[guess.charAt(i)-'0']++;
        }

        int cows = -bulls;
        for  (int i = 0; i < 10; i++) {
            cows += Math.min(secretCounts[i], guessCounts[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
