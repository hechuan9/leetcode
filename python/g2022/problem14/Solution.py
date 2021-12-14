class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        common = strs[0]
        for string in strs[1:]:
            newCommon = ""
            for i in range(min(len(common), len(string))):
                if common[i] == string[i]:
                    newCommon += common[i]
                else:
                    break
            common = newCommon
        return common
