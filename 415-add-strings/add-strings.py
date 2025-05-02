class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        # n1 = int(num1)
        # n2 = int(num2)
        # num1 = num1[::-1]
        # num2 = num2[::-1]
        # i, j = len(num1)-1 , len(num2)-1
        n1, n2 = 0, 0
        # while num1:
        #     n1 = n1*10 + int(num1[i])%10
        #     i -= 1
        for i in range(len(num1)):
            n1 = n1*10 + int(num1[i])
        for j in range(len(num2)):
            n2 = n2*10 + int(num2[j])
        n12 = n1 + n2
        if n12==0:
            return "0"
        s = ""
        while(n12):
            y = n12%10
            s = s + str(y)
            n12 = n12//10
        return s[::-1]