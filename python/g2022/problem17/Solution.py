class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mapping = {
            '2': "abc",
            '3': "def",
            '4': "ghi",
            '5': "jkl",
            '6': "mno",
            '7': "pqrs",
            '8': "tuv",
            '9': "wxyz",
        }

        res = []

        def permutate(digits, letters):
            nonlocal res
            if digits == "":
                res.append(letters)
                return

            for letter in mapping[digits[0]]:
                permutate(digits[1:], letters + letter)

        if digits == "":
            return [];
        permutate(digits, "")
        return res;