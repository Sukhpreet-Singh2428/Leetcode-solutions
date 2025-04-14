class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        lst = []
        result = []
        n = len(nums)
        for i in nums:
            if i not in lst:
                lst.append(i)
            else:
                result.append(i)  # duplicate
        for i in range(1, n + 1):
            if i not in lst:
                result.append(i)  # missing
                break
        return result