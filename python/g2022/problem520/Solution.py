class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        first_letter_capital = word[0].isupper()
        
        if first_letter_capital:
            if len(word) >= 2:
                second_letter_capital = word[1].isupper()
                if second_letter_capital:
                    for c in word[2:]:
                        if not c.isupper():
                            return False
                else:
                    for c in word[2:]:
                        if c.isupper():
                            return False
        else:
            for c in word:
                if c.isupper():
                    return False
        return True