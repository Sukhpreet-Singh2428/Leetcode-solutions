class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        lst = []
        nums.sort()
        for x in nums:
            lst.append(x)
        return lst