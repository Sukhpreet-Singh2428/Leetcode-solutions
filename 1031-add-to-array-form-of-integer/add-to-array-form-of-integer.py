class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        # s = ""
        # for x in num:
        #     s = s + str(x)
        # result = int(s) + k  --> int(s) till 4300 digits after it overflowa
        # lst = []
        # while(result):
        #     y = result%10
        #     lst.append(y)
        #     result = result//10
        # return lst[::-1]

        i = len(num)-1
        result = []
        while i>=0 or k>0:
            if i>=0:
                k += num[i]
                i -= 1
            result.append(k%10)
            k //= 10 
        return result[::-1]