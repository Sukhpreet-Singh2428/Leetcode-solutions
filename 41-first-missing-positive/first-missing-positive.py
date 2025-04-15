class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        nums.sort()
        firstmissing = 1
        for x in range(len(nums)):
            if(nums[x]==firstmissing):
                firstmissing = firstmissing + 1
        return firstmissing