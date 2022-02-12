class Solution:
    def myAtoi(self, s: str) -> int:
        i = 0
        sign = 1
        unsigned = 0
        
        INT_MAX = pow(2,31) - 1 
        INT_MIN = -pow(2,31)
        
        
        # Skip leading whitespaces
        while i < len(s) and s[i] == ' ':
            i += 1
            
        # deal with sign
        if i < len(s) and s[i] == '+':
            sign = 1
            i += 1
        elif i < len(s) and s[i] == '-':
            sign = -1
            i += 1
            
        # get number
        while i < len(s) and s[i].isdigit():
            unsigned = unsigned * 10 + int(s[i])
            
            if sign == 1 and unsigned > INT_MAX:
                return INT_MAX
            elif sign == -1 and -unsigned < INT_MIN:
                return INT_MIN
            
            i += 1
            
        return sign * unsigned
        