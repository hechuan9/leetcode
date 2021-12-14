class Solution:
    def reverseWords(self, s: str) -> str:
        #" ".join.reversed(s.split(" "))

        output = ""
        temp = ""
        for c in s:
            if c == " ":
                if temp != "":
                    output = temp if output == "" else temp + " " + output
                    temp = ""
            else:
                temp += c

        if temp != "":
            output = temp if output == "" else temp + " " + output
        return output