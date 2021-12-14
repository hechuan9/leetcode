class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        mymax = 0
        count = 0
        i = 0
        j = 0
        dic = defaultdict(int)
        while j != len(s):
            c = s[j]
            count += 1
            dic[c] += 1

            while dic[c] > 1:
                dic[s[i]] -= 1
                count -= 1
                i += 1
            j += 1
            mymax = max(mymax, count)
        return mymax
