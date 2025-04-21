class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        lst = []
        s = ""
        for i in range(len(digits)):
            s = s + str(digits[i])
        num = int(s) + 1
        return [int(x) for x in str(num)]   